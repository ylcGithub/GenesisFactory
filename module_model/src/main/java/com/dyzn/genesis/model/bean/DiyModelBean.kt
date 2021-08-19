package com.dyzn.genesis.model.bean

/**
 *@author YLC-D
 *@create on 2021/7/8 16
 *说明:
"missionState":1,
 * "missionStateDescription":"未完成", （上传图片的时候）
 * <p>
 * "missionState":2,
 * "missionStateDescription":"排队中..."
 * <p>
 * "missionState":3,
 * "missionStateDescription":"创建中..."
 * <p>
 * "missionState":4,
 * "missionStateDescription":"创建失败"
 * <p>
 * "missionState":5,
 * "missionStateDescription":"创建成功"
 *
 *
 * item 的类型区分参数
 * 1：标题布局 0：普通布局
 * itemType;
 *
 * 该分类下面有多少个子项
 *itemCount;
 * 默认列表不能编辑
 * boolean canEdit;
 */
data class DiyModelBean(
    var createAt: Long = 0L,
    var missionState: Int = 0,
    var missionStateDescription: String = "",
    var modelid: Long = 0L,
    var goodsname: String = "",
    var id: Long = 0L,
    var prefab: String = "",
    var angle: Int = 20,
    var goodsimage: String = "",
    var errorMsg: String = "",
    var itemType: Int = 0,
    var itemCount: Int = 0,
    var canEdit: Boolean = false,
    var selected: Boolean = false
)
