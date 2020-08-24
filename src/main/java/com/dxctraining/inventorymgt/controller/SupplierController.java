package com.dxctraining.inventorymgt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;
import com.dxctraining.inventorymgt.supplier.service.SupplierServiceImpl;
import com.dxctraining.inventorymgt.supplier.dto.SessionData;

import java.util.*;

import javax.annotation.PostConstruct;

@Controller
public class SupplierController {

	@Autowired
	private ISupplierService supplierservice;
	
	@Autowired
	private SessionData sessiondata;

	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("Preethi", "12345");
		supplier1 = supplierservice.add(supplier1);
		Supplier supplier2 = new Supplier("Sai", "12346");
		supplier1 = supplierservice.add(supplier2);
		Supplier supplier3 = new Supplier("Chandubatla", "12347");
		supplier1 = supplierservice.add(supplier3);

	}

	@GetMapping("/profile")
	public ModelAndView supplierDetails(@RequestParam("id") int id) {
		Supplier sup = supplierservice.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", sup);
		return modelAndView;
	}

	@GetMapping("/listall")
	public ModelAndView all() {
		List<Supplier> values = supplierservice.displayAllSuppliers();
		ModelAndView modelAndView = new ModelAndView("supplierlist", "suppliers", values);
		return modelAndView;
	}

	@GetMapping("/supplierregister")
	public ModelAndView registerSupplier() {
		ModelAndView modelAndView = new ModelAndView("supplierregister");
		return modelAndView;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("password") String password) {
		System.out.println("inside processregister method, name=" + name);
		Supplier supplier = new Supplier(name, password);
		supplierservice.add(supplier);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("name") String name, @RequestParam("id") int id,@RequestParam("password") String password) {
		boolean correct = supplierservice.authentication(id, password);
		if (correct) {
			sessiondata.saveLogin(id);
			Supplier supplier = supplierservice.findSupplierById(id);
			ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		sessiondata.clear();
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
