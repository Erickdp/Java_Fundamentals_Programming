/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

/**
 * Clase que representa la herencia de Habitación a Suite
 * 
 * @version 8.0 28 feb 2019
 * @author Erick Díaz
 */
public final class Suite extends Habitacion {

	private String sala;     // Confirmación de Sala en Suite
	private String gym;      // Confirmación de Gimnasio en Suite
	private String bal;      // Confirmación de Balcón en Suite
	private String aireAcon; // Confirmación de aire Acondicionado en Suite
	
	public Suite() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numeroBano
	 * @param numeroDormi
	 * @param tamanoCama
	 * @param tamanoTv
	 * @param tenerCocina
	 * @param sala
	 * @param gym
	 * @param bal
	 * @param aireAcon
	 */
	public Suite(int numeroBano, int numeroDormi, String tamanoCama, String tamanoTv, String tenerCocina, String sala,
			String gym, String bal, String aireAcon) {
		super(numeroBano, numeroDormi, tamanoCama, tamanoTv, tenerCocina);
		this.sala = sala;
		this.gym = gym;
		this.bal = bal;
		this.aireAcon = aireAcon;
	}
	
	/**
	 * @return the sala
	 */
	public String getSala() {
		return sala;
	}

	/**
	 * @return the gym
	 */
	public String getGym() {
		return gym;
	}

	/**
	 * @return the bal
	 */
	public String getBal() {
		return bal;
	}

	/**
	 * @return the aireAcon
	 */
	public String getAireAcon() {
		return aireAcon;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(String sala) {
		this.sala = sala;
	}

	/**
	 * @param gym the gym to set
	 */
	public void setGym(String gym) {
		this.gym = gym;
	}

	/**
	 * @param bal the bal to set
	 */
	public void setBal(String bal) {
		this.bal = bal;
	}

	/**
	 * @param aireAcon the aireAcon to set
	 */
	public void setAireAcon(String aireAcon) {
		this.aireAcon = aireAcon;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " " + sala.toUpperCase() + " cuenta con Sala, " + gym.toUpperCase() + " tiene Gimnsaio, "
				+ bal.toUpperCase() + " tiene Balcón y " + aireAcon.toUpperCase() + " dispone de Aire Acondicionado.\n"; 
	}
}
