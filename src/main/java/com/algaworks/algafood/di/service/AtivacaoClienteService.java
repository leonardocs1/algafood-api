package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.modelo.Cliente;

public class AtivacaoClienteService {

	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
		
		System.out.println("AtivacaoClienteService: " + notificador);
	}

	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
