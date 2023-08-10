package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeResumoModel {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty("Uberlândia")
	private String nome;
	
	@ApiModelProperty("Minas Gerais")
	private String estado;
}
