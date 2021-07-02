package br.com.zup.autores.entities.autor.repositories

import br.com.zup.autores.entities.autor.entity.Autor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository : JpaRepository<Autor, Long>