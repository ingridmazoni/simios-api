package br.com.mercadolivre.simian.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DnaServiceImplTest {
		
	
	@Test
	public void carregaListaDna() {
		
		DnaServiceImpl dnaServiceImpl = new DnaServiceImpl();
		
		List<String> dna = new ArrayList<String>();
		dna.add("CTGAGA");
		dna.add("CTGAGC");
		dna.add("TATTGT");
		dna.add("AGAGGG");
		dna.add("CCCCTA");
		dna.add("TCACTG");
		
		dnaServiceImpl.carregaMatrizDna(dna);
			
		
		
	}
	
	

}
