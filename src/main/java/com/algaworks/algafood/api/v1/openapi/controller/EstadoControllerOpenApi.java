package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.EstadoModel;
import com.algaworks.algafood.api.v1.model.input.EstadoInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Estados")
public interface EstadoControllerOpenApi {

	@Operation(summary = "Lista os estados")
	CollectionModel<EstadoModel> listar();

	@Operation(summary = "Busca um estado por ID")
	EstadoModel buscar(@Parameter(description = "ID de um estado", example = "1", required = true) Long estadoId);

	@Operation(summary = "Adiciona um estado")
	EstadoModel adicionar(@RequestBody(description = "Representação de um estado", required = true) EstadoInput estadoInput);

	@Operation(summary = "Atualiza um estado por ID")
	EstadoModel atualizar(@Parameter(description = "ID de um estado", example = "1", required = true) Long estadoId,  @RequestBody(description = "Representação de um estado com os dados atualizados", required = true) EstadoInput estadoInput);

	@Operation(summary = "Remove um estado por ID")
	void remover(@Parameter(description = "ID de um estado", example = "1", required = true) Long estadoId);
}
