package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemPedidoModel {

	@ApiModelProperty(example = "1")
	private Long produtoId;
	
	@ApiModelProperty(example = "Salada picante com carne grelhada")
	private String produtoNome;
	
	@ApiModelProperty(example = "1")
	private Integer quantidade;
	
	@ApiModelProperty(example = "2.99")
	private BigDecimal precoUnitario;
	
	@ApiModelProperty(example = "10.99")
	private BigDecimal precoTotal;
	
	@ApiModelProperty(example = "Sem observação")
	private String observacao;
}
