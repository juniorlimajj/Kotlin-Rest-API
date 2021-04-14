package tech.juniorlima.kotlinrestapi

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import tech.juniorlima.kotlinrestapi.controller.BookController
import tech.juniorlima.kotlinrestapi.model.BookModel

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [KotlinRestApiApplication::class])
@AutoConfigureMockMvc
@TestPropertySource(locations = ["classpath:application-test.properties"])
@ContextConfiguration(classes = [TestConfiguration::class])
class KotlinRestApiApplicationTest {
    @Autowired
    private val bookController: BookController? = null
    @Autowired
    private val book: BookModel? = null

    @Test
    fun contextLoads() {
    }

    @Test
    fun createBook() {
        book?.let { bookController?.createNewBook(it) }
    }

    @Test
    fun getAllBooks() {
        val size: String = java.lang.String.valueOf(bookController?.getAllBooks()
                ?.size)
        assertThat(size == "1")
    }
}