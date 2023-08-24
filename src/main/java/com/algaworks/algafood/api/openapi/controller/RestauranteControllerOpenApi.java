package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.model.RestauranteBasicoModel;
import com.algaworks.algafood.api.model.RestauranteModel;
import com.algaworks.algafood.api.model.input.RestauranteInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {

	@ApiOperation(value = "Lista restaurantes", response = RestauranteBasicoModel.class)
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nome da projeção de pedidos", allowableValues = "apenas-nome",
				name = "projecao", paramType = "query", type = "string")
	})
	CollectionModel<RestauranteBasicoModel> listar();

	@ApiIgnore
	@ApiOperation(value = "Lista restaurantes", hidden = true)
	CollectionModel<RestauranteApenasNomeModel> listarApenasNome();

	@ApiOperation("Busca um restaurante por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "ID do restaurante não encontrado", response = Problem.class)
	})
	RestauranteModel buscar(@ApiParam(value = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@ApiOperation("Cadastra um restaurante")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Restaurante cadastrado")
	})
	RestauranteModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo restaurante", required = true) RestauranteInput restauranteInput);

	@ApiOperation("Atualiza um restaurante")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Restaurante atualizado"),
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "ID do restaurante não encontrado", response = Problem.class)
	})
	RestauranteModel atualizar(@ApiParam(value = "ID de um restaurante", required = true) Long restauranteId, 
			@ApiParam(name = "corpo", value = "Representação de um restaurante com os novos dados", required = true ) RestauranteInput restauranteInput);

	@ApiOperation("Ativa um restaurante")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante ativado"), 
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "ID do restaurante não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> ativar(@ApiParam(value = "ID de um restaurante", required = true) Long restauranteId);
	
	@ApiOperation("Inativa um restaurante")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante inativado"),
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "ID do restaurante não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> inativar(@ApiParam(value = "ID de um restaurante", required = true)Long restauranteId);

	@ApiOperation("Ativa uma lista de restaurantes")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurantes ativados"),
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
	})
	void ativarMultiplos(@ApiParam(value = "Lista de ID de restaurante", required = true) List<Long> restaurantesIds);

	@ApiOperation("Inativa uma lista de restaurantes")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurantes inativados"),
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
	})
	void inativarMultiplos(@ApiParam(value = "Lista de ID de restaurante", required = true) List<Long> restaurantesIds) ;

	@ApiOperation("Abre um restaurante")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante aberto"),
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "ID do restaurante não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> abrir(@ApiParam(value = "ID de um restaurante", required = true) Long restauranteId);

	@ApiOperation("Fecha um restaurante")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante aberto"),
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "ID do restaurante não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> fechar(@ApiParam(value = "ID de um restaurante", required = true) Long restauranteId);
}
