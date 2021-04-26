package br.com.zup.opinioes

import br.com.zup.produtos.Produto
import br.com.zup.usuarios.Usuario
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Opiniao (

    @field:Min(1)
    @field:Max(5)
    val nota: Int,

    @field:NotBlank
    val titulo: String,

    @field:NotBlank
    @field:Size(max = 500)
    val descricao: String,

    @field:NotBlank
    @field:ManyToOne
    val produto: Produto
        ){

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    val id: UUID? = null
}