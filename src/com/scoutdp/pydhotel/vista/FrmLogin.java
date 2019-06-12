/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import com.scoutdp.pydhotel.control.ClienteTrs;
import com.scoutdp.pydhotel.control.UsuarioTrs;
import com.scoutdp.pydhotel.modelo.Socio;
import com.scoutdp.pydhotel.modelo.Usuario;
import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa la p�gina principal de Login del Usuario (Terminado)
 * 
 * @version 8.0 28 feb 2019
 * @author Erick D�az
 */
public class FrmLogin {

	public static Usuario usuarioSesion; // Objeto de tipo Usuario que guardar� el usuario ingresado
	public static Socio clienteVip; // Objeto de tipo Cliente que guardar� el cliente ingresado
	public static String ingreso; // Variable que obtendr� el usuario o correo
	public static String ingVip; // Variable que guardar� al usuario V.I.P

	/**
	 * Solo desde esta clase se podr� tener un main, el cual ejecutar� el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Simulaci�n de ventana para el Usuario
		String salir = "entrar"; // Variable que servir� para terminar el cilco do - while
		String confir; // Variable que ayudar� a captar la confirmaci�n de V.I.P
		String clave; // Variable que obtendr� la clave
		/*
		 * Crear un objeto de la clase UsuarioTrs con el cual se llamar� al m�todo que
		 * valide usuario y clave
		 */
		UsuarioTrs adminUsuario = new UsuarioTrs();
		ClienteTrs adminCliente = new ClienteTrs();
		/*
		 * Declaraci�n con el cual si encontr� al Usuario lo enviar� a un frmPrincipal
		 */
		FrmPrincipal frmPrincipal;
		int opcion = 0;
		do {
			System.out.println();
			System.out.println(" *------------ * * * * ------------* ");
			System.out.println(" *---------- * * * * * *  ---------* ");
			System.out.println(" *---------[ D. J. C. HOTEL ]------* ");
			System.out.println(" *---------- * * * * * *  ---------* ");
			System.out.println(" *------------ * * * * ------------* ");
			System.out.println();
			// 1. Recuperar Valores.
			System.out.println("// Desea Ingresar Con el Usuario o Correo ");
			System.out.println("// Presione: ");
			System.out.println("// 1. Usuario");
			System.out.println("// 2. Correo");
			// Realizar un cast de String a int para entrar al men�
			try {
				opcion = Integer.parseInt(UtilLectura.leerTeclado());
			} catch (NumberFormatException e) {
				System.err.println("Solo Debe de Digitar 1 = Usuario. 2 = Correo.");
			}
			
			switch (opcion) {
			case 1:
				System.out.println("- Ingrese el Usuario y Contrase�a -");
				System.out.println("          Usuario ");
				ingreso = UtilLectura.leerTeclado();
				System.out.println("          Contrase�a ");
				clave = UtilLectura.leerTeclado();
				// 2. Llamar al m�todo de negocio y enviar la inf. a validar
				usuarioSesion = adminUsuario.validarUsuario(ingreso, clave);
				// 3. Si el usuario es correcto ingresar� a la apl. si no enviar� un error
				if (usuarioSesion != null) {
					System.out.println("-------------------------------------------");
					System.out.println("�Es Usuario V.I.P?. (Para Obtener Beneficios )");
					System.out.println("Digite 'si' , si esque tiene un n�mero de Tarjeta V.I.P");
					confir = UtilLectura.leerTeclado();
					if (confir.equalsIgnoreCase("si")) {
						System.out.println("-          *     *     *         -");
						System.out.println("Ingrese el n�mero de Tarjeta V.I.P");
						ingVip = UtilLectura.leerTeclado();
						clienteVip = adminCliente.validarCliente(ingreso, ingVip);
						if (clienteVip != null) {
							System.out.println("*****************");
							System.out.println("V.I.P Encontrado");
							System.out.println("");
							frmPrincipal = new FrmPrincipal();
							break;
						} else {
							System.out.println("*******************");
							System.err.println("V.I.P NO Encontrado");
							System.out.println("");
							frmPrincipal = new FrmPrincipal();
							break;
						}
					} else {
						frmPrincipal = new FrmPrincipal();
						break;
					}
				} else {
					/*
					 * Mensaje que se enviar� si no ingres� correctamente los datos
					 */
					System.err.println("Datos Incorrectos en Usuario/Contrase�a");
					System.out.println("\n");
					System.out.println("Vueva a intentar, digite nuevamente una opci�n para ingresar");
				}
				break;

			case 2:
				/*
				 * Seguno formulario el c�al permite ingresar con el correo
				 */
				System.out.println("- Ingrese el Correo y Contrase�a -");
				System.out.println("          Correo ");
				ingreso = UtilLectura.leerTeclado();
				System.out.println("          Contrase�a ");
				clave = UtilLectura.leerTeclado();
				usuarioSesion = adminUsuario.validarUsuario(ingreso, clave);
				if (usuarioSesion != null) {
					System.out.println("-------------------------------------------");
					System.out.println("�Es Cliente V.I.P?. ( Para Obtener Beneficios )");
					System.out.println("Digite 'si' , si esque tiene un n�mero de Tarjeta V.I.P");
					confir = UtilLectura.leerTeclado();
					if (confir.equalsIgnoreCase("si")) {
						System.out.println("-          *     *     *         -");
						System.out.println("Ingrese el n�mero de Tarjeta V.I.P");
						ingVip = UtilLectura.leerTeclado();
						clienteVip = adminCliente.validarCliente(ingreso, ingVip);
						if (clienteVip != null) {
							System.out.println("*****************");
							System.out.println("V.I.P Encontrado");
							System.out.println("");
							frmPrincipal = new FrmPrincipal();
							break;
						} else {
							System.out.println("*******************");
							System.out.println("V.I.P NO Encontrado");
							System.out.println("");
							frmPrincipal = new FrmPrincipal();
							break;
						}
					} else {
						frmPrincipal = new FrmPrincipal();
						break;
					}
				} else {
					System.err.println("Datos Incorrectos en Usuario/Contrase�a");
					System.out.println("\n");
					System.out.println("Vueva a intentar, digite nuevamente una opci�n para ingresar");
				}
				break;

			default:
				System.err.println("x Error x Digite nuevamente ");
				break;

			}
		} while (salir != "salir");
	}
}