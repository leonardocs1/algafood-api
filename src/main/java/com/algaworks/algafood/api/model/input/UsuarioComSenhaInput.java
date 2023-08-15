package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioComSenhaInput extends UsuarioInput {

	@ApiModelProperty(example = "1234", required = true)
	@NotBlank
	@Size(min = 4, max = 12)
	private String senha;
}
