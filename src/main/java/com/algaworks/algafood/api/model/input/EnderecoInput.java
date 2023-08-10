package com.algaworks.algafood.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoInput {

	@ApiModelProperty(example = "38400-000", required = true)
	@NotBlank
	private String cep;
	
	@ApiModelProperty(example = "Rua 04", required = true)
	@NotBlank
	private String logradouro;
	
	@ApiModelProperty(example = "900", required = true)
	@NotBlank
	private String numero;
	
	@ApiModelProperty(example = "Sem complemento")
	private String complemento;
	
	@ApiModelProperty(example = "Catumbi", required = true)
	@NotBlank
	private String bairro;
	
	@Valid
	@NotNull
	private CidadeIdInput cidade;
}
