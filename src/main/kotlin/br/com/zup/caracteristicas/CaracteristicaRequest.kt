package br.com.zup.caracteristicas

import br.com.zup.produtos.Produto
import io.micronaut.core.annotation.Introspected
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@Introspected
data class CaracteristicaRequest(
    @field:NotBlank
    val nome: String,

    @field:NotBlank
    val descricao: String,

//    @field:NotBlank
//    @ManyToOne
//    val produto: Produto
){
    fun toModel(): Caracteristica{
        return Caracteristica(nome, descricao)
    }
}