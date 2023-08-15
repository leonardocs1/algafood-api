package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioInput {

	@ApiModelProperty(example = "João", required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(example = "joao@email.com", required = true)
	@NotBlank
	@Email
	private String email;
}
