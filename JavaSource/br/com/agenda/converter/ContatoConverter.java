package br.com.agenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.agenda.model.Contato;
import br.com.agenda.repository.ContatoRepository;
import br.com.agenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Contato.class)
public class ContatoConverter implements Converter {

	private ContatoRepository contatoRepository;

	public ContatoConverter() {
		contatoRepository = CDIServiceLocator.getBean(ContatoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext faces, UIComponent component,
			String value) {
		Contato retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = contatoRepository.buscaPorId(id);
		}
		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Contato contato = (Contato) value;
			return contato.getId() == null ? null : contato.getId().toString();

		}

		return "";
	}

}
