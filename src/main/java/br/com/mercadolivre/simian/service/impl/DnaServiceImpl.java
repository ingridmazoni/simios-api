package br.com.mercadolivre.simian.service.impl;

import java.util.ArrayList;
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
	
	@Override
	public boolean isSimian (List<String> dna) {
		
		dna.addAll(carregaMatrizDna(dna));
		
		for (String d:dna) {
			if(Pattern.compile("[A]{4}").matcher(d).find()
					||Pattern.compile("[T]{4}").matcher(d).find()
					||Pattern.compile("[C]{4}").matcher(d).find()
					||Pattern.compile("[G]{4}").matcher(d).find()
			) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	public List<String> carregaMatrizDna(List<String> dna) {
		
		String [][] matrizDna = new String[6][6];
		
		StringBuilder matriz = new StringBuilder();
		
		for(int i=0; i<6;i++) {  
			for(int j=0;j<6;j++) {
				
				matrizDna[i][j]=String.valueOf(dna.get(i).charAt(j));
				matriz.append(matrizDna[i][j]+"   ");
				
			}
			matriz.append("\n");
		}
		
		System.out.println(matriz.toString());
		
		return verificaMatrizDna(matrizDna);
		
		
	}
	
	
	public List<String> verificaMatrizDna(String [][] matrizDna) {
		
		List<String> listSequenciaDna = new ArrayList<String>();
		
		List<String> dnaDiagonaisPrincipais = new ArrayList<String>();
				
		recursivaDiagonaisPrincipais(0, 0, matrizDna, dnaDiagonaisPrincipais , new String());
		recursivaDiagonaisPrincipais(0, 1, matrizDna, dnaDiagonaisPrincipais , new String());
		recursivaDiagonaisPrincipais(0, 2, matrizDna, dnaDiagonaisPrincipais , new String());
		recursivaDiagonaisPrincipais(1, 0, matrizDna, dnaDiagonaisPrincipais , new String());
		recursivaDiagonaisPrincipais(2, 0, matrizDna, dnaDiagonaisPrincipais, new String());
		
		List<String> dnaDiagonaisSecundarias = new ArrayList<String>();
		 
		  recursivaDiagonaisSecundarias(3, 0, matrizDna, dnaDiagonaisSecundarias, new String());
		  recursivaDiagonaisSecundarias(4, 0, matrizDna, dnaDiagonaisSecundarias, new String());
		  recursivaDiagonaisSecundarias(5, 0, matrizDna, dnaDiagonaisSecundarias, new String());
		  recursivaDiagonaisSecundarias(5, 1, matrizDna, dnaDiagonaisSecundarias, new String());
		  recursivaDiagonaisSecundarias(5, 2, matrizDna, dnaDiagonaisSecundarias, new String());
		  
		  List<String> dnaColunas = new ArrayList<String>();
			 
		  for(int j=0;j<6;j++) {
			  recursivaColunas(0, j, matrizDna, dnaColunas, new String());
		  }
		  		  
		  System.out.println("Diagonais Principais");
		dnaDiagonaisPrincipais.stream().forEach(list->{
			System.out.println(list);
		});  
		 
		System.out.println("\rDiagonais Secundarias");
		dnaDiagonaisSecundarias.stream().forEach(list->{
			
			System.out.println(list);
		});
			
		System.out.println("\rDiagonais Colunas");
		dnaColunas.stream().forEach(list->{
			
			System.out.println(list);
		});
		
		listSequenciaDna.addAll(dnaDiagonaisPrincipais);
		listSequenciaDna.addAll(dnaDiagonaisSecundarias);
		listSequenciaDna.addAll(dnaColunas);
		
		return listSequenciaDna;
		
	}
	
	public void recursivaDiagonaisPrincipais(int i , int j , String [][] matrizDna, List<String> dnaDiagonais , String linha) {
		
				
		if(i==5 || j==5) {
			linha+=matrizDna[i][j];
			dnaDiagonais.add(linha);
		}else {
			
			linha+= matrizDna[i][j];
			recursivaDiagonaisPrincipais(++i, ++j, matrizDna, dnaDiagonais , linha) ;
			
		}
		
	}
	
	
	public void recursivaDiagonaisSecundarias(int i , int j , String [][] matrizDna, List<String> dnaDiagonais , String linha) {
		
		
		if(i==0 || j==5) {
			linha+= matrizDna[i][j];
			dnaDiagonais.add(linha);
		}else {
			
			linha+= matrizDna[i][j];
			recursivaDiagonaisSecundarias(--i, ++j, matrizDna, dnaDiagonais , linha) ;
			
		}
		
	}
	
	public void recursivaColunas(int i , int j , String [][] matrizDna, List<String> dnaColunas , String linha) {
			
			
			if(i==5) {
				linha+= matrizDna[i][j];
				dnaColunas.add(linha);
			}else {
				
				linha+= matrizDna[i][j];
				recursivaColunas(++i, j, matrizDna, dnaColunas , linha) ;
				
			}
		
	
	}

}