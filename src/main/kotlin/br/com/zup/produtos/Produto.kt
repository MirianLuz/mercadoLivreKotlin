package br.com.zup.produtos

import br.com.zup.caracteristicas.Caracteristica
import br.com.zup.categorias.Categoria
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import org.hibernate.annotations.Type
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Produto(
    @field:NotBlank
    @Column(nullable = false, unique = true)
    val nome: String,

    @field: NotNull
    val valor: BigDecimal,

    @field: NotNull
    val qtdeDisponivel: Int,

    @field:OneToMany
    @Cascade(CascadeType.ALL)
    val caracteristica : Set<Caracteristica>,

    @field:NotBlank
    val descricao: String,

    @field:NotBlank
    @field:ManyToOne
   // @JoinColumn(name = "categoria_id")
    val categoria: Categoria,

    val instanteCadastro: LocalDateTime = LocalDateTime.now()

){
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    var id: UUID? = null
}

