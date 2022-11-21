package it.prova.myebay.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.prova.myebay.dto.AcquistoDTO;
import it.prova.myebay.dto.UtenteDTO;
import it.prova.myebay.model.Acquisto;
import it.prova.myebay.service.AcquistoService;

@Controller
@RequestMapping(value = "/acquisto")
public class AcquistoController {

	@Autowired
	private AcquistoService acquistoService;

	@GetMapping
	public ModelAndView listAllAcquisti() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("acquisti_list_attribute",
				AcquistoDTO.createAcquistoDTOFromModelList(acquistoService.listAll(), false));
		mv.setViewName("acquisto/list");
		return mv;
	}

	@RequestMapping("/list")
	public String listAcquisti(Acquisto acquistoExample, ModelMap model, HttpServletRequest request) {
		UtenteDTO utenteInSessione = (UtenteDTO) request.getSession().getAttribute("userInfo");
		acquistoExample.setUtente(utenteInSessione.buildUtenteModel(false));
		model.addAttribute("acquisti_list_attribute",
				AcquistoDTO.createAcquistoDTOFromModelList(acquistoService.findByExample(acquistoExample), true));

		return "acquisto/list";
	}

	@GetMapping("/search")
	public String searchAcquisto(Model model) {
		return "acquisto/search";
	}

	@GetMapping("/show/{idAcquisto}")
	public String showAnnuncio(HttpServletRequest request, @PathVariable(required = true) Long idAcquisto,
			Model model) {
		Acquisto acquistoModel = acquistoService.caricaSingoloElemento(idAcquisto);
		UtenteDTO utenteInSessione = (UtenteDTO) request.getSession().getAttribute("userInfo");
		acquistoModel.setUtente(utenteInSessione.buildUtenteModel(false));
		AcquistoDTO result = AcquistoDTO.buildAcquistoDTOFromModel(acquistoModel, true);
		model.addAttribute("show_acquisto_attr", result);
		return "acquisto/show";
	}

}