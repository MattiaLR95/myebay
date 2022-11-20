package it.prova.myebay.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.prova.myebay.dto.AnnuncioDTO;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.service.AnnuncioService;

@Controller
@RequestMapping(value = "/annuncio")
public class AnnuncioController {

	@Autowired
	private AnnuncioService annuncioService;

	@PostMapping("/listAnnuncio")
	public String listAnnunci(Annuncio utenteExample, ModelMap model) {
		model.addAttribute("annuncio_list_attribute",
				AnnuncioDTO.buildAnnuncioDTOListFromModelList(annuncioService.findByExample(utenteExample)));
		return "listAnnuncio";
	}

	@GetMapping("/search")
	public String searchAnnuncio() {
		return "annuncio/search";
	}
	
}