package br.com.zup.entities.livro.repositories

import br.com.zup.entities.livro.entities.Livro
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface LivroRepository : JpaRepository<Livro, Long> {

    fun existsByIsbn(isbn: String): Boolean

}