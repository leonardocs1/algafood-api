package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class AlteracaoRestauranteMain {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1L);
		restaurante1.setNome("MC Vinis");
		restaurante1.setTaxaFrete(new BigDecimal(10.99));

		restaurante1 = restauranteRepository.adicionar(restaurante1);

		System.out.printf("%d - %s - %.2f\n", restaurante1.getId(), restaurante1.getNome(), restaurante1.getTaxaFrete().doubleValue());
	}
}
