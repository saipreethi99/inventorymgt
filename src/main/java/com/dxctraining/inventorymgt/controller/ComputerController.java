package com.dxctraining.inventorymgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class ComputerController extends Item {
	@Autowired
	private IComputerService computerservice;
	@Autowired
	private ISupplierService supplierservice;

	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("Preethi");
		supplier1 = supplierservice.add(supplier1);
		Supplier supplier2 = new Supplier("Sai");
		supplier1 = supplierservice.add(supplier2);
		Supplier supplier3 = new Supplier("Chandubatla");
		supplier1 = supplierservice.add(supplier3);
		Computer computer1 = new Computer("Hp", supplier1, 5000);
		computerservice.add(computer1);
		Computer computer2 = new Computer("Apple", supplier2, 8000);
		computerservice.add(computer2);
		Computer computer3 = new Computer("Lenovo", supplier3, 6000);
		computerservice.add(computer3);
	}

	@GetMapping("/computer")
	public ModelAndView computerDetails(@RequestParam("id") int id) {
		Computer computer = computerservice.findComputerById(id);
		ModelAndView modelAndView = new ModelAndView("computerdetails", "computer", computer);
		return modelAndView;
	}

	@GetMapping("/listallcomputers")
	public ModelAndView all() {
		List<Computer> values = computerservice.allComputers();
		ModelAndView modelAndView = new ModelAndView("computerlist", "computers", values);
		return modelAndView;
	}

}
