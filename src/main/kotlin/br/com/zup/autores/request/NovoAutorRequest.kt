package br.com.zup.autores.request

data class NovoAutorRequest(
    val nome: String,
    val email: String,
    val descricao: String
)
