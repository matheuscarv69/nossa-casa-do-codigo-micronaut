package br.com.zup.entities.livro.request

import br.com.zup.core.anotacoes.Categoria
import br.com.zup.entities.livro.entities.Livro
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.NotBlank

@Introspected
data class NovoLivroRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank val autor: String,
    @field:NotBlank @field:Categoria val categoria: String,
    @field:NotBlank val isbn: String
//    @field:JsonFormat(pattern = "dd/MM/yyyy")
//    val publicacao: LocalDate
) {

    fun paraLivro(): Livro {
        return Livro(
            nome = nome,
            autor = autor,
            categoria = categoria,
            isbn = isbn
        )
    }

}
