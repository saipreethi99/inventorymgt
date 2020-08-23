package com.dxctraining.inventorymgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class ComputerController {
	@Autowired
	private IComputerService computerservice;
	@Autowired
	private ISupplierService supplierservice;

	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("Preethi","12345");
		supplier1 = supplierservice.add(supplier1);
		Supplier supplier2 = new Supplier("Sai","12346");
		supplier1 = supplierservice.add(supplier2);
		Supplier supplier3 = new Supplier("Chandubatla","12347");
		supplier1 = supplierservice.add(supplier3);
		Computer computer1 = new Computer("Hp", supplier1, 5000);
		computer1=computerservice.add(computer1);
		Computer computer2 = new Computer("Apple", supplier2, 8000);
		computer2=computerservice.add(computer2);
		Computer computer3 = new Computer("Lenovo", supplier3, 6000);
		computer2=computerservice.add(computer3);
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
	
	@GetMapping("/computerregister")
	public ModelAndView registerComputer() {
		ModelAndView modelAndView = new ModelAndView("computerregister");
		return modelAndView;
	}

	@GetMapping("/computerprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name,@RequestParam("diskSize") int diskSize) {
		System.out.println("inside processregister method, name=" + name);
		Computer computer = new Computer(name,diskSize);
		computerservice.add(computer);
		ModelAndView modelAndView = new ModelAndView("computerdetails", "computer", computer);
		return modelAndView;
	}
	
	/*@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("name") String name, @RequestParam("id") int id, @RequestParam("diskSize")int diskSize) {
		Computer computer = computerservice.findComputerById(id);
		ModelAndView modelAndView = new ModelAndView("computerdetails", "computer",computer);
		return modelAndView;
	}*/
}
	/*@GetMapping("/addcomputer")
	public ModelAndView processAddComputer(@RequestParam("name")String name, @RequestParam("diskSize")int diskSize) {
		Computer computer = new Computer(name, diskSize);
		computer = computerservice.add(computer);
		ModelAndView modelAndView = new ModelAndView("computerdetails","computer",computer);
		return modelAndView;
	}

	@GetMapping("/postcomputer")
	public ModelAndView postAddComputer() {
		CreateComputerRequest computers = new CreateComputerRequest();
		ModelAndView modelAndView = new ModelAndView("postcomputer","computers",computers);
		return modelAndView;
	}
	
	@PostMapping("/processpostcomputer")
	public ModelAndView processComputer(@ModelAttribute("computers") CreateComputerRequest computer) {
		String name = computer.getName();
		int diskSize = computer.getDiskSize();
		Computer computers = new Computer(name, diskSize);
		//computer=computerservice.add(computer);
		ModelAndView modelAndView = new ModelAndView("computerdetails", "computer", computers);
		return modelAndView;
	}*/
