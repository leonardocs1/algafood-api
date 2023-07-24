package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.filter.vendaDiariaFilter;
import com.algaworks.algafood.domain.model.dto.VendaDiaria;

public interface VendaQueryService {

	List<VendaDiaria> consultarVendasDiarias(vendaDiariaFilter filtro);
}
