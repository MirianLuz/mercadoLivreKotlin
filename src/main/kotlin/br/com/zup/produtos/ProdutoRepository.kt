package br.com.zup.produtos

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface ProdutoRepository : JpaRepository<Produto, UUID>{
}