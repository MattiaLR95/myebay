package it.prova.myebay.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.myebay.dto.UtenteDTOCambioPassword;
import it.prova.myebay.service.UtenteService;

@Controller
@RequestMapping("/account")
public class CambiaPasswordController {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/cambioPassword")
	public String cambiaPassword(Model model) {
		model.addAttribute("changePass_utente_attr", new UtenteDTOCambioPassword());
		return "account/cambiapassword";
	}

	@PostMapping("/executeCambiaPassword")
	public String executeCambiaPassword(@ModelAttribute("changePass_utente_attr") UtenteDTOCambioPassword utenteDTO,
			BindingResult result, Model model, RedirectAttributes redirectAttrs, Principal principal) {
		if (!result.hasFieldErrors("nuovaPassword")
				&& !utenteDTO.getNuovaPassword().equals(utenteDTO.getConfermaNuovaPassword())) {
			result.rejectValue("confermaNuovaPassword", "utente.password.diverse");
			return "account/cambioPassword";
		}

		if (!passwordEncoder.matches(utenteDTO.getPassword(),
				utenteService.findByUsername(principal.getName()).getPassword())) {
			result.rejectValue("password", "utente.password.nonYourPassword");
			return "account/cambioPassword";
		}

		utenteService.cambiaPassword(utenteDTO.getConfermaNuovaPassword(), principal.getName());

		model.addAttribute("successMessage", "Password cambiata correttamente");
		return "redirect:/logout";
	}
}