package com.dyzn.genesis.module_login.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dyzn.genesis.lib_common.base.BaseApplication
import com.dyzn.genesis.module_login.data.bean.UserInfo
import com.dyzn.genesis.module_login.data.dao.UserInfoDao

/**
 * @author Administrator
 * @create on 2020/4/12 0012
 * 说明: 数据声明
 */
@Database(entities = [UserInfo::class], version = 1, exportSchema = false)
abstract class LoginDataBase : RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDao

    companion object {
        val instance: LoginDataBase
            get() = Room.databaseBuilder(
                BaseApplication.getAppContext(),
                LoginDataBase::class.java,
                "small_factory_login_module_db"
            ).allowMainThreadQueries().build()
    }
}