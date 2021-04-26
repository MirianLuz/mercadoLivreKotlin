package br.com.zup.opinioes

import br.com.zup.produtos.ProdutoRepository
import br.com.zup.usuarios.Usuario
import br.com.zup.usuarios.UsuarioRepository
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import java.util.*
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/produto/{id}/opiniao")
class OpiniaoController(
    @Inject val produtoRepository: ProdutoRepository,
    @Inject val opiniaoRepository: OpiniaoRepository
) {

    @Post
    @Transactional
    fun cadastra(@Body @Valid request: OpiniaoRequest, @PathVariable id: UUID) : HttpResponse<Any>{

        if(produtoRepository.existsById(id) == false){
            return HttpResponse.badRequest("Produto não encontrado")
        }
        val produto = produtoRepository.findById(id)

        val opiniao = opiniaoRepository.save(request.toModel(produto.get()))

        val uri = UriBuilder.of("produto/{id}/opiniao").expand(mutableMapOf(Pair("id", opiniao)))

        return HttpResponse.created(uri)
    }
}