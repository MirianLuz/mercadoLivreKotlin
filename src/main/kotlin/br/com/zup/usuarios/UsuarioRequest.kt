package br.com.zup.usuarios

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class UsuarioRequest(

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Size(min = 6)
    val senha: String

){
    fun toModel(): Usuario {
        return Usuario(email, senha)
    }
}