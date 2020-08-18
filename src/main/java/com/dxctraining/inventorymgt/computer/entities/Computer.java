package com.dxctraining.inventorymgt.computer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
@Table(name="computers")
public class Computer extends Item{
	
	private int disksize;
	
	public Computer(String name,Supplier supplier,int disksize) {
		super(name,supplier);
		this.disksize=disksize;
	}
	public Computer() {
		
	}
	
	public int getDisksize() {
		return disksize;
	}
	public void setDisksize(int disksize) {
		this.disksize = disksize;
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
        if (arg == null || (arg instanceof Computer) ){
            return false;
        }
        Computer that = (Computer) arg;
        boolean isequal=this.getId()==that.getId();
        return isequal;
		
	}
}