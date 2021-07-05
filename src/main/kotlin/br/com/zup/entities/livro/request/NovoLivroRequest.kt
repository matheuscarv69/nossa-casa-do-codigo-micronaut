package br.com.zup.entities.livro.request

import br.com.zup.core.anotacoes.Categoria
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank

@Introspected
data class NovoLivroRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank val autor: String,
    @field:NotBlank @field:Categoria val categoria: String,
//    @field:JsonFormat(pattern = "dd/MM/yyyy")
//    val publicacao: LocalDate
)
