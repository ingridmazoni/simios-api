package br.com.mercadolivre.simian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;

import br.com.mercadolivre.simian.enums.TipoDna;


@Entity
@Table(
	    uniqueConstraints =  @UniqueConstraint(
	        name = "uk_sequencias_dna",
	        columnNames = {
	            "sequencia_dna1",
	            "sequencia_dna2",
	            "sequencia_dna3",
	            "sequencia_dna4",
	            "sequencia_dna5",
	            "sequencia_dna6"
	        }
	    )
	)
@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
public class Dna implements Serializable {
	
	private static final long serialVersionUID = -8654008407910404296L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_dna")
	private Long idDna;
	
	@NotBlank
	@NotNull
	@Size(min=1, max=6)
	@Column(name="sequencia_dna1", nullable=false, length = 6)
	private String sequenciaDna1;
	
	@NotBlank
	@NotNull
	@Size(min=1, max=6)
	@Column(name="sequencia_dna2", nullable=false, length = 6)
	private String sequenciaDna2;
	
	@NotBlank
	@NotNull
	@Size(min=1, max=6)
	@Column(name="sequencia_dna3", nullable=false, length = 6)
	private String sequenciaDna3;
	
	@NotBlank
	@NotNull
	@Size(min=1, max=6)
	@Column(name="sequencia_dna4", nullable=false, length = 6)
	private String sequenciaDna4;
	
	@NotBlank
	@NotNull
	@Size(min=1, max=6)
	@Column(name="sequencia_dna5", nullable=false, length = 6)
	private String sequenciaDna5;
	
	@NotBlank
	@NotNull
	@Size(min=1, max=6)
	@Column(name="sequencia_dna6", nullable=false, length = 6)
	private String sequenciaDna6;
	
	@Column(name = "tipo_dna" , nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoDna tipoDna;
	
	public Dna() {
		super();
		
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
