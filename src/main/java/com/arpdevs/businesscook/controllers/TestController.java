package com.arpdevs.businesscook.controllers;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpdevs.businesscook.helpers.GregorianHelper;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Api(value = "Testes", tags = {"Testes"})
public class TestController {
	
	@Autowired
	GregorianHelper gregorianHelper;
	
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
	
	@GetMapping("/dates")
	public String gregorianTest() {
		try {
			GregorianCalendar now = new GregorianCalendar();
			Timestamp timeStamp = new Timestamp(now.getTimeInMillis());
			
			String conv = timeStamp.toString().substring(0, 10);
			GregorianCalendar date = gregorianHelper.stringToCalendar(conv, "yyyy-MM-dd");
			gregorianHelper.debugGregorianCalendar(date);
			return gregorianHelper.printGregorianCalendar(date);
		} catch(Exception ex) {
			ex.printStackTrace(System.out);
			return null;
		}
	}

}
