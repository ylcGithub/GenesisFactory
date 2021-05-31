package com.dyzn.genesis.module_login.data.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author YLC-D
 * @create on 2020/4/23 16
 * 说明: 用户信息表
 */
@Entity
data class UserInfo(
    @PrimaryKey
    var id: Long = 0,
    /** 昵称  */
    @ColumnInfo
    var nickname: String? = null,

    /** 真实姓名  */
    @ColumnInfo
    var realname: String? = null,

    /** 电话  */
    @ColumnInfo
    var phone: String? = null,

    /** 1 男 2 女  */
    @ColumnInfo
    var sex: Int = 0,

    /** 头像url  */
    @ColumnInfo
    var avatar: String? = null,

    /** 出生日期  */
    @ColumnInfo
    var dateofbirth: String? = null,

    /** 所在地  */
    @ColumnInfo
    var location: String? = null,

    /** 邮箱  */
    @ColumnInfo
    var email: String? = null,

    /** 用户关联的机器人设备id  */
    @ColumnInfo
    var deviceid: String? = null,

    /** 该用户的个人成长值 用来判断等级  */
    @ColumnInfo
    var growthofbase: Long = 0,

    /** 该用户的额外成长值 用来判断等级  */
    @ColumnInfo
    var growthofadd: Long = 0,
)