package br.com.zup.autores.controllers

import br.com.zup.autores.entities.autor.repositories.AutorRepository
import br.com.zup.autores.response.DetalhesDoAutorResponse
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/autores")
class BuscaDetalheDeAutoresController(val autorRepository: AutorRepository) {


    @Get
    fun buscaDetalheAutores(pageable: Pageable): HttpResponse<Any> {
        return autorRepository.findAll(pageable)
            .map { autor ->
                DetalhesDoAutorResponse(autor)
            }.let { autores ->
                HttpResponse.ok(autores)
            }
    }

}