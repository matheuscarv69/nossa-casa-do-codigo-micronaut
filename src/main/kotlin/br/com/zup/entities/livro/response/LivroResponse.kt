package br.com.zup.entities.livro.response

import br.com.zup.entities.livro.entities.Livro

data class LivroResponse(
    val nome: String,
    val autor: String,
    val categoria: String,
    val isbn: String
) {

    constructor(livro: Livro) : this(
        nome = livro.nome,
        autor = livro.autor,
        categoria = livro.categoria,
        isbn = livro.isbn
    )

}