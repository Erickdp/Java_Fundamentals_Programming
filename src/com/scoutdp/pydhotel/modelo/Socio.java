/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

import java.util.Date;

/**
 * Clase que herada de la clase Usuario y en donde se representan atributos y
 * métodos de un cliente
 * 
 * @version 8.0 8 mar 2019
 * @author Erick Díaz
 */
public final class Socio extends Usuario {

	private String paseVip; // Variable que representa la cuenta V.I.P de un Socio
	
	public Socio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombreUsu
	 * @param claveUsu
	 * @param correoUsu
	 * @param idUsu
	 * @param fechaCreacionUsu
	 * @param paseVip
	 */
	public Socio(String nombreUsu, String claveUsu, String correoUsu, int idUsu, Date fechaCreacionUsu,
			String paseVip) {
		super(nombreUsu, claveUsu, correoUsu, idUsu, fechaCreacionUsu);
		this.paseVip = paseVip;
	}


	/**
	 * @return the paseVip
	 */
	public String getPaseVip() {
		return paseVip;
	}

	/**
	 * @param paseVip the paseVip to set
	 */
	public void setPaseVip(String paseVip) {
		this.paseVip = paseVip;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return super.toString() + " *** SU NÚMERO DE TARJETA V.I.P ES [" + paseVip + "]"; 
	}
	
}
