/**
 * 
 */
package com.scoutdp.pydhotel.control;

/**
 * 
 * Tipo de clase que representa el contrato de negocio para las operaciones de
 * la bdd
 * 
 * @version 8.0 1 mar 2019
 * @author Erick Díaz
 *
 *         <a href="www.matoosfe.com">Soporte</a>
 */
public interface ICrud {
	public String guardar(Object registro);

	public String eliminar(int id);

	public String actualizar(int id, Object registro);

	public Object[] listar();

	public Object consultarConId(int id) throws MiExcepcion2;

}
