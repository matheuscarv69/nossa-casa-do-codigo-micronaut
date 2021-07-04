package br.com.zup.core

import br.com.zup.autores.response.EnderecoResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.client.annotation.Client

@Client("\${url-service-cep}")
interface EnderecoClient {

    @Get("/{cep}")
    fun consulta(cep: String): HttpResponse<EnderecoResponse>

//    Consumindo XML 
//    @Get("/{cep}", consumes = [MediaType.APPLICATION_XML]) // Uma forma de declarar o consumes/retorno como xml
//    @Get("/{cep}")
//    @Consumes(MediaType.APPLICATION_XML) // outra forma de definir o consumes/retorno
//    @Produces(MediaType.APPLICATION_XML) // outra forma de definir o producer/request
//    fun consulta(cep: String): HttpResponse<EnderecoResponse>


}