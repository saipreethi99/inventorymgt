package com.dxctraining.inventorymgt.supplier.service;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierService {

		Supplier findSupplierById(int id);

    	Supplier add(Supplier supplier);

    	void remove(int id);
    	

}