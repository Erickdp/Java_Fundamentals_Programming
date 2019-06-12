/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

/**
 *  Clase que representa atributos y métodos de la Habitación
 * 
 *  @version    8.0 28 feb 2019
 *  @author     Erick Díaz
 */
public class Habitacion {
	
	private int     numHabi;      // Número de habitación en donde se encuentra
	private int     numeroBano;   // Número de baños en la habitación
	private int     numeroDormi;  // Número de cuartos en la habitación
	private String  tamanoCama;   // Tamaño de cama en el/los dormitorios  
	private String  tamanoTv;     // Tamaño de Tv en la habitación
	private String  tenerCocina;  // Confirmación de cocina incluida
	
	public Habitacion() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Método constructor de la clase Habitación, el cual
	 * recibe 5 parámetros
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

	// Creación de métodos que modifiquen y comuniquen el estado de un objeto de la clase Habitación
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
		this.numHabi = (int)(Math.random()*150); // Sentencia que permitirá generar los números de habitaciones
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
	//Método que permitirá obtener el número de la habitación
	public int getNumHabitacion() {
		return numHabi;
	}

	@Override
	public String toString() {
		return "Número de su Habitación: N°" + numHabi + " .El cúal tiene " + numeroDormi +
				" Dormitorio/s. " + numeroBano + " Baños, Camas de tamaño\n " + tamanoCama + ", " + 
				" Televisión de Tamaño " + tamanoTv + ", & " + tenerCocina.toUpperCase() + " tiene Cocina.\n";
	}
}
