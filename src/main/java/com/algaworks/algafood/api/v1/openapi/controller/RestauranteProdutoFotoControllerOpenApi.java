package com.algaworks.algafood.api.v1.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.api.v1.model.FotoProdutoInput;
import com.algaworks.algafood.api.v1.model.FotoProdutoModel;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "security_auth")
public interface RestauranteProdutoFotoControllerOpenApi {

	FotoProdutoModel atualizarFoto(Long restauranteId, Long produtoId, FotoProdutoInput fotoProdutoInput,
			MultipartFile arquivo) throws IOException;

	public void remover(Long restauranteId, Long produtoId);

	FotoProdutoModel buscar(Long restauranteId, Long produtoId);

	ResponseEntity<?> servir(Long restauranteId, Long produtoId, String acceptHeader)
			throws HttpMediaTypeNotAcceptableException;
}
