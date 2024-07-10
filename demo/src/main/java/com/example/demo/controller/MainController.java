package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CatalogItem;
import com.example.demo.service.ICatalogService;


@RestController
@RequestMapping(value = "/ui/test",produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

	@Autowired
	private ICatalogService service;
	
	@GetMapping(value="/getbyid")
	public String getById() {
		
		return  service.getById("5b76d68daa687233af42ea54").toString();
	}
	
	@GetMapping(value="/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAll() {
		return service.getAll(1, 30, false,  "title").toString();
	}
	
	
}
