package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Pedidos")
public interface FluxoPedidoControllerOpenApi {

	@Operation(summary = "Registra confirmação de pedido")
	ResponseEntity<Void> confirmar(@Parameter(description = "Código de pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true) String codigoPedido);

	@Operation(summary = "Registra cancelamento de pedido")
	ResponseEntity<Void> cancelar(@Parameter(description = "Código de pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true) String codigoPedido);

	@Operation(summary = "Registra entrega de pedido")
	ResponseEntity<Void> entregar(@Parameter(description = "Código de pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true) String codigoPedido);
}
