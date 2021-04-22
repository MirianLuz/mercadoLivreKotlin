package br.com.zup.produtos

import br.com.zup.caracteristicas.Catacteristica
import br.com.zup.categorias.Categoria
import org.hibernate.annotations.Type
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Produto (
    @field:NotBlank
    @Column(nullable = false, unique = true)
    val nome: String,

    @field: NotNull
    val valor: BigDecimal,

    @field: NotNull
    val qtdeDisponivel: Int,

    val caracteristica : Set<Catacteristica>,

    @field:NotBlank
    val descricao: String,

    @field:NotBlank
    val categoria : Categoria,

    val instanteCadastro : LocalDateTime = LocalDateTime.now()

){
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    var id: UUID? = null
}