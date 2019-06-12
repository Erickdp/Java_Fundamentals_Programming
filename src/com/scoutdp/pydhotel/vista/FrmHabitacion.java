/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.scoutdp.pydhotel.control.HabitacionTrs;
import com.scoutdp.pydhotel.control.MiExcepcion;
import com.scoutdp.pydhotel.control.MiExcepcion2;
import com.scoutdp.pydhotel.control.SuiteTrs;
import com.scoutdp.pydhotel.modelo.Habitacion;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Suite;
import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa el formulario de la habitación (Terminada)
 * 
 * @version 8.0 28 feb 2019
 * @author Erick Díaz
 */
public class FrmHabitacion {

	/*
	 * Instanciación la cuál permite hacer uso de la clase que implementa la
	 * interfaz CRUD
	 */
	HabitacionTrs habitacionTrs = new HabitacionTrs();
	SuiteTrs suiteTrs = new SuiteTrs();
	public static Suite suite;
	public static Habitacion habitacion;
	/*
	 * Declaración de Array el cual sea el encargado de guardar el método de listar
	 * para luego ser recorrido con un array
	 */
	Object[] listarHabitacion;
	Object mostrarHbS;

	private int dormitorios; // Variable que obtendrá el número de dormitorios
	private int banos; // Variable que obtendrá el número de baños
	private int opcion2 = 0; // Variable para ingresar a nuevas opciones dentro del formulario
	private int numAct; // Variable que permitirá obtener el N° de Habitacon/Suite a Actualizar
	private int numCons; // Variable que permitirá obtener el N° de Habitacon/Suite a Consultar
	private String cama; // Variable que obtendrá el tamaño de la cama
	private String cocina; // Variable que obtendrá el tamaño de la cocina
	private String tv; // Variable que obtendrá el tamaño de la TV
	private String mensaje; // Variable que ayudará a devolver un mensaje en consola
	private boolean bandera = true; // boleano que ayudará a realizar banderas
	private Date fecha = new Date(); // INSTANCIACIÓN DE UN OBJETO DE TIPO DATE -> (DEPRECATED)
	private SimpleDateFormat resetearFecha = new SimpleDateFormat("yyyy-MM-dd");
	private boolean salir = false;

	public FrmHabitacion() {
		abrirMenuDeOpcion();
	}

