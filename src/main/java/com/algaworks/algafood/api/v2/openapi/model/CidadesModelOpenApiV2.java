package com.algaworks.algafood.api.v2.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v2.model.CidadeModelV2;

import lombok.Data;

@Data
public class CidadesModelOpenApiV2 {

	private CidadeEmbeddedModelOpenApi _embedded;
	private Links _links;

	@Data
	public class CidadeEmbeddedModelOpenApi {
		private List<CidadeModelV2> cidades;
	}
}
