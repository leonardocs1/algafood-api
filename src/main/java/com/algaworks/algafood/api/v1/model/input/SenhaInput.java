package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SenhaInput {

	@Schema(example = "1234")
	@NotBlank
	private String senhaAtual;

	@Schema(example = "1234")
	@NotBlank
	@Size(min = 4, max = 12)
	private String novaSenha;
}
