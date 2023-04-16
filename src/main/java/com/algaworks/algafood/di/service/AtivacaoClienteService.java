package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.modelo.Cliente;

@Component
public class AtivacaoClienteService {

	@Autowired(required = false)
	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if (notificador != null) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");			
		} else {
			System.out.println("Não existe noficador, mas cliente foi ativado");
		}
	}


}
