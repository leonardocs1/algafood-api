package com.algaworks.algafood.api.v1.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.v1.model.RestauranteBasicoModel;

import lombok.Data;

@Data
public class RestaurantesModelOpenApi {

	private RestauranteEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@Data
	public class RestauranteEmbeddedModelOpenApi {
		private List<RestauranteBasicoModel> restaurantes;
	}
}
