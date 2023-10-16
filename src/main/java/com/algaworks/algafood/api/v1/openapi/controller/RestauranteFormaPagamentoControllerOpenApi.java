package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Restaurantes")
public interface RestauranteFormaPagamentoControllerOpenApi {

	@Operation(summary = "Lista as formas de pagamentos associadas ao restaurante")
	CollectionModel<FormaPagamentoModel> listar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId);

	@Operation(summary = "Associação de restaurante com forma de pagamento")
	ResponseEntity<Void> associar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId);

	@Operation(summary = "Desassociação de restaurante com forma de pagamento")
	ResponseEntity<Void> desassociar(
			@Parameter(description = "ID de um restaurante", example = "1", required = true) Long restauranteId,
			@Parameter(description = "ID de uma forma de pagamento", example = "1", required = true) Long formaPagamentoId);
}
