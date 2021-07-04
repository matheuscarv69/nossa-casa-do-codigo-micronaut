package br.com.zup.autores.response

data class EnderecoResponse(
    val cep: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val street: String,
    val service: String
)
