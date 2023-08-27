package com.algaworks.algafood.api.v2.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.algaworks.algafood.api.v1.model.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "cozinhas")
@ApiModel("CozinhaModel")
@Setter
@Getter
public class CozinhaModelV2 extends RepresentationModel<CozinhaModelV2>{

	@ApiModelProperty(example = "1")
	@JsonView(RestauranteView.Resumo.class)
	private Long idCozinha;
	
	@ApiModelProperty(example = "Nordestina")
	@JsonView(RestauranteView.Resumo.class)
	private String nomeCozinha;
}
