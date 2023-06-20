package com.innovatitive.utils;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.innovatitive.model.Innovativestudents;


public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				Properties prop = new Properties();
				prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/kirandb");
				prop.put(Environment.USER, "root");
				prop.put(Environment.PASS, "Admin@123");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				config.setProperties(prop);
				config.addAnnotatedClass(Innovativestudents.class);

				ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties()).build();
				sessionFactory = config.buildSessionFactory(serviceregistry);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return sessionFactory;

	}

}
