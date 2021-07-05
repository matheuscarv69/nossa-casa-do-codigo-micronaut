package br.com.zup.entities.autor.response

import br.com.zup.entities.autor.entities.Autor
import br.com.zup.entities.autor.entities.Endereco

data class DetalhesDoAutorResponse(
    val nome: String,
    val email: String,
    val cpf: String,
    val descricao: String,
    val criadoEm: String,
    val endereco: Endereco
) {

    constructor(autor: Autor) : this(
        autor.nome,
        autor.email,
        autor.cpf,
        autor.descricao,
        autor.criadoEm.toString(),
        Endereco(autor.endereco)
    )

}
