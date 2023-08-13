package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoModel {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Picanha Completa")
	private String nome;
	
	@ApiModelProperty(example = "Acompanha arroz, mandioca e feijão tropeiro")
	private String descricao;
	
	@ApiModelProperty(example = "99.90")
	private BigDecimal preco;
	
	@ApiModelProperty(example = "true")
	private Boolean ativo;
	
}
