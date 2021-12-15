package com.arpdevs.businesscook.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Api(value = "Testes", tags = {"Testes"})
public class TestController {
	
	@GetMapping("/stream")
	public String streamTesting() {
		String[] cnhs = {"A", "AB", "AC"};
		String cat = "AB";
		String categorias = "";
		
		for(String categoria: cnhs) {
			categorias += categoria + ", ";
		}
		
		if(Arrays.asList(cnhs).stream().anyMatch(cnh -> cnh == cat)) {
			return "CNHs: " + categorias.substring(0, categorias.length() - 2) + " | Escolhida: " + cat + " é Compatível";
		} else {
			return "CNHs: " + categorias.substring(0, categorias.length() - 2) + " | Escolhida: " + cat + " é Incompatível";
		}
	}

}
