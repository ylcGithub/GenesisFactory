package com.dyzn.genesis.lib_base_res.dimen

import android.util.Log
import java.io.*
import java.text.DecimalFormat

/**
 *@author YLC-D
 *@create on 2020/10/21 11
 *说明:
 */
fun gen() {
    // 1.根据UI画布大小比例进行换算，假设UI图分辨率为1334x750
    //  设备默认缩放因子密度为 density  = 320 / 160 , 即 density = 2
    //  宽度 width = 750
    //  可选项，根据你实际的UI设计图来定义

    //密度因子
    val density = 2.0f
    //屏幕相对宽度
    val width: Float = 750 / density


    //2.根据UI画布大小比例进行换算，假设UI图分辨率为1080x1920
    //         * 高分率缩放因子密度一般为 density = 480 / 160 , 即 density = 3
    //         * 宽度 width = 1080
    //         * 可选项，根据你实际的UI设计图来定义
//        density = 3.0f;
//        width = 1080 / density;
    //执行生成适配的dimens.xml文件
    create(width)
}

/**
 * 生成对应的适配的dimens.xml文件
 * @param width 宽
 */
fun create(width: Float) {
    val file = File("./lib_base_res/src/main/res/values/dimens.xml")
    val sw240 = StringBuilder()
    val sw320 = StringBuilder()
    val sw360 = StringBuilder()
    val sw380 = StringBuilder()
    val sw410 = StringBuilder()
    val sw480 = StringBuilder()
    val sw600 = StringBuilder()
    val sw720 = StringBuilder()
    val sw760 = StringBuilder()
    val sw800 = StringBuilder()
    val sw900 = StringBuilder()
    val sw1080 = StringBuilder()
    val sw1200 = StringBuilder()
    val sw1440 = StringBuilder()
    val sw1890 = StringBuilder()
    val builderArray = arrayOf(
        sw240,
        sw320,
        sw360,
        sw380,
        sw410,
        sw480,
        sw600,
        sw720,
        sw760,
        sw800,
        sw900,
        sw1080,
        sw1200,
        sw1440,
        sw1890,
    )
    val readerF = BufferedReader(FileReader(file))
    try {
        var tempString: String?
        while (readerF.readLine().also { tempString = it } != null) {
            if (tempString!!.contains("</dimen>")) {
                val start = tempString!!.substring(0, tempString!!.indexOf(">") + 1)
                val end = tempString!!.substring(tempString!!.lastIndexOf("<") - 2)
                val num = java.lang.Float.valueOf(
                    tempString!!.substring(
                        tempString!!.indexOf(">") + 1,
                        tempString!!.indexOf("</dimen>") - 2
                    )
                )
                stringDeal(builderArray, start, "jisuan", end, "\n", num = num, width = width)
            } else {
                stringDeal(builderArray, tempString!!, "\n", num = 0f, width = 0f)
            }
        }
        readerF.close()
        val sw240file = "./lib_base_res/src/main/res/values-sw240dp/dimens.xml"
        val sw320file = "./lib_base_res/src/main/res/values-sw320dp/dimens.xml"
        val sw360file = "./lib_base_res/src/main/res/values-sw360dp/dimens.xml"
        val sw380file = "./lib_base_res/src/main/res/values-sw380dp/dimens.xml"
        val sw410file = "./lib_base_res/src/main/res/values-sw410dp/dimens.xml"
        val sw480file = "./lib_base_res/src/main/res/values-sw480dp/dimens.xml"
        val sw600file = "./lib_base_res/src/main/res/values-sw600dp/dimens.xml"
        val sw720file = "./lib_base_res/src/main/res/values-sw720dp/dimens.xml"

        val sw760file = "./lib_base_res/src/main/res/values-sw760dp/dimens.xml"
        val sw800file = "./lib_base_res/src/main/res/values-sw800dp/dimens.xml"
        val sw900file = "./lib_base_res/src/main/res/values-sw900dp/dimens.xml"

        val sw1080file = "./lib_base_res/src/main/res/values-sw1080dp/dimens.xml"
        val sw1200file = "./lib_base_res/src/main/res/values-sw1200dp/dimens.xml"
        val sw1440file = "./lib_base_res/src/main/res/values-sw1440dp/dimens.xml"
        val sw1890file = "./lib_base_res/src/main/res/values-sw1890dp/dimens.xml"
        val fileArray = arrayOf(
            sw240file,
            sw320file,
            sw360file,
            sw380file,
            sw410file,
            sw480file,
            sw600file,
            sw720file,
            sw760file,
            sw800file,
            sw900file,
            sw1080file,
            sw1200file,
            sw1440file,
            sw1890file
        )
        for (index in fileArray.indices) {
            writeFile(fileArray[index], builderArray[index].toString())
        }
    } catch (e: Exception) {
        Log.e("YLC", e.message + "")
        e.printStackTrace()
    } finally {
        readerF.close()
    }
}

fun writeFile(file: String, text: String) {
    CreateFileUtil.createFile(file)
    var out: PrintWriter? = null
    var fileWriter: FileWriter? = null
    try {
        fileWriter = FileWriter(file)
        out = PrintWriter(BufferedWriter(fileWriter))
        out.println(text)
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        out?.close()
        fileWriter?.close()
    }
}

fun stringDeal(array: Array<StringBuilder>, vararg strs: String, num: Float, width: Float) {

    for (index in array.indices) {
        for (str in strs) {
            if ("jisuan" == str) {
                array[index].append(cutToTwo(getSize(index, num, width)))
            } else {
                array[index].append(str)
            }
        }
    }
}

fun getSize(index: Int, num: Float, width: Float): Float {
    val coeff: Int
    when (index) {
        0 -> {
            coeff = 240
        }
        1 -> {
            coeff = 320
        }
        2 -> {
            coeff = 360
        }
        3 -> {
            coeff = 384
        }
        4 -> {
            coeff = 410
        }
        5 -> {
            coeff = 480
        }
        6 -> {
            coeff = 600
        }
        7 -> {
            coeff = 720
        }
        8 -> {
            coeff = 760
        }
        9 -> {
            coeff = 800
        }
        10 -> {
            coeff = 900
        }
        11 -> {
            coeff = 1080
        }
        12 -> {
            coeff = 1200
        }
        13 -> {
            coeff = 1440
        }
        14 -> {
            coeff = 1890
        }
        else -> {
            coeff = 1080
        }
    }

    return num * coeff / width
}

val DOUBLE_DF_TWO = DecimalFormat("0.00")
fun cutToTwo(value: Float): String {
    var str = DOUBLE_DF_TWO.format(value.toDouble())
    if ("-0.00" == str) {
        str = "0.00"
    }
    return str
}

fun main() {
    gen()
}