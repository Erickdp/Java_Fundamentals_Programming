/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

import java.time.LocalDate;

/**
 * Clase que representa la reserva del Usuario
 * 
 * @version 8.0 16 mar 2019
 * @author Erick Díaz
 */
public class Reserva {

	/*
	 * Variables que permitirán el manejo
	 * de fechas 
	 */
	private LocalDate fechaDeEstancia;  
	private LocalDate fechaDeRetiro;
	
	private int idReserva;
	private Habitacion habitacionReservada = null;
	private Suite suiteReservada = null;
	private StringBuffer strBf = new StringBuffer();

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fechaDeEstancia
	 * @param fechaDeRetiro
	 * @param idReserva
	 */
	public Reserva(LocalDate fechaDeEstancia, LocalDate fechaDeRetiro, int idReserva) {
		this.fechaDeEstancia = fechaDeEstancia;
		this.fechaDeRetiro = fechaDeRetiro;
		this.idReserva = idReserva;
	}


	/**
	 * Con este constructor se podrá dar una respuesta
	 * mas rápida si dos objetos son igual ya que se
	 * ahorra tiempo para no llenar el formulario y al final
	 * recibir una respuesta de error.
	 * @param idReserva
	 */
	public Reserva(int idReserva) {
		this.idReserva = idReserva;
	}

	/**
	 * @param fechaDeEstancia
	 * @param fechaDeRetiro
	 * @param idReserva
	 * @param habitacionReservada
	 */
	public Reserva(LocalDate fechaDeEstancia, LocalDate fechaDeRetiro, int idReserva, Habitacion habitacionReservada) {
		this.fechaDeEstancia = fechaDeEstancia;
		this.fechaDeRetiro = fechaDeRetiro;
		this.idReserva = idReserva;
		this.habitacionReservada = habitacionReservada;
	}

	/**
	 * @param fechaDeEstancia
	 * @param fechaDeRetiro
	 * @param idReserva
	 * @param suiteReservada
	 */
	public Reserva(LocalDate fechaDeEstancia, LocalDate fechaDeRetiro, int idReserva, Suite suiteReservada) {
		this.fechaDeEstancia = fechaDeEstancia;
		this.fechaDeRetiro = fechaDeRetiro;
		this.idReserva = idReserva;
		this.suiteReservada = suiteReservada;
	}

	/**
	 * @return the fechaDeEstancia
	 */
	public LocalDate getFechaDeEstancia() {
		return fechaDeEstancia;
	}

	/**
	 * @return the fechaDeRetiro
	 */
	public LocalDate getFechaDeRetiro() {
		return fechaDeRetiro;
	}

	/**
	 * @return the idReserva
	 */
	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * @param fechaDeEstancia the fechaDeEstancia to set
	 */
	public void setFechaDeEstancia(LocalDate fechaDeEstancia) {
		this.fechaDeEstancia = fechaDeEstancia;
	}

	/**
	 * @param fechaDeRetiro the fechaDeRetiro to set
	 */
	public void setFechaDeRetiro(LocalDate fechaDeRetiro) {
		this.fechaDeRetiro = fechaDeRetiro;
	}

	/**
	 * @param idReserva the idReserva to set
	 */
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * @return the habitacionReservada
	 */
	public Habitacion getHabitacionReservada() {
		return habitacionReservada;
	}

	/**
	 * @return the suiteReservada
	 */
	public Suite getSuiteReservada() {
		return suiteReservada;
	}

	/**
	 * @param habitacionReservada the habitacionReservada to set
	 */
	public void setHabitacionReservada(Habitacion habitacionReservada) {
		this.habitacionReservada = habitacionReservada;
	}

	/**
	 * @param suiteReservada the suiteReservada to set
	 */
	public void setSuiteReservada(Suite suiteReservada) {
		this.suiteReservada = suiteReservada;
	}

	/*
	 * Se Va a comparar Objetos que tengan el 
	 * mismo Id de reserva
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idReserva;
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
		Reserva other = (Reserva) obj;
		if (idReserva != other.idReserva)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (getHabitacionReservada() != null) {
			strBf.append("- RESERVA DE - |").append(getHabitacionReservada()).append("| PARA (").append(fechaDeEstancia)
					.append(") HASTA (").append(getFechaDeRetiro()).append(")");
		} else if (getSuiteReservada() != null) {
			strBf.append("- RESERVA DE - |").append(getSuiteReservada()).append("| PARA (").append(fechaDeEstancia)
					.append(") HASTA (").append(getFechaDeRetiro()).append(")");
		}
		return strBf.toString();
	}
}
