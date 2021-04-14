package tech.juniorlima.kotlinrestapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class BookModel (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotBlank
        val title: String = "",

        @get: NotBlank
        val author: String = "",

        @JsonBackReference
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "category_id")
        val category: CategoryModel? = null
)