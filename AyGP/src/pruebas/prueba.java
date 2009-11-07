package pruebas;

import datos.TGestorDeDatos;
import enumerados.*;
import modelo.*;

public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TEmpleado empleado = new TEmpleado(100, "Juan", "BB", "45790123",
				ECategoriaEmpleado.MOTOCICLISTA, EEstadoEmpleado.DISPONIBLE);

		TGestorDeDatos g = new TGestorDeDatos();

		g.cargar_estado();

		empleado.asignar_horario(EDia.JUEVES, 1200, 1835);
		g.dat.getLista_empleados().add(empleado);

		String cadena = g.dat.getLista_empleados().get(0).getRangosHorarios(
				EDia.JUEVES).get(0);
		System.out.print(cadena);

		g.guardar_estado();
	}
}
