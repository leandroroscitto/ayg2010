package pruebas;

import java.util.Calendar;

import modelo.TEmpleado;
import datos.TGestorDeDatos;
import enumerados.ECategoriaEmpleado;
import enumerados.EDia;
import enumerados.EEstadoEmpleado;

public class prueba {
	
	public static TGestorDeDatos g;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TEmpleado empleado = new TEmpleado(100, "Juan", "BB", "45790123",
				ECategoriaEmpleado.MOTOCICLISTA, EEstadoEmpleado.DISPONIBLE);

		g = new TGestorDeDatos();

		g.cargar_estado();

		empleado.asignar_horario(EDia.JUEVES, 1200, 1835);
		//g.dat.getLista_empleados().add(empleado);

		String cadena = g.getDatos().getLista_empleados().get(g.getDatos().getLista_empleados().size()-1).getNombre();
		System.out.print(cadena);
			
		String[] Cats = new String[ECategoriaEmpleado.values().length];
		for (ECategoriaEmpleado cat: ECategoriaEmpleado.values()){
			Cats[cat.ordinal()]=cat.toString();
			System.out.print(cat.toString());
		}
		System.out.println(Cats.toString());
		
		String[] Ests = new String[EEstadoEmpleado.values().length];
		for (EEstadoEmpleado cat: EEstadoEmpleado.values()){
			Ests[cat.ordinal()]=cat.toString();
		}
		
		@SuppressWarnings("unused")
		Prot_empleado Ventana= new Prot_empleado(Cats, Ests);
		//Ventana.notify();

		g.guardar_estado();
		
		Calendar C=Calendar.getInstance();
		C.set(1997, 10, 25);
		Calendar C1=Calendar.getInstance();
		C1.set(1997, 10, 24);
		C1.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		System.out.println(C.get(Calendar.DAY_OF_WEEK));
		System.out.println(C1.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(C1.before(C));
	}
}
