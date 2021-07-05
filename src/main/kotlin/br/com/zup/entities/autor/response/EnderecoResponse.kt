package br.com.zup.entities.autor.response

import br.com.zup.entities.autor.entities.Endereco

data class EnderecoResponse(
    val cep: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val street: String,
) {

    fun paraEndereco(numero: String): Endereco {
        return Endereco(
            cep = cep,
            estado = state,
            cidade = city,
            bairro = neighborhood,
            rua = street,
            numero = numero
        )
    }
}
