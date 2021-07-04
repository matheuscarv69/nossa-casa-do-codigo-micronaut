package br.com.zup.entities.autor.controllers

import br.com.zup.entities.autor.repositories.AutorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import javax.transaction.Transactional

@Controller("/autores/{id}")
class DeletarAutorController(val autorRepository: AutorRepository) {

    @Delete
    @Transactional
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {
        return autorRepository.findById(id).let { possivelAutor ->
            if (possivelAutor.isEmpty) {
                return HttpResponse.notFound()
            }
            autorRepository.deleteById(id)
            HttpResponse.ok()
        }
    }


}