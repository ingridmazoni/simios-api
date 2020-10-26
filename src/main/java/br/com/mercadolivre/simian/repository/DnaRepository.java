package br.com.mercadolivre.simian.repository;
  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mercadolivre.simian.entity.Dna;
import br.com.mercadolivre.simian.enums.TipoDna;
  

 public interface DnaRepository extends JpaRepository<Dna, Long> {
	 
	@Query(value = "SELECT coalesce(count(dna),0) FROM Dna dna where dna.tipoDna = :tipoDna ")
	Long getCountTipoDna(@Param("tipoDna") TipoDna tipoDna);
	  
  
 


	
  
  }
 