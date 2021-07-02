package br.com.zup.autores.response

import br.com.zup.autores.entities.autor.entity.Autor

class DetalhesDoAutorResponse(autor: Autor) {

    val nome = autor.nome
    val email = autor.email
    val cpf = autor.cpf
    val descricao = autor.descricao
    val criadoEm = autor.criadoEm

}
