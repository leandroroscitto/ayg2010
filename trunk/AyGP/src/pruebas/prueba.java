package pruebas;

import java.util.Calendar;
import java.util.Date;

import control.cadministrador;

import modelo.TEmpleado;
import modelo.TEquipo;
import modelo.TEvento;
import datos.TGestorDeDatos;
import enumerados.ECategoriaEmpleado;
import enumerados.ECategoriaEquipo;
import enumerados.EDia;
import enumerados.EEstadoEmpleado;
import enumerados.EEstadoEquipo;

public class prueba {
	
	public static TGestorDeDatos g;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TEmpleado empleado = new TEmpleado(100,"31272448", "Juan", "BB", "45790123",
				ECategoriaEmpleado.MOTOCICLISTA, EEstadoEmpleado.DISPONIBLE);
		TEmpleado empleado2 = new TEmpleado(101,"32246441", "Pedro", "Roca", "4265541",
				ECategoriaEmpleado.MOTOCICLISTA, EEstadoEmpleado.DISPONIBLE);
		TEmpleado empleado3 = new TEmpleado(110,"193272452", "Jose", "Suarez", "151790123",
				ECategoriaEmpleado.MOTOCICLISTA, EEstadoEmpleado.DISPONIBLE);
		TEmpleado empleado4 = new TEmpleado(100,"25562282", "Gonzalo", "BB", "45790123",
				ECategoriaEmpleado.MOTOCICLISTA, EEstadoEmpleado.DISPONIBLE);
		TEquipo equipo1 = new TEquipo(1,"Radio",ECategoriaEquipo.RADIO, EEstadoEquipo.EN_REPARACION);
		TEquipo equipo2 = new TEquipo(2,"Casco Rojo",ECategoriaEquipo.CASCO, EEstadoEquipo.DISPONIBLE);
		TEquipo equipo3 = new TEquipo(3,"Casco Verde",ECategoriaEquipo.CASCO, EEstadoEquipo.NO_DISPONIBLE);
		Calendar C = Calendar.getInstance();
		C.set(2015,12,28);
		TEvento evento1 = new TEvento(1,"Fin del mundo","Fin del mundo",C);
		
		g = new TGestorDeDatos();

		g.cargar_estado();
		
		g.agregar_elemento(evento1);
		g.agregar_elemento(equipo1);
		g.agregar_elemento(equipo2);
		g.agregar_elemento(equipo3);
		g.agregar_elemento(empleado);
		g.agregar_elemento(empleado2);
		g.agregar_elemento(empleado3);
		g.agregar_elemento(empleado4);
		
		cadministrador adm= new cadministrador(g);
/*
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
		
		AltaModCliente VAltaCliente = new AltaModCliente();
		
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
		*/
	}
}
