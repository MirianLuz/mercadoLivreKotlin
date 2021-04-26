package br.com.zup.usuarios

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import javax.validation.Valid

//@Singleton
@Controller("/usuario")
class UsuarioController(@Inject private val usuarioRepository: UsuarioRepository) {

    @Post
    //@Transactional
    fun cadastra(@Body @Valid request: UsuarioRequest): HttpResponse<Any>{
        if(usuarioRepository.existsByEmail(request.email)){
            return HttpResponse.badRequest("Usuário já cadastrado")
        }

        val usuario = usuarioRepository.save(request.toModel())


        val uri = UriBuilder.of("/usuario/{id}")
            .expand(mutableMapOf(Pair("id", usuario.id)))
        return HttpResponse.created(uri)
    }
}