package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.UsuarioModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Restaurantes")
public interface RestauranteUsuarioResponsavelControllerOpenApi {

	@Operation(summary = "Lista os usuários responsáveis associados ao restaurante")
	CollectionModel<UsuarioModel> listar(
			@Parameter(description = "ID do restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Associação de restaurante com usuário responsável")
	ResponseEntity<Void> associar(
			@Parameter(description = "ID do restaurante", example = "1", required = true) Long restauranteId, 
			@Parameter(description = "ID do usuário responsável", example = "1", required = true) Long usuarioId);

	@Operation(summary = "Desassociação de restaurnte com usuário responsável")
	ResponseEntity<Void> desassociar(
			@Parameter(description = "ID do restaurante", example = "1", required = true) Long restauranteId, 
			@Parameter(description = "ID do usuário responsável", example = "1", required = true) Long usuarioId);

}
