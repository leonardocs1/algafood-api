package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoModel {

	@ApiModelProperty(example = "8d774bcf-b238-42f3-aef1-5fb388754d63")
	private String codigo;
	
	@ApiModelProperty(example = "79.99")
	private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.99")
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "99.90")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CRIADO")
	private String status;
	
	@ApiModelProperty(example = "2019-11-03T02:00:30Z")
	private OffsetDateTime dataCriacao;
	
	@ApiModelProperty(example = "2019-11-03T02:00:30Z")
	private OffsetDateTime dataConfirmacao;
	
	@ApiModelProperty(example = "2019-11-03T02:00:30Z")
	private OffsetDateTime dataEntrega;
	
	@ApiModelProperty(example = "2019-11-03T02:00:30Z")
	private OffsetDateTime dataCancelamento;
	
	private RestauranteResumoModel restaurante;
	private UsuarioModel cliente;
	private FormaPagamentoModel formaPagamento;
	private EnderecoModel enderecoEntrega;
	private List<ItemPedidoModel> itens;
}
