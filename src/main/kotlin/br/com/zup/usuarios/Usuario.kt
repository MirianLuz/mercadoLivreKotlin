package br.com.zup.usuarios

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.*
import javax.inject.Singleton
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Usuario(

    @field:NotBlank
    @Column(nullable = false, unique = true)
    val email: String,

    @field:NotBlank
    val senha : String,

        ){

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    var id: UUID? = null

    @Column(nullable = false)
    val dataCadastro = LocalDateTime.now()
}