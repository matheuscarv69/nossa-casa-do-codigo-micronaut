package br.com.zup.autores.request

import br.com.zup.autores.entities.autor.entity.Autor
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
    @field:NotBlank @field:Size(max = 400) val descricao: String
) {

    fun paraAutor() = Autor(
        nome = nome,
        email = email,
        cpf = cpf,
        descricao = descricao
    )

}
