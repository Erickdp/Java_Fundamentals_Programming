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
 *  @author     Erick Díaz
 */
public class MemoriaBDD {
		
	public static int          contHab = 0;  // Variable que ayudará a recorrer el array habitaciones
	public static int          contSu = 0;   // Variable que ayudará a recorrer el array Suites
	public static int          contCli = 1;  // Variable que permitirá recorrer el array Cliente
	public static int          contCli2 = 0; // Valor que ayudará a que no se altere el contador de lugares en el array cuando se elimine un usuario
	public static int          contUsu = 1;  // Variable que permitirá recorrer el array Usuario
	public static Usuario[]    usuarios;     // Declaración de un array de tipo Usuario el cuál guarde usuarios regsitrados
	public static Habitacion[] habitaciones; // Declaración de un array de tipo Habitación 
	public static Suite[]      suites;       // Declaración de un array de tipo Suite 
	public static Socio[]    clientes;       // Declaración de un array de Tipo clientes el cúal determina quienes tienen membresía
	public static ArrayList<Servicio> servicios;
	public static ArrayList<TipoServicio> tipoServicio;
	public static ArrayList<Reserva> reservas;
	
	/*
	 * Creación de un constructor estático para la clase
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
		inicializarValores(); // Llamada al método inicializarValores 
	}

	private static void inicializarValores() {
		usuarios[0] = new Usuario("Erick", "1726", "erickdp@hotmail.com", 0, new Date());
		clientes[0] = new Socio("Erick", "1726", "erickdp@hotmail.com", 0, new Date(), "041099");
		TipoServicio tipoDeSerUno = new TipoServicio(0, "Entretenimiento", "Películas, Juegos, Actividades");
		tipoServicio.add(tipoDeSerUno);
	}	
}
