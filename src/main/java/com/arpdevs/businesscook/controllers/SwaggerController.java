package com.arpdevs.businesscook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;

@Controller
@CrossOrigin
@Api(value = "Swagger Documentations", tags = {"Swagger Route"})
public class SwaggerController {
	
	@GetMapping("/docs")
	public String swaggerDocs() {
		return "redirect:/swagger-ui.html";
	}

}
