/**
 * 
 */
package com.scoutdp.pydhotel.util;

import java.util.Scanner;

/**
 *  Clase que representa las operaciones utilitarias de lectura
 * 
 *  @version    8.0 28 feb 2019
 *  @author     Erick Díaz
 */
public class UtilLectura {
	private static Scanner leer;

	/*
	 * Método que lee desde teclado
	 * @return
	 */
	public static String leerTeclado() {
		String valorALeer = null;
		leer = new Scanner(System.in);
		// Leyendo el formato ingresado en formato cadena
		valorALeer = leer.next();
		return valorALeer;	
	}
}
