package com.riccardofinazzi.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	private static final String $TAG = new String("HIBERNATE_UTIL: ");

	private HibernateUtil() {}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder()
						.configure("/com/riccardofinazzi/hibernate/util/hibernate.cfg.xml").build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				System.out.println($TAG + "couldn't create SessionFactory");
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

	public static void closeFactory() {

		if (sessionFactory != null) {
			sessionFactory.close();
			System.out.println($TAG + "SessionFactory closed");
		}

		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println($TAG + "StandardServiceRegistryBuilder destroyed");
		}
	}
}