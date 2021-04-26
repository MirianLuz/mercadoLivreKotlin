package br.com.zup.produtos

import br.com.zup.categorias.CategoriaRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/produto")
class ProdutoController(
    @Inject val produtoRepository: ProdutoRepository,
    @Inject val categoriaRepository: CategoriaRepository
) {

    @Post
    //@Transactional
    fun cadastra (@Body @Valid request: ProdutoRequest):HttpResponse<Any>{
        val produto = produtoRepository.save(request.toModel(categoriaRepository))

        val uri = UriBuilder.of("/produto/{id}").expand(mutableMapOf(Pair("id", produto.id)))

        return HttpResponse.created(uri)
    }

}