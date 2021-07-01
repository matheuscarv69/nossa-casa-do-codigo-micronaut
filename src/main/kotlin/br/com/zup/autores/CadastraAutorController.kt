package br.com.zup.autores

import br.com.zup.autores.request.NovoAutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController {

    @Post
    fun cadastra(@Body @Valid req: NovoAutorRequest) {
        println("Request -> $req")

        req.paraAutor().also {
            println("Request convertida para Autor: ")
            println("Autor: ${it.nome}")
        }

    }

}