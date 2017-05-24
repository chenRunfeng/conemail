package service;

import java.util.List;
import java.io.Serializable;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IBaseDao; 
import dao.BaseDaoImpl;
import service.IBaseServices;  
import entity.Sys_User;
@Service
@Transactional
public class BaseServiceImpl<T, PK extends Serializable> implements IBaseServices<T, PK>{  
    @Autowired
    private BaseDaoImpl<T, PK> BaseDaoImpl;     
    public T get(PK id) {  
        return BaseDaoImpl.get(id);  
    }  
      
    public PK save(T entity) {  
        return BaseDaoImpl.save(entity);  
    }  
    public List<T> getUsers(){
    	return BaseDaoImpl.getentitys();
    }
}  
