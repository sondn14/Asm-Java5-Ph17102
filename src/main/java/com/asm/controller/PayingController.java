package com.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayingController {
	
	@PostMapping("paying")
	public String paying() {
		return null;
	}
}
