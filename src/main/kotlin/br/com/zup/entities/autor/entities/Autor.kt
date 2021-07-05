package br.com.zup.entities.autor.entities

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(
    val nome: String,
    val email: String,
    val cpf: String,
    val endereco: Endereco,
    var descricao: String
) {

    @Id
    @GeneratedValue
    val id: Long? = null

    val criadoEm: LocalDateTime = LocalDateTime.now()



}
