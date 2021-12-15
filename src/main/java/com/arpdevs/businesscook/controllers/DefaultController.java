package com.arpdevs.businesscook.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "Default", tags = {"Default Requests"})
public class DefaultController {
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Shows a welcome message")
	public String defaultMessage() {
		return "This is a RESTful API"; 
	}

}
