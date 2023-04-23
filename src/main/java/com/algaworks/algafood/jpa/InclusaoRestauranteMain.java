package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("SushiRest");
		restaurante1.setTaxaFrete(new BigDecimal(9.99));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("AmericanFood");
		restaurante2.setTaxaFrete(new BigDecimal(12.99));
		
		restaurante1 = restauranteRepository.adicionar(restaurante1);
		restaurante2 = restauranteRepository.adicionar(restaurante2);
		
		System.out.printf("%d - %s - %.2f\n", restaurante1.getId(), restaurante1.getNome(), restaurante1.getTaxaFrete());
		System.out.printf("%d - %s - %.2f\n", restaurante2.getId(), restaurante2.getNome(), restaurante2.getTaxaFrete());
	}
}
