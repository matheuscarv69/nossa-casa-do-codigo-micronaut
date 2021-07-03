package br.com.zup.autores.controllers

import br.com.zup.autores.entities.autor.repositories.AutorRepository
import br.com.zup.autores.response.DetalhesDoAutorResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import javax.transaction.Transactional

@Controller("/autores/{id}")
class AtualizarAutorController(val autorRepository: AutorRepository) {

    @Put
    @Transactional
    fun atualiza(@PathVariable id: Long, descricaoReq: String): HttpResponse<Any> {
        return autorRepository.findById(id).let { possivelAutor ->
            if (possivelAutor.isEmpty) {
                return HttpResponse.notFound()
            }
            possivelAutor.get()
        }.apply {
            this.descricao = descricaoReq
//            autorRepository.update(this) // omitido pois a classe esta anotada com @Transactional e o autor encontra-se no estado de managed
        }.let { autorAtualizado ->
            HttpResponse.ok(DetalhesDoAutorResponse(autorAtualizado))
        }
    }

}