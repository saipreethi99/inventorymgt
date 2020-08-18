package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.exceptions.ItemNotFoundException;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNotFoundException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class InventoryUi {
	
	@Autowired
	private ISupplierService service;
	
	@Autowired
    private IItemService itemService;
	
	@Autowired
	private IComputerService computerservice;
	
	@Autowired
    private IPhoneService phoneservice;

	@PostConstruct
	private void runapp() {
		try {
			Supplier supplier1=new Supplier("preethi");
			service.add(supplier1);
			Supplier supplier2=new Supplier("sai");
			service.add(supplier2);
			Supplier supplier3=new Supplier("chandubatla");
			service.add(supplier3);
			Item item1 = new Item("item1", supplier1);
			itemService.add(item1);
			Item item2 = new Item("item2", supplier2);
			itemService.add(item2);
			Item item3 = new Item("item3", supplier3);
			itemService.add(item3);
		    Computer computer=new Computer("Hp",supplier2,1000);
		    computerservice.add(computer);
			Phone phone=new Phone("oppo",supplier1,20);
			phoneservice.add(phone);
			int computerid=computer.getId();
			Computer fetched1=computerservice.findComputerById(computerid);
			System.out.println(" item fetched " +fetched1.getId()+ " " +fetched1.getName()+ " " +fetched1.getSupplier()+ "" +fetched1.getDisksize());
			int phoneid=phone.getId();
			Phone fetched2=phoneservice.findPhoneById(phoneid);
			System.out.println(" item fetched " +fetched2.getId()+ " " +fetched2.getName()+ " " +fetched2.getSupplier()+ " " +fetched2.getStoragesize());
			
		}
		 catch (ItemNotFoundException e) {
	            e.printStackTrace();
	        } catch (InvalidArgumentException e) {
	            e.printStackTrace();
	        }
	}
		   
}