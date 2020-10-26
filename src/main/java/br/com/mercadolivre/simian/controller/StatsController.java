package br.com.mercadolivre.simian.controller;

import java.math.BigDecimal;
import java.net.URI;

import javax.inject.Inject;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mercadolivre.simian.enums.TipoDna;
import br.com.mercadolivre.simian.repository.DnaRepository;
import br.com.mercadolivre.simios.api.StatsApi;
import br.com.mercadolivre.simios.api.model.Stats;

@RestController
public class StatsController implements StatsApi {
	
	@Inject
	private DnaRepository dnaRepository;

	@Override
	public ResponseEntity<Stats> stats() {

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		HttpHeaders responseHeaders = new org.springframework.http.HttpHeaders();
		responseHeaders.setLocation(location);
		
		  Long qtdoSimions = dnaRepository.getCountTipoDna(TipoDna.SIMIAN);
		
		  Stats stats = new Stats();
		  stats.setCountHumanDna(dnaRepository.getCountTipoDna(TipoDna.HUMANO));
		  stats.setCountMutantDna(qtdoSimions);
					
			  if(qtdoSimions>0) {
			    stats.ratio(BigDecimal.valueOf(qtdoSimions).divide(BigDecimal.valueOf(100).setScale(3)));
			  
			  }else {
				  stats.ratio(BigDecimal.ZERO);
			  }
			 
		return new ResponseEntity<Stats>(stats,responseHeaders,HttpStatus.OK);
	}

}
