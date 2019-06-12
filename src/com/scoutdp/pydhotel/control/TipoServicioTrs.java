/**
 * 
 */
package com.scoutdp.pydhotel.control;

import java.util.List;

import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.TipoServicio;

/**
 * Clase que implementa las Opreaciones CRUD con coleciones
 * 
 * @version 8.0 15 mar 2019
 * @author Erick Díaz
 */
public class TipoServicioTrs implements ICrudC {

	@Override
	public String guardar(Object registro) throws MiExcepcion {
		boolean paso = false;
		for (TipoServicio buscarOtro : MemoriaBDD.tipoServicio) {
			if (buscarOtro.equals(registro)) {
				paso = true;
				break;
			}
		}
		if (!paso) {
			MemoriaBDD.tipoServicio.add((TipoServicio) registro);
			return "Guardado Correctamente";
		} else {
			throw new MiExcepcion();
		}
	}

	@Override
	public String eliminar(Object registro) throws MiExcepcion{
		int posicion = MemoriaBDD.tipoServicio.indexOf(registro);
		if (posicion >= 0) {
			MemoriaBDD.tipoServicio.remove(posicion);
			return "Tipo De Servicio Eliminado Correctamente";
		} else {
			throw new MiExcepcion();
		}
	}

	@Override
	public String actualizar(Object registro) {
		String mensaje = null;
		TipoServicio servicioN = (TipoServicio) registro;
		for (TipoServicio buscarId : MemoriaBDD.tipoServicio) {
			if (buscarId.getIdTipoSv() == servicioN.getIdTipoSv()) {
				MemoriaBDD.tipoServicio.set(buscarId.getIdTipoSv(), servicioN);
				mensaje = "Tipo De Servicio Actualizado Correcatmente";
				break;
			}
		}
		return mensaje;
	}

	@Override
	public List<?> listar() {
		return MemoriaBDD.tipoServicio;
	}

	@Override
	public Object consultar(int id) throws MiExcepcion {
		boolean paso = false;
		for (TipoServicio buscarId : MemoriaBDD.tipoServicio) {
			if (buscarId.getIdTipoSv() == id) {
				paso = true;
				break;
			}
		}
		if (!paso) {
			throw new MiExcepcion();
		} else {
			return MemoriaBDD.tipoServicio.get(id);
		}
	}

	public String imprimirListaFormateada() {
		StringBuilder strBld = new StringBuilder();
		for (TipoServicio tipoSv : MemoriaBDD.tipoServicio) {
			if (tipoSv != null) {
				strBld.append(tipoSv.getIdTipoSv()).append(". [").append(tipoSv.getNombreTipoSv()).append("] ");
			}
		}
		return strBld.toString();
	}
}
