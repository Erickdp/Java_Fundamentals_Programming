/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.scoutdp.pydhotel.control.ClienteTrs;
import com.scoutdp.pydhotel.control.UsuarioTrs;
import com.scoutdp.pydhotel.modelo.Socio;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Usuario;
import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa el formulario del Cliente donde se podrá consultar y
 * agregar usuarios
 * 
 * @version 8.0 28 feb 2019
 * @author Erick Díaz
 */
public class FrmCliente {

	/*
	 * Objetos que permitirán usar métodos de la Interfaz CRUD
	 */
	ClienteTrs clienteTrs = new ClienteTrs();
	UsuarioTrs usuarioTrs = new UsuarioTrs();
	String mensaje;
	String nombre;
	String correo;
	String clave;
	int id;
	String numTarj;
	String mensaje2;
	Date fecha = new Date();
	SimpleDateFormat resetearFormato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Object[] listarMiembros; // Array de tipo Object Para guardar Listar Usuarios/Clientes
	Object clienteConsultado;
	Object usuarioConsultado;

	public FrmCliente() {
		crearMenuCli();
	}

	private void crearMenuCli() {
		int opcion = 0;
		int opcion2;
		int idElim;
		do {
			try {
				System.out.println("");
				System.out.println("  * * *     »--------(¯` CLIENTES ´¯)--------»    * * *       ");
				System.out.println(">--------  1. AGREGAR USUARIOS                      --------< ");
				System.out.println(">--------  2. LISTAR                                --------< ");
				System.out.println(">--------  3. ACTUALIZAR                            --------< ");
				System.out.println(">--------  4. CONSULTAR                            --------< ");
				System.out.println(">--------  5. ELIMINAR                              --------< ");
				System.out.println("6. REGRESAR                       --------------------------< ");
				System.out.println("");
				// Se elegirá una opcion por teclado
				opcion = Integer.parseInt(UtilLectura.leerTeclado());

				switch (opcion) {
				case 1:
					if (FrmLogin.clienteVip != null) {
						// 1. Recuperar valores
						System.out.println("_Para Agregar Usuarios Ingrese_");
						System.out.println("Nombre:");
						nombre = UtilLectura.leerTeclado();
						System.out.println("Correo:");
						correo = UtilLectura.leerTeclado();
						System.out.println("Clave:");
						clave = UtilLectura.leerTeclado();
						System.out.println("ID:");
						id = Integer.parseInt(UtilLectura.leerTeclado());
						/*
						 * 2. Creación de un registro de tipo Usuario el cúal almacenara los datos en un
						 * objeto de tipo Usuario
						 */
						Usuario usuarioNuevo = new Usuario();
						usuarioNuevo.setNombreUsu(nombre);
						usuarioNuevo.setCorreoUsu(correo);
						usuarioNuevo.setClaveUsu(clave);
						if (id != 0) { // No se permite usar la posición de Usuario con ID 0
							usuarioNuevo.setIdUsu(id);
						} else { // Romper el switch si se intenta usar el id 0
							System.out.println("El ID es del Usuario Principal intente con un nuevo Usuario");
							break;
						}
						usuarioNuevo.setFechaCreacionUsu(new Date());
						// 3. Llamar al constructor
						mensaje = usuarioTrs.guardar(usuarioNuevo);
						// 4. Procesar la informacion
						System.out.println(mensaje);

						if (mensaje.equals("Usuario Nuevo Agregado")) { // Acceso a que el Usuario creado sea VIP
							System.out.println("_________________________________________");
							System.out.println("Quiere que el Usuario Agregado Sea V.I.P?");
							mensaje = UtilLectura.leerTeclado();
							if (mensaje.equalsIgnoreCase("si")) { // Permitirá Crear objetos de Tipo Cliente en los
																	// arrays
								System.out.println("********************************************");
								System.out.println("Agrege Un Número de Tarjeta al Nuevo Cliente");
								// 1.1 Recuperar valores
								numTarj = UtilLectura.leerTeclado();
								// 2.1 Creación de objeto que guardará clientes VIP
								Socio clienteNuevo = new Socio(); // Instanciación de un Objeto de tipo Socio
								// Se usan los parámetros ya ingresados para crear el Objeto, el cúal solo
								// necesitará un número de Tarjeta
								clienteNuevo.setPaseVip(numTarj);
								clienteNuevo.setClaveUsu(clave);
								clienteNuevo.setNombreUsu(nombre);
								clienteNuevo.setCorreoUsu(correo);
								clienteNuevo.setIdUsu(id);
								clienteNuevo.setFechaCreacionUsu(new Date());
								// 3.1 Llamar al constructor
								mensaje = clienteTrs.guardar(clienteNuevo);
								// 4.1 Procesar la informacion
								System.out.println(mensaje);
								System.out.println(" [    *   *   *     ] ");
								System.out.println("Formulario Terminado.");
							} else { // Si no quiere que sea VIP se guardará como Usuario regular
								System.out.println(" [    *  *  *     ] ");
								System.out.println("Formulario Terminado.");
							}
						}
					} else {
						System.err.println("Solo Usarios V.I.P pueden agregar a otros.");
					}
					break;

				case 2:
					System.out.println("Desea Listar USUARIOS o Miembros V.I.P");
					System.out.println("1. Usuario ------------------ 2. V.I.P");
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
					switch (opcion2) {
					case 1:
						listarMiembros = usuarioTrs.listar();
						for (Object it : listarMiembros) { // Devuelve Los Usuarios Registrados
							System.out.println(it);
						}
						break;

					case 2:
						if (FrmLogin.clienteVip != null) {
							listarMiembros = clienteTrs.listar();
							for (Object it : listarMiembros) { // Devuelve los clientes Registrados
								System.out.println(it);
							}
						} else {
							System.err.println("Solo Usuarios V.I.P Pueden Acceder A Los Registros de otros V.I.P");
						}
						break;

					default:
						System.err.println("Opción Incorrecta");
						break;
					}
					break;

				case 3:
					/*
					 * Al actualizar al Usuario los campos si este es VIP también se actualizarán al
					 * igual si esque se actualiza su membresía
					 */
					if (FrmLogin.clienteVip != null) {
						System.out.println("***--------------------***---------------------***");
						System.out.println("      ¿DESEA ACTUALIZAR CLIENTES O USUARIOS?   ");
						System.out.println("(LOS CAMBIOS QUE SE REALIZEN SE LOS APLICARÁ A USUARIOS "
								+ "Y CLIENTES SI ESTOS SON COMUNES");
						System.out.println("DIGITE");
						System.out.println("1. USUARIOS");
						System.out.println("2. CLIENTES");
						opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
						if (opcion2 == 1) {
							listarMiembros = usuarioTrs.listar();
							for (Object listarUsu : listarMiembros) {
								System.out.println(listarUsu);
							}
							System.out.println(
									"************************************************" + "***************************");
							System.out.println("Ingrese el ID Del Usuario A Actuzalizar");
							id = Integer.parseInt(UtilLectura.leerTeclado());
							if (id == 0) { // El Usuario con ID 0 no puede ser actaulizado
								System.err.println("No se Pueden Actualizar los datos Del Usuario 0");
								break;
							}
							System.out.println("Nuevo Nombre:");
							nombre = UtilLectura.leerTeclado();
							System.out.println("Nuevo Correo:");
							correo = UtilLectura.leerTeclado();
							System.out.println("Nueva Clave:");
							clave = UtilLectura.leerTeclado();

							Usuario usuarioNuevo = new Usuario();
							Socio clienteNuevo = new Socio();
							usuarioNuevo.setNombreUsu(nombre);
							usuarioNuevo.setCorreoUsu(correo);
							usuarioNuevo.setClaveUsu(clave);
							usuarioNuevo.setIdUsu(id);
							usuarioNuevo.setFechaCreacionUsu(new Date());
							for (Socio busIdC : MemoriaBDD.clientes) { // Busca si el Usuario tiene membresía para
																		// actualizarlo
								if (busIdC != null && busIdC.getIdUsu() == id) {
									clienteNuevo.setNombreUsu(nombre); // Se usan los nuevos datos ingresados
									clienteNuevo.setClaveUsu(clave);
									clienteNuevo.setCorreoUsu(correo);
									clienteNuevo.setIdUsu(id);
									clienteNuevo.setFechaCreacionUsu(new Date());
									System.out.println("Ingrese un Nuevo número de Tarjeta");
									numTarj = UtilLectura.leerTeclado();
									clienteNuevo.setPaseVip(numTarj);
									break;
								}
							}
							/*
							 * Se envía a cada clase su correspondiente validación si el Usuario es
							 * corriente el ID en cliente no lo encontrará y devolvera su mensaje de no
							 * encontrado
							 */
							mensaje = usuarioTrs.actualizar(id, usuarioNuevo);
							mensaje2 = clienteTrs.actualizar(id, clienteNuevo);
							System.out.println(mensaje + " & " + mensaje2); // Se usan los dos mensajes para indicar si
																			// Usuario/Cliente fueron actualizados
						} else if (opcion2 == 2) {
							listarMiembros = clienteTrs.listar();
							for (Object listarCli : listarMiembros) {
								System.out.println(listarCli);
							}
							System.out.println(
									"************************************************" + "***************************");
							System.out.println("Ingrese el ID Del Cliente A Actuzalizar");
							id = Integer.parseInt(UtilLectura.leerTeclado());
							if (id == 0) { // El Usuario con ID 0 no puede ser actaulizado
								System.err.println("No se Pueden Actualizar los datos Del Cliente 0");
								break;
							}
							/*
							 * Como para ser Cliente debió ser Usuario entonces no es necesario buscar si
							 * existe un usuario con el ID que ingrese
							 */
							System.out.println("Nuevo Nombre:");
							nombre = UtilLectura.leerTeclado();
							System.out.println("Nuevo Correo:");
							correo = UtilLectura.leerTeclado();
							System.out.println("Nueva Clave:");
							clave = UtilLectura.leerTeclado();
							System.out.println("Ingrese un Nuevo número de Tarjeta");
							numTarj = UtilLectura.leerTeclado();

							Usuario usuarioNuevo = new Usuario();
							Socio clienteNuevo = new Socio();
							usuarioNuevo.setNombreUsu(nombre);
							usuarioNuevo.setCorreoUsu(correo);
							usuarioNuevo.setClaveUsu(clave);
							usuarioNuevo.setIdUsu(id);
							usuarioNuevo.setFechaCreacionUsu(new Date());
							clienteNuevo.setNombreUsu(nombre); // Se usan los nuevos datos ingresados
							clienteNuevo.setClaveUsu(clave);
							clienteNuevo.setCorreoUsu(correo);
							clienteNuevo.setIdUsu(id);
							clienteNuevo.setFechaCreacionUsu(new Date());
							clienteNuevo.setPaseVip(numTarj);

							System.out.println(clienteTrs.actualizar(id, clienteNuevo) + " & "
									+ usuarioTrs.actualizar(id, usuarioNuevo));
						} else {
							System.err.println("A digitado mal");
						}
					} else {
						System.err.println("Solo Miembros V.I.P pueden actualizar los Campos.");
					}
					break;

				case 4:
					if (FrmLogin.clienteVip != null) {
						System.out.println("---------[PARA CONSULTAR]---------");
						System.out.println("Ingrese ID a consultar: ");
						opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
						clienteConsultado = clienteTrs.consultarConId(opcion2);
						usuarioConsultado = usuarioTrs.consultarConId(opcion2);
						if (clienteConsultado == null && usuarioConsultado == null) {
							System.err.println("ESTADO DEL CLIENTE EN [" + resetearFormato.format(fecha)
									+ "] ES:**NO EXISTE REGISTRO**");
						} else if (clienteConsultado != null) { // Si existe el ID del cliente el del Usuario también
							System.out.println("ESTADO DEL CLIENTE EN [" + resetearFormato.format(fecha) + "] "
									+ clienteConsultado);
						} else {
							System.out.println("ESTADO DEL USUARIO EN [" + resetearFormato.format(fecha) + "] "
									+ usuarioConsultado);
						}
					} else {
						System.err.println("Solo Clientes V.I.P pueden consultar el Estado de los Clientes / Usuarios");
					}
					break;

				case 5:
					/*
					 * Tener en cuenta si esque existe el Cliente el Usaurio también por eso se
					 * buscan los 2 al eliminar usuario ya que si se elimina el Usuario su membresía
					 * también pero si su membresía se elimina el Usuario solo será corriente
					 */
					System.out.println("***DESEA ELIMINAR:***");
					System.out.println("1. USUARIOS (Tener en Cuenta que al Eliminar un Usuario y "
							+ "Este es V.I.P su registro también quedará eliminado)");
					System.out.println("2. CLIENTES");
					opcion2 = Integer.parseInt(UtilLectura.leerTeclado());
					switch (opcion2) {
					case 1:
						listarMiembros = usuarioTrs.listar();
						for (Object it : listarMiembros) {
							System.out.println(it);
						}
						System.out.println("Ingrese el ID del usuario a eliminar");
						idElim = Integer.parseInt(UtilLectura.leerTeclado());
						if (idElim != 0) {
							mensaje = usuarioTrs.eliminar(idElim);
							System.out.println(mensaje);
						} else {
							System.err.println("El Usuario 0 No puede ser ELIMINADO");
						}
						break;

					case 2:
						if (FrmLogin.clienteVip != null) { // Solo Miembros pueden cancelar la membresía de otros
							listarMiembros = clienteTrs.listar();
							for (Object it : listarMiembros) {
								System.out.println(it);
							}
							System.out.println("Ingrese el ID del Cliente a eliminar");
							idElim = Integer.parseInt(UtilLectura.leerTeclado());
							if (idElim != 0) {
								mensaje = clienteTrs.eliminar(idElim);
								System.out.println(mensaje);
							} else {
								System.err.println("El Cliente 0 No puede ser Eliminado");
							}
						} else {
							System.err.println("Solo Usuarios V.I.P pueden eliminar a otros");
						}
						break;

					default:
						System.err.println("Opción Incorrecta");
						break;
					}
					break;

				case 6:
					FrmPrincipal frmPrincipal = new FrmPrincipal();

				default:
					System.err.println("Opción Incorrecta");
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
