package pruebas;

import control.cadministrador;
import control.coperador;
import datos.TGestorDeDatos;

public class prueba {

	public static TGestorDeDatos g;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	
		TEmpleado empleado = new TEmpleado(100, 31272448, "Juan", "BB",
				"45790123", ECategoriaEmpleado.MOTOCICLISTA,
				EEstadoEmpleado.DISPONIBLE,1);
		TEmpleado empleado2 = new TEmpleado(101, 32246441, "Pedro", "Roca",
				"4265541", ECategoriaEmpleado.MOTOCICLISTA,
				EEstadoEmpleado.LICENCIA_ENFERMEDAD,2);
		TEmpleado empleado3 = new TEmpleado(110, 19327245, "Jose", "Suarez",
				"151790123", ECategoriaEmpleado.CICLISTA,
				EEstadoEmpleado.DISPONIBLE,3);
		TEmpleado empleado4 = new TEmpleado(200, 25562282, "Gonzalo", "BB",
				"45790123", ECategoriaEmpleado.CHOFER,
				EEstadoEmpleado.NO_DISPONIBLE,4);
		TEquipo equipo1 = new TEquipo(1, "Radio", ECategoriaEquipo.RADIO,
				EEstadoEquipo.EN_REPARACION);
		TEquipo equipo2 = new TEquipo(2, "Casco Rojo", ECategoriaEquipo.CASCO,
				EEstadoEquipo.DISPONIBLE);
		TEquipo equipo3 = new TEquipo(3, "Casco Verde", ECategoriaEquipo.CASCO,
				EEstadoEquipo.NO_DISPONIBLE);
		Calendar C = Calendar.getInstance();
		//C.set(2000, 02, 30);
		TEvento evento1 = new TEvento(1, "Fin del mundo", "Fin del mundo", C.getTime());
		TVehiculo V1= new TVehiculo("ABC123","Ford","Falcon","Rojo",123,EEstadoVehiculo.EN_REPARACION,ETipoVehiculo.CAMIONETA,1);
		TVehiculo V2= new TVehiculo("ABC523","Subaru","Impreza","Azul",123,EEstadoVehiculo.RETENIDO_INFRACCIONES,ETipoVehiculo.COCHE,2);
		TGasto G1 = new TGasto(123,"Nose",ECategoriaPedido.FLETES,"Nose que poner",(float) 12.3);
		TGasto G2 = new TGasto(321,"Igual",ECategoriaPedido.REMISERIA,"Igual que antes",(float) 4.58);
		TCliente Cl1 = new TCliente("Carlos","BB","1231234","465464","13-131231231-21",1);
		TCliente Cl2 = new TCliente("Lenny","AA","1231234","31272431","13-13145231-21",2);
		TPedido Pd1 = new TPedido(1,"Bahia Blanca","Buenos Aires",EEstadoPedido.DEMORADO,C,C,Cl1);
		TPedido Pd2 = new TPedido(2,"Buenos Blanca","Blanca Aires",EEstadoPedido.EN_ESPERA,C,C,Cl2);
		*/
		
		g = new TGestorDeDatos();

		g.cargar_estado();
		
		/*
		try {
			g.agregar_elemento(evento1);
			g.agregar_elemento(equipo1);
			g.agregar_elemento(equipo2);
			g.agregar_elemento(equipo3);
			g.agregar_elemento(empleado);
			g.agregar_elemento(empleado2);
			g.agregar_elemento(empleado3);
			g.agregar_elemento(empleado4);
			g.agregar_elemento(V1);
			g.agregar_elemento(V2);
			g.agregar_elemento(G1);
			g.agregar_elemento(G2);
			g.agregar_elemento(Cl1);
			g.agregar_elemento(Cl2);
			g.agregar_elemento(Pd1);
			g.agregar_elemento(Pd2);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		*/
		cadministrador c1 = new cadministrador("Prueba",g);
		coperador c = new coperador("Prueba",g); 	
		
		g.guardar_estado();
		
		/*@SuppressWarnings("unused")
		cadministrador adm = new cadministrador(g);
		@SuppressWarnings("unused")
		coperador ope = new coperador(g);
		*/
		/*
		 * empleado.asignar_horario(EDia.JUEVES, 1200, 1835);
		 * //g.dat.getLista_empleados().add(empleado);
		 * 
		 * String cadena =
		 * g.getDatos().getLista_empleados().get(g.getDatos().getLista_empleados().size()-1).getNombre();
		 * System.out.print(cadena);
		 * 
		 * String[] Cats = new String[ECategoriaEmpleado.values().length]; for
		 * (ECategoriaEmpleado cat: ECategoriaEmpleado.values()){
		 * Cats[cat.ordinal()]=cat.toString(); System.out.print(cat.toString()); }
		 * System.out.println(Cats.toString());
		 * 
		 * String[] Ests = new String[EEstadoEmpleado.values().length]; for
		 * (EEstadoEmpleado cat: EEstadoEmpleado.values()){
		 * Ests[cat.ordinal()]=cat.toString(); }
		 * 
		 * AltaModCliente VAltaCliente = new AltaModCliente();
		 * 
		 * @SuppressWarnings("unused") Prot_empleado Ventana= new
		 * Prot_empleado(Cats, Ests); //Ventana.notify();
		 * 
		 * g.guardar_estado();
		 * 
		 * Calendar C=Calendar.getInstance(); C.set(1997, 10, 25); Calendar
		 * C1=Calendar.getInstance(); C1.set(1997, 10, 24);
		 * C1.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		 * 
		 * System.out.println(C.get(Calendar.DAY_OF_WEEK));
		 * System.out.println(C1.get(Calendar.DAY_OF_WEEK));
		 * 
		 * System.out.println(C1.before(C));
		 */
	}
}
