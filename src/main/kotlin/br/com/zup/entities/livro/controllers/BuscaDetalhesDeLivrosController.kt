package br.com.zup.entities.livro.controllers

import br.com.zup.entities.livro.repositories.LivroRepository
import br.com.zup.entities.livro.response.LivroResponse
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import javax.transaction.Transactional

@Validated
@Controller("/livros")
class BuscaDetalhesDeLivrosController(val livroRepository: LivroRepository) {

    @Get
    @Transactional
    fun busca(pageable: Pageable): HttpResponse<Any> {
        return livroRepository
            .findAll(pageable)
            .map { livro ->
                LivroResponse(livro)
            }.let { listaLivros ->
                HttpResponse.ok(listaLivros)
            }
    }

}