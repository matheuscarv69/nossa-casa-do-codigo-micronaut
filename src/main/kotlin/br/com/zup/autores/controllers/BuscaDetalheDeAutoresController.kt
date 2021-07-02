package br.com.zup.autores.controllers

import br.com.zup.autores.entities.autor.repositories.AutorRepository
import br.com.zup.autores.response.DetalhesDoAutorResponse
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("/autores")
class BuscaDetalheDeAutoresController(val autorRepository: AutorRepository) {


    @Get
    fun buscaDetalheAutores(@QueryValue(defaultValue = "") email: String, pageable: Pageable): HttpResponse<Any> {
        if (email.isEmpty()) {
            return autorRepository.findAll(pageable).map { autor ->
                DetalhesDoAutorResponse(autor)
            }.let { autores ->
                HttpResponse.ok(autores)
            }
        }

        return autorRepository.findByEmail(email).let { possivelAutor ->
            if (possivelAutor.isEmpty) {
                return HttpResponse.notFound()
            }
            possivelAutor.get()
        }.let { autor ->
            HttpResponse.ok(DetalhesDoAutorResponse(autor))
        }

    }

}