package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.PermissaoModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Grupos")
public interface GrupoPermissaoControllerOpenApi {

	@Operation(summary = "Lista as permissões associadas a um grupo")
	CollectionModel<PermissaoModel> listar(
			@Parameter(description = "ID do grupo", example = "1", required = true) Long grupoId);

	@Operation(summary = "Associação de permissão com grupo")
	ResponseEntity<Void> associar(@Parameter(description = "ID do grupo", example = "1", required = true) Long grupoId,
			@Parameter(description = "ID da permissão", example = "1", required = true) Long permissaoId);

	@Operation(summary = "Desassociação de permissão com grupo")
	ResponseEntity<Void> dessasociar(
			@Parameter(description = "ID do grupo", example = "1", required = true) Long grupoId,
			@Parameter(description = "ID da permissão", example = "1", required = true) Long permissaoId);

}
