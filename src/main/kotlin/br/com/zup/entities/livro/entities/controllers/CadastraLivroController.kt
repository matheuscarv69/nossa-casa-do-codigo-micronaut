package br.com.zup.entities.livro.entities.controllers

import br.com.zup.entities.livro.request.NovoLivroRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/livros")
class CadastraLivroController {

    @Post
    fun cadastra(@Body @Valid req: NovoLivroRequest): HttpResponse<Any> {
        println(req)

        return HttpResponse.ok()
    }

}