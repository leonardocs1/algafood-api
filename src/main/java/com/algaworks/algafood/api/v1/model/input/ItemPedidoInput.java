package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemPedidoInput {

	@Schema(example = "1")
	@NotNull
	private Long produtoId;
	
	@Schema(example = "1")
	@NotNull
	@PositiveOrZero
	private Integer quantidade;
	
	@Schema(example = "Ao ponto")
	private String observacao;
}
