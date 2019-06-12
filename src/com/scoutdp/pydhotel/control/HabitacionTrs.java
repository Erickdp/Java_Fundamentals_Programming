/**
 * 
 */
package com.scoutdp.pydhotel.control;

import com.scoutdp.pydhotel.modelo.Habitacion;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;

/**
 * Clase que representa la implementaci�n de la interfaz ICrud
 * 
 * @version 8.0 5 mar 2019
 * @author Erick D�az
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
				return "Habitaci�n Guardada,";
			} else {
				return "No se pueden guardar mas Habitaciones";
			}
		} else {
			return "Complete todos los datos";
		}
	}

	/*
	 * M�todo que permite eliminar los objetos del array habitaciones
	 * seg�n su identificador
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
			return "Habitaci�n ELIMINADA";
		} else {
			return "No se encontr� el N�mero de la Habitaci�n";
		}
	}

	/*
	 * M�todo que permite actualizar objetos de tipo Habitaci�n
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
			return "Habitaci�n Actualizada";
		} else {
			return "No se encontr� la habitaci�n";
		}
	}

	/*
	 * M�todo que permite listar todos los objetos del array
	 * habitaciones de la clase MemoriaBdd
	 * (non-Javadoc)
	 * @see com.scoutdp.pydhotel.control.ICrud#listar()
	 */
	@Override
	public Object[] listar() {
		return MemoriaBDD.habitaciones;
	}

	/*
	 * Este m�todo permitir� obtener la habitaci�n que se desea
	 * consultar seg�n su n�mero de Habitaci�n
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
