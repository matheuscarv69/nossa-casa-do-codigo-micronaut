package br.com.zup.entities.autor.controllers

import br.com.zup.core.EnderecoClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class CadastraAutorControllerTest{

    @field:Inject
    lateinit var enderecoClient: EnderecoClient

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient


    @Test
    internal fun `Deve cadastrar um novo Autor`() {



    }


}