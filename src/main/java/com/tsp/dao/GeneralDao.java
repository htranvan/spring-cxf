package com.tsp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.tsp.model.BasicEntity;

public class GeneralDao<E extends BasicEntity, ID extends Serializable> implements IGeneralDao<E, ID> {

	@Resource
	public SessionFactory sessionFactory;
	
	public GeneralDao() {}

	public GeneralDao(final Class<E> entity, SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession() == null ? sessionFactory.openSession() : sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getEntityClass() {
   		return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
   	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(ID id) {
		IdentifierLoadAccess iLa = getCurrentSession().byId(getEntityClass());
		return (E) iLa.load(id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public ID save(E entity) {
		ID res = (ID) getCurrentSession().save(entity);
		return res;
	}

}
