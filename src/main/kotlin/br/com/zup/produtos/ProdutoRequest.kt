package br.com.zup.produtos

import br.com.zup.caracteristicas.Catacteristica
import br.com.zup.categorias.Categoria
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.persistence.Column
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

@Introspected
data class ProdutoRequest (
    @field:NotBlank
    @Column(nullable = false, unique = true)
    val nome: String,

    @field: NotNull
    @field: Positive
    val valor: BigDecimal,

    @field: NotNull
    @field: Positive
    val qtdeDisponivel: Int,

    @field: Size(min = 3)
    val caracteristica : Set<Catacteristica>,

    @field:NotBlank
    @field: Size(max =  1000)
    val descricao: String,

    @field:NotBlank
    val categoria : Categoria

    ){

    fun toModel(): Produto{
        return Produto(nome, valor, qtdeDisponivel, caracteristica, descricao, categoria)
    }
}