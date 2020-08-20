package com.dxctraining.inventorymgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

import java.util.*;

import javax.annotation.PostConstruct;

@Controller
public class PhoneController {

	@Autowired
	private ISupplierService supplierservice;
	
	@Autowired
	private IPhoneService phoneservice;

	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("Preethi");
		supplier1 = supplierservice.add(supplier1);
		Supplier supplier2 = new Supplier("Sai");
		supplier1 = supplierservice.add(supplier2);
		Supplier supplier3 = new Supplier("Chandubatla");
		supplier1 = supplierservice.add(supplier3);
		
	}

	@GetMapping("/profile")
	public ModelAndView supplierDetails(@RequestParam("id") int id) {
		Supplier sup = supplierservice.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("details", "supplier", sup);
		return modelAndView;
	}

	@GetMapping("/listallcom")
	public ModelAndView all() {
		List<Phone> computer = phoneservice.displayAllPhones();
		ModelAndView modelAndView = new ModelAndView("list", "computers", computer);
		return modelAndView;
	}
}
