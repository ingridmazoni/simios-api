package br.com.mercadolivre.simian.controller;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mercadolivre.simian.enums.TipoDna;
import br.com.mercadolivre.simian.service.DnaService;
import br.com.mercadolivre.simios.api.SimianApi;
import br.com.mercadolivre.simios.api.model.Dna;
import br.com.mercadolivre.simios.api.model.ResponseSimian;


@RestController
public class SimianController implements SimianApi {
	
	@Inject
	private DnaService simianService;

	@Override
	public ResponseEntity<ResponseSimian> isSimian(@Valid @RequestBody Dna dna) {
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.setLocation(location);
		
		boolean validateDna = simianService.validateDna(dna.getDna());
		String tipoDna = "SIMIAN";
		
		if(validateDna && TipoDna.SIMIAN.name().equals(tipoDna)) {
			
			ResponseSimian responseSimian = simianService.saveDna(dna.getDna() , TipoDna.SIMIAN);
							
			return new ResponseEntity<ResponseSimian>(responseSimian , responseHeaders,HttpStatus.OK);
		}
		else if (validateDna && TipoDna.HUMANO.name().equals(tipoDna)) {
			
			ResponseSimian responseSimian = simianService.saveDna(dna.getDna() , TipoDna.HUMANO);
			
			return new ResponseEntity<ResponseSimian>(responseSimian, responseHeaders,HttpStatus.FORBIDDEN);
		}
				
		return new ResponseEntity<ResponseSimian>(HttpStatus.FORBIDDEN);
	}

}
