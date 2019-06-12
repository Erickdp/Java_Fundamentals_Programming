/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import java.math.BigDecimal;

import com.scoutdp.pydhotel.control.MiExcepcion;
import com.scoutdp.pydhotel.control.ServicioTrs;
import com.scoutdp.pydhotel.control.TipoServicioTrs;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Servicio;
import com.scoutdp.pydhotel.modelo.TipoServicio;
import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa los servicios que se pueden Usar
 * 
 * @version 8.0 28 feb 2019
 * @author Erick Díaz
 */
public class FrmServicios {

	TipoServicioTrs tipoServicioTrs = new TipoServicioTrs();
	ServicioTrs servicioTrs = new ServicioTrs();

	private int idSv;
	private int tenerTSv;
	private String nombreSv;
	private String descrSv;
	private BigDecimal precioSv;
	private TipoServicio tipoSv;

	public FrmServicios() {
		abrirMenuDeServicios();
	}

	private void abrirMenuDeServicios() {
		int opcion = 0;
		do {
			try {
				System.out.println("");
				System.out.println("  * * *     »- * * * *(¯` SERVICIOS ´¯)* * * * -»    * * *    ");
				System.out.println(">--------  1. LISTAR                                 --------< ");
				System.out.println(">--------  2. AGREGAR                                --------< ");
				System.out.println(">--------  3. ACTUALIZAR                            --------< ");
				System.out.println(">--------  4. CONSULTAR                            --------< ");
				System.out.println(">--------  5. ELIMINAR                              --------< ");
				System.out.println("6. REGRESAR                       --------------------------< ");
				System.out.println("");
				opcion = Integer.parseInt(UtilLectura.leerTeclado());
				switch (opcion) {
				case 1:
					System.out.println("TIPOS DE SERVICIOS EXISTENTES\n");
					for (Object iterador1 : MemoriaBDD.tipoServicio) {
						System.out.println(iterador1);
					}
					System.out.println("\nServicios Existentes\n");
					for (Object iterador : servicioTrs.listar()) {
						System.out.println(iterador);
					}
					break;

				case 2:
					System.out.println("Para Utilizar Los Servicios Ingrese:");
					System.out.println("1. ID Del Producto");
					idSv = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("2. Nombre Del Servicio");
					nombreSv = UtilLectura.leerTeclado();
					System.out.println("3. Descripción Corta");
					descrSv = UtilLectura.leerTeclado();
					System.out.println("4. Precio Del Servicio");
					precioSv = new BigDecimal(UtilLectura.leerTeclado());
					System.out.println(tipoServicioTrs.imprimirListaFormateada());
					System.out.println("\n Ingrese Al Tipo De Producto que pertenece ");
					tenerTSv = Integer.parseInt(UtilLectura.leerTeclado());
					try {
						tipoSv = (TipoServicio) tipoServicioTrs.consultar(tenerTSv);
						Servicio nuevoSv = new Servicio(idSv, descrSv, nombreSv, precioSv, tipoSv);
						System.out.println(servicioTrs.guardar(nuevoSv));
					} catch (MiExcepcion e) {
						System.err.println("No se contró El Tipo De Servicio Digaitado");
					}
					break;

				case 3:
					System.out.println("Para Actualizar un Servicio Ingrese EL ID de servicio");
					idSv = Integer.parseInt(UtilLectura.leerTeclado());
					try {
						servicioTrs.consultar(idSv);
						System.out.println("1. Nombre Del Servicio");
						nombreSv = UtilLectura.leerTeclado();
						System.out.println("2. Descripción Corta");
						descrSv = UtilLectura.leerTeclado();
						System.out.println("5. Precio Del Servicio");
						precioSv = new BigDecimal(UtilLectura.leerTeclado());
						System.out.println(tipoServicioTrs.imprimirListaFormateada());
						System.out.println("\n Ingrese el Nuevo Tipo De Producto al que pertenece ");
						tenerTSv = Integer.parseInt(UtilLectura.leerTeclado());
						try {
							tipoSv = (TipoServicio) tipoServicioTrs.consultar(tenerTSv);
							Servicio nuevoSv = new Servicio(idSv, descrSv, nombreSv, precioSv, tipoSv);
							System.out.println(servicioTrs.actualizar(nuevoSv));
						} catch (MiExcepcion e) {
							System.err.println("No se contró El Tipo De Servicio Digitado");
						}
					} catch (MiExcepcion e) {
						System.err.println("No se Encontró El Servicio A Actualizar");
					}
					break;
				
				case 4:
					System.out.println("Ingrese El ID del Servicio que desea Consultar");
					try {
						idSv = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("El Servicio Consultado Es : " + servicioTrs.consultar(idSv));
					} catch (Exception e) {
						System.err.println("No se encontró el Servicio Solicitado");
					}
					break;
				
				case 5:
					System.out.println("\nServicios Existentes\n");
					for (Object iterador : servicioTrs.listar()) {
						System.out.println(iterador);
					}
					System.out.println("\nIngese el ID del Servicio a Eliminar");
					idSv = Integer.parseInt(UtilLectura.leerTeclado());
					try {
						Servicio servicioE = (Servicio) servicioTrs.consultar(idSv);
						System.out.println(servicioTrs.eliminar(servicioE));
					} catch (Exception e) {
						System.err.println("No se Encontró el ID del Servicio A eliminar");
					}
					break;
					
				case 6:
					FrmPrincipal frmPrincipal = new FrmPrincipal();
					break;

				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println(
						"Por Favor, Para ingresar a un Menú Digite su número \nno escriba Letras/Palabras/Símbolos, "
								+ "\nEn caso donde se pida ingresar un número No escriba decimales. Vuelva a Intentar");
			}
		} while (opcion != 6);

	}

}
