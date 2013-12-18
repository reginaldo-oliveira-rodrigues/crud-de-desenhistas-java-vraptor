package br.com.rgn.infrastructure;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtils {
	// TODO refatorar
	public static Session getSession() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		return factory.openSession();
	}

}
