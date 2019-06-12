/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

import java.util.Date;

/**
 *  Clase que representa atributos y métodos del Usuario
 * 
 *  @version    8.0 28 feb 2019
 *  @author     Erick Díaz
 */
public class Usuario {
	
	private String nombreUsu;        // Nombre del Usuario
	private String claveUsu;         // Clave del Usuario
	private String correoUsu;        // Correo del Usuario
	private Date   fechaCreacionUsu; // Fecha de creación de cuenta
	private int    idUsu;            // id de usuario

	
	/**
	 * Método que ayudará a salvar el Alias con el que 
	 * registro
	 * @param nombreUsu
	 */
	public Usuario(String nombreUsu, String correoUsu) {
		this.nombreUsu = nombreUsu;
		this.correoUsu = correoUsu;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Método constructor de la clase Usuario
	 * @param nombreUsu
	 * @param claveUsu
	 * @param correoUsu
	 * @param fechaCreacionUsu
	 */
	public Usuario(String nombreUsu, String claveUsu, String correoUsu, int idUsu, Date fechaCreacionUsu) {
		this.nombreUsu = nombreUsu;
		this.claveUsu = claveUsu;
		this.correoUsu = correoUsu;
		this.idUsu = idUsu;
		this.fechaCreacionUsu = fechaCreacionUsu;
	}
	
	// Creación de métodos que modifiquen y comuniquen el estado de un objeto de la clase Usuario
	/**
	 * @return the nombreUsu
	 */
	public String getNombreUsu() {
		return nombreUsu;
	}

	/**
	 * @return the claveUsu
	 */
	public String getClaveUsu() {
		return claveUsu;
	}

	/**
	 * @return the correoUsu
	 */
	public String getCorreoUsu() {
		return correoUsu;
	}

	/**
	 * @return the fechaCreacionUsu
	 */
	public Date getFechaCreacionUsu() {
		return fechaCreacionUsu;
	}

	/**
	 * @param nombreUsu the nombreUsu to set
	 */
	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	/**
	 * @param claveUsu the claveUsu to set
	 */
	public void setClaveUsu(String claveUsu) {
		this.claveUsu = claveUsu;
	}

	/**
	 * @param correoUsu the correoUsu to set
	 */
	public void setCorreoUsu(String correoUsu) {
		this.correoUsu = correoUsu;
	}

	/**
	 * @param fechaCreacionUsu the fechaCreacionUsu to set
	 */
	public void setFechaCreacionUsu(Date fechaCreacionUsu) {
		this.fechaCreacionUsu = fechaCreacionUsu;
	}
	/**
	 * @return the idUsu
	 */
	public int getIdUsu() {
		return idUsu;
	}
	/**
	 * @param idUsu the idUsu to set
	 */
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ">**** ID: " + idUsu + " Nombre[ " + nombreUsu + " ] Correo: " + correoUsu + ". CLAVE *"
				+ claveUsu + "* Fecha De Creación " + fechaCreacionUsu;
	}
	
}
