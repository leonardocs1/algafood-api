package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.input.ProdutoInput;

public interface ProdutosControllerOpenApi {

	CollectionModel<ProdutoModel> listar(Long restauranteId, Boolean incluirInativos);

	ProdutoModel buscar(Long restauranteId, Long produtoId);

	ProdutoModel adicionar(Long restauranteId, ProdutoInput produtoInput);

	ProdutoModel atualizar(Long restauranteId, ProdutoInput produtoInput);
}
