package com.algaworks.algafood.api.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.FotoProdutoInput;
import com.algaworks.algafood.api.model.FotoProdutoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Produtos")
public interface RestauranteProdutoFotoControllerOpenApi {

	@ApiOperation("Atualiza a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Foto do produto atualizada"),
		@ApiResponse(code = 404, message = "Produto do restaurante não encontrado", response = Problem.class)
	})
	FotoProdutoModel atualizarFoto(
			@ApiParam(value = "ID do restaurante", example = "1") Long restauranteId, 
			@ApiParam(value = "ID do produto", example = "1") Long produtoId,
			FotoProdutoInput fotoProdutoInput) throws IOException;
	
	@ApiOperation("Excluí a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Foto do produto atualizada"),
		@ApiResponse(code = 400, message = "ID do restaurante ou produto inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Produto do restaurante não encontrado", response = Problem.class)
	})
	public void remover(
			@ApiParam(value = "ID do restaurante", example = "1") Long restauranteId,
			@ApiParam(value = "ID do produto", example = "1")Long produtoId);

	
	@ApiOperation(value = "Busca a foto do produto de um restaurante", produces = "application/json, image/jpeg, image/png")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do restaurante ou produto inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Produto do restaurante não encontrado", response = Problem.class)
	})
	FotoProdutoModel buscar(
			@ApiParam(value = "ID do restaurante", example = "1") Long restauranteId, 
			@ApiParam(value = "ID do produto", example = "1") Long produtoId);

	@ApiOperation(value = "Busca a foto do produto de um restaurante", hidden = true)
	ResponseEntity<?> servir(Long restauranteId,
			Long produtoId, String acceptHeader)
					throws HttpMediaTypeNotAcceptableException;

	
	
}
