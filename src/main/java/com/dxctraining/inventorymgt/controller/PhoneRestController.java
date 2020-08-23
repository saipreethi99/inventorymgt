package com.dxctraining.inventorymgt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.inventorymgt.phone.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.phone.entities.Phone;
import com.dxctraining.inventorymgt.phone.service.IPhoneService;



@RestController
@RequestMapping("/phones")
public class PhoneRestController {
	
	@Autowired
	private IPhoneService Phoneservice;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Phone createPhone(@RequestBody CreatePhoneRequest computer) {
		Phone Phoneservice1 = new Phone(computer.getName(),computer.getStorageSize());
		Phoneservice1 = Phoneservice.add(Phoneservice1);
		return Phoneservice1;	
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Phone getComputer(@PathVariable("id")int id) {
		Phone computerservice1 = Phoneservice.findPhoneById(id);
		return computerservice1;
	}

}