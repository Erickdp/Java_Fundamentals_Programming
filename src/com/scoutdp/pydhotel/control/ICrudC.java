/**
 * 
 */
package com.scoutdp.pydhotel.control;

import java.util.List;

/**
 *  Clase que representa la utilizaci�n de interface con las operaciones CRUD
 * 
 *  @version    8.0 15 mar 2019
 *  @author     Erick D�az
 */
public interface ICrudC {

	/**
	 * M�todo que permite guardad Objetos
	 * @param registro
	 * @return
	 */
	public String guardar(Object registro) throws MiExcepcion;
	
	/**
	 * M�todo que permite eliminar objetos
	 * @param registro
	 * @return
	 */
	public String eliminar(Object registro) throws MiExcepcion;
	
	/**
	 * M�todo que permite actualizar Objetos
	 * @param registro
	 * @return
	 */
	public String actualizar(Object registro);
	
	/**
	 * M�todo que permite listar
	 * @return
	 */
	public List<?> listar();
	
	/**
	 * M�todo que permite consultar con id
	 * @throws MiExcepcion 
	 */
	
	public Object consultar(int id) throws MiExcepcion;
}
