package br.com.zup.autores

import br.com.zup.autores.entities.autor.repositories.AutorRepository
import br.com.zup.autores.request.NovoAutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid req: NovoAutorRequest) {
        println("Request -> $req")

        req.paraAutor().apply {
            println("Request convertida para Autor: ")
            println("Autor: ${this.nome}")
            autorRepository.save(this)
        }

    }

}