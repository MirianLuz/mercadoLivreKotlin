package br.com.zup.categorias

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.validation.constraints.NotBlank

@Introspected
data class CategoriaRequest(
    @field:NotBlank
    @Column(nullable = false, unique = true)
    val nome: String
) {
    fun toModel(): Categoria{
        return Categoria(nome)
    }
}
