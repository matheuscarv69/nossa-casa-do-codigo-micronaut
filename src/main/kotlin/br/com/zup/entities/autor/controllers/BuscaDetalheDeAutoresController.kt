package br.com.zup.entities.autor.controllers

import br.com.zup.entities.autor.repositories.AutorRepository
import br.com.zup.entities.autor.response.DetalhesDoAutorResponse
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import javax.transaction.Transactional

@Controller("/autores")
class BuscaDetalheDeAutoresController(val autorRepository: AutorRepository) {

    @Get
    @Transactional
    fun buscaDetalheAutores(
        @QueryValue(defaultValue = "") email: String,
        @QueryValue(defaultValue = "") cpf: String,
        pageable: Pageable
    ): HttpResponse<Any> {

        if (email.isEmpty() && cpf.isEmpty()) {
            return autorRepository.findAll(pageable).map { autor ->
                DetalhesDoAutorResponse(autor)
            }.let { autores ->
                HttpResponse.ok(autores)
            }
        }

        if (cpf.isNotEmpty()) {
            return autorRepository.procuraPorCpf(cpf).let { possivelAutor ->
                if (possivelAutor.isEmpty) {
                    return HttpResponse.notFound()
                }
                possivelAutor.get()
            }.let { autor ->
                HttpResponse.ok(DetalhesDoAutorResponse(autor))
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