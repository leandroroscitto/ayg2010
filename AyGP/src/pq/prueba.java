package pq;

public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TEmpleado empleado = new TEmpleado(100, "Juan", "BB", "45790123",
				tipo_categoria_empleado.MOTOCICLISTA,
				tipo_estado_empleado.DISPONIBLE);

		GestorDeDatos g = new GestorDeDatos();

		g.cargar_estado();
		
		System.out.printf("%s", g.dat.getLista_empleados().get(0).getRangosHorarios(TDia.LUNES));		
		
		empleado=g.dat.getLista_empleados().get(0);
		
		g.quitar_elemento(empleado);

		g.guardar_estado();

	}
}
