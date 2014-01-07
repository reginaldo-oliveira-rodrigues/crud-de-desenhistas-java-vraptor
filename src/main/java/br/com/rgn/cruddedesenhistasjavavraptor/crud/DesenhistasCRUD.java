package br.com.rgn.cruddedesenhistasjavavraptor.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.rgn.cruddedesenhistasjavavraptor.entity.Desenhista;
import br.com.rgn.utils.StringUtils;

/**
 * Classe no padrão DAO para cadastrar, atualizar, selecionar ou excluir desenhistas cadastrados. 
 *
 */
@Component
public class DesenhistasCRUD {	
	private Session session;
	
	public DesenhistasCRUD(Session session){
		this.session = session;
	}
	
	public Long cadastrar(Desenhista desenhista) {
		session.beginTransaction();
		Long id = (Long)session.save(desenhista);
		session.getTransaction().commit();
		return id;
	}

	public Desenhista consultar(Desenhista desenhista) {
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
			resultado = (List<Desenhista>) session.createCriteria(Desenhista.class).list();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return resultado;
	}

	public void atualizar(Desenhista desenhista) {
		session.beginTransaction();
		session.update(desenhista);
		session.getTransaction().commit();
	}
	
	public void remover(Desenhista desenhista) {
		session.beginTransaction();
		session.delete(desenhista);
		session.getTransaction().commit();
	}
	
	
	
	
	private String getHQLcomFiltro(Desenhista desenhista) {
		String query = "from Desenhista d";
		String condicao = "";
		
		if (desenhista.getId() != null) {
			condicao += " where d.id = " + desenhista.getId();
		}
		if (!StringUtils.isBlank(desenhista.getNome())) {
			if(StringUtils.isBlank(condicao.toString())){
				condicao += " where ";
			}else{
				condicao += " and ";
			}
			condicao += " d.nome like '%" + desenhista.getNome() + "%'";
		}
		if (!StringUtils.isBlank(desenhista.getEmail())) {
			if(StringUtils.isBlank(condicao.toString())){
				condicao += " where ";
			}else{
				condicao += " and ";
			}
			condicao += "d.email like '%" + desenhista.getEmail() + "%'";
		}
		if (!StringUtils.isBlank(desenhista.getSite())){
			if(StringUtils.isBlank(condicao.toString())){
				condicao += " where ";
			}else{
				condicao += " and ";
			}
			condicao += "d.site like '%"  + desenhista.getSite()  + "%'";
		}
		query += condicao;
		return query;
	}	

}
