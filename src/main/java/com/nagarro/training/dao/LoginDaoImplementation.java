package com.nagarro.training.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.training.dto.User;


public class LoginDaoImplementation implements LoginDao {
	@Autowired
	private HibernateDao hibernateDao;

	public User getUserDetails(String username) {
		User user = null;
		hibernateDao.begin();
		user = hibernateDao.getSession().get(User.class, username);
		hibernateDao.commit();
		hibernateDao.close();
		return user;
	}

	public void updatePassword(String username, String password) {
		User user = null;
		user = getUserDetails(username);
		user.setPassword(password);
		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		session.update(user);
		session.getTransaction();
		hibernateDao.commit();
		hibernateDao.close();
	}

	public void signup(User user) {
		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		session.save(user);
		session.getTransaction();
		hibernateDao.commit();
		hibernateDao.close();
	}
}
