package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.GrupoModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@Operation(summary = "Lista os grupos associados a um usuário")
	CollectionModel<GrupoModel> listar(
			@Parameter(description = "ID de um usuário", example = "1", required = true) Long usuarioId);

	@Operation(summary = "Associação de grupo com usuário")
	ResponseEntity<Void> associar(
			@Parameter(description = "ID de um usuário", example = "1", required = true) Long usuarioId,
			@Parameter(description = "ID de um grupo", example = "1", required = true) Long grupoId);

	@Operation(summary = "Desassociação de grupo com usuário")
	ResponseEntity<Void> desassociar(
			@Parameter(description = "ID de um usuário", example = "1", required = true) Long usuarioId,
			@Parameter(description = "ID de um grupo", example = "1", required = true) Long grupoId);

}
