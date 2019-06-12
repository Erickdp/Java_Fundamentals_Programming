/**
 * 
 */
package com.scoutdp.pydhotel.control;

import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Socio;

/**
 * Clase que implementa las operaciones CRUD.
 * 
 * @version 8.0 9 mar 2019
 * @author Erick Díaz
 */
public class ClienteTrs implements ICrud {
	/*
	 * Método para validar un Cliente a través de su clave de tarjeta se debe de
	 * tener un objeto de tipo Cliente el cual guarde el nombre ya ingresado o
	 * correo y la clave de tarjeta
	 */
	public Socio validarCliente(String ingreso, String clave) {
		Socio clienteEn = null;
		// Uso de For - each para iterar en toda la estructura
		for (Socio busqueda2 : MemoriaBDD.clientes) {
			if (busqueda2 != null && (busqueda2.getPaseVip().equals(clave)
					&& (busqueda2.getNombreUsu().equals(ingreso) || busqueda2.getCorreoUsu().equals(ingreso)))) {
				clienteEn = busqueda2;
				break;
			}
		}
		return clienteEn;
	}

	@Override
	public String guardar(Object registro) {
		boolean band = false;
		for (int i = 0; i < MemoriaBDD.clientes.length; i++) {
			if (MemoriaBDD.clientes[i] == null) {
				MemoriaBDD.clientes[i] = (Socio) registro;
				band = true;
				break;
			}
		}
		if (band) {
			return "V.I.P Guardado Correctamente";
		} else {
			return "En la versión demo solo se pueden agregar hasta 3 Clientes";
		}
	}

	@Override
	public String eliminar(int id) {
		boolean band = false;
		int contador = 0;
		for (Socio elimCli : MemoriaBDD.clientes) {
			if (elimCli != null && elimCli.getIdUsu() == id) {
				band = true;
				break;
			}
			contador++;
		}
		if (band) {
			MemoriaBDD.clientes[contador] = null;
			return "Cliente Eliminado Correctamente";
		} else {
			return "No se encontró el ID del cliente";
		}
	}

	@Override
	public String actualizar(int id, Object registro) {
		boolean band = false;
		int posEnc = 0;
		if (id != 0) {
			for (Socio busCli : MemoriaBDD.clientes) {
				if (busCli != null && busCli.getIdUsu() == id) {
					band = true;
					break;
				}
				posEnc++;
			}
		}
		if (band) {
			MemoriaBDD.clientes[posEnc] = (Socio) registro;
			return "Cliente Actualizado";
		} else {
			return "Cliente No Actualizado";
		}
	}

	@Override
	public Object[] listar() {
		return MemoriaBDD.clientes;
	}

	@Override
	public Object consultarConId(int id) {
		boolean bandera = false;
		int contPos = 0;
		for (Socio busIdCli : MemoriaBDD.clientes) {
			if (busIdCli != null && busIdCli.getIdUsu() == id) {
				bandera = true;
				break;
			}
			contPos++;
		}
		if (bandera) {
			return MemoriaBDD.clientes[contPos];
		} else {
			return null;
		}
	}

}
