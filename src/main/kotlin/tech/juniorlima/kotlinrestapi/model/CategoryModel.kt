package tech.juniorlima.kotlinrestapi.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class CategoryModel(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotBlank
        val name: String = "",

        @JsonManagedReference
        @OneToMany(mappedBy = "category", cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.EAGER)
        var books: List<BookModel> = emptyList()
)