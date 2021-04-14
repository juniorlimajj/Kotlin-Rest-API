package tech.juniorlima.kotlinrestapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.juniorlima.kotlinrestapi.model.BookModel

@Repository
interface BookRepository : JpaRepository<BookModel, Long>