package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.input.ProdutoInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Produtos")
public interface ProdutosControllerOpenApi {

	@Operation(summary = "Lista os produtos de um restaurante")
	CollectionModel<ProdutoModel> listar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "Incluir ou não produtos inativos", example = "true", required = false) Boolean incluirInativos);

	@Operation(summary = "Busca um produto de um restaurante")
	ProdutoModel buscar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de um produto", example = "1", required = true) Long produtoId);

	@Operation(summary = "Cadastra um produto de um restaurante")
	ProdutoModel adicionar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "Descrição de um produto", required = true) ProdutoInput produtoInput);

	@Operation(summary = "Atualiza um produto de um restaurante")
	ProdutoModel atualizar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de um produto", example = "1", required = true) Long produtoId,
			@Parameter(description = "Descrição de um produto", required = true) ProdutoInput produtoInput);
}
