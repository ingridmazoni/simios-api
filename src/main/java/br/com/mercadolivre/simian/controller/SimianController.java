package br.com.mercadolivre.simian.controller;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mercadolivre.simian.service.SimianService;
import br.com.mercadolivre.simios.api.SimianApi;
import br.com.mercadolivre.simios.api.model.Dna;


@RestController
public class SimianController implements SimianApi {
	
	@Inject
	private SimianService simianService;

	@Override
	public ResponseEntity<Void> isSimian(@Valid @RequestBody List<Dna> dna) {
		
		simianService.saveSimian(dna.get(0).getDna());
		
			
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.setLocation(location);
		
		
		return new ResponseEntity<Void>(responseHeaders,HttpStatus.OK);
	}

}
