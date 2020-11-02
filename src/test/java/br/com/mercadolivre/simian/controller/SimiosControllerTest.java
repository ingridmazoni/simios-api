package br.com.mercadolivre.simian.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mercadolivre.simios.api.model.Dna;
import br.com.mercadolivre.simios.api.model.ResponseSimian;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class SimiosControllerTest {
		
	  @LocalServerPort 
	  private int port;
	 
	  @Autowired
	  private TestRestTemplate restTemplate;
			
		  @Test
		  @Order(1) 
		  public void testApiDnaHumano() throws Exception {
			  
			  List<String> listDna = new ArrayList<String>();
			  listDna.add("ATGCGA");
			  listDna.add("CAGTGC");
			  listDna.add("TTATTT");
			  listDna.add("AGACGG");
			  listDna.add("GCGTCA");
			  listDna.add("TCACTG");
		  
			  Dna dna=new Dna();
			  dna.dna(listDna);
			  
		  ResponseEntity<ResponseSimian> responseEntity =
		  this.restTemplate.postForEntity("http://localhost:" + port + "/simian" , dna, ResponseSimian.class);
		  
		  assertEquals(403, responseEntity.getStatusCodeValue()); 
		  assertEquals(false, responseEntity.getBody().getIsSimian());
		
		  
		  }
		 
	
		  @Test
		  @Order(2) 
		  public void testApiDnaSimios() throws Exception {
			  
			  List<String> listDna = new ArrayList<String>();
			  listDna.add("CTGAGA");
			  listDna.add("CTGAGC");
			  listDna.add("TATTGT");
			  listDna.add("AGAGGG");
			  listDna.add("CCCCTA");
			  listDna.add("TCACTG");
						  
			  Dna dna=new Dna();
			  dna.dna(listDna);
			  
		  ResponseEntity<ResponseSimian> responseEntity =
		  this.restTemplate.postForEntity("http://localhost:" + port + "/simian" , dna, ResponseSimian.class);
		  
		  assertEquals(200, responseEntity.getStatusCodeValue()); 
		  assertEquals(true, responseEntity.getBody().getIsSimian());
		
		  
		  }
		 
	
	  
}
