/**
 * 
 */
package com.scoutdp.pydhotel.vista;

import com.scoutdp.pydhotel.util.UtilLectura;

/**
 * Clase que representa el formulacio principal en donde el Usuario puede
 * acceder a distintos men�s
 * 
 * @version 8.0 28 feb 2019
 * @author Erick D�az
 */
public class FrmPrincipal {

	private boolean salir = false;
	public FrmPrincipal() {
		crarMenuPrincipal();
	}

	private void crarMenuPrincipal() {
		int opcion = 0;
		do {
			System.out.println("�--------(�` BIENVENIDO ��)--------� ");
			System.out.println(">--------  1. HABITACIONES --------< ");
			System.out.println(">--------  2. RESERVAS     --------< ");
			System.out.println(">--------  3. CLIENTES >>V.I.P<< ---< ");
			System.out.println(">--------  4. SERVICIOS   ---------< ");
			System.out.println(">--------  5. TIPO SERVICIOS ------< ");
			System.out.println("6. SALIR --------------------------< ");
			// Se elegir� una opcion por teclado
			try {
				opcion = Integer.parseInt(UtilLectura.leerTeclado());
			} catch (NumberFormatException e) {
				System.err.println("Por favor para ingresar a los Men�s solo Digite sus N�meros.");
			}

			switch (opcion) {
			case 1:
				salir = true;
				FrmHabitacion frmhabitacion = new FrmHabitacion();
				break;

			case 2:
				salir = true;
				FrmReserva frmreserva = new FrmReserva();
				break;

			case 3:
				salir = true;
				FrmCliente frmcliente = new FrmCliente();
				break;

			case 4:
				salir = true;
				FrmServicios frmservicios = new FrmServicios();
				break;

			case 5:
				salir = true;
				FrmTipoServicio frmTipoServicio = new FrmTipoServicio();
				break;
				
			case 6:
				salir = true;
				System.exit(0);

			default:
				System.err.println("--- Opci�n Incorrecta ---");
				break;
			}
		} while (!salir);
	}
}