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
 * Clase que representa el formulario de la habitaci�n (Terminada)
 * 
 * @version 8.0 28 feb 2019
 * @author Erick D�az
 */
public class FrmHabitacion {

	/*
	 * Instanciaci�n la cu�l permite hacer uso de la clase que implementa la
	 * interfaz CRUD
	 */
	HabitacionTrs habitacionTrs = new HabitacionTrs();
	SuiteTrs suiteTrs = new SuiteTrs();
	public static Suite suite;
	public static Habitacion habitacion;
	/*
	 * Declaraci�n de Array el cual sea el encargado de guardar el m�todo de listar
	 * para luego ser recorrido con un array
	 */
	Object[] listarHabitacion;
	Object mostrarHbS;

	private int dormitorios; // Variable que obtendr� el n�mero de dormitorios
	private int banos; // Variable que obtendr� el n�mero de ba�os
	private int opcion2 = 0; // Variable para ingresar a nuevas opciones dentro del formulario
	private int numAct; // Variable que permitir� obtener el N� de Habitacon/Suite a Actualizar
	private int numCons; // Variable que permitir� obtener el N� de Habitacon/Suite a Consultar
	private String cama; // Variable que obtendr� el tama�o de la cama
	private String cocina; // Variable que obtendr� el tama�o de la cocina
	private String tv; // Variable que obtendr� el tama�o de la TV
	private String mensaje; // Variable que ayudar� a devolver un mensaje en consola
	private boolean bandera = true; // boleano que ayudar� a realizar banderas
	private Date fecha = new Date(); // INSTANCIACI�N DE UN OBJETO DE TIPO DATE -> (DEPRECATED)
	private SimpleDateFormat resetearFecha = new SimpleDateFormat("yyyy-MM-dd");
	private boolean salir = false;

	public FrmHabitacion() {
		abrirMenuDeOpcion();
	}

