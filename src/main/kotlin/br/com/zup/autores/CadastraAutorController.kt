package br.com.zup.autores

import br.com.zup.autores.request.NovoAutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/autores")
class CadastraAutorController {

    @Post
    fun cadastra(@Body req: NovoAutorRequest) {
        println(req)
    }

}