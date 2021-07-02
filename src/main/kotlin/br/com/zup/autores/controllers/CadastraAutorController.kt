package br.com.zup.autores.controllers

import br.com.zup.autores.entities.autor.repositories.AutorRepository
import br.com.zup.autores.request.NovoAutorRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid req: NovoAutorRequest): HttpResponse<Any> {
        println("Request -> $req")

        println("Convertendo Request para Autor: ")

        return req.paraAutor()
            .apply {
                println("Autor: ${this.nome}")
                autorRepository.save(this)
            }.let { autor ->
                val uri = UriBuilder
                    .of("/autores/{id}")
                    .expand(mutableMapOf(Pair("id", autor.id)))

                HttpResponse.created(uri)
            }
    }

}