package com.dyzn.genesis.lib_base_res.dimen

import java.io.*
import java.util.*

/**
 *@author YLC-D
 *@create on 2020/10/21 15
 *说明:
 */
object CreateFileUtil {
    fun createFile(destFileName: String): Boolean {
        val file = File(destFileName)
        if (file.exists()) {
            println("创建单个文件" + destFileName + "失败，目标文件已存在！")
            return false
        }
        if (destFileName.endsWith(File.separator)) {
            println("创建单个文件" + destFileName + "失败，目标文件不能为目录！")
            return false
        }
        //判断目标文件所在的目录是否存在
        if (!Objects.requireNonNull(file.parentFile).exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            println("目标文件所在目录不存在，准备创建它！")
            if (!file.parentFile.mkdirs()) {
                println("创建目标文件所在目录失败！")
                return false
            }
        }
        //创建目标文件
        return try {
            if (file.createNewFile()) {
                println("创建单个文件" + destFileName + "成功！")
                true
            } else {
                println("创建单个文件" + destFileName + "失败！")
                false
            }
        } catch (e: IOException) {
            e.printStackTrace()
            println("创建单个文件" + destFileName + "失败！" + e.message)
            false
        }
    }


    private fun createDir(dName: String): Boolean {
        var destDirName = dName
        val dir = File(destDirName)
        if (dir.exists()) {
            println("创建目录" + destDirName + "失败，目标目录已经存在")
            return false
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName += File.separator
        }
        //创建目录
        return if (dir.mkdirs()) {
            println("创建目录" + destDirName + "成功！")
            true
        } else {
            println("创建目录" + destDirName + "失败！")
            false
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //创建目录
        val dirName = "./app/src/main/res/values-sw1890dp"
        createDir(dirName)
        //创建文件
        val fileName = "$dirName/dimens.xml"
        createFile(fileName)
        writeFile(
            fileName, """
     <resources>
     </resources>
     """.trimIndent()
        )
    }

    private fun writeFile(file: String, text: String) {
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
            if (fileWriter != null) {
                try {
                    fileWriter.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}