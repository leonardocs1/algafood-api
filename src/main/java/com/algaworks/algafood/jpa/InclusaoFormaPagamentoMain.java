package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class InclusaoFormaPagamentoMain {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento forma1 = new FormaPagamento();
		forma1.setDescricao("BITCOIN");
		
		FormaPagamento forma2 = new FormaPagamento();
		forma2.setDescricao("Vale-Presente");
		
		forma1 = formaPagamentoRepository.adicionar(forma1);
		forma2 = formaPagamentoRepository.adicionar(forma2);
		
		System.out.printf("%d - %s\n", forma1.getId(), forma1.getDescricao());
		System.out.printf("%d - %s\n", forma2.getId(), forma2.getDescricao());
	}
}
