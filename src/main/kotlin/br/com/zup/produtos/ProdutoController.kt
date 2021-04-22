package br.com.zup.produtos

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/produto")
class ProdutoController(@Inject val produtoRepository: ProdutoRepository) {

    @Post
    @Transactional
    fun cadastra (@Body @Valid request: ProdutoRequest):HttpResponse<Any>{
        
    }

}