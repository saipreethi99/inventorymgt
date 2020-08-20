package com.dxctraining.inventorymgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import javax.annotation.PostConstruct;
@Controller
public class PhoneController extends Item {
	
	@Autowired
	private IPhoneService phoneservice;
	
	@Autowired
	private ISupplierService supplierservice;

	@PostConstruct
	public void init() {
		Supplier supplier3 = new Supplier("preethi");
		supplier3 = supplierservice.add(supplier3);
		Supplier supplier4 = new Supplier("sai");
		supplier4 = supplierservice.add(supplier4);
		Supplier supplier5 = new Supplier("chinnu");
		supplier4 = supplierservice.add(supplier5);

		Phone phone1 = new Phone("oppo", supplier3, 32);
		phoneservice.add(phone1);
		Phone phone2 = new Phone("vivo", supplier4, 64);
		phoneservice.add(phone2);
		Phone phone3 = new Phone("oneplus", supplier5, 256);
		phoneservice.add(phone3);
	}

	@GetMapping("/phone")
	public ModelAndView phoneDetails(@RequestParam("id") int id) {
		Phone phone = phoneservice.findPhoneById(id);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "phone", phone);
		return modelAndView;
	}

	@GetMapping("/listallphones")
	public ModelAndView all() {
		List<Phone> phones = phoneservice.allPhones();
		ModelAndView modelAndView = new ModelAndView("phonelist", "phones", phones);
		return modelAndView;
	}

}
