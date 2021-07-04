package br.com.zup.entities.autor.entities

import br.com.zup.entities.autor.response.EnderecoResponse
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
