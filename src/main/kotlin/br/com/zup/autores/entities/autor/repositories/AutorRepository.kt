package br.com.zup.autores.entities.autor.repositories

import br.com.zup.autores.entities.autor.entity.Autor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {

    fun findByEmail(email: String): Optional<Autor>

}