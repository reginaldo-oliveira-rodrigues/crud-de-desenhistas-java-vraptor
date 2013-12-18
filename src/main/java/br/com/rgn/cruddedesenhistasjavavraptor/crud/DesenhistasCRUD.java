package br.com.rgn.cruddedesenhistasjavavraptor.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;
import br.com.rgn.infrastructure.HibernateUtils;
import br.com.rgn.utils.StringUtils;

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
			Query q = session.createQuery(this.getHQL(desenhista));
			List resultado = q.list();
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

	public void atualizar(String nome, Desenhista desenhista) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.update(nome, desenhista);
		session.getTransaction().commit();
	}
	
	public void remover(Desenhista desenhista) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.delete(desenhista);
		session.getTransaction().commit();
	}
	
	
	
	
	private String getHQL(Desenhista desenhista) {
		StringBuilder query = new StringBuilder();
		StringBuilder condicao = new StringBuilder();
		query.append("from Desenhista d");
		if (!StringUtils.isBlank(desenhista.getNome())) {
			condicao.append(" where d.nome like '%");
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
