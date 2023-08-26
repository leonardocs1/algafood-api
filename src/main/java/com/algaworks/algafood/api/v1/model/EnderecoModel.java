package com.algaworks.algafood.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoModel {

	@ApiModelProperty(example = "38400-200")
	private String cep;
	
	@ApiModelProperty(example = "Rua 01")
	private String logradouro;
	
	@ApiModelProperty(example ="930")
	private String numero;
	
	@ApiModelProperty(example = "Casa 20")
	private String complemento;
	
	@ApiModelProperty(example = "Martins")
	private String bairro;
	
	private CidadeResumoModel cidade;
}

