package br.com.rgn.cruddedesenhistasjavavraptor.test.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.rgn.cruddedesenhistasjavavraptor.crud.DesenhistasCRUD;
import br.com.rgn.infrastructure.HbCriadorDeSessoes;
import br.com.rgn.infrastructure.HbSessoes;
import br.com.rgn.infrastructure.HibernateConfigurator;

public class CriadorDeDesenhistasCRUD {

	public static DesenhistasCRUD criar() {
		AnnotationConfiguration conf = new HibernateConfigurator().getInstance();
		SessionFactory factory = new HbCriadorDeSessoes(conf).getInstance();
		Session session = new HbSessoes(factory).getInstance();
		return new DesenhistasCRUD(session);
	}
	
}
