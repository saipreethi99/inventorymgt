package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.Item;

public interface IItemService {
    Item findItemById(int id);

    Item add(Item item);

    void remove(int id);
    
}