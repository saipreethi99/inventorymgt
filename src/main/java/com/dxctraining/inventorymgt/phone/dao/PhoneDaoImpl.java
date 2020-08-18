package com.dxctraining.inventorymgt.phone.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.exceptions.PhoneNotFoundException;

@Repository
public class PhoneDaoImpl implements IPhoneDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Phone findPhoneById(int id) {
        Phone phone=entityManager.find(Phone.class,id);
        if(phone==null){
            throw new PhoneNotFoundException("Phone not found for id="+id);
        }
        return phone;
    }

    @Override
    public Phone add(Phone phone ) {
        entityManager.persist(phone);
        return phone;
    }

    @Override
    public void remove(int id) {
     Phone Phone = findPhoneById(id) ;
     entityManager.remove(Phone);
    }
}