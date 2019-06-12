/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import com.scoutdp.pydhotel.control.MiExcepcion;
import com.scoutdp.pydhotel.control.TipoServicioTrs;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.TipoServicio;
import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa los Tipos De Servicios A Agregar
 * 
 * @version 8.0 15 mar 2019
 * @author Erick Díaz
 */
public class FrmTipoServicio {

	private int idTSv;
	private String nombreTSv;
	private String descripcionTSV;
	TipoServicio nuevoTServicio;
	private boolean salir = false;

	TipoServicioTrs tipoServicioTrs = new TipoServicioTrs();

	public FrmTipoServicio() {
		crearMenuDeTipoDeServicios();
	}

	private void crearMenuDeTipoDeServicios() {

		int opcion = 0;
		if (FrmLogin.clienteVip != null) {
			do {
				System.out.println("\n  * * *     »- * * * *(¯` TIPO DE SERVICIOS ´¯)* * * * -»    * * *    ");
				System.out.println(">--------  1. LISTAR                                          --------< ");
				System.out.println(">--------  2. AGREGAR                                         --------< ");
				System.out.println(">--------  3. ACTUALIZAR                                      --------< ");
				System.out.println(">--------  4. CONSULTAR                                       --------< ");
				System.out.println(">--------  5. ELIMINAR                                        --------< ");
				System.out.println("6. REGRESAR                       ------------------------------------<\n");
				try {
					opcion = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("- Digite El Número Del Menú");
				}
				switch (opcion) {
				case 1:
					opcion = 0;
					for (TipoServicio tipoServicio : MemoriaBDD.tipoServicio) {
						System.out.println(tipoServicio);
					}
					break;

				case 2:
					opcion = 0;
					System.out.println("Para Agregar Tipos De Servicios Ingrese");
					System.out.println("1. ID para El Tipo De Servicio");
					try {
						idTSv = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("2. Nombre Del Tipo De Servicio");
						nombreTSv = UtilLectura.leerTeclado();
						System.out.println("3. Descripción del Tipo De Servicio");
						descripcionTSV = UtilLectura.leerTeclado();
						nuevoTServicio = new TipoServicio();
						nuevoTServicio.setIdTipoSv(idTSv);
						nuevoTServicio.setNombreTipoSv(nombreTSv);
						nuevoTServicio.setDescripcionTipoSv(descripcionTSV);
						System.out.println(tipoServicioTrs.guardar(nuevoTServicio));
					} catch (NumberFormatException e) {
						System.err.println("- - - Ingrese Un Número Valido - - - ");
					} catch (MiExcepcion e) {
						System.err.println("Ya Existe Un Tipo De producto Similiar Ingrese Otro");
					}
					break;

				case 3:
					opcion = 0;
					System.out.println("Para Actualizar Los Tipos de Servicio Ingrese su ID");
					try {
						idTSv = Integer.parseInt(UtilLectura.leerTeclado());
						tipoServicioTrs.consultar(idTSv);
						System.out.println("Ingrese Un Nuevo Nombre Para el Tipo de Servicio");
						nombreTSv = UtilLectura.leerTeclado();
						System.out.println("Ingrese Una Nueva Descripción Para el Tipo de Servicio");
						descripcionTSV = UtilLectura.leerTeclado();
						nuevoTServicio = new TipoServicio(idTSv, nombreTSv, descripcionTSV);
						System.out.println(tipoServicioTrs.actualizar(nuevoTServicio));
					} catch (MiExcepcion e) {
						System.err.println("No se contró el Tipo De Servicio A Actualizar");
					} catch (NumberFormatException e1) {
						System.err.println("- - - No a Ingresado Un Número Entero - - -");
					}
					break;

				case 4:
					opcion = 0;
					System.out.println("- - - Para Cosnultar Un Tipo De Servicio Ingrese Su ID - - -");
					try {
					   idTSv = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println(tipoServicioTrs.consultar(idTSv));
					} catch (MiExcepcion e) {
						System.err.println("No Existe El Tipo De Servicio Que Buscaba");
					} catch (NumberFormatException e1) {
						System.err.println("- - - No a Ingresado Un Número Entero - - -");
					}
					break;

				case 5:
					opcion = 0;
					System.out.println(tipoServicioTrs.imprimirListaFormateada());
					System.out.println("\n¿Cúal Tipo de Servicio Desea Eliminar? Ingrese Su ID");
					try {
						idTSv = Integer.parseInt(UtilLectura.leerTeclado());
						TipoServicio servicioE = (TipoServicio) tipoServicioTrs.consultar(idTSv);
						System.out.println(tipoServicioTrs.eliminar(servicioE));
					} catch (MiExcepcion e) {
						System.err.println("No Existe ese tipo De Servicio");
					} catch (NumberFormatException e1) {
						System.err.println("- - - No a Ingresado Un Número Entero - - -");
					}
					break;

				case 6:
					opcion = 0;
					FrmPrincipal frmPrincipal = new FrmPrincipal();
					salir = true;
					break;

				default:
					System.err.println("- - - Opción Incorrecta - - -");
					break;
				}
			} while (!salir);
		} else {
			System.err.println("Solo Miembros V.I.P pueden acceder a este Menú");
			FrmPrincipal frmPrincipal = new FrmPrincipal();
		}

	}
}