	private void abrirMenuDeOpcion() {
		do {
			System.out.println("");
			System.out.println("            �--------(�` HABITACI�N ��)--------�              ");
			System.out.println(">--------  1. LISTAR                                --------< ");
			System.out.println(">--------  2. AGREGAR HABITACI�N PERSONALIZADA      --------< ");
			System.out.println(">--------  3. AGREGAR SUITE PERSONALIZADA (SOLO V.I.P)  --------< ");
			System.out.println(">--------  4. ACTUALIZAR                            --------< ");
			System.out.println(">--------  5. CONSULTAR                             --------< ");
			System.out.println(">--------  6. ELIMINAR                              --------< ");
			System.out.println("7. REGRESAR --------------------------< ");
			// Se elegir� una opcion por teclado
			int opcion = 0;
			try {
				opcion = Integer.parseInt(UtilLectura.leerTeclado());
			} catch (NumberFormatException e) {
				System.err.println("Por favor para ingresar a los Men�s solo Digite sus N�meros.");
			}
			switch (opcion) {
			case 1:
				System.out.println("**�QUIERE LISTAR LAS HABITACIONES O SUITES?**");
				System.out.println(">>Digite 1. Habitaciones 2. Suites<<");
				System.out.println(">>Listar:");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitaciones 2. Suites.");
				}
				System.out.println("\n"); // Salto de l�nea
				if (opcion2 == 1) {
					listarHabitacion = habitacionTrs.listar(); // Llamada al m�todo de la clase habitacionTrs el cu�l
																// devuelve un array de Object
					for (Object listar : listarHabitacion) { // For - each que recorrer� el array de Objetos de Tipo
																// Habitaci�n
						if (listar != null) { // Ayudar� a dar una mejor im�gen al array Null
							System.out.println(listar);
						} else {
							System.out.println("SIN RESERVA");
						}
					}
				} else if (opcion2 == 2) {
					listarHabitacion = suiteTrs.listar();
					for (Object listar : listarHabitacion) { // For - each que recorrer� el array de Objetos de Tipo
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
				System.out.println("Para Personalizar la habitaci�n; Ingrese: ");
				System.out.println("N�mero de Dormitorios");
				try {
					dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("N�mero de Ba�os");
					banos = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("Tama�o de la cama");
					cama = UtilLectura.leerTeclado();
					System.out.println("Tama�o de la Tv");
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
					// 4. Procesar la informaci�n
					System.out.println(mensaje);
				} catch (NumberFormatException e) {
					System.err.println("Solamente Puede Agregar N�mero Enteros En los apartados que piden 'Cuantos'.");
				}
				break;

			case 3:
				if (FrmLogin.clienteVip != null) { // Permite que solo Socios Puedan acceder a este apartado
					// 1. Recuperar valores
					try {
						System.out.println("Para Personalizar la Suite, Ingrese: ");
						System.out.println("N�mero de Dormitorios");
						dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("N�mero de Ba�os");
						banos = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("Tama�o de la cama");
						cama = UtilLectura.leerTeclado();
						System.out.println("Tama�o de la Tv");
						tv = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga cocina?");
						cocina = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga una sala?");
						String sala = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga gimnasio?");
						String gym = UtilLectura.leerTeclado();
						System.out.println("Quiere que la Suite tenga Balc�n?");
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
						// 4. Procesar la informaci�n
						System.out.println(mensaje);
					} catch (NumberFormatException e) {
						System.err.println(
								"Solamente Puede Agregar N�mero Enteros En los apartados que piden 'Cuantos'.");
					}
				} else {
					System.err.println("Solo Usuarios V.I.P pueden Personalizar Suites");
					break;
				}
				break;

			case 4:
				System.out.println("�DESEA ACTUALIZAR UNA HABITACI�N O SUITE?");
				System.out.println("1. Habitaci�n");
				System.out.println("2. Suite");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitaci�n 2. Suite.");
				}
				if (opcion2 == 1) {
					listarHabitacion = habitacionTrs.listar();
					for (Object lisHab : MemoriaBDD.habitaciones) { // Listar Habitaciones
						System.out.println(lisHab);
					}
					System.out.println(" - - -Ingrese el N�mero de Habitaci�n que desea Actualizar.- - -");
					try {
						numAct = Integer.parseInt(UtilLectura.leerTeclado());
						habitacionTrs.consultarConId(numAct);
						// 1. Recuperar valores
						System.out.println("Para Personalizar la habitaci�n; Ingrese: ");
						System.out.println("N�mero de Dormitorios");
						dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("N�mero de Ba�os");
						banos = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("Tama�o de la cama");
						cama = UtilLectura.leerTeclado();
						System.out.println("Tama�o de la Tv");
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
						// 4. Procesar la informaci�n
						System.out.println(mensaje);
					} catch (MiExcepcion2 e) {
						System.err.println("No se encontr� el N�mero de La Habitaci�n");
					} catch (NumberFormatException e1) {
						System.err.println("Solo Debe Ingresar Un N�mero (Entero que Tenga La Habitaci�n)");
					}
				} else if (opcion2 == 2) {
					/*
					 * Si esque el Usuario que inicio sesi�n no es V.I.P no necesitar� acceder a
					 * este apartado desde su ejecuci�n
					 */
					if (FrmLogin.clienteVip != null) {
						listarHabitacion = suiteTrs.listar();
						for (Object lisSu : MemoriaBDD.suites) {
							System.out.println(lisSu);
						}
						System.out.println("Ingrese el N� De La Suite");
						try {
							numAct = Integer.parseInt(UtilLectura.leerTeclado());
							habitacionTrs.consultarConId(numAct);
							// 1. Recuperar valores
							/*
							 * Se v�lida en la clase FrmHabitacion del paquete Vista (se puede hacer en la
							 * clase HabitacionTrs) si esque el n�mero de la habitaci�n existe o no
							 */
							System.out.println("Para Personalizar la Suite, Ingrese: ");
							System.out.println("N�mero de Dormitorios");
							dormitorios = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println("N�mero de Ba�os");
							banos = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println("Tama�o de la cama");
							cama = UtilLectura.leerTeclado();
							System.out.println("Tama�o de la Tv");
							tv = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga cocina?");
							cocina = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga una sala?");
							String sala = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga gimnasio?");
							String gym = UtilLectura.leerTeclado();
							System.out.println("Quiere que la Suite tenga Balc�n)");
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
							// 4. Procesar la informaci�n
							System.out.println(mensaje);
						} catch (MiExcepcion2 e) {
							System.err.println("No se encontr� el N�mero de La Suite");
						} catch (NumberFormatException e1) {
							System.err.println("Solo Debe Ingresar Un N�mero (Entero que Tenga La Suite)");
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
				System.out.println("�Desea Consultar Una Habitaci�n O Suite?");
				System.out.println("1. Habitaci�n");
				System.out.println("2. Suite");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitaci�n 2. Suite.");
				}
				if (opcion2 == 1) {
					System.out.println("Ingrese el N� De la Habitaci�n");
					try {
						numCons = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println("");
						mostrarHbS = habitacionTrs.consultarConId(numCons);
						System.out.println(
								"El Estado de La Habitaci�n En [" + resetearFecha.format(fecha) + "] Es " + mostrarHbS);
					} catch (MiExcepcion2 e) {
						System.err.println("No Se Encontr� El N�mero De La Habitaci�n!!");
					} catch (NumberFormatException e1) {
						System.err.println("Solo Ingrese Un N�mero Entero (N�mero De Habitaci�n)");
					}
				} else if (opcion2 == 2) {
					if (FrmLogin.clienteVip != null) {
						try {
							System.out.println("Ingrese el N� De la Suite");
							numCons = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println("");
							mostrarHbS = habitacionTrs.consultarConId(numCons);
							System.out.println("El Estado de La Habitaci�n En [" + resetearFecha.format(fecha) + "] Es "
									+ mostrarHbS);
						} catch (MiExcepcion2 e) {
							System.err.println("No Se Encontr� El N�mero De La Suite!!");
						} catch (NumberFormatException e1) {
							System.err.println("Solo Ingrese Un N�mero Entero (N�mero De Suite)");
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
				System.out.println("�DESEA ELIMINAR SUITE O HABITACION?");
				System.out.println("1. Habitaci�n");
				System.out.println("2. Suite");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
				} catch (NumberFormatException e) {
					System.err.println("Solo digite 1. Habitaci�n 2. Suite.");
				}
				if (opcion2 == 1) {
					System.out.println("");
					listarHabitacion = habitacionTrs.listar();
					for (Object it : listarHabitacion) {
						System.out.println(it);
					}
					System.out.println("");
					System.out.println("�Qu� n�mero de Habitaci�n desea eliminar?");
					try {
						opcion = Integer.parseInt(UtilLectura.leerTeclado());
						System.out.println(suiteTrs.eliminar(opcion));
					} catch (NumberFormatException e) {
						System.err.println("Solo Ingrese Un N�mero Entero (N�mero De Habitaci�n)");
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
						System.out.println("�Qu� n�mero de Suite desea eliminar?");
						try {
							opcion = Integer.parseInt(UtilLectura.leerTeclado());
							System.out.println(suiteTrs.eliminar(opcion));
						} catch (NumberFormatException e) {
							System.err.println("Solo Ingrese Un N�mero Entero (N�mero De Suite)");
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
				System.err.println("--- Opci�n Incorrecta ---");
				break;
			}
		} while (!salir);

	}
}
