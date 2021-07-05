package br.com.zup.entities.livro.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
class Livro(
    val nome: String,
    val autor: String,
    val categoria: String,
    @Column(unique = true) val isbn: String
) {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null


}