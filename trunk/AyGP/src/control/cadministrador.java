package control;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.TEmpleado;
import modelo.TEquipo;
import modelo.TEvento;
import modelo.THorario;
import modelo.TVehiculo;
import modelo.THorario.TRangoHorario;
import ventanas.VentanaEmpleado;
import ventanas.VentanaEquipo;
import ventanas.VentanaEvento;
import ventanas.VentanaHorarios;
import ventanas.VentanaPAdministrador;
import ventanas.VentanaVehiculo;
import datos.TGestorDeDatos;
import enumerados.EDia;
import enumerados.EEstadoEmpleado;

public class cadministrador {
	private VentanaPAdministrador ventana;
	private VentanaEmpleado vempleado;
	@SuppressWarnings("unused")
	private VentanaHorarios vhorarios;
	@SuppressWarnings("unused")
	private VentanaVehiculo vvehiculo;
	@SuppressWarnings("unused")
	private VentanaEquipo vequipo;
	@SuppressWarnings("unused")
	private VentanaEvento vevento;

	private int indicemodf = -1;

	private TGestorDeDatos GDatos;

	public cadministrador(String NomUsa,TGestorDeDatos GD) {
		GDatos = GD;

		ventana = new VentanaPAdministrador(NomUsa,this);
		actualizartablas();
	}

	// ===================EMPLEADOS===========================================

