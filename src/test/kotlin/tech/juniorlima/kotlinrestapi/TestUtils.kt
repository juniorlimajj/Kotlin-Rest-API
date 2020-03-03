package tech.juniorlima.kotlinrestapi

import com.google.common.base.Charsets
import com.google.common.io.Resources
import java.io.IOException

object TestUtils {
    fun loadFileJson(fileName: String?): String? {
        val url = Resources.getResource(fileName!!)
        var text: String? = null
        text = try {
            Resources.toString(url, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
        return text
    }
}