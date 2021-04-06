package com.nagarro.training.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.training.dao.HibernateDao;
import com.nagarro.training.dao.HibernateDaoImplementation;
import com.nagarro.training.dao.LoginDao;
import com.nagarro.training.dao.LoginDaoImplementation;
import com.nagarro.training.service.EmployeeManagementService;
import com.nagarro.training.service.LoginService;

@Configuration
public class AppConfig {
	@Bean
	public HibernateDao getHibernateDao() {
		return new HibernateDaoImplementation();
	}

	@Bean
	public LoginDao getLoginDao() {
		return new LoginDaoImplementation();
	}

	@Bean
	public LoginService getLoginService() {
		return new LoginService();
	}

	@Bean
	public EmployeeManagementService getEmployeeManagementService() {
		return new EmployeeManagementService();
	}
}
