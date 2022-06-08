package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asm.model.Motobike;
import com.asm.service.MotobikeService;

@Controller
public class HomeController {
	
	
	@Autowired
	private MotobikeService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Motobike> listXe = service.getAll();
		model.addAttribute("listXe",listXe);
		return "index";
	}
	
	@GetMapping("/product")
	public String product(Model model) {
		List<Motobike> listXe = service.getAll();
		model.addAttribute("listXe",listXe);
		return"shop";
	}
}
