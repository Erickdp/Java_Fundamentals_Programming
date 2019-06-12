/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

import java.math.BigDecimal;

/**
 * Clase que representa:
 * 
 * @version 8.0 15 mar 2019
 * @author Erick Díaz
 */
public class Servicio {

	private int idSv;
	private String descripcionSv;
	private String nombreSv;
	private BigDecimal precioSv;
	private TipoServicio tipoSv;

	private StringBuilder strBlr = new StringBuilder();

	public Servicio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idSv
	 * @param descripcionSv
	 * @param nombreSv
	 * @param precioSv
	 * @param tipoSv
	 */
	public Servicio(int idSv, String descripcionSv, String nombreSv, BigDecimal precioSv, TipoServicio tipoSv) {
		this.idSv = idSv;
		this.descripcionSv = descripcionSv;
		this.nombreSv = nombreSv;
		this.precioSv = precioSv;
		this.tipoSv = tipoSv;
	}

	/**
	 * @return the idSv
	 */
	public int getIdSv() {
		return idSv;
	}

	/**
	 * @return the descripcionSv
	 */
	public String getDescripcionSv() {
		return descripcionSv;
	}

	/**
	 * @return the nombreSv
	 */
	public String getNombreSv() {
		return nombreSv;
	}

	/**
	 * @return the precioSv
	 */
	public BigDecimal getPrecioSv() {
		return precioSv;
	}

	/**
	 * @return the tipoSv
	 */
	public TipoServicio getTipoSv() {
		return tipoSv;
	}

	/**
	 * @param idSv the idSv to set
	 */
	public void setIdSv(int idSv) {
		this.idSv = idSv;
	}

	/**
	 * @param descripcionSv the descripcionSv to set
	 */
	public void setDescripcionSv(String descripcionSv) {
		this.descripcionSv = descripcionSv;
	}

	/**
	 * @param nombreSv the nombreSv to set
	 */
	public void setNombreSv(String nombreSv) {
		this.nombreSv = nombreSv;
	}

	/**
	 * @param precioSv the precioSv to set
	 */
	public void setPrecioSv(BigDecimal precioSv) {
		this.precioSv = precioSv;
	}

	/**
	 * @param tipoSv the tipoSv to set
	 */
	public void setTipoSv(TipoServicio tipoSv) {
		this.tipoSv = tipoSv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		strBlr.append("ID del Servicio [").append(idSv).append("] Nombre ''").append(nombreSv)
				.append("'' Descripción -").append(descripcionSv).append("- A $").append(precioSv).append(" DE TIPO :")
				.append(tipoSv.getNombreTipoSv());
		return strBlr.toString();
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
		result = prime * result + idSv;
		result = prime * result + ((nombreSv == null) ? 0 : nombreSv.hashCode());
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
		Servicio other = (Servicio) obj;
		if (idSv != other.idSv)
			return false;
		if (nombreSv == null) {
			if (other.nombreSv != null)
				return false;
		} else if (!nombreSv.equals(other.nombreSv))
			return false;
		return true;
	}
}
