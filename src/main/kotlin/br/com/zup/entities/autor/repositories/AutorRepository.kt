package br.com.zup.entities.autor.repositories

import br.com.zup.entities.autor.entities.Autor
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {

    fun findByEmail(email: String): Optional<Autor>

    @Query("SELECT a FROM Autor a WHERE a.cpf = :cpf")
    fun buscaPorCpf(cpf: String): Optional<Autor>

    @Query("SELECT * FROM AUTOR AS A WHERE A.CPF = :cpf", nativeQuery = true)
    fun procuraPorCpf(cpf:String): Optional<Autor>

}