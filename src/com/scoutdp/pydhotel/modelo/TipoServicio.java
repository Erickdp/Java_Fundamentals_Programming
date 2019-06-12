/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

import java.util.List;

/**
 * Clase que representa:
 * 
 * @version 8.0 15 mar 2019
 * @author Erick Díaz
 */
public class TipoServicio {

	private int idTipoSv;
	private String nombreTipoSv;
	private String descripcionTipoSv;
	private StringBuilder strBld = new StringBuilder();
	private List<Servicio> servicios;

	public TipoServicio() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idTipoSv
	 * @param nombreTipoSv
	 * @param descripcionTipoSv
	 */
	public TipoServicio(int idTipoSv, String nombreTipoSv, String descripcionTipoSv) {
		this.idTipoSv = idTipoSv;
		this.nombreTipoSv = nombreTipoSv;
		this.descripcionTipoSv = descripcionTipoSv;
	}

	/**
	 * @return the idTipoSv
	 */
	public int getIdTipoSv() {
		return idTipoSv;
	}

	/**
	 * @return the nombreTipoSv
	 */
	public String getNombreTipoSv() {
		return nombreTipoSv.toUpperCase();
	}

	/**
	 * @return the descripcionTipoSv
	 */
	public String getDescripcionTipoSv() {
		return descripcionTipoSv.toLowerCase();
	}

	/**
	 * @return the servicios
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param idTipoSv the idTipoSv to set
	 */
	public void setIdTipoSv(int idTipoSv) {
		this.idTipoSv = idTipoSv;
	}

	/**
	 * @param nombreTipoSv the nombreTipoSv to set
	 */
	public void setNombreTipoSv(String nombreTipoSv) {
		this.nombreTipoSv = nombreTipoSv;
	}

	/**
	 * @param descripcionTipoSv the descripcionTipoSv to set
	 */
	public void setDescripcionTipoSv(String descripcionTipoSv) {
		this.descripcionTipoSv = descripcionTipoSv;
	}

	/**
	 * @param servicios the servicios to set
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		strBld.append("ID DEL TIPO DE SERVICIO [").append(idTipoSv).append("] CATEGORÍA -").append(getNombreTipoSv())
				.append("- DESCRIPCIÓN : ").append(getDescripcionTipoSv()).append(".");
		return strBld.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoSv;
		result = prime * result + ((nombreTipoSv == null) ? 0 : nombreTipoSv.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoServicio other = (TipoServicio) obj;
		if (idTipoSv != other.idTipoSv)
			return false;
		if (nombreTipoSv == null) {
			if (other.nombreTipoSv != null)
				return false;
		} else if (!nombreTipoSv.equalsIgnoreCase(other.nombreTipoSv))
			return false;
		return true;
	}

}
