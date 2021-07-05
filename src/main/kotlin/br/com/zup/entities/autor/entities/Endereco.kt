package br.com.zup.entities.autor.entities

import javax.persistence.Embeddable

@Embeddable
 class Endereco(
    val rua: String,
    val cidade: String,
    val estado: String,
    val cep: String,
    val numero: String,
    val bairro: String
)