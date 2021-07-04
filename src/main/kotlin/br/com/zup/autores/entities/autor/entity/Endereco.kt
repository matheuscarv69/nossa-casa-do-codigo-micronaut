package br.com.zup.autores.entities.autor.entity

import br.com.zup.autores.response.EnderecoResponse
import javax.persistence.Embeddable

@Embeddable
class Endereco(
    enderecoResp: EnderecoResponse,
    val numero: String
) {

    val rua = enderecoResp.street
    val cidade = enderecoResp.city
    val estado = enderecoResp.state
    val cep = enderecoResp.cep
    val bairro = enderecoResp.neighborhood

}
