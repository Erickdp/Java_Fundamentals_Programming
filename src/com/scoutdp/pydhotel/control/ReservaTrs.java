/**
 * 
 */
package com.scoutdp.pydhotel.control;

import java.math.BigDecimal;
import java.util.List;

import com.scoutdp.pydhotel.modelo.Habitacion;
import com.scoutdp.pydhotel.modelo.MemoriaBDD;
import com.scoutdp.pydhotel.modelo.Reserva;
import com.scoutdp.pydhotel.modelo.Suite;

/**
 * Clase que implementa la interfaz CRUD usando coleciones para la Reserva
 * 
 * @version 8.0 17 mar 2019
 * @author Erick Díaz
 */
public class ReservaTrs implements ICrudC {

	@Override
	public String guardar(Object registro) {
		MemoriaBDD.reservas.add((Reserva) registro);
		return "        * * * * * *  ";
	}

	/*
	 * Método que permite eliminar un objeto según su id ya que independiente de sus
	 * argumentos serán iguales si su ID es igual (non-Javadoc)
	 * 
	 * @see com.scoutdp.pydhotel.control.ICrudC#eliminar(java.lang.Object)
	 */
	@Override
	public String eliminar(Object registro) {
		Reserva eliRes = (Reserva) registro;
		String mensaje = "NO SE PUDO ELIMINAR LA RESERVA";
		for (Reserva busRes : MemoriaBDD.reservas) {
			if (eliRes.equals(busRes)) {
				MemoriaBDD.reservas.remove(busRes);
				mensaje = "RESERVA ELIMINADA CORRECTAMENTE";
				break;
			}
		}
		return mensaje;
	}

	/*
	 * Método que permite actualizar la fecha de ingreso/salida de un Objeto de tipo
	 * Reserva. Lo que se intentó es : 1. Realizar un cast del registro el cául
	 * tiene completo sus campos de fechaReserva, fechaRetiro, número de Reserva,
	 * las habitaciones o suites están en null, 2. Se recorre el ArrayList hasta que
	 * con el método equals el cúal compara objetos de tipo Reserva según solamente
	 * su ID 3. Encontrado el ID de dos objetos iguales se pasa a la codición de que
	 * si su tipo de dato referencial Habitacion O Suite están vacíos realizar
	 * alguno de los apartados pues el ID puede ser 1 y no haber reservado una Suite
	 * sino una Habitación o viceversa por eso se realiza ese argumento lógico. 4.
	 * Con los 2 Objetos encontrados se prodigue a que el Objeto "antiguo" mediante
	 * el método seter obtenga únicamente la fecha de entrada/salida del objeto
	 * "nuevo" para así el objeto "antiguo" obtener una nueva fecha. 5. Se rompe la
	 * iteración si ocurrió alguno de los apartados (non-Javadoc)
	 * 
	 * @see com.scoutdp.pydhotel.control.ICrudC#actualizar(java.lang.Object)
	 */
	@Override
	public String actualizar(Object registro) {
		Reserva reservaN = (Reserva) registro;
		String resp = null;
		for (Reserva reservaV : MemoriaBDD.reservas) {
			if (reservaN.equals(reservaV) && reservaV.getHabitacionReservada() != null) {
				reservaV.setFechaDeEstancia(reservaN.getFechaDeEstancia());
				reservaV.setFechaDeRetiro(reservaN.getFechaDeRetiro());
				resp = "Reserva De Habitación Actualizada Correctamente";
				break;
			} else if (reservaN.equals(reservaV) && reservaV.getSuiteReservada() != null) {
				reservaV.setFechaDeEstancia(reservaN.getFechaDeEstancia());
				reservaV.setFechaDeRetiro(reservaN.getFechaDeRetiro());
				resp = "Reserva De Suite Actualizada Correctamente";
				break;
			}
		}
		return resp;
	}

	@Override
	public List<?> listar() { // Usar enves del for - each que hay en la clase frmreserva, agregar.
		return MemoriaBDD.reservas;
	}

	@Override
	public Object consultar(int id) throws MiExcepcion{
		int contador = 0;
		Object numReserva = null;
		boolean bandera = false;
		for (Reserva reserva : MemoriaBDD.reservas) {
			if (reserva.getIdReserva() == id) {
				numReserva = MemoriaBDD.reservas.get(contador);
				bandera = true;
				break;
			} else {
				contador++;
			}
		}
		if (bandera) {
			return numReserva;
		} else {
			throw new MiExcepcion();
		}
	}

