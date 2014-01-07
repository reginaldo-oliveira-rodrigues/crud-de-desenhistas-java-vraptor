package br.com.rgn.infrastructure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class HbSessoes implements ComponentFactory<Session>{
	private SessionFactory factory;
	private Session session;
	
	public HbSessoes(SessionFactory factory){
		this.factory = factory;
	}
	
	@PostConstruct
	public void abre(){
		session = factory.openSession();
	}
	
	public Session getInstance(){
		return session;
	}
	
	@PreDestroy
	public void fecha(){
		session.close();
	}
}
