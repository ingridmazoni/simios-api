package br.com.mercadolivre.simian.controller;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.mercadolivre.simian.enums.TipoDna;
import br.com.mercadolivre.simian.repository.DnaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureMockMvc
public class StatsControllerTest {
	
	@MockBean 
	private DnaRepository dnaRepository;
	 	
    @Autowired 
    private MockMvc mockMvc;
	  
		  
	  @Test 
	  public void testApiStatsWithDnaMutantZerado() throws Exception {
	  
			given(dnaRepository.getCountTipoDna(TipoDna.SIMIAN)).willReturn(0L);
			given(dnaRepository.getCountTipoDna(TipoDna.HUMANO)).willReturn(5L);
			
	  
		mockMvc.perform(get("http://localhost:8081/stats")
										  .accept(MediaType.APPLICATION_JSON)) 
										  .andExpect(status().isOk())	
										  .andDo(print())
										  .andExpect(MockMvcResultMatchers.jsonPath("$.count_mutant_dna").value(0L))
										  .andExpect(MockMvcResultMatchers.jsonPath("$.count_human_dna").value(5L))
										  .andExpect(MockMvcResultMatchers.jsonPath("$.ratio").value(0L));
	   }
	 
	  @Test 
	  public void testApiStatsWithDnaMutant() throws Exception {
	  
			given(dnaRepository.getCountTipoDna(TipoDna.SIMIAN)).willReturn(2L);
			given(dnaRepository.getCountTipoDna(TipoDna.HUMANO)).willReturn(5L);
			
	  
		mockMvc.perform(get("http://localhost:8081/stats")
										  .accept(MediaType.APPLICATION_JSON)) 
										  .andExpect(status().isOk())	
										  .andDo(print())
										  .andExpect(MockMvcResultMatchers.jsonPath("$.count_mutant_dna").value(2L))
										  .andExpect(MockMvcResultMatchers.jsonPath("$.count_human_dna").value(5L))
										  .andExpect(MockMvcResultMatchers.jsonPath("$.ratio").value(0.02));
	   }
	
	
		
	
	
	  
}
