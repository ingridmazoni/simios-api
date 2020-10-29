package br.com.mercadolivre.simian.service;

import java.util.List;

import br.com.mercadolivre.simian.enums.TipoDna;
import br.com.mercadolivre.simios.api.model.ResponseSimian;

public interface DnaService {
	
	public ResponseSimian saveDna(List<String> dna , TipoDna tipoDna);
	
	public boolean validateDna(List<String> dna);
	
	public boolean isSimian (List<String> dna);

}
