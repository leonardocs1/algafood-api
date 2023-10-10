package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SenhaInput {

	@NotBlank
	private String senhaAtual;

	@NotBlank
	@Size(min = 4, max = 12)
	private String novaSenha;
}
