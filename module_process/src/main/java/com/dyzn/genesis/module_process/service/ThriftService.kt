package com.dyzn.genesis.module_process.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.dyzn.genesis.lib_common.config.HawkKey.USER_PASSWORD
import com.dyzn.genesis.lib_common.config.HawkKey.USER_PHONE
import com.dyzn.genesis.lib_common.util.ThreadPoolUtils
import com.dyzn.genesis.module_process.R
import com.dyzn.genesis.module_process.core.StringConstant.CONNECT_THRIFT_SUCCESS
import com.dyzn.genesis.module_process.core.StringConstant.DEVICE_STATE_REPEAT_LOGIN
import com.dyzn.genesis.module_process.netty.ClientConnectHandler
import com.dyzn.genesis.module_process.netty.MessageHelper
import com.dyzn.genesis.module_process.netty.gen.ClientType
import com.dyzn.genesis.module_process.netty.gen.DataType
import com.dyzn.genesis.module_process.netty.gen.LoginMsg
import com.orhanobut.hawk.Hawk
import org.apache.commons.lang3.StringUtils
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 *@author YLC-D
 *@create on 2020/11/24 10
 *说明:
 */
class ThriftService : Service() {
    /**
     * 判断thrift是否可以重新连接
     */
    private var canReset = false
    private val executorService:ScheduledExecutorService = ThreadPoolUtils.getExecutorService(
        javaClass.simpleName
    )

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setForegroundNotification()
        }
        initService()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setForegroundNotification()
        }
        return START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setForegroundNotification() {
        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "$packageName:access_thrift_channel"
        val channel = NotificationChannel(
            channelId,
            "$packageName:channel_1", NotificationManager.IMPORTANCE_DEFAULT
        )
        nm.createNotificationChannel(channel)
        val notification = NotificationCompat.Builder(this, channelId) //优先级高,显示在通知栏目最上面
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setSmallIcon(R.mipmap.base_ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.base_ic_launcher)) //标题
            .setContentTitle(getString(R.string.thrift_service_title)) //内容
            .setContentText(getString(R.string.thrift_service_title)) //该通知正在进行中 不能被取消 删除
            .setOngoing(true)
            .build()
        startForeground(1, notification)
    }

    private fun initService(){
        //消息帮助类初始化
        //初始化连接失败 常量
        Hawk.put(DEVICE_STATE_REPEAT_LOGIN, false)
        Hawk.put(CONNECT_THRIFT_SUCCESS, false)

        val handler = object : ClientConnectHandler{

            override fun error(exception: Exception?) {
                exception?.printStackTrace()
                Hawk.put(CONNECT_THRIFT_SUCCESS, false)
                TimeUnit.SECONDS.sleep(2)
                if(canReset){
                    canReset = false
                    MessageHelper.close()
                    MessageHelper.init()
                }
            }

            override fun connected() {
                canReset = true
                startPing()
                loginThrift()
            }
        }
        MessageHelper.handler = handler
        canReset = false
        MessageHelper.close()
        MessageHelper.init()
    }

    private fun startPing(){
        executorService.scheduleAtFixedRate({
            if (MessageHelper.sendMsgAble()) {
                MessageHelper.sendMsg(DataType.PingCmd, null)
            }
        }, 0, 2, TimeUnit.SECONDS)
    }
    private fun loginThrift(){
        val loginMsg = LoginMsg()
        loginMsg.setClientType(ClientType.user)
        loginMsg.setPassword(Hawk.get(USER_PASSWORD, ""))
        loginMsg.setUserID(Hawk.get(USER_PHONE, ""))
        if (StringUtils.isNotEmpty(loginMsg.getUserID())) {
            Hawk.put(CONNECT_THRIFT_SUCCESS, true)
            MessageHelper.sendMsg(DataType.LoginCmd, loginMsg)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            stopForeground(true)
        }
        canReset = false
        MessageHelper.close()
    }

}