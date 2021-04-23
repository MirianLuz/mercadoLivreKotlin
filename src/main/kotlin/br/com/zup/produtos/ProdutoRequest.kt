package br.com.zup.produtos

import br.com.zup.caracteristicas.Caracteristica
import br.com.zup.categorias.Categoria
import br.com.zup.categorias.CategoriaRepository
import br.com.zup.categorias.CategoriaResponse
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.util.*
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

    @field: Size(min = 1)
    val caracteristica : Set<Caracteristica>,

    @field:NotBlank
    @field: Size(max =  1000)
    val descricao: String,

    @field:NotBlank
    val categoriaId : UUID

    ){

    fun toModel(categoriaRepository: CategoriaRepository): Produto{
        val categoria = categoriaRepository.findById(categoriaId)
        return Produto(nome, valor, qtdeDisponivel,caracteristica, descricao, categoria.get())
    }
}