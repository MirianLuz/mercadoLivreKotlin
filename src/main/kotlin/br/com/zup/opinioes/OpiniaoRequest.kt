package br.com.zup.opinioes

import br.com.zup.produtos.Produto
import br.com.zup.usuarios.Usuario
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class OpiniaoRequest (
    @field:Min(1)
    @field:Max(5)
    val nota: Int,

    @field:NotBlank
    val titulo: String,

    @field:NotBlank
    @field:Size(max = 500)
    val descricao: String,

){
    fun toModel(produto: Produto): Opiniao{
        return Opiniao(nota,titulo,descricao, produto)
    }
}