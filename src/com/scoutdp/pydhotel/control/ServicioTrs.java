/**
 * 
 */
package com.scoutdp.pydhotel.control;

import java.util.List;

import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Servicio;

/**
 * Clase que implementa los procesos CRUD con coleciones
 * 
 * @version 8.0 15 mar 2019
 * @author Erick Díaz
 */
public class ServicioTrs implements ICrudC {

	@Override
	public String guardar(Object registro) {
		Servicio servN = (Servicio) registro;
		for (Servicio servV : MemoriaBDD.servicios) {
			if (servN.equals(servV)) {
				return "Ya Existe Un Servicio Con Esos Parámetros";
			}
		}
		if (registro != null) {
			MemoriaBDD.servicios.add((Servicio) registro);
			return "Guardado Correctamente";
		} else {
			return "Complete todos los Campos";
		}
	}

	@Override
	public String eliminar(Object registro) {
		int posicionObj = MemoriaBDD.servicios.indexOf(registro);
		if (posicionObj >= 0) {
			MemoriaBDD.servicios.remove(posicionObj);
			return "Eliminado Correctamente";
		} else {
			return "No se encontró el Registro a eliminar";
		}
	}

	@Override
	public String actualizar(Object registro) {
		String mensaje = null;
		int contador = 0;
		Servicio servicioN = (Servicio) registro;
		for (Servicio buscarId : MemoriaBDD.servicios) {
			if (buscarId.getIdSv() == servicioN.getIdSv()) {
				MemoriaBDD.servicios.set(contador, servicioN);
				mensaje = "Servicio Actualizado Correctamente";
				break;
			}
			contador++;
		}
		return mensaje;
	}

	@Override
	public List<?> listar() {
		return MemoriaBDD.servicios;
	}

	@Override
	public Object consultar(int id) throws MiExcepcion {
		boolean paso = false;
		int contador = 0;
		for (Servicio buscarId : MemoriaBDD.servicios) {
			if (buscarId.getIdSv() == id) {
				paso = true;
				break;
			}
			contador++;
		}
		if (paso) {
			return MemoriaBDD.servicios.get(contador);
		} else {
			throw new MiExcepcion();
		}
	}

}
