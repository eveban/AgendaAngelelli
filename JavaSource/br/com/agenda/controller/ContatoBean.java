package br.com.agenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.agenda.model.Contato;
import br.com.agenda.repository.ContatoRepository;
import br.com.agenda.repository.filter.ContatoFilter;
import br.com.agenda.service.ContatoService;
import br.com.agenda.util.jsf.FacesUtil;

@Named("contatoBean")
@ViewScoped
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContatoRepository contatoRepository;

	@Inject
	private ContatoService contatoService;

	private Contato contato;

	private List<Contato> contatosFiltrados;

	private ContatoFilter contatoFilter;

	public ContatoBean() {
		limpar();
		contatoFilter = new ContatoFilter();
	}

	public boolean isEditando() {
		return this.contato.getId() != null;
	}

	public void salvar() {
		this.contato = contatoService.salvar(this.contato);
		limpar();
		FacesUtil.addInfoMessage("Contato salvo com sucesso");
	}

	public void excluir() {
		contatoRepository.remover(contato);
		contatosFiltrados.remove(contato);
		FacesUtil.addInfoMessage("Contato " + contato.getNome()
				+ " excluído com sucesso!");
	}

	public void pesquisaContatos() {
		contatosFiltrados = contatoRepository.filtrado(contatoFilter);
	}

	public void limpar() {
		this.contato = new Contato();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ContatoFilter getContatoFilter() {
		return contatoFilter;
	}

	public void setContatoFilter(ContatoFilter contatoFilter) {
		this.contatoFilter = contatoFilter;
	}

	public List<Contato> getContatosFiltrados() {
		return contatosFiltrados;
	}

}
