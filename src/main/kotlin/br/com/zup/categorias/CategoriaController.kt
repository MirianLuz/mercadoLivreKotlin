package br.com.zup.categorias

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/categoria")
class CategoriaController(@Inject val categoriaRepository: CategoriaRepository) {

    @Post
    @Transactional
    fun cadastra(@Body @Valid request: CategoriaRequest) : HttpResponse<Any>{
        if(categoriaRepository.existsByNome(request.nome)){
            return HttpResponse.badRequest("Categoria já cadastrado")
        }

        val categoria = categoriaRepository.save(request.toModel())

        val uri = UriBuilder.of("/categoria/{id}")
            .expand(mutableMapOf(Pair("id", categoria.id)))

        return HttpResponse.created(uri)
    }
}