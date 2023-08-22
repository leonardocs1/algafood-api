package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.AlgaLinks;
import com.algaworks.algafood.api.controller.GrupoController;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.domain.model.Grupo;

@Component
public class GrupoModelAssembler extends RepresentationModelAssemblerSupport<Grupo, GrupoModel> {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AlgaLinks algalinks;
	
	public GrupoModelAssembler() {
		super(GrupoController.class, GrupoModel.class);
	}

	public GrupoModel toModel(Grupo grupo) {
		GrupoModel grupoModel = createModelWithId(grupo.getId(), grupo);
		modelMapper.map(grupo, grupoModel);
		
		grupoModel.add(algalinks.linkToGrupos("grupos"));
		grupoModel.add(algalinks.linkToGrupoPermissoes(grupo.getId(), "permissoes"));

		return grupoModel;
	}

	@Override
	public CollectionModel<GrupoModel> toCollectionModel(Iterable<? extends Grupo> entities) {
		return super.toCollectionModel(entities)
				.add(algalinks.linkToGrupos());
	}

}
