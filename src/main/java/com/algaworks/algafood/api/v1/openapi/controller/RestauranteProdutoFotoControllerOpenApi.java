package com.algaworks.algafood.api.v1.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.api.v1.model.FotoProdutoInput;
import com.algaworks.algafood.api.v1.model.FotoProdutoModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Produtos")
public interface RestauranteProdutoFotoControllerOpenApi {

	@Operation(summary = "Atualiza a foto do produto de um restaurante")
	FotoProdutoModel atualizarFoto(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de um produto", example = "2", required = true) Long produtoId,
			@RequestBody(required = true) FotoProdutoInput fotoProdutoInput, MultipartFile arquivo) throws IOException;

	@Operation(summary = "Busca a foto do produto de um restaurante", responses = {
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = FotoProdutoModel.class)),
					@Content(mediaType = "image/jpeg", schema = @Schema(type = "string", format = "binary")),
					@Content(mediaType = "image/png", schema = @Schema(type = "string", format = "binary")) }

			) })
	FotoProdutoModel buscar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de um produto", example = "2", required = true) Long produtoId);

	@Operation(hidden = true)
	ResponseEntity<?> servir(Long restauranteId, Long produtoId, String acceptHeader)
			throws HttpMediaTypeNotAcceptableException;

	@Operation(summary = "Exclui a foto do produto de um restaurante")
	void remover(Long restauranteId, Long produtoId);
}
