package com.dyzn.genesis.lib_base_mvvm.core

/**
 *@author YLC-D
 *@create on 2020/10/20 16
 *说明:
 */
object RouterConstants {

    private const val HOME = "/main"
    private const val LOGIN = "/login"
    private const val MALL = "/mall"
    private const val FORUM = "/forum"
    private const val PROCESS = "/process"
    private const val DIY = "/diy"
    private const val MINE = "/mine"
    /**
     * 主界面
     */
    const val MAIN_ACTIVITY = "$HOME/MainActivity"
    /**
     * 登录
     */
    const val LOGIN_ACTIVITY = "$LOGIN/LoginActivity"

    /**
     * 商城
     */
    const val MALL_ACTIVITY = "$MALL/MallActivity"

    /**
     * 论坛
     */
    const val FORUM_ACTIVITY = "$FORUM/ForumActivity"

    /**
     * 操作中心
     */
    const val PROCESS_ACTIVITY = "$PROCESS/ProcessActivity"

    /**
     * 模型DIY
     */
    const val DIY_ACTIVITY = "$DIY/DiyActivity"

    /**
     * 个人中心
     */
    const val MINE_ACTIVITY = "$MINE/MineActivity"
}