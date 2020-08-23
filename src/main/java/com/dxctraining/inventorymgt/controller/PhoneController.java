package com.dxctraining.inventorymgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computer.entities.Computer;
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
		Supplier supplier3 = new Supplier("preethi","12348");
		supplier3 = supplierservice.add(supplier3);
		Supplier supplier4 = new Supplier("sai","12349");
		supplier4 = supplierservice.add(supplier4);
		Supplier supplier5 = new Supplier("chinnu","12340");
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
	
	@GetMapping("/phoneregister")
	public ModelAndView registerphone() {
		ModelAndView modelAndView = new ModelAndView("phoneregister");
		return modelAndView;
	}

	@GetMapping("/phoneprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name,@RequestParam("storageSize") int storageSize) {
		System.out.println("inside processregister method, name=" + name);
		Phone phone = new Phone(name, storageSize);
		phoneservice.add(phone);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "phone", phone);
		return modelAndView;
	}
	
	/*@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("name") String name, @RequestParam("id") int id,  @RequestParam("storageSize")int storageSize) {
		Phone phone = phoneservice.findPhoneById(id);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "phone", phone);
		return modelAndView;
	}*/
}
	/*@GetMapping("/addphone")
	public ModelAndView processAddPhone(@RequestParam("name")String name, @RequestParam("storageSize")int storageSize) {
		Phone phone = new Phone(name, storageSize);
		phone = phoneservice.add(phone);
		ModelAndView modelAndView = new ModelAndView("phonedetails","phone",phone);
		return modelAndView;
	}
	
	@GetMapping("/postphone")
	public ModelAndView postAddPhone() {
		CreatePhoneRequest phones = new CreatePhoneRequest();
		ModelAndView modelAndView = new ModelAndView("postphone","phones",phones);
		return modelAndView;
	}
	
	@PostMapping("/processpostphone")
	public ModelAndView processPhone(@ModelAttribute("phones") CreatePhoneRequest phone) {
		String name = phone.getName();
		int storageSize = phone.getStorageSize();
		Phone phones= new Phone(name,storageSize);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "Phone", phones);
		return modelAndView;
	}*/


