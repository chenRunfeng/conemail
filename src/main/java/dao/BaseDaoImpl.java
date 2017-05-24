package dao;

import java.util.List;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import entity.*;
@Repository
public class BaseDaoImpl<T,PK extends Serializable> implements IBaseDao<T, PK> {

	private Class<T> entityClass;
	@Resource
	protected SessionFactory sessionFactory;
	

	public BaseDaoImpl() {
		this.entityClass=null;
		Class<?> class1=getClass();
		Type type=class1.getGenericSuperclass();
		if(type instanceof ParameterizedType){
			Type[] paraTypes =((ParameterizedType)type).getActualTypeArguments();
			this.entityClass=(Class<T>) paraTypes[0];
		}
	}
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory){
    	this.sessionFactory=sessionFactory;
    }
    protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public T get(PK id) {
		// TODO Auto-generated method stub
		Assert.notNull(id,"id is required");
		return (T)getSession().get(entityClass,id);
	}

	public PK save(T entity) {
		// TODO Auto-generated method stub
		Assert.notNull(entity,"entity is required");
		return (PK)getSession().save(entity);
	}
//	@SuppressWarnings("unchecked")
//    public List<T> getentitys(){
//    	return this.getSession().createCriteria(Sys_User.class).list();
//    }
	@SuppressWarnings("unchecked")
    public List<T> getentitys(){
    	return (List<T>)getSession().createCriteria(entityClass.getClass()).list();
    }
}
