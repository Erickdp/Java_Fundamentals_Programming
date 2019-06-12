/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import com.scoutdp.pydhotel.control.HabitacionTrs;
import com.scoutdp.pydhotel.control.MiExcepcion;
import com.scoutdp.pydhotel.control.MiExcepcion2;
import com.scoutdp.pydhotel.control.ReservaTrs;
import com.scoutdp.pydhotel.control.SuiteTrs;
import com.scoutdp.pydhotel.modelo.Habitacion;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Reserva;
import com.scoutdp.pydhotel.modelo.Suite;
import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa el formulario de Reserva con el que el Usuario va a
 * interactuar una vez terminado el formulario de la clase FrmHabitacion
 * (Terminado)
 * 
 * @version 8.0 28 feb 2019
 * @author Erick D�az
 */
public class FrmReserva {

	private int opcion = 0;
	private int opcion2 = 0;
	private int diaIngreso;
	private int idReserva;
	private int mesIngreso;
	private int diaRetiro;
	private int mesRetiro;
	private int numHab;
	private Habitacion habitacion;
	private Suite suite;
	private String resp;
	private LocalDate fechaDeReserva;
	private LocalDate fechaDeRetiro;
	private boolean salir = false;
	/*
	 * Declaraci�n de objetos que permiti�n utilizar clases que controlen procesos
	 */
	HabitacionTrs habTrs = new HabitacionTrs();
	SuiteTrs suiteTrs = new SuiteTrs();
	ReservaTrs reservaTrs = new ReservaTrs();
	private SimpleDateFormat hoy = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

	public FrmReserva() {
		abrirMenuReserva();
	}

