package br.com.zup.categorias

import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Categoria (

    @field:NotBlank
    @Column(nullable = false, unique = true)
    val nome: String

        ) {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    var id: UUID? = null
}