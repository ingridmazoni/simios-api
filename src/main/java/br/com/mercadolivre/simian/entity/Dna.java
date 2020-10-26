package br.com.mercadolivre.simian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.mercadolivre.simian.enums.TipoDna;


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
	
	@Column(name="sequenciaDna1", nullable=false, unique= true , length = 6)
	private String sequenciaDna1;
	
	@Column(name="sequenciaDna2", nullable=false, unique= true , length = 6)
	private String sequenciaDna2;
	
	@Column(name="sequenciaDna3", nullable=false, unique= true , length = 6)
	private String sequenciaDna3;
	
	@Column(name="sequenciaDna4", nullable=false, unique= true , length = 6)
	private String sequenciaDna4;
	
	@Column(name="sequenciaDna5", nullable=false, unique= true , length = 6)
	private String sequenciaDna5;
	
	@Column(name="sequenciaDna6", nullable=false, unique= true , length = 6)
	private String sequenciaDna6;
	
	@Column(name = "tipoDna")
	@Enumerated(EnumType.STRING)
	private TipoDna tipoDna;
	
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

	public String getSequenciaDna1() {
		return sequenciaDna1;
	}

	public void setSequenciaDna1(String sequenciaDna1) {
		this.sequenciaDna1 = sequenciaDna1;
	}

	public String getSequenciaDna2() {
		return sequenciaDna2;
	}

	public void setSequenciaDna2(String sequenciaDna2) {
		this.sequenciaDna2 = sequenciaDna2;
	}

	public String getSequenciaDna3() {
		return sequenciaDna3;
	}

	public void setSequenciaDna3(String sequenciaDna3) {
		this.sequenciaDna3 = sequenciaDna3;
	}

	public String getSequenciaDna4() {
		return sequenciaDna4;
	}

	public void setSequenciaDna4(String sequenciaDna4) {
		this.sequenciaDna4 = sequenciaDna4;
	}

	public String getSequenciaDna5() {
		return sequenciaDna5;
	}

	public void setSequenciaDna5(String sequenciaDna5) {
		this.sequenciaDna5 = sequenciaDna5;
	}

	public String getSequenciaDna6() {
		return sequenciaDna6;
	}

	public void setSequenciaDna6(String sequenciaDna6) {
		this.sequenciaDna6 = sequenciaDna6;
	}

	public TipoDna getTipoDna() {
		return tipoDna;
	}

	public void setTipoDna(TipoDna tipoDna) {
		this.tipoDna = tipoDna;
	}

	
	

	

}