	private void abrirMenuDeOpcion() {
		do {
			System.out.println("");
			System.out.println("            »--------(¯` HABITACIÓN ´¯)--------»              ");
			System.out.println(">--------  1. LISTAR                                --------< ");
			System.out.println(">--------  2. AGREGAR HABITACIÓN PERSONALIZADA      --------< ");
			System.out.println(">--------  3. AGREGAR SUITE PERSONALIZADA (SOLO V.I.P)  --------< ");
			System.out.println(">--------  4. ACTUALIZAR                            --------< ");
			System.out.println(">--------  5. CONSULTAR                             --------< ");
			System.out.println(">--------  6. ELIMINAR                              --------< ");
			System.out.println("7. REGRESAR --------------------------< ");
			// Se elegirá una opcion por teclado
			int opcion = 0;
			try {
				opcion = Integer.parseInt(UtilLectura.leerTeclado());
			} catch (NumberFormatException e) {
				System.err.println("Por favor para ingresar a los Menús solo Digite sus Números.");
			}
			switch (opcion) {
			case 1:
				System.out.println("**¿QUIERE LISTAR LAS HABITACIONES O SUITES?**");
				System.out.println(">>Digite 1. Habitaciones 2. Suites<<");
				System.out.println(">>Listar:");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitaciones 2. Suites.");
				}
				System.out.println("\n"); // Salto de línea
				if (opcion2 == 1) {
					listarHabitacion = habitacionTrs.listar(); // Llamada al método de la clase habitacionTrs el cuál
																// devuelve un array de Object
					for (Object listar : listarHabitacion) { // For - each que recorrerá el array de Objetos de Tipo
																// Habitación
						if (listar != null) { // Ayudará a dar una mejor imágen al array Null
							System.out.println(listar);
						} else {
							System.out.println("SIN RESERVA");
						}
					}
				} else if (opcion2 == 2) {
					listarHabitacion = suiteTrs.listar();
					for (Object listar : listarHabitacion) { // For - each que recorrerá el array de Objetos de Tipo
																// Suite
						if (listar != null) {
							System.out.println(listar);
						} else {
							System.out.println("SIN RESERVA");
						}
					}
				} else {
					System.err.println("A DIGITADO MAL.");
					break;
				}
				break;

			case 2:
				// 1. Recuperar valores
				System.out.println("Para Personalizar la habitación; Ingrese: ");
				System.out.println("Número de Dormitorios");
				try {
					dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("Número de Baños");
					banos = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("Tamaño de la cama");
					cama = UtilLectura.leerTeclado();
					System.out.println("Tamaño de la Tv");
					tv = UtilLectura.leerTeclado();
					System.out.println("Quiere que tenga cocina?");
					cocina = UtilLectura.leerTeclado();
					// 2. Crear Un registro (Objeto de tipo Habitacion)
					habitacion = new Habitacion(); // Se puede realizar esto con los sets o crear un objeto que guarde
													// todos
													// estos atributos
					habitacion.setNumeroDormi(dormitorios);
					habitacion.setNumeroBano(banos);
					habitacion.setTamanoCama(cama);
					habitacion.setTamanoTv(tv);
					habitacion.setTenerCocina(cocina);
					// 3. Llamar al controlador
					mensaje = habitacionTrs.guardar(habitacion);
					// 4. Procesar la información
					System.out.println(mensaje);
				} catch (NumberFormatException e) {
					System.err.println("Solamente Puede Agregar Número Enteros En los apartados que piden 'Cuantos'.");
				}
				break;

			case 3:
				if (FrmLogin.clienteVip != null) { // Permite que solo Socios Puedan acceder a este apartado
					// 1. Recuperar valores
					try {
						System.out.println("Para Personalizar la Suite, Ingrese: ");
						System.out.println("Número de Dormitorios");
						dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("Número de Baños");
						banos = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("Tamaño de la cama");
						cama = UtilLectura.leerTeclado();
						System.out.println("Tamaño de la Tv");
						tv = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga cocina?");
						cocina = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga una sala?");
						String sala = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga gimnasio?");
						String gym = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga Balcón?");
						String bal = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga Aire Acondicionado");
						String aa = UtilLectura.leerTeclado();
						// 2. Crear un registro (Objeto de tipo Suite)
						suite = new Suite();
						suite.setNumeroDormi(dormitorios);
						suite.setNumeroBano(banos);
						suite.setTamanoCama(cama);
						suite.setTenerCocina(cocina);
						suite.setTamanoTv(tv);
						suite.setSala(sala);
						suite.setGym(gym);
						suite.setAireAcon(aa);
						suite.setBal(bal);
						// 3. Llamar al controlador
						mensaje = suiteTrs.guardar(suite);
						// 4. Procesar la información
						System.out.println(mensaje);
					} catch (NumberFormatException e) {
						System.err.println(
								"Solamente Puede Agregar Número Enteros En los apartados que piden 'Cuantos'.");
					}
				} else {
					System.err.println("Solo Usuarios V.I.P pueden Personalizar Suites");
					break;
				}
				break;

			case 4:
				System.out.println("¿DESEA ACTUALIZAR UNA HABITACIÓN O SUITE?");
				System.out.println("1. Habitación");
				System.out.println("2. Suite");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitación 2. Suite.");
				}
				if (opcion2 == 1) {
					listarHabitacion = habitacionTrs.listar();
					for (Object lisHab : MemoriaBDD.habitaciones) { // Listar Habitaciones
						System.out.println(lisHab);
					}
					System.out.println(" - - -Ingrese el Número de Habitación que desea Actualizar.- - -");
					try {
						numAct = Integer.parseInt(UtilLectura.leerTeclado());
						habitacionTrs.consultarConId(numAct);
						// 1. Recuperar valores
						System.out.println("Para Personalizar la habitación; Ingrese: ");
						System.out.println("Número de Dormitorios");
						dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("Número de Baños");
						banos = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("Tamaño de la cama");
						cama = UtilLectura.leerTeclado();
						System.out.println("Tamaño de la Tv");
						tv = UtilLectura.leerTeclado();
						System.out.println("Quiere que tenga cocina?");
						cocina = UtilLectura.leerTeclado();
						// 2. Crear Un registro (Objeto de tipo Habitacion)
						habitacion = new Habitacion();
						habitacion.setNumeroDormi(dormitorios);
						habitacion.setNumeroBano(banos);
						habitacion.setTamanoCama(cama);
						habitacion.setTamanoTv(tv);
						habitacion.setTenerCocina(cocina);
						// 3. Llamar al controlador
						mensaje = habitacionTrs.actualizar(numAct, habitacion);
						// 4. Procesar la información
						System.out.println(mensaje);
					} catch (MiExcepcion2 e) {
						System.err.println("No se encontró el Número de La Habitación");
					} catch (NumberFormatException e1) {
						System.err.println("Solo Debe Ingresar Un Número (Entero que Tenga La Habitación)");
					}
				} else if (opcion2 == 2) {
					/*
					 * Si esque el Usuario que inicio sesión no es V.I.P no necesitará acceder a
					 * este apartado desde su ejecución
					 */
					if (FrmLogin.clienteVip != null) {
						listarHabitacion = suiteTrs.listar();
						for (Object lisSu : MemoriaBDD.suites) {
							System.out.println(lisSu);
						}
						System.out.println("Ingrese el N° De La Suite");
						try {
							numAct = Integer.parseInt(UtilLectura.leerTeclado());
							habitacionTrs.consultarConId(numAct);
							// 1. Recuperar valores
							/*
							 * Se válida en la clase FrmHabitacion del paquete Vista (se puede hacer en la
							 * clase HabitacionTrs) si esque el número de la habitación existe o no
							 */
							System.out.println("Para Personalizar la Suite, Ingrese: ");
							System.out.println("Número de Dormitorios");
							dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println("Número de Baños");
							banos = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println("Tamaño de la cama");
							cama = UtilLectura.leerTeclado();
							System.out.println("Tamaño de la Tv");
							tv = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga cocina?");
							cocina = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga una sala?");
							String sala = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga gimnasio?");
							String gym = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga Balcón)");
							String bal = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga Aire Acondicionado");
							String aa = UtilLectura.leerTeclado();
							// 2. Crear un registro (Objeto de tipo Suite)
							suite = new Suite();
							suite.setNumeroDormi(dormitorios);
							suite.setNumeroBano(banos);
							suite.setTamanoCama(cama);
							suite.setTenerCocina(cocina);
							suite.setSala(sala);
							suite.setGym(gym);
							suite.setAireAcon(aa);
							suite.setBal(bal);
							// 3. Llamar al controlador
							mensaje = suiteTrs.actualizar(numAct, suite);
							// 4. Procesar la información
							System.out.println(mensaje);
						} catch (MiExcepcion2 e) {
							System.err.println("No se encontró el Número de La Suite");
						} catch (NumberFormatException e1) {
							System.err.println("Solo Debe Ingresar Un Número (Entero que Tenga La Suite)");
						}
					} else {
						System.err.println("No Existen Suites a Actualizar");
					}
				} else {
					System.err.println("- - - A DIGITADO MAL - - -");
				}
				break;

