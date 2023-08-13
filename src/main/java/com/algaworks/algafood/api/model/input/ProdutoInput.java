package com.algaworks.algafood.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInput {

	@ApiModelProperty(example = "Picanha completa", required = true)
	@NotBlank
	private String nome;

	@ApiModelProperty(example = "Acompanha arroz, mandioca e feijão tropeiro", required = true)
	@NotBlank
	private String descricao;

	@ApiModelProperty(example = "99.90", required = true)
	@NotNull
	@PositiveOrZero
	private BigDecimal preco;

	@ApiModelProperty(example = "true", required = true)
	@NotNull
	private Boolean ativo;
}