	/*
	 * Método que permitirá determinar si dos objetos son iguales según su ID de
	 * reserva
	 */
	public String reservaRepetida(Object reservaNueva) throws MiExcepcion{
		boolean bandera = false;
		String mensaje = null;
		for (Reserva reservaRepetida : MemoriaBDD.reservas) { // Con este for permite buscar entre el ArrayList
			if (reservaNueva.equals(reservaRepetida)) {
				bandera = true;
				break;
			}
		}
		if (bandera) {
			throw new MiExcepcion();
		} else {
			return mensaje;
		}
		
	}

	public BigDecimal realizarTotal(Reserva reserva) {
		BigDecimal total = new BigDecimal("10.0");
		BigDecimal totalD = new BigDecimal("10.5"); // Número
		BigDecimal totalB = new BigDecimal("8.9"); // Número
		BigDecimal totalC = new BigDecimal("20.0"); // Tamaño
		BigDecimal totalTv = new BigDecimal("50.80"); // Tamaño

		Habitacion habitacion = reserva.getHabitacionReservada();
		Suite suite = reserva.getSuiteReservada();
		if (suite != null) {
			if (suite.getGym().equalsIgnoreCase("si")) {
				total = total.add(new BigDecimal("50.0"));
			} else if (suite.getBal().equalsIgnoreCase("si")) {
				total = total.add(new BigDecimal("60.50"));
			} else if (suite.getSala().equalsIgnoreCase("si")) {
				total = total.add(new BigDecimal("100.0"));
			} else if (suite.getAireAcon().equalsIgnoreCase("si")) {
				total = total.add(new BigDecimal("70.0"));
			} else if (suite.getNumeroDormi() >= 1) {
				total = total.add(new BigDecimal("70.0").multiply(new BigDecimal(suite.getNumeroDormi())));
			} else if (suite.getNumeroBano() >= 1) {
				total = total.add(new BigDecimal("25.0").multiply(new BigDecimal(suite.getNumeroBano())));
			} else if (suite.getTamanoCama().equalsIgnoreCase("Grande")) {
				total = total.add(totalC.add(new BigDecimal("50.5")));
			} else if (suite.getTenerCocina().equalsIgnoreCase("si")) {
				total = total.add(new BigDecimal("30.5"));
			} else if (suite.getTamanoTv().equalsIgnoreCase("Grande")) {
				total = total.add(totalTv);
			}
		} else {
			if (habitacion.getNumeroDormi() >= 1) {
				total = total.add(totalD.multiply(new BigDecimal(habitacion.getNumeroDormi())));
			} else if (habitacion.getNumeroBano() >= 1) {
				total = total.add(totalB.multiply(new BigDecimal(habitacion.getNumeroBano())));
			} else if (habitacion.getTamanoCama().equalsIgnoreCase("Grande")
					| habitacion.getTamanoCama().equalsIgnoreCase("G")) {
				total = total.add(totalC.add(new BigDecimal("30.50")));
			} else if (habitacion.getTamanoCama().equalsIgnoreCase("Mediana")
					| habitacion.getTamanoCama().equalsIgnoreCase("mediano")
					| habitacion.getTamanoCama().equalsIgnoreCase("m")) {
				total = total.add(totalC.add(new BigDecimal("20")));
			} else if (habitacion.getTamanoTv().equalsIgnoreCase("Grande")
					| habitacion.getTamanoTv().equalsIgnoreCase("G")) {
				total = total.add(totalTv.add((new BigDecimal("10"))));
			} else if (habitacion.getTenerCocina().equalsIgnoreCase("si")) {
				total = total.add(new BigDecimal("30.5"));
			}
		}
		return total;
	}
	
	public void reservaRepetida2(Object reservaNueva) throws MiExcepcion2 {
		boolean bandera = false;
		for (Reserva reservaRepetida : MemoriaBDD.reservas) { // Con este for permite buscar entre el ArrayList
			if (reservaNueva.equals(reservaRepetida)) {
				bandera = true;
				break;
			}
		}
		if (!bandera) {
			throw new MiExcepcion2();
		}
	}
}