	public void crearEmpleado() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vempleado = new VentanaEmpleado("Creación de empleado", "Crear", this);
	}

	public void modificarEmpleado(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_empleados().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TEmpleado Empleado = GDatos.getDatos().getLista_empleados().get(indice);

		ventana.getFramePrincipal().setEnabled(false);
		vempleado = new VentanaEmpleado("Modificación de empleado",
				"Modificar", this, Empleado);
		actualizarthorarios();
	}

	public void quitoEmpleado(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_empleados().size();

		ventana.getFramePrincipal().setEnabled(false);
		if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
				"¿Está seguro que desa eliminar el empleado?") == 0) {

			TEmpleado Empleado = GDatos.getDatos().getLista_empleados().get(
					indice);

			//GDatos.quitar_elemento(Empleado);
			Empleado.setEstado(EEstadoEmpleado.NO_DISPONIBLE);
			GDatos.guardar_estado();

			actualizartempleados();
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	public void actualizoEmpleado(TEmpleado Empleado) {
		boolean error = false;
		// Si es una creación
		if (indicemodf == -1) {
			try {
				GDatos.agregar_elemento(Empleado);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"El legajo ingresado ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vempleado = new VentanaEmpleado("Creación de empleado",
						"Crear", this, Empleado);
				actualizarthorarios();
				error = true;
			}
		} else {
			// Si es una modificación, indicemodf es el indice del
			// elemento a modificar
			try {
				GDatos.modificar_elemento(indicemodf, Empleado);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"El legajo ingresado ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vempleado = new VentanaEmpleado("Modificación de empleado",
						"Modificar", this, Empleado);
				actualizarthorarios();
				error = true;
			}
		}
		if (!error) {
			// Se actualizan las tablas de empleados
			actualizartempleados();

			// Y se guarda el estado
			GDatos.guardar_estado();

			// Luego de que creo o modificó la ventana devería desaparecer
			ventana.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			ventana.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaEmpleado(boolean Actualizo) {
		if (Actualizo) {
			actualizartempleados();
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	// ==================HORARIOS=============================================

	public void crearHorario() {
		vempleado.getFramePrincipal().setEnabled(false);
		vhorarios = new VentanaHorarios(this);
	}

	public void quitoHorario(int indice) {
		assert indice >= 0;

		THorario horarios = vempleado.getHorarioLocal();

		horarios.quitar_rango_horario(indice);

		actualizarthorarios();
	}

	public void creoHorario(EDia Dia, int HI, int HF) {
		vempleado.agregarRHorario(Dia, HI, HF);
		actualizarthorarios();
		vempleado.getFramePrincipal().setEnabled(true);
		vempleado.getFramePrincipal().requestFocus();
	}

	public void cerroventanaHorarios() {
		vempleado.getFramePrincipal().setEnabled(true);
		vempleado.getFramePrincipal().requestFocus();
	}

	private String rellenarint(int i) {
		if (i < 10) {
			return ("0" + i);
		} else {
			return String.valueOf(i);
		}
	}

	@SuppressWarnings("serial")
	public void actualizarthorarios() {
		THorario Horario = vempleado.getHorarioLocal();
		JTable thorario = vempleado.getTHorarios();

		thorario.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Dia",
				"Entrada", "Salida" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		thorario.setModel(TM);

		int HoraI, HoraF, MinI, MinF;
		String HoraIS, HoraFS, MinIS, MinFS;
		for (TRangoHorario rango : Horario.getAsignacion()) {
			HoraI = rango.getHoraIni() / 100;
			MinI = rango.getHoraIni() % 100;
			HoraF = rango.getHoraFin() / 100;
			MinF = rango.getHoraFin() % 100;
			HoraIS = rellenarint(HoraI);
			MinIS = rellenarint(MinI);
			HoraFS = rellenarint(HoraF);
			MinFS = rellenarint(MinF);

			TM.addRow(new Object[] { rango.getDia(), HoraIS + ":" + MinIS,
					HoraFS + ":" + MinFS });
		}
	}

	// ==============FIN HORARIOS=============================================

	// ===============FIN EMPLEADOS===========================================

	// ===================VEHICULOS===========================================

	public void crearVehiculo() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vvehiculo = new VentanaVehiculo("Creación de vehículo", "Crear", this);
	}

	public void modificarVehiculo(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_vehiculos().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TVehiculo Vehiculo = GDatos.getDatos().getLista_vehiculos().get(indice);

		ventana.getFramePrincipal().setEnabled(false);
		vvehiculo = new VentanaVehiculo("Modificación de vehículo",
				"Modificar", this, Vehiculo);
	}

	public void quitoVehiculo(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_empleados().size();

		ventana.getFramePrincipal().setEnabled(false);
		if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
				"¿Está seguro que desa eliminar el vehículo?") == 0) {

			TVehiculo Vehiculo = GDatos.getDatos().getLista_vehiculos().get(
					indice);

			GDatos.quitar_elemento(Vehiculo);
			GDatos.guardar_estado();

			actualizartvehiculos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	public void actualizoVehiculo(TVehiculo Vehiculo) {
		boolean error = false;
		// Si es una creación
		if (indicemodf == -1) {
			try {
				GDatos.agregar_elemento(Vehiculo);
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(ventana.getFramePrincipal(),
								"La patente asignada al vehículo ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla para que la modifique
				ventana.getFramePrincipal().setEnabled(false);
				vvehiculo = new VentanaVehiculo("Creación de vehículo",
						"Crear", this, Vehiculo);
				error = true;
			}
		} else {
			// Si es una modificación, indicemodf es el indice del
			// elemento a modificar
			try {
				GDatos.modificar_elemento(indicemodf, Vehiculo);
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(ventana.getFramePrincipal(),
								"La patente asignada al vehículo ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vvehiculo = new VentanaVehiculo("Modificación de vehículo",
						"Modificar", this, Vehiculo);
				error = true;
			}
		}
		if (!error) {
			// Se actualizan las tablas de empleados
			actualizartvehiculos();

			// Y se guarda el estado
			GDatos.guardar_estado();

			// Luego de que creo o modificó la ventana devería desaparecer
			ventana.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			ventana.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaVehiculo(boolean Actualizo) {
		if (Actualizo) {
			actualizartvehiculos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		ventana.getFramePrincipal().requestFocus();
	}

	// ===============FIN VEHICULOS===========================================

	// ===================EQUIPOS=============================================

	public void crearEquipo() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vequipo = new VentanaEquipo("Creación de equipo", "Crear", this);
	}

	public void modificarEquipo(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_equipos().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TEquipo Equipo = GDatos.getDatos().getLista_equipos().get(indice);

		ventana.getFramePrincipal().setEnabled(false);
		vequipo = new VentanaEquipo("Modificación de equipo", "Modificar",
				this, Equipo);
	}

	public void quitoEquipo(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_equipos().size();

		ventana.getFramePrincipal().setEnabled(false);
		if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
				"¿Está seguro que desa eliminar el equipo?") == 0) {

			TEquipo Equipo = GDatos.getDatos().getLista_equipos().get(indice);

			GDatos.quitar_elemento(Equipo);
			GDatos.guardar_estado();

			actualizartequipos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	public void actualizoEquipo(TEquipo Equipo) {
		boolean error = false;
		// Si es una creación
		if (indicemodf == -1) {
			try {
				GDatos.agregar_elemento(Equipo);
			} catch (Exception e) {
				// NO DEBERIA OCURRIR, TODOS LOS EQUIPOS SON UNICOS
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al equipo ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla para que la modifique
				ventana.getFramePrincipal().setEnabled(false);
				vequipo = new VentanaEquipo("Creación de equipo", "Crear",
						this, Equipo);
				error = true;
			}
		} else {
			// Si es una modificación, indicemodf es el indice del
			// elemento a modificar
			try {
				GDatos.modificar_elemento(indicemodf, Equipo);
			} catch (Exception e) {
				// NO DEBERIA OCURRIR, TODOS LOS EQUIPOS SON UNICOS
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al equipo ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vequipo = new VentanaEquipo("Modificación de equipo",
						"Modificar", this, Equipo);
				error = true;
			}
		}
		if (!error) {
			// Se actualizan las tablas de empleados
			actualizartequipos();

			// Y se guarda el estado
			GDatos.guardar_estado();

			// Luego de que creo o modificó la ventana devería desaparecer
			ventana.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			ventana.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaEquipo(boolean Actualizo) {
		if (Actualizo) {
			actualizartvehiculos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		ventana.getFramePrincipal().requestFocus();
	}

	// ===============FIN EQUIPOS=============================================

	// ===================EVENTOS=============================================

	public void crearEvento() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vevento = new VentanaEvento("Creación de eventos", "Crear", this);
	}

	public void modificarEvento(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_eventos().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TEvento Evento = GDatos.getDatos().getLista_eventos().get(indice);

		ventana.getFramePrincipal().setEnabled(false);
		vevento = new VentanaEvento("Modificación de evento", "Modificar",
				this, Evento);
	}

	public void quitoEvento(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_eventos().size();

		ventana.getFramePrincipal().setEnabled(false);
		if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
				"¿Está seguro que desa eliminar el evento?") == 0) {

			TEvento Evento = GDatos.getDatos().getLista_eventos().get(indice);

			GDatos.quitar_elemento(Evento);
			GDatos.guardar_estado();

			actualizarteventos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	public void actualizoEvento(TEvento Evento) {
		boolean error = false;
		// Si es una creación
		if (indicemodf == -1) {
			try {
				GDatos.agregar_elemento(Evento);
			} catch (Exception e) {
				// NO DEBERIA OCURRIR, TODOS LOS EQUIPOS SON UNICOS
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al evento ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla para que la modifique
				ventana.getFramePrincipal().setEnabled(false);
				vevento = new VentanaEvento("Creación de evento", "Crear",
						this, Evento);
				error = true;
			}
		} else {
			// Si es una modificación, indicemodf es el indice del
			// elemento a modificar
			try {
				GDatos.modificar_elemento(indicemodf, Evento);
			} catch (Exception e) {
				// NO DEBERIA OCURRIR, TODOS LOS EQUIPOS SON UNICOS
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al evento ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vevento = new VentanaEvento("Modificación de evento",
						"Modificar", this, Evento);
				error = true;
			}
		}
		if (!error) {
			// Se actualizan las tablas de empleados
			actualizarteventos();

			// Y se guarda el estado
			GDatos.guardar_estado();

			// Luego de que creo o modificó la ventana devería desaparecer
			ventana.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			ventana.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaEvento(boolean Actualizo) {
		if (Actualizo) {
			actualizarteventos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		ventana.getFramePrincipal().requestFocus();
	}

	// ===============FIN EVENTOS=============================================

	// ===================VENTANA PRINCIPAL===================================

	public void actualizartablas() {
		actualizartempleados();
		actualizartequipos();
		actualizarteventos();
		actualizartvehiculos();
	}

	@SuppressWarnings("serial")
	public void actualizartempleados() {
		ArrayList<TEmpleado> lista_empleados = GDatos.getDatos()
				.getLista_empleados();
		JTable empleados = ventana.getTEmpleados();

		empleados.removeAll();

		DefaultTableModel TM = new DefaultTableModel(
				new String[] { "Legajo", "DNI", "Nombre", "Dirección",
						"Teléfono", "Categoria", "Estado" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false,
					false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		empleados.setModel(TM);
		for (TEmpleado E : lista_empleados) {
			/*
			 * TODO:VER SI ES NECESARIO String legajos =
			 * String.valueOf(E.getLegajo()); String dnis = E.getDni(); String
			 * nombres = E.getNombre(); String direccions = E.getDireccion();
			 * String telefonos = E.getTelefono(); String estados =
			 * E.getEstado().toString(); String categorias =
			 * E.getCategoria().toString(); TM.addRow(new String[] { legajos,
			 * dnis, nombres, direccions, telefonos, categorias, estados });
			 */
			TM.addRow(new Object[] { E.getLegajo(), E.getDni(), E.getNombre(),
					E.getDireccion(), E.getTelefono(), E.getCategoria(),
					E.getEstado() });
		}
	}

	@SuppressWarnings("serial")
	public void actualizartequipos() {
		ArrayList<TEquipo> lista_equipos = GDatos.getDatos().getLista_equipos();
		JTable equipos = ventana.getTEquipos();

		equipos.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "ID",
				"Nombre", "Tipo", "Estado" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false,
					false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		equipos.setModel(TM);
		for (TEquipo E : lista_equipos) {
			String id = String.valueOf(E.getId_equipo());
			String nombres = E.getNombre();
			String tipos = E.getTipo_equipo().toString();
			String estados = E.getEstado().toString();
			TM.addRow(new String[] { id, nombres, tipos, estados });
		}
	}

	@SuppressWarnings( { "serial", "deprecation" })
	public void actualizarteventos() {
		ArrayList<TEvento> lista_eventos = GDatos.getDatos().getLista_eventos();
		JTable eventos = ventana.getTEventos();

		eventos.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "ID",
				"Nombre", "Fecha" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		eventos.setModel(TM);
		for (TEvento E : lista_eventos) {
			String id = String.valueOf(E.getId_evento());
			String nombres = E.get_nombre();
			Date fecha = E.getFecha();

			int Dia = fecha.getDate();
			int Mes = fecha.getMonth() + 1;
			int Anio = fecha.getYear();

			if (Anio > 100) {
				// Es despues de 2000
				Anio = Anio - 100;
			} // Es antes del 2000

			String DiaS;
			String MesS;
			String AnioS;
			if (Dia < 10) {
				DiaS = "0" + String.valueOf(Dia);
			} else {
				DiaS = String.valueOf(Dia);
			}
			if (Mes < 10) {
				MesS = "0" + String.valueOf(Mes);
			} else {
				MesS = String.valueOf(Mes);
			}
			if (Anio < 10) {
				AnioS = "0" + String.valueOf(Anio);
			} else {
				AnioS = String.valueOf(Anio);
			}

			TM.addRow(new String[] { id, nombres,
					DiaS + "/" + MesS + "/" + AnioS });
		}
	}

	@SuppressWarnings("serial")
	public void actualizartvehiculos() {
		ArrayList<TVehiculo> lista_vehiculos = GDatos.getDatos()
				.getLista_vehiculos();
		JTable vehiculos = ventana.getTVehiculos();

		vehiculos.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Patente",
				"Color", "Estado", "Tipo", "Kilometraje", "Marca", "Modelo" },
				0) {
			boolean[] columnEditable = new boolean[] { false, false, false,
					false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		vehiculos.setModel(TM);
		for (TVehiculo V : lista_vehiculos) {
			String Patente = V.getPatente();
			String Color = V.getColor();
			String Estado = V.getEstado().toString();
			String Tipo = V.getTipoVehiculo().toString();
			String Kilometraje = String.valueOf(V.getKilometraje());
			String Marca = V.getMarca();
			String Modelo = V.getModelo();

			TM.addRow(new String[] { Patente, Color, Estado, Tipo, Kilometraje,
					Marca, Modelo });
		}
	}

	// ===============FIN VENTANA PRINCIPAL===================================
}