	private void abrirMenuReserva() {
		do {
			System.out.println("\n  * * *     �- * * * *(�`       RESERVA     ��)* * * * -�    * * *    ");
			System.out.println(">--------  1. AGREGAR                                         --------< ");
			System.out.println(">--------  2. ACTUALIZAR                                      --------< ");
			System.out.println(">--------  3. CONSULTAR                                       --------< ");
			System.out.println(">--------  4. ELIMINAR                                        --------< ");
			System.out.println("5. REGRESAR                       ------------------------------------<\n");
			try {
				opcion = 0;
				opcion = Integer.parseInt(UtilLectura.leerTeclado());
			} catch (NumberFormatException e) {
				System.err.println("Por favor para ingresar a los Men�s solo Digite sus N�meros.");
			}
			switch (opcion) {
			case 1:
				System.out.println("FECHA ACTUAL : " + hoy.format(new Date()));
				System.out.println("\nPor Favor Ingrese el n�mero de reserva que realizar� (Ejemplo : Si es la "
						+ "primera reserva que realizar� digite 1), La Fecha de Estancia & Retiro");
				System.out.println(
						"\nUna ves realizada la Reserva Solo se puede ACTUALIZAR su fecha de " + "Ingreso y Salida");
				try {
					idReserva = Integer.parseInt(UtilLectura.leerTeclado());
					Reserva verificarReserva = new Reserva(idReserva); // Objeto el caul tiene un contructor solamente
					// con un argumento Int para poder validar este
					// apartado
					/*
					 * Se permite que varias reservas con distintos ID puedan ser guardadas esto
					 * evita que al momento de realizar el total no se usea los ID varias veces
					 */
					reservaTrs.reservaRepetida(verificarReserva);
					System.out.println("\nD�a De Entrada");
					diaIngreso = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("\nMes De Entrada");
					mesIngreso = Integer.parseInt(UtilLectura.leerTeclado());
					fechaDeReserva = LocalDate.of(2019, mesIngreso, diaIngreso);
					System.out.println("\nD�a De Retiro");
					diaRetiro = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("\nMes De Retiro");
					mesRetiro = Integer.parseInt(UtilLectura.leerTeclado());
					fechaDeRetiro = LocalDate.of(2019, mesRetiro, diaRetiro);

					System.out.println("\n�Reserv� una Habitaci�n O Suite?");
					resp = UtilLectura.leerTeclado();
					/*
					 * Acceso a distintos apartados seg�n las respuesta del Usuario
					 */
					if (resp.equalsIgnoreCase("habitaci�n") || resp.equalsIgnoreCase("habitacion")) {
						System.out.println("\nHabitaciones Guardadas\n");
						for (Habitacion mostrarH : MemoriaBDD.habitaciones) {
							if (mostrarH != null) {
								System.out.println(mostrarH);
							} else {
								System.out.println("Sin Reserva");
							}
						}
						System.out.println("\nIngrese el n�mero de Habitaci�n que Reserv�");
						numHab = Integer.parseInt(UtilLectura.leerTeclado());
						// Se env�a el n�mero de la habitaci�n para validar si existe
						if (habTrs.consultarConId(numHab) != null) {
							/*
							 * Se realiza un cast del Objeto obtenido por el m�todo para finalmente
							 * instanicar un objeto con su corresponiente constructor
							 */
							habitacion = (Habitacion) habTrs.consultarConId(numHab);
							Reserva reserva = new Reserva(fechaDeReserva, fechaDeRetiro, idReserva, habitacion);
							System.out.println("\n" + reservaTrs.guardar(reserva));
						} else { // Si la habitaci�n no existe lo enviar� a este apartado
							System.err.println(" - - - No Exite El n�mero de la Habitaci�n - - - ");
							break;
						}
					} else if (resp.equalsIgnoreCase("Suite")) {
						if (FrmLogin.clienteVip != null) { // Acceso solamente a Miembros pues si no lo es no tuvo que
															// agregar Suites en el men� FrmHabitaciones
							System.out.println("\nSuites Guardadas\n");
							for (Suite mostrarS : MemoriaBDD.suites) {
								if (mostrarS != null) {
									System.out.println(mostrarS);
								}
							}
							System.out.println("\nIngrese el n�mero de Suite que Reserv�");
							numHab = Integer.parseInt(UtilLectura.leerTeclado());
							if (suiteTrs.consultarConId(numHab) != null) { // Permite que la habitaci�n que reserve
																			// pueda estar registrada
								suite = (Suite) suiteTrs.consultarConId(numHab);
								Reserva reserva = new Reserva(fechaDeReserva, fechaDeRetiro, idReserva, suite);
								System.out.println("\n" + reservaTrs.guardar(reserva));
							} else {
								System.err.println(" - - - No Existe el n�mero de la Suite - - -");
								break;
							}

						} else {
							System.err.println("No es Miembro V.I.P");
							break;
						}

					} else {
						System.err.println(" - - - A ESCRITO MAL - - -");
						break;
					}
					/*
					 * Se indica la fecha de donde utilizar� las habitaciones
					 */
					System.out.println(" * * * RESERVA EXITOSA * * *");
					System.out.println("N�MERO DE RESERVA (" + idReserva + ") FECHA DE INGRESO ["
							+ fechaDeReserva.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + "] HASTA ["
							+ fechaDeRetiro.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + "]");

				} catch (NumberFormatException e) {
					System.err.println("- - - No ingres� un N�mero Entero - - -");
				} catch (MiExcepcion e1) {
					System.err.println("- - - Ya Existe ID de Reserva  - - -");
				} catch (MiExcepcion2 e2) {
					System.err.println("- - - No se Encontr� el N�mero de la Habitaci�n/Suite - - -");
				}
				break;

			case 2:
				System.out.println("\n�QUE RESERVA DESEA ACTUALIZAR, INGRESE EL ID?");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
					Reserva actReserva = new Reserva(opcion2);
					reservaTrs.reservaRepetida2(actReserva);
					/*
					 * Lo �nico que se podr� actualizar es la fecha de reserva y la fecha de retiro
					 * pues entonces no hubiera sido necesario el apartado actualizar en la clase
					 * FrmHabitacion
					 */
					System.out.println("\nD�a De Entrada");
					diaIngreso = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("\nMes De Entrada");
					mesIngreso = Integer.parseInt(UtilLectura.leerTeclado());
					fechaDeReserva = LocalDate.of(2019, mesIngreso, diaIngreso);
					System.out.println("\nD�a De Retiro");
					diaRetiro = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("\nMes De Retiro");
					mesRetiro = Integer.parseInt(UtilLectura.leerTeclado());
					fechaDeRetiro = LocalDate.of(2019, mesRetiro, diaRetiro);
					Reserva nuevaReserva = new Reserva(fechaDeReserva, fechaDeRetiro, opcion2); // Se instancia un
																								// objeto el cu�l tiene
																								// un constructor �nico
																								// para esta acci�n
					System.out.println(reservaTrs.actualizar(nuevaReserva) + "\n"); // No se realiza ning�n condicional
																					// ya que siempre existir� el ID por
																					// la l�nea 163
					System.out.println("\n" + reservaTrs.consultar(opcion2));
				} catch (NumberFormatException e) {
					System.err.println("No a Ingreado Un N�mero Entero");
				} catch (MiExcepcion2 e1) {
					System.err.println("No Existe la resrva Con ese ID");
				} catch (MiExcepcion e2) {
					System.err.println("- - - No se Pudo Actualizar - - -");
				}
				break;
				
			case 3:
				System.out.println("- - - Ingrese El N�mero de Reserva Que Desea Consultar - - -");
				opcion2 = 0;
				try {
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
					System.out.println("Reserva Realizada El [" + hoy.format(new Date()) + "]\n");
					Reserva totalR = (Reserva) reservaTrs.consultar(opcion2);
					BigDecimal montoTotal = reservaTrs.realizarTotal(totalR);
					System.out.println(totalR);
					System.out.println("\n***   - - - SU TOTAL ES DE - - -   ***\n");
					System.out.println("- - - - - $" + montoTotal.toString() + " - - - - -");
					if (FrmLogin.clienteVip != null) {
						System.out.println("Usuario V.I.P tiene un descuento de 15%");
						System.out.println("\n           MONTO FINAL           \n");
						BigDecimal montoVip = montoTotal.subtract(montoTotal.multiply(new BigDecimal("0.15")));
						System.out.println("- - - - - $" + montoVip.toString() + " - - - - -");
						System.out.println("\n FIN DE CONSULTA");
					} else {
						System.out.println("\n FIN DE CONSULTA");
					}

				} catch (NumberFormatException e) {
					System.err.println("No a Ingreado Un N�mero Entero");
				} catch (MiExcepcion e1) {
					System.err.println("No Existe el ID de Reserva");
				} 
				break;
				
			case 4:
				opcion2 = 0;
				try {
					System.out.println("[ INGRESE EL ID DE LA RESERVA QUE DESEA ELIMINAR ]");
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
					Reserva eliReserva = new Reserva(opcion2); // Para instanciar el objeto se usa solamente el
																// constructor que tiene de argumento id de reserva
					System.out.println("\n" + reservaTrs.eliminar(eliReserva) + "\n");
				} catch (NumberFormatException e) {
					System.err.println("No a Ingreado Un N�mero Entero");
				}
				break;

			case 5:
				FrmPrincipal frmPrincipal = new FrmPrincipal();
				salir = true;
				break;

			default:
				System.err.println("- - - [ Opci�n Incorreta ] - - -");
				break;
			}
		} while (!salir);
	}
}
