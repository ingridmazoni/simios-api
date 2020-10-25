package br.com.mercadolivre.simian.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Dna implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8654008407910404296L;

	@Id
	@GeneratedValue
	private Long idDna;
	
	@Column(name="sequenciaDna", nullable=false, unique= true , length = 6)
	String sequenciaDna;
	
	public Dna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdDna() {
		return idDna;
	}

	public void setIdDna(Long idDna) {
		this.idDna = idDna;
	}

	public String getSequenciaDna() {
		return sequenciaDna;
	}

	public void setSequenciaDna(String sequenciaDna) {
		this.sequenciaDna = sequenciaDna;
	}

   
	
	
	

}
