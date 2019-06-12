/**
 * 
 */
package com.scoutdp.pydhotel.control;

import java.util.List;

/**
 *  Clase que representa la utilización de interface con las operaciones CRUD
 * 
 *  @version    8.0 15 mar 2019
 *  @author     Erick Díaz
 */
public interface ICrudC {

	/**
	 * Método que permite guardad Objetos
	 * @param registro
	 * @return
	 */
	public String guardar(Object registro) throws MiExcepcion;
	
	/**
	 * Método que permite eliminar objetos
	 * @param registro
	 * @return
	 */
	public String eliminar(Object registro) throws MiExcepcion;
	
	/**
	 * Método que permite actualizar Objetos
	 * @param registro
	 * @return
	 */
	public String actualizar(Object registro);
	
	/**
	 * Método que permite listar
	 * @return
	 */
	public List<?> listar();
	
	/**
	 * Método que permite consultar con id
	 * @throws MiExcepcion 
	 */
	
	public Object consultar(int id) throws MiExcepcion;
}
