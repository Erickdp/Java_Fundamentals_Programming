/**
 * 
 */
package com.scoutdp.pydhotel.control;

import com.scoutdp.pydhotel.modelo.Habitacion;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;

/**
 * Clase que representa la implementación de la interfaz ICrud
 * 
 * @version 8.0 5 mar 2019
 * @author Erick Díaz
 *
 *         <a href="www.matoosfe.com">Soporte</a>
 */
public class HabitacionTrs implements ICrud{

	@Override
	public String guardar(Object registro) {
		boolean bandera = false;
		int contPos = 0;
		if (registro != null) {
			for (Habitacion busHab : MemoriaBDD.habitaciones) {
				if (busHab == null) {
					bandera = true;
					break;
				}
				contPos++;
			}
			if (bandera) {
				MemoriaBDD.habitaciones[contPos] = (Habitacion) registro;
				return "Habitación Guardada,";
			} else {
				return "No se pueden guardar mas Habitaciones";
			}
		} else {
			return "Complete todos los datos";
		}
	}

	/*
	 * Método que permite eliminar los objetos del array habitaciones
	 * según su identificador
	 * (non-Javadoc)
	 * @see com.scoutdp.pydhotel.control.ICrud#eliminar(int)
	 */
	@Override
	public String eliminar(int id) {
		boolean bandera = false;
		int conPos = 0;
		for (Habitacion elimHab : MemoriaBDD.habitaciones) {
			if (elimHab != null && elimHab.getNumHabitacion() == id) {
				bandera = true;
				break;
			}
			conPos++;
		}
		if (bandera) {
			MemoriaBDD.habitaciones[conPos] = null;
			return "Habitación ELIMINADA";
		} else {
			return "No se encontró el Número de la Habitación";
		}
	}

	/*
	 * Método que permite actualizar objetos de tipo Habitación
	 * (non-Javadoc)
	 * @see com.scoutdp.pydhotel.control.ICrud#actualizar(int, java.lang.Object)
	 */
	@Override
	public String actualizar(int id, Object registro) {
		boolean bandera = false;
		int conPos = 0;
		for (Habitacion actHab : MemoriaBDD.habitaciones){
			if (actHab != null && actHab.getNumHabitacion() == id) {
				bandera = true;
				break;
			}
			conPos++;
		}
		if (bandera) {
			MemoriaBDD.habitaciones[conPos] = (Habitacion) registro;
			return "Habitación Actualizada";
		} else {
			return "No se encontró la habitación";
		}
	}

	/*
	 * Método que permite listar todos los objetos del array
	 * habitaciones de la clase MemoriaBdd
	 * (non-Javadoc)
	 * @see com.scoutdp.pydhotel.control.ICrud#listar()
	 */
	@Override
	public Object[] listar() {
		return MemoriaBDD.habitaciones;
	}

	/*
	 * Este método permitirá obtener la habitación que se desea
	 * consultar según su número de Habitación
	 * (non-Javadoc)
	 * @see com.scoutdp.pydhotel.control.ICrud#consultarConId(int)
	 */
	@Override
	public Object consultarConId(int id) throws MiExcepcion2{
		boolean bandera = false;
		int conPos = 0;
		for (Habitacion busHabitacion : MemoriaBDD.habitaciones) {
			if (busHabitacion != null && busHabitacion.getNumHabitacion() == id) {
				bandera = true;
				break;
			}
			conPos++;
		}
		if (bandera) {
			return MemoriaBDD.habitaciones[conPos];
		} else {
			throw new MiExcepcion2();
		}
	}
}
