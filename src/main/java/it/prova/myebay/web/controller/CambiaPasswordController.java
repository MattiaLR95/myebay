package it.prova.myebay.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class CambiaPasswordController {
	
	@GetMapping("/cambiaPassword")
	public String cambiaPassword (Model model,Principal principal) {
		
		return "/cambiapassword";
	}
	
	@PostMapping("/saveCambiaPassword")
	public String saveCambiaPassword (Model model, Principal principal) {
		
		return "/executeLogout";
	}
}
