package br.com.mercadolivre.simian.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class DnaServiceImplTest {
	
	
	DnaServiceImpl dnaServiceImpl = new DnaServiceImpl();
		
	
	@Test
	public void carregaListaDna() {
		
				
		List<String> listaSequenciasDna = getDnaSimian();
				
		 assertEquals("CTGAGA", listaSequenciasDna.get(0)); 
		 assertEquals("CTGAGC", listaSequenciasDna.get(1)); 
		 assertEquals("TATTGT", listaSequenciasDna.get(2)); 
		 assertEquals("AGAGGG", listaSequenciasDna.get(3));
		 assertEquals("CCCCTA", listaSequenciasDna.get(4));
		 assertEquals("TCACTG", listaSequenciasDna.get(5));
			
		 assertEquals("CTTGTG", listaSequenciasDna.get(6)); 
		 assertEquals("TGTGA", listaSequenciasDna.get(7)); 
		 assertEquals("GAGG", listaSequenciasDna.get(8)); 
		 assertEquals("CAACT", listaSequenciasDna.get(9));
		 assertEquals("TGCC", listaSequenciasDna.get(10));
		 
		 assertEquals("AAGA", listaSequenciasDna.get(11)); 
		 assertEquals("CGTAG", listaSequenciasDna.get(12)); 
		 assertEquals("TCATGA", listaSequenciasDna.get(13)); 
		 assertEquals("CCGGC", listaSequenciasDna.get(14));
		 assertEquals("ACGT", listaSequenciasDna.get(15));
		 
		 assertEquals("CCTACT", listaSequenciasDna.get(16)); 
		 assertEquals("TTAGCC", listaSequenciasDna.get(17)); 
		 assertEquals("GGTACA", listaSequenciasDna.get(18)); 
		 assertEquals("AATGCC", listaSequenciasDna.get(19));
		 assertEquals("GGGGTT", listaSequenciasDna.get(20));
		 assertEquals("ACTGAG", listaSequenciasDna.get(21));
	}
	
	
	@Test
	public void isSimian() {
		
		List<String> listaSequenciaSimian = getDnaSimian();
		assertEquals(true, dnaServiceImpl.isSimian(listaSequenciaSimian));
		

		List<String> listaSequenciaHumano = getDnaHumano();
		assertEquals(false, dnaServiceImpl.isSimian(listaSequenciaHumano));
	}
	
	@Test
	public void validateDna() {
		
		List<String> listaSequenciaDna = new ArrayList<String>();
		listaSequenciaDna.add("CTGAGA");
		listaSequenciaDna.add("CTGAGC");
		listaSequenciaDna.add("TATTGT");
		listaSequenciaDna.add("AGAGG2");
		listaSequenciaDna.add("CCCCTA");
		listaSequenciaDna.add("TCACTG");
		assertEquals(false, dnaServiceImpl.validateDna(listaSequenciaDna));
		
	}
	
	@Test
	public void validateDna2() {
		
		List<String> listaSequenciaDna = new ArrayList<String>();
		listaSequenciaDna.add("CTGAGA");
		listaSequenciaDna.add("CTGAGC");
		listaSequenciaDna.add("TATTGT");
		listaSequenciaDna.add("AGAGGG");
		listaSequenciaDna.add("CCCCTH");
		listaSequenciaDna.add("TCACTG");
		assertEquals(false, dnaServiceImpl.validateDna(listaSequenciaDna));
		
	}
	
	@Test
	public void validateDna3() {
		
		List<String> listaSequenciaDna = new ArrayList<String>();
		listaSequenciaDna.add("CTGAGA");
		listaSequenciaDna.add("CTGAGC");
		listaSequenciaDna.add(" ");
		listaSequenciaDna.add("AGAGGG");
		listaSequenciaDna.add("CCCCTA");
		listaSequenciaDna.add("TCACTG");
		assertEquals(false, dnaServiceImpl.validateDna(listaSequenciaDna));
		
	}
	
	public List<String> getDnaSimian() {
		List<String> dna = new ArrayList<String>();
		dna.add("CTGAGA");
		dna.add("CTGAGC");
		dna.add("TATTGT");
		dna.add("AGAGGG");
		dna.add("CCCCTA");
		dna.add("TCACTG");
		
		return dnaServiceImpl.carregaMatrizDna(dna);
	}
	
	public List<String> getDnaHumano() {
		List<String> dna = new ArrayList<String>();
		dna.add("ATGCGA");
		dna.add("CAGTGC");
		dna.add("TTATTT");
		dna.add("AGACGG");
		dna.add("GCGTCA");
		dna.add("TCACTG");
		
		return dnaServiceImpl.carregaMatrizDna(dna);
	}
	
	

}
