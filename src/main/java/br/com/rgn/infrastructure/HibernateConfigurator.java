package br.com.rgn.infrastructure;

import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class HibernateConfigurator implements ComponentFactory<AnnotationConfiguration>{
	
	public AnnotationConfiguration getInstance(){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		return configuration.configure();
	}
}
