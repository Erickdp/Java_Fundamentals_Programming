/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

/**
 *  Clase que representa atributos y m�todos de la Habitaci�n
 * 
 *  @version    8.0 28 feb 2019
 *  @author     Erick D�az
 */
public class Habitacion {
	
	private int     numHabi;      // N�mero de habitaci�n en donde se encuentra
	private int     numeroBano;   // N�mero de ba�os en la habitaci�n
	private int     numeroDormi;  // N�mero de cuartos en la habitaci�n
	private String  tamanoCama;   // Tama�o de cama en el/los dormitorios  
	private String  tamanoTv;     // Tama�o de Tv en la habitaci�n
	private String  tenerCocina;  // Confirmaci�n de cocina incluida
	
	public Habitacion() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * M�todo constructor de la clase Habitaci�n, el cual
	 * recibe 5 par�metros
	 * @param numeroBano
	 * @param numeroDormi
	 * @param tamanoCama
	 * @param tamanoTv
	 * @param tenerCocina
	 * @param tenerSala
	 */
	public Habitacion(int numeroBano, int numeroDormi, String tamanoCama, String tamanoTv,
			String tenerCocina) {
		this.numeroBano = numeroBano;
		this.numeroDormi = numeroDormi;
		this.tamanoCama = tamanoCama;
		this.tamanoTv = tamanoTv;
		this.tenerCocina = tenerCocina;
	}

	// Creaci�n de m�todos que modifiquen y comuniquen el estado de un objeto de la clase Habitaci�n
	/**
	 * @return the numeroBano
	 */
	public int getNumeroBano() {
		return numeroBano;
	}

	/**
	 * @return the numeroDormi
	 */
	public int getNumeroDormi() {
		return numeroDormi;
	}

	/**
	 * @return the tamanoCama
	 */
	public String getTamanoCama() {
		return tamanoCama.toUpperCase();
	}

	/**
	 * @return the tamanoTv
	 */
	public String getTamanoTv() {
		return tamanoTv.toUpperCase();
	}

	/**
	 * @return the tenerCocina
	 */
	public String getTenerCocina() {
		return tenerCocina.toUpperCase();
	}
	/**
	 * @param numeroBano the numeroBano to set
	 */
	public void setNumeroBano(int numeroBano) {
		this.numeroBano = numeroBano;
	}
	/**
	 * @param numeroDormi the numeroDormi to set
	 */
	public void setNumeroDormi(int numeroDormi) {
		this.numeroDormi = numeroDormi;
		this.numHabi = (int)(Math.random()*150); // Sentencia que permitir� generar los n�meros de habitaciones
	}
	/**
	 * @param tamanoCama the tamanoCama to set
	 */
	public void setTamanoCama(String tamanoCama) {
		this.tamanoCama = tamanoCama;
	}
	/**
	 * @param tamanoTv the tamanoTv to set
	 */
	public void setTamanoTv(String tamanoTv) {
		this.tamanoTv = tamanoTv;
	}
	/**
	 * @param tenerCocina the tenerCocina to set
	 */
	public void setTenerCocina(String tenerCocina) {
		this.tenerCocina = tenerCocina;
	}
	//M�todo que permitir� obtener el n�mero de la habitaci�n
	public int getNumHabitacion() {
		return numHabi;
	}

	@Override
	public String toString() {
		return "N�mero de su Habitaci�n: N�" + numHabi + " .El c�al tiene " + numeroDormi +
				" Dormitorio/s. " + numeroBano + " Ba�os, Camas de tama�o\n " + tamanoCama + ", " + 
				" Televisi�n de Tama�o " + tamanoTv + ", & " + tenerCocina.toUpperCase() + " tiene Cocina.\n";
	}
}
