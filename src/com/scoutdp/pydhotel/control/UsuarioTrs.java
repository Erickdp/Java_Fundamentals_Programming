/**
 * 
 */
package com.scoutdp.pydhotel.control;

import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Socio;
import com.scoutdp.pydhotel.modelo.Usuario;

/**
 * Clase que validará el usuario y contraseña ingresador en la clase FrmLogin
 * 
 * @version 8.0 28 feb 2019
 * @author Erick Díaz
 */
public class UsuarioTrs implements ICrud {
	/**
	 * Método para validar un usuario a través de su nombre o correo de usuario y
	 * clave
	 * 
	 * @param usuario nombre del usuario
	 * @param clave   nombre de la clave
	 * @return
	 */
	public Usuario validarUsuario(String ingreso, String clave) {
		Usuario usuarioRec = null;
		// Uso de For - each para iterar en toda la estructura
		for (Usuario busqueda : MemoriaBDD.usuarios) {
			// EN LA CLASE DE ESTRUCTURA DE DATOS BUSCARÁ AL USUARIO Y CLAVE
			if (busqueda != null && (busqueda.getClaveUsu().equals(clave)
					&& (busqueda.getNombreUsu().equals(ingreso) || busqueda.getCorreoUsu().equals(ingreso)))) {
				usuarioRec = busqueda;
				break;
			}
		}
		return usuarioRec;
	}

	@Override
	public String guardar(Object registro) {
		boolean band = false;
		if (registro != null) {
			for (int i = 0; i < MemoriaBDD.usuarios.length; i++) {
				if (MemoriaBDD.usuarios[i] == null) {
					MemoriaBDD.usuarios[i] = (Usuario) registro;
					band = true;
					break;
				}
			}
			if (band) {
				return "Usuario Nuevo Agregado";
			} else {
				return "En la versión demo solo se pueden agregar hasta 3 Usuarios";
			}
		} else {
			return "Debe llenar todos los Datos";
		}
	}

	@Override
	public String eliminar(int id) {
		boolean band = false;
		boolean band2 = false;
		int conPos = 0;
		int conPos2 = 0;
		for (Usuario elimUsu : MemoriaBDD.usuarios) {
			if (elimUsu != null && elimUsu.getIdUsu() == id) {
				band = true;
				break;
			}
			conPos++;
		}
		if (band) { // Si encuentra al Usuario empieza a buscar si tiene membresía
			for (Socio elimCliente : MemoriaBDD.clientes) {
				if (elimCliente != null && elimCliente.getIdUsu() == id) {
					band2 = true;
					break;
				}
				conPos2++;
			}
		}
		if (band && band2) {
			MemoriaBDD.usuarios[conPos] = null;
			MemoriaBDD.clientes[conPos2] = null;
			return "Usuario y Cliente Eliminados";
		} else if (band) {
			MemoriaBDD.usuarios[conPos] = null;
			return "Usuario Eliminado";
		} else {
			return "No se encontró ID del Usuario";
		}
	}

	@Override
	public String actualizar(int id, Object registro) {
		boolean band = false;
		int posEnc = 0;
		for (Usuario busUsu : MemoriaBDD.usuarios) {
			if (busUsu != null && busUsu.getIdUsu() == id) {
				band = true;
				break;
			}
			posEnc++;
		}
		if (band) {
			MemoriaBDD.usuarios[posEnc] = (Usuario) registro;
			return "Usuario Actualizado";
		} else {
			return "No se encontró el ID del Usuario a Actualizar";
		}

	}

	@Override
	public Object[] listar() {
		return MemoriaBDD.usuarios;
	}

	@Override
	public Object consultarConId(int id) {
		boolean bander = false;
		int     contPos = 0;
		for (Usuario busIdUsu : MemoriaBDD.usuarios) {
			if (busIdUsu != null && busIdUsu.getIdUsu() == id) {
				bander = true;
				break;
			}
			contPos++;
		}
		if (bander) {
			return MemoriaBDD.usuarios[contPos];
		} else {
		return null;
		}
	}
}
