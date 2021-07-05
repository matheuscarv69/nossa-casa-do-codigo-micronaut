package br.com.zup.entities.autor.response

import br.com.zup.entities.autor.entities.Autor

class DetalhesDoAutorResponse(autor: Autor) {

    val nome = autor.nome
    val email = autor.email
    val cpf = autor.cpf
    val descricao = autor.descricao
    val criadoEm = autor.criadoEm.toString()
    val endereco = EnderecoResponse(autor.endereco)

}
