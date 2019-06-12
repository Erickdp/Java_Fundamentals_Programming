/**
 * 
 */
package com.scoutdp.pydhotel.control;

import com.scoutdp.pydhotel.modelo.Suite;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;

/**
 * Clase que representa
 * 
 * @version 8.0 5 mar 2019
 * @author Erick Díaz
 *
 *         <a href="www.matoosfe.com">Soporte</a>
 */
public class SuiteTrs implements ICrud {

	@Override
	public String guardar(Object registro) {
		boolean bandera = false;
		int contPos = 0;
		if (registro != null) {
			for (Suite busSuite : MemoriaBDD.suites) {
				if (busSuite == null) {
					bandera = true;
					break;
				}
				contPos++;
			}
			if (bandera) {
				MemoriaBDD.suites[contPos] = (Suite) registro;
				return "**Suite Guardada**";
			} else {
				return "No se pueden guardar mas Suites";
			}
		} else {
			return "Complete todos los datos";
		}
	}

	@Override
	public String eliminar(int id) {
		boolean bandera = false;
		int conPos = 0;
		for (Suite elimSui : MemoriaBDD.suites) {
			if (elimSui != null && elimSui.getNumHabitacion() == id) {
				bandera = true;
				break;
			}
			conPos++;
		}
		if (bandera) {
			MemoriaBDD.suites[conPos] = null;
			return "Suite ELIMINADA";
		} else {
			return "No se encontró el número de la Suite";
		}
	}

	@Override
	public String actualizar(int id, Object registro) {
		boolean bandera = false;
		int conPos = 0;
		for (Suite actSu : MemoriaBDD.suites) {
			if (actSu != null && actSu.getNumHabitacion() == id) {
				bandera = true;
				break;
			}
			conPos++;
		}
		if (bandera) {
			MemoriaBDD.suites[conPos] = (Suite) registro;
			return "Suite Actualizada";
		} else {
			return "No se encontró el Número de la Suite";
		}
	}

	@Override
	public Object[] listar() {
		return MemoriaBDD.suites;
	}

	@Override
	public Object consultarConId(int id) {
		boolean bandera = false;
		int conPos = 0;
		for (Suite busSuite : MemoriaBDD.suites) {
			if (busSuite != null && busSuite.getNumHabitacion() == id) {
				bandera = true;
				break;
			}
			conPos++;
		}
		if (bandera) {
			return MemoriaBDD.suites[conPos];
		} else {
			return null;
		}
	}

}
