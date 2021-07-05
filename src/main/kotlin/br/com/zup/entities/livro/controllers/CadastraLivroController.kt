package br.com.zup.entities.livro.controllers

import br.com.zup.entities.livro.repositories.LivroRepository
import br.com.zup.entities.livro.request.NovoLivroRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/livros")
class CadastraLivroController(val livroRepository: LivroRepository) {

    @Post
    @Transactional
    fun cadastra(@Body @Valid req: NovoLivroRequest): HttpResponse<Any> {

        if (livroRepository.existsByIsbn(req.isbn)) {

            return HttpResponse.badRequest()
        }

        return req.paraLivro().apply {
            livroRepository.save(this)
        }.let { livro ->
            val uri = UriBuilder
                .of("/livros/{id}")
                .expand(mutableMapOf(Pair("id", livro.id)))

            HttpResponse.created(uri)
        }
    }

}