package tech.juniorlima.kotlinrestapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.juniorlima.kotlinrestapi.model.BookModel
import tech.juniorlima.kotlinrestapi.repository.BookRepository
import tech.juniorlima.kotlinrestapi.repository.CategoryRepository
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BookController(private val bookRepository: BookRepository,
                     private val categoryRepository: CategoryRepository){

    @GetMapping("/books")
    fun getAllBooks(): List<BookModel> =
            bookRepository.findAll()

    @PostMapping("/book")
    fun createNewBook(@Valid @RequestBody book:BookModel){
        book.category?.let { categoryRepository.save(it) }
        bookRepository.save(book)
    }

    @GetMapping("/books/{id}")
    fun getBookById(@PathVariable(value = "id") bookId: Long):
            ResponseEntity<BookModel> {
        return bookRepository.findById(bookId).map { book ->
            ResponseEntity.ok(book)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/books/{id}")
    fun deleteBookById(@PathVariable(value = "id") bookId: Long):
            ResponseEntity<Void> {

        return bookRepository.findById(bookId).map { book  ->
            bookRepository.delete(book)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}