package com.nagarro.training.dao;

import org.hibernate.Session;

public interface HibernateDao {
	public Session getSession();

	public void begin();

	public void commit();

	public void close();

	public void rollback();
}