			case 5:
				System.out.println("");
				System.out.println("¿Desea Consultar Una Habitación O Suite?");
				System.out.println("1. Habitación");
				System.out.println("2. Suite");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitación 2. Suite.");
				}
				if (opcion2 == 1) {
					System.out.println("Ingrese el N° De la Habitación");
					try {
						numCons = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("");
						mostrarHbS = habitacionTrs.consultarConId(numCons);
						System.out.println(
								"El Estado de La Habitación En [" + resetearFecha.format(fecha) + "] Es " + mostrarHbS);
					} catch (MiExcepcion2 e) {
						System.err.println("No Se Encontró El Número De La Habitación!!");
					} catch (NumberFormatException e1) {
						System.err.println("Solo Ingrese Un Número Entero (Número De Habitación)");
					}
				} else if (opcion2 == 2) {
					if (FrmLogin.clienteVip != null) {
						try {
							System.out.println("Ingrese el N° De la Suite");
							numCons = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println("");
							mostrarHbS = habitacionTrs.consultarConId(numCons);
							System.out.println("El Estado de La Habitación En [" + resetearFecha.format(fecha) + "] Es "
									+ mostrarHbS);
						} catch (MiExcepcion2 e) {
							System.err.println("No Se Encontró El Número De La Suite!!");
						} catch (NumberFormatException e1) {
							System.err.println("Solo Ingrese Un Número Entero (Número De Suite)");
						}
					} else {
						System.err.println("No Existen Suites A consultar");
					}
				} else {
					System.err.println(" - - -A Digitado Mal- - -");
				}
				break;

			case 6:
				System.out.println("");
				System.out.println("¿DESEA ELIMINAR SUITE O HABITACION?");
				System.out.println("1. Habitación");
				System.out.println("2. Suite");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitación 2. Suite.");
				}
				if (opcion2 == 1) {
					System.out.println("");
					listarHabitacion = habitacionTrs.listar();
					for (Object it : listarHabitacion) {
						System.out.println(it);
					}
					System.out.println("");
					System.out.println("¿Qué número de Habitación desea eliminar?");
					try {
						opcion = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println(suiteTrs.eliminar(opcion));
					} catch (NumberFormatException e) {
						System.err.println("Solo Ingrese Un Número Entero (Número De Habitación)");
					}
				} else if (opcion2 == 2) {
					/*
					 * Solo Miembros VIP pueden modificar eliminar y agregar Suites
					 */
					if (FrmLogin.clienteVip != null) {
						System.out.println("");
						listarHabitacion = suiteTrs.listar();
						for (Object it : listarHabitacion) {
							System.out.println(it);
						}
						System.out.println("");
						System.out.println("¿Qué número de Suite desea eliminar?");
						try {
							opcion = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println(suiteTrs.eliminar(opcion));
						} catch (NumberFormatException e) {
							System.err.println("Solo Ingrese Un Número Entero (Número De Suite)");
						}
					} else {
						System.err.println("No existen Suites A ELIMINAR");
					}
				} else {
					System.err.println(" - - -A Digitado Mal - - -");
				}
				break;

			case 7:
				FrmPrincipal frmPrincipal = new FrmPrincipal();
				salir = true;
				break;

			default:
				System.err.println("--- Opción Incorrecta ---");
				break;
			}
		} while (!salir);

	}
}
