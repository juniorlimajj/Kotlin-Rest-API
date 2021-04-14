package tech.juniorlima.kotlinrestapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.juniorlima.kotlinrestapi.model.CategoryModel
import tech.juniorlima.kotlinrestapi.repository.CategoryRepository
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CategoryController(private val categoryRepository: CategoryRepository){

    @GetMapping("/categories")
    fun getAllCategories() : List<CategoryModel> =
            categoryRepository.findAll()

    @PostMapping("/category")
    fun createNewCategory(@Valid @RequestBody category: CategoryModel):
            ResponseEntity<CategoryModel> {
        categoryRepository.save(category)
        return ResponseEntity.ok(category)
    }

    @GetMapping("/categories/{id}")
    fun getBookById(@PathVariable(value = "id") categoryId: Long):
            ResponseEntity<CategoryModel> {
        return categoryRepository.findById(categoryId).map { category ->
            ResponseEntity.ok(category)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/categorias/{id}")
    fun deleteLivroById(@PathVariable(value = "id") categoryId: Long):
            ResponseEntity<Void> {

        return categoryRepository.findById(categoryId).map { category  ->
            categoryRepository.delete(category)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}