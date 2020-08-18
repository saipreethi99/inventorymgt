package com.dxctraining.inventorymgt.phone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
@Table(name="phones")
public class Phone extends Item{

	private int storagesize;
	
	public Phone(String name,Supplier supplier,int storagesize) {
		super(name,supplier);
		this.storagesize=storagesize;
	}
	public Phone() {
		
	}
	
	public int getStoragesize() {
		return storagesize;
	}
	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}
	
	@Override
	public int hashCode() {
		return this.getId();
	}
	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}
        if (arg == null || arg instanceof Phone) {
            return false;
        }
        Phone that = (Phone) arg;
        boolean isequal=this.getId()==that.getId();
        return isequal;
		
	}
	
}