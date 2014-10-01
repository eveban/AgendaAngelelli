package br.com.agenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.agenda.model.Contato;
import br.com.agenda.repository.filter.ContatoFilter;
import br.com.agenda.service.NegocioException;
import br.com.agenda.util.jpa.Transactional;

public class ContatoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager entityManager;

	public Contato guardar(Contato contato) {
		return entityManager.merge(contato);
	}

	public Contato buscaPorId(Long id) {
		return entityManager.find(Contato.class, id);
	}

	@Transactional
	public void remover(Contato contato) {
		try {
			contato = buscaPorId(contato.getId());
			entityManager.remove(contato);
			entityManager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Não foi possível remover o contato!");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Contato> filtrado(ContatoFilter filtro) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Contato.class);

		/* pom.xml - ArtifactId = commons-lang3 */
		if (StringUtils.isNotBlank(filtro.getTelefone())) {
			criteria.add(Restrictions.ilike("telefone", filtro.getTelefone(),
					MatchMode.START));
		}
		if (StringUtils.isNotBlank(filtro.getTelefoneComercial())) {
			criteria.add(Restrictions.ilike("telefoneComercial",
					filtro.getTelefoneComercial(), MatchMode.START));
		}
		if (StringUtils.isNotBlank(filtro.getTelefoneCelular())) {
			criteria.add(Restrictions.ilike("telefoneCelular",
					filtro.getTelefoneCelular(), MatchMode.START));
		}
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(),
					MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}
}
