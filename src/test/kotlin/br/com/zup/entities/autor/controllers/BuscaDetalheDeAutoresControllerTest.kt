package br.com.zup.entities.autor.controllers

import br.com.zup.entities.autor.entities.Autor
import br.com.zup.entities.autor.entities.Endereco
import br.com.zup.entities.autor.repositories.AutorRepository
import br.com.zup.entities.autor.response.DetalhesDoAutorResponse
import br.com.zup.entities.autor.response.EnderecoResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class BuscaDetalheDeAutoresControllerTest {

    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    lateinit var autor: Autor

    @BeforeEach
    internal fun setUp() {
        val enderecoResp = EnderecoResponse(
            "69316398",
            "RR",
            "Boa Vista",
            "Senador Hélio Campos",
            "Avenida Abel Monteiro Reis"
        )

        val endereco = enderecoResp.paraEndereco("692")

        autor = Autor(
            "Rafael Ponte",
            "rafael.ponte@zup.com.br",
            "10489029000",
            endereco,
            "Marajá dos Legados"
        )

        autorRepository.save(autor)
    }

    @AfterEach
    internal fun tearDown() {
        autorRepository.deleteAll()
    }

    @Test
    internal fun `deve retornar os detalhes de um autor`() {

        val response = client
            .toBlocking()
            .exchange("/autores?email=${autor.email}", DetalhesDoAutorResponse::class.java)

        println(response)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())

        assertEquals(autor.nome, response.body()!!.nome)
        assertEquals(autor.email, response.body()!!.email)
        assertEquals(autor.descricao, response.body()!!.descricao)
    }
}