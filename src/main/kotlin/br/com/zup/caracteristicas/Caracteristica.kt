package br.com.zup.caracteristicas

import br.com.zup.produtos.Produto
import org.hibernate.annotations.Type
import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@Entity
class Caracteristica (
    @field:NotBlank
    val nome: String,

    @field:NotBlank
    val descricao: String,

//    @field:NotBlank
//    @ManyToOne
//    val produto: Produto
        ){
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    var id: UUID? = null
}
