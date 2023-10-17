package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.model.input.SenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@SecurityRequirement(name = "security_auth")
@Tag(name = "Usuários")
public interface UsuarioControllerOpenApi {

	@Operation(summary = "Lista os usuários")
	CollectionModel<UsuarioModel> listar();

	@Operation(summary = "Busca o usuário por ID")
	UsuarioModel buscar(@Parameter(description = "ID do usuário", example = "1", required = true) Long usuarioId);

	@Operation(summary = "Cadastra um usuário")
	UsuarioModel adicionar(@RequestBody(description = "Representação de um novo usuário", required = true) UsuarioComSenhaInput usuarioInput);

	@Operation(summary = "Atualiza um usuário por ID")
	UsuarioModel atualizar( 
			@Parameter(description = "ID do usuário", example = "1", required = true) Long usuarioId, 
			@RequestBody(description = "Representação de um usuário com os novos dados", required = true) UsuarioInput usuarioInput);

	@Operation(summary = "Atualiza a senha de um usuário")
	void atualizarSenha(
			@Parameter(description = "ID do usuário", example = "1", required = true) Long usuarioId, 
			@RequestBody(description = "Representação de um nova senha", required = true) SenhaInput senhaInput);
}
