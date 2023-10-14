package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.input.CozinhaInput;
import com.algaworks.algafood.core.springdoc.PageableParameter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Cozinhas")
public interface CozinhaControllerOpenApi {

	@Operation(summary = "Lista as cozinhas")
	@PageableParameter
	PagedModel<CozinhaModel> listar(@Parameter(hidden = true) Pageable pageable);

	@Operation(summary = "Busca uma cozinha por ID")
	CozinhaModel buscar(@Parameter(description = "ID de uma cozinha", example = "1", required = true) Long cozinhaId);

	@Operation(summary = "Adiciona uma nova cozinha")
	CozinhaModel adicionar(@RequestBody(description = "Representação de uma cozinha", required = true) CozinhaInput cozinhaInput);

	@Operation(summary = "Atualiza uma cozinha por ID")
	CozinhaModel atualizar(@Parameter(description = "ID de uma cozinha", example = "1", required = true) Long cozinhaId, @RequestBody(description = "Representação de uma cozinha com os dados atualizados", required = true) CozinhaInput cozinhaInput);

	@Operation(summary = "Excluí uma cozinha por ID")
	void remover(@Parameter(description = "ID de uma cozinha", example = "1", required = true) Long cozinhaId);
}
