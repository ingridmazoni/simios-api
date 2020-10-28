package br.com.mercadolivre.simian.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.mercadolivre.simian.enums.TipoDna;
import  br.com.mercadolivre.simian.repository.DnaRepository;
import br.com.mercadolivre.simian.service.DnaService;
import br.com.mercadolivre.simios.api.model.ResponseSimian;


@Service
public class DnaServiceImpl implements DnaService {
	
	@Inject
	private DnaRepository dnaRepository;
	 
	@Override
	public ResponseSimian saveDna(List<String> dna , TipoDna tipoDna) {
		
		br.com.mercadolivre.simian.entity.Dna sequenciaDna = new br.com.mercadolivre.simian.entity.Dna();
		sequenciaDna.setSequenciaDna1(dna.get(0));
		sequenciaDna.setSequenciaDna2(dna.get(1));
		sequenciaDna.setSequenciaDna3(dna.get(2));
		sequenciaDna.setSequenciaDna4(dna.get(3));
		sequenciaDna.setSequenciaDna5(dna.get(4));
		sequenciaDna.setSequenciaDna6(dna.get(5));
		sequenciaDna.setTipoDna(tipoDna);
		
		br.com.mercadolivre.simian.entity.Dna sequenciaDnaGravada = dnaRepository.save(sequenciaDna);
			
		br.com.mercadolivre.simios.api.model.Dna dnaRetorno = new br.com.mercadolivre.simios.api.model.Dna();
		dnaRetorno.addDnaItem(sequenciaDnaGravada.getSequenciaDna1());
		dnaRetorno.addDnaItem(sequenciaDnaGravada.getSequenciaDna2());
		dnaRetorno.addDnaItem(sequenciaDnaGravada.getSequenciaDna3());
		dnaRetorno.addDnaItem(sequenciaDnaGravada.getSequenciaDna4());
		dnaRetorno.addDnaItem(sequenciaDnaGravada.getSequenciaDna5());
		dnaRetorno.addDnaItem(sequenciaDnaGravada.getSequenciaDna6());
				
		ResponseSimian responseSimion = new ResponseSimian();
	
		responseSimion.setIsSimian(tipoDna.equals(TipoDna.SIMIAN)?true:false);
		responseSimion.setSequenciaDna(dnaRetorno);
					
		return responseSimion;
		
	}

	@Override
	public boolean validateDna(List<String> dna) {
		
		for(String d : dna) {
									
			if(d==null || !Pattern.matches("[ATCG]{6}", d) || d.isEmpty() || d.isEmpty() ) {
				return false;
			}
		}
		
		
		return true;
	}
	
	
	

}
