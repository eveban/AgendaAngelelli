package br.com.agenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.agenda.model.Contato;
import br.com.agenda.repository.ContatoRepository;
import br.com.agenda.util.jpa.Transactional;

public class ContatoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContatoRepository contatoRepository;

	@Transactional
	public Contato salvar(Contato contato) {
		return contatoRepository.guardar(contato);
	}

}
