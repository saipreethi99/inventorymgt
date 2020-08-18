package com.dxctraining.inventorymgt.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Item;

@Transactional
@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private IItemDao dao;

    @Override
    public Item findItemById(int id) {
       Item item= dao.findItemById(id);
        return item;
    }


    @Override
    public Item add(Item item) {
        item=dao.add(item);
        return item;
    }

    @Override
    public void remove(int id) {
       dao.remove(id);
    }

}