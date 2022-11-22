package it.prova.myebay.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import it.prova.myebay.dto.UtenteDTO;
import it.prova.myebay.model.Utente;
import it.prova.myebay.repository.utente.UtenteRepository;

@Component
public class CustomAuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Utente utenteFromDb = utenteRepository.findByUsername(authentication.getName()).orElseThrow(
				()-> new UsernameNotFoundException("Username" + authentication.getName() + "not found"));
		
		//voglio mettere in sessione uno userInfo perché spring security mette solo un principal da cui attingere username
		utenteFromDb = utenteRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Username " + authentication.getName() + " not found"));
		UtenteDTO utenteParziale = new UtenteDTO();
		utenteParziale.setNome(utenteFromDb.getNome());
		utenteParziale.setCognome(utenteFromDb.getCognome());
		utenteParziale.setId(utenteFromDb.getId());
		utenteParziale.setCreditoResiduo(utenteFromDb.getCreditoResiduo());
		request.getSession().setAttribute("userInfo", utenteParziale);
		
		String idAnnuncioWithNoAuthParam = request.getParameter("idAnnuncioWithNoAuth");
		if(StringUtils.isNotBlank(idAnnuncioWithNoAuthParam) && NumberUtils.isCreatable(idAnnuncioWithNoAuthParam)) {
			Long idAnnuncioWithNoAuth = Long.parseLong(idAnnuncioWithNoAuthParam);
			response.sendRedirect("/annuncio/show/"+idAnnuncioWithNoAuth);
			return;
		}
		
		response.sendRedirect("/home");
	}

}
