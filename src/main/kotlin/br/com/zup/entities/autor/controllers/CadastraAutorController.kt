package br.com.zup.entities.autor.controllers

import br.com.zup.entities.autor.repositories.AutorRepository
import br.com.zup.entities.autor.request.NovoAutorRequest
import br.com.zup.core.EnderecoClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(
    val autorRepository: AutorRepository,
    val enderecoClient: EnderecoClient
) {

    @Post
    @Transactional
    fun cadastra(@Body @Valid req: NovoAutorRequest): HttpResponse<Any> {
        val enderecoResponse = enderecoClient.consulta(req.cep)
            ?: return HttpResponse.badRequest("CEP informado é inválido")

        return req.paraAutor(enderecoResponse.body()!!)
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