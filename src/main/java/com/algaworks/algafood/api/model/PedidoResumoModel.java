package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoResumoModel {

	@ApiModelProperty(example = "8d774bcf-b238-42f3-aef1-5fb388754d63")
	private String codigo;
	
	@ApiModelProperty(example = "87.20")
	private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.00")
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "100.00")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CRIADO")
	private String status;
	
	@ApiModelProperty(example = "2019-11-03T02:00:30Z")
	private OffsetDateTime dataCriacao;
	
	private RestauranteResumoModel restaurante;
	
	@ApiModelProperty(example = "José da Silva")
	private String nomeCliente;
}
