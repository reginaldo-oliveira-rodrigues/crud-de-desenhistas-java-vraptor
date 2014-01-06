package br.com.rgn.cruddedesenhistasjavavraptor.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;
import br.com.rgn.infrastructure.HibernateUtils;
import br.com.rgn.utils.StringUtils;

/**
 * Classe no padrão DAO para cadastrar, atualizar, selecionar ou excluir desenhistas cadastrados. 
 * @author regis
 *
 */
@Component
public class DesenhistasCRUD {	

	public Long cadastrar(Desenhista desenhista) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Long id = (Long)session.save(desenhista);
		session.getTransaction().commit();
		return id;
	}

	public Desenhista consultar(Desenhista desenhista) {
		Session session = HibernateUtils.getSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(this.getHQLcomFiltro(desenhista));
			List<Desenhista> resultado = (ArrayList<Desenhista>)q.list();
			if(resultado != null && resultado.size() != 0){
				desenhista = (Desenhista) q.list().get(0);
			}else{
				desenhista = null;
			}
			
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return desenhista;
	}
	
	public List<Desenhista> listar(){
		List<Desenhista> resultado = new ArrayList<Desenhista>();
		try {
			resultado = (List<Desenhista>) HibernateUtils.getSession().createCriteria(Desenhista.class).list();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return resultado;
	}

	public void atualizar(Desenhista desenhista) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.update(desenhista);
		session.getTransaction().commit();
	}
	
	public void remover(Desenhista desenhista) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.delete(desenhista);
		session.getTransaction().commit();
	}
	
	
	
	
	private String getHQLcomFiltro(Desenhista desenhista) {
		StringBuilder query = new StringBuilder();
		StringBuilder condicao = new StringBuilder();
		query.append("from Desenhista d");
		if (desenhista.getId() != null) {
			condicao.append(" where d.id = ");
			condicao.append(desenhista.getId());
		}
		if (!StringUtils.isBlank(desenhista.getNome())) {
			if(StringUtils.isBlank(condicao.toString())){
				condicao.append(" where ");
			}else{
				condicao.append(" and ");
			}
			condicao.append(" d.nome like '%");
			condicao.append(desenhista.getNome());
			condicao.append("%'");
		}
		if (!StringUtils.isBlank(desenhista.getEmail())) {
			if(StringUtils.isBlank(condicao.toString())){
				condicao.append(" where ");
			}else{
				condicao.append(" and ");
			}
			condicao.append("d.email like '%");
			condicao.append(desenhista.getEmail());
			condicao.append("%'");
		}
		if (!StringUtils.isBlank(desenhista.getSite())){
			if(StringUtils.isBlank(condicao.toString())){
				condicao.append(" where ");
			}else{
				condicao.append(" and ");
			}
			condicao.append("d.site like '%");
			condicao.append(desenhista.getSite());
			condicao.append("%'");
		}
		query.append(condicao.toString());
		return query.toString();
	}	

}
