package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.v1.model.RestauranteBasicoModel;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.api.v1.model.input.RestauranteInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Restaurantes")
public interface RestauranteControllerOpenApi {

	@Operation(summary = "Lista os restaurantes", parameters = {
			@Parameter(name = "projecao",
					   description = "Nome da projeção",
					   example = "apenas-nome",
					   in = ParameterIn.QUERY,
					   required = false
					)
	})
	CollectionModel<RestauranteBasicoModel> listar();

	@Operation(hidden = true)
	CollectionModel<RestauranteApenasNomeModel> listarApenasNome();

	@Operation(summary = "Busca um restaurante por ID")
	RestauranteModel buscar(@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Adiciona um restaurante")
	RestauranteModel adicionar(@Parameter(description = "Representação de um restaurante", required = true) RestauranteInput restauranteInput);

	@Operation(summary = "Atualiza um restaurante por ID")
	RestauranteModel atualizar(@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId, 
			@Parameter(description = "Representação de um restaurante com os dados", required = true) RestauranteInput restauranteInput);

	@Operation(summary = "Ativa um restaurante por ID")
	ResponseEntity<Void> ativar(@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Inativa um restaurante por ID")
	ResponseEntity<Void> inativar(@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Ativa múltiplos resturantes")
	void ativarMultiplos(@Parameter(description = "IDs de restaurantes") List<Long> restaurantesIds);

	@Operation(summary = "Inativa múltiplos restaurantes")
	void inativarMultiplos(@Parameter(description = "IDs de restaurantes") List<Long> restaurantesIds);

	@Operation(summary = "Abre um restaurante por ID")
	ResponseEntity<Void> abrir(@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Fecha um restaurante por ID")
	ResponseEntity<Void> fechar(@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);
}
