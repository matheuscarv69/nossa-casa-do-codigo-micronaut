package br.com.zup.autores.controllers

import br.com.zup.autores.entities.autor.repositories.AutorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/autores/{id}")
class DeletarAutorController(val autorRepository: AutorRepository) {


    @Delete
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