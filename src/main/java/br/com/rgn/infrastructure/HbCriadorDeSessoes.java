package br.com.rgn.infrastructure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class HbCriadorDeSessoes implements ComponentFactory<SessionFactory>{
	
	private AnnotationConfiguration configuration;
	private SessionFactory sessionFactory;
	
	public HbCriadorDeSessoes(AnnotationConfiguration configuration){
		this.configuration = configuration;
	}
	
	@PostConstruct
	public void abre(){
		this.sessionFactory = configuration.buildSessionFactory();
	}
	
	public SessionFactory getInstance(){
		return sessionFactory;
	}
	
	@PreDestroy
	public void fecha(){
		this.sessionFactory.close();
	}
}
