package com.dyzn.genesis.module_login.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.dyzn.genesis.lib_common.base.BaseDao
import com.dyzn.genesis.module_login.data.bean.UserInfo

/**
 * @author YLC-D
 * @create on 2020/10/26 16
 * 说明:
 */
@Dao
interface UserInfoDao:BaseDao<UserInfo> {
    /**
     * 根据用户id查找用户信息
     * @param userId 用户id
     */
    @Query("select * from UserInfo where id = :userId")
    fun selectById(userId: Long): UserInfo?
}