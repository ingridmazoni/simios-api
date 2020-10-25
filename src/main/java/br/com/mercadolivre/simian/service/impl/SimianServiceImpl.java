package br.com.mercadolivre.simian.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import  br.com.mercadolivre.simian.repository.SimianRepository;
import br.com.mercadolivre.simian.service.SimianService;

@Service
public class SimianServiceImpl implements SimianService {
	
	@Inject
	private SimianRepository simianRepository;
	 
	@Override
	public void  saveSimian(String dna) {
		
		br.com.mercadolivre.simian.entity.Dna sequenciaDna = new br.com.mercadolivre.simian.entity.Dna();
		sequenciaDna.setSequenciaDna(dna);
	
		simianRepository.save(sequenciaDna);
		  
		
	}

}
