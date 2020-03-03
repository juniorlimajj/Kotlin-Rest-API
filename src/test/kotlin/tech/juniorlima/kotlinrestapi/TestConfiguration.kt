package tech.juniorlima.kotlinrestapi

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import tech.juniorlima.kotlinrestapi.TestUtils.loadFileJson
import tech.juniorlima.kotlinrestapi.model.BookModel
import java.io.IOException


@TestConfiguration
class TestConfiguration {
    @Autowired
    private val mapper: ObjectMapper? = null

    @Bean
    @Throws(IOException::class)
    fun mockedPlace(): BookModel? {
        val book = loadFileJson("payload.json")
            return mapper?.readValue(book, BookModel::class.java)
    }
}