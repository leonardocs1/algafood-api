package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.api.v1.model.input.PedidoInput;
import com.algaworks.algafood.core.springdoc.PageableParameter;
import com.algaworks.algafood.domain.filter.PedidoFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Pedidos")
public interface PedidoControllerOpenApi {

	@Operation(summary = "Pesquisa os pedidos",
			parameters = {
					@Parameter(in = ParameterIn.QUERY, name = "clientId",
								description = "ID do cliente para filtro de pesquisa",
								example = "1", schema = @Schema(type = "integer")),
					@Parameter(in = ParameterIn.QUERY, name = "restauranteId",
								description = "ID do restaurante para filtro de pesquisa",
								example = "1", schema = @Schema(type = "integer")),
					@Parameter(in = ParameterIn.QUERY, name = "dataCriacaoInicio",
							   description = "Data/hora de criação inicial de um pedido para filtro de pesquisa",
							   example = "2023-12-01T00:00:00Z", schema = @Schema(type = "string", format = "date-time")),
					@Parameter(in = ParameterIn.QUERY, name = "dataCriacaoFim",
					   description = "Data/hora de criação final de um pedido para filtro de pesquisa",
					   example = "2023-12-01T00:00:00Z", schema = @Schema(type = "string", format = "date-time"))
			})
	@PageableParameter
	PagedModel<PedidoResumoModel> pesquisar(@Parameter(hidden = true) PedidoFilter filtro, @Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Busca um pedido por código")
	PedidoModel buscar(@Parameter(description = "Código do pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true) String codigoPedido);

	@Operation(summary = "Registra um pedido")
	PedidoModel adicionar(@RequestBody(description = "Representação de um pedido", required = true) PedidoInput pedidoInput);

}
