package br.com.zup.autores.request

import br.com.zup.autores.entities.autor.entity.Autor
import br.com.zup.autores.entities.autor.entity.Endereco
import br.com.zup.autores.response.EnderecoResponse
import io.micronaut.core.annotation.Introspected
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoAutorRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String,
    @field:CPF val cpf: String,
    @field:NotBlank val cep: String,
    @field:NotBlank val numero: String,
    @field:NotBlank @field:Size(max = 400) val descricao: String
) {

    fun paraAutor(enderecoResp: EnderecoResponse): Autor {
        val endereco = Endereco(enderecoResp = enderecoResp, numero = numero)

        return Autor(
            nome = nome,
            email = email,
            cpf = cpf,
            endereco = endereco,
            descricao = descricao
        )
    }

}
