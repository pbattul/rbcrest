package com.RBC;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

		@Bean
	    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	        return hemf.getSessionFactory();
	    }

}
