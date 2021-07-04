package br.com.zup.core

import br.com.zup.autores.response.EnderecoResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("\${url-service-cep}")
interface EnderecoClient {

    @Get("/{cep}")
    fun consulta(cep: String): HttpResponse<EnderecoResponse>


}