/**
 * 
 */
package com.scoutdp.pydhotel.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *  Clase que representa la base de datos en memoria
 * 
 *  @version    8.0 28 feb 2019
 *  @author     Erick D�az
 */
public class MemoriaBDD {
		
	public static int          contHab = 0;  // Variable que ayudar� a recorrer el array habitaciones
	public static int          contSu = 0;   // Variable que ayudar� a recorrer el array Suites
	public static int          contCli = 1;  // Variable que permitir� recorrer el array Cliente
	public static int          contCli2 = 0; // Valor que ayudar� a que no se altere el contador de lugares en el array cuando se elimine un usuario
	public static int          contUsu = 1;  // Variable que permitir� recorrer el array Usuario
	public static Usuario[]    usuarios;     // Declaraci�n de un array de tipo Usuario el cu�l guarde usuarios regsitrados
	public static Habitacion[] habitaciones; // Declaraci�n de un array de tipo Habitaci�n 
	public static Suite[]      suites;       // Declaraci�n de un array de tipo Suite 
	public static Socio[]    clientes;       // Declaraci�n de un array de Tipo clientes el c�al determina quienes tienen membres�a
	public static ArrayList<Servicio> servicios;
	public static ArrayList<TipoServicio> tipoServicio;
	public static ArrayList<Reserva> reservas;
	
	/*
	 * Creaci�n de un constructor est�tico para la clase
	 * MemoriaBDD el cual inicialize las posiciones de los
	 * arrays
	 */
	static {
		usuarios = new Usuario[4];
		habitaciones = new Habitacion[5];
		suites = new Suite[2];
		clientes = new Socio[4];
		servicios = new ArrayList<Servicio>();
		tipoServicio = new ArrayList<TipoServicio>();
		reservas = new ArrayList<Reserva>();
		inicializarValores(); // Llamada al m�todo inicializarValores 
	}

	private static void inicializarValores() {
		usuarios[0] = new Usuario("Erick", "1726", "erickdp@hotmail.com", 0, new Date());
		clientes[0] = new Socio("Erick", "1726", "erickdp@hotmail.com", 0, new Date(), "041099");
		TipoServicio tipoDeSerUno = new TipoServicio(0, "Entretenimiento", "Pel�culas, Juegos, Actividades");
		tipoServicio.add(tipoDeSerUno);
	}	
}
