package br.com.mercadolivre.simian.enums;

public enum TipoDna {
	
	SIMIAN("SIMIAN"),HUMANO("HUMANO");
	
	String tipoDna;

	TipoDna(String string) {
		
	}

	public String getTipoDna() {
		return tipoDna;
	}

	public void setTipoDna(String tipoDna) {
		this.tipoDna = tipoDna;
	}
	
		

}
