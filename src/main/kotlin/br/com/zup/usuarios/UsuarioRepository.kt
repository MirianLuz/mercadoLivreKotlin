package br.com.zup.usuarios

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface UsuarioRepository : JpaRepository<Usuario, UUID> {
    fun existsByEmail(email: String?): Boolean
}