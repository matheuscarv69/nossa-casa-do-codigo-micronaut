package br.com.zup.entities.autor.controllers

import br.com.zup.core.EnderecoClient
import br.com.zup.entities.autor.entities.Autor
import br.com.zup.entities.autor.repositories.AutorRepository
import br.com.zup.entities.autor.request.NovoAutorRequest
import br.com.zup.entities.autor.response.EnderecoResponse
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
internal class CadastraAutorControllerTest {

    @field:Inject
    lateinit var enderecoClient: EnderecoClient

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @field:Inject
    lateinit var autorRepository: AutorRepository

    lateinit var novoAutorRequest: NovoAutorRequest
    lateinit var enderecoResp: EnderecoResponse
    var autorId: Long = -1

    @BeforeEach
    internal fun setUp() {
        // cenario
        novoAutorRequest = NovoAutorRequest(
            nome = "Rafael Ponte",
            email = "rafael.ponte@zup.com.br",
            cpf = "54058244020",
            cep = "69316398",
            numero = "692",
            descricao = "Marajá dos Legados"
        )

        enderecoResp = EnderecoResponse(
            cep = "69316398",
            state = "RR",
            city = "Boa Vista",
            neighborhood = "Senador Hélio Campos",
            street = "Avenida Abel Monteiro Reis"
        )
    }

    @AfterEach
    internal fun tearDown() {
        autorRepository.deleteById(autorId)
    }

    @Test
    internal fun `Deve cadastrar um novo Autor`() {

        // mockando a chamado para o servico externo de consulta de cep
        Mockito.`when`(enderecoClient.consulta(novoAutorRequest.cep))
            .thenReturn(HttpResponse.ok(enderecoResp))

        val request = HttpRequest.POST("/autores", novoAutorRequest)

        // acao
        val response = client.toBlocking().exchange(request, Any::class.java)



        // assertivas
        assertEquals(HttpStatus.CREATED, response.status)
        assertTrue(response.headers.contains("Location"))

        autorId = response.header("Location")!!.substring(9).toLong()

        // \\d+$ para o regex pegar toda a string, se deixar só o \\d ele só vai pegar um digito
        assertTrue(response.header("Location")!!.matches("/autores/\\d+$".toRegex()))

    }

    @MockBean(EnderecoClient::class)
    fun enderecoMock(): EnderecoClient {
        return Mockito.mock(EnderecoClient::class.java)
    }

}