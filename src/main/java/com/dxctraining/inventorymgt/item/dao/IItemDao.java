package com.dxctraining.inventorymgt.item.dao;

import com.dxctraining.inventorymgt.item.entities.Item;

public interface IItemDao {

    Item findItemById(int id);

    Item add(Item item);

    void remove(int id);
    
}