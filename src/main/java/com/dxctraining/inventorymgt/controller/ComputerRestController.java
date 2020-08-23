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

import com.dxctraining.inventorymgt.computer.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.computer.entities.Computer;
import com.dxctraining.inventorymgt.computer.service.IComputerService;



@RestController
@RequestMapping("/computers")
public class ComputerRestController {
	
	@Autowired
	private IComputerService computerservice;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Computer createComputer(@RequestBody CreateComputerRequest computer) {
		Computer computerservice1 = new Computer(computer.getName(),computer.getDiskSize());
		computerservice1 = computerservice.add(computerservice1);
		return computerservice1;	
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Computer getComputer(@PathVariable("id")int id) {
		Computer computerservice1 = computerservice.findComputerById(id);
		return computerservice1;
	}
	
}