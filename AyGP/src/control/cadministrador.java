package control;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.TEmpleado;
import modelo.TEquipo;
import modelo.TEvento;
import datos.TGestorDeDatos;
import sun.util.resources.LocaleNames_es;
import ventanas.VentanaPAdministrador;

public class cadministrador {
	private VentanaPAdministrador ventana;

	private TGestorDeDatos GDatos;

	public cadministrador(TGestorDeDatos GD) {
		GDatos = GD;

		ventana = new VentanaPAdministrador();
		// ventana.initComponents();
		System.out.println("C");
		actualizartablas();

	}

	public void actualizartablas() {
		actualizartempleados();
		actualizartequipos();
		actualizarteventos();
	}

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
			String legajos = String.valueOf(E.getLegajo());
			String dnis = E.getDni();
			String nombres = E.getNombre();
			String direccions = E.getDireccion();
			String telefonos = E.getTelefono();
			String estados = E.getEstado().toString();
			String categorias = E.getCategoria().toString();
			TM.addRow(new String[] { legajos, dnis, nombres, direccions,
					telefonos, estados, categorias });
		}
	}

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
			Calendar fecha = E.getFecha();

			String months[] = { "Diciembre", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
					"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre" };

			String Dia = String.valueOf(fecha.get(Calendar.DATE));
			System.out.print(fecha.get(Calendar.DATE));
			String Mes = months[fecha.get(Calendar.MONTH)];
			System.out.print(fecha.get(Calendar.MONTH));
			String Anio = String.valueOf(fecha.get(Calendar.YEAR));
			System.out.print(fecha.get(Calendar.YEAR));
			TM
					.addRow(new String[] { id, nombres,
							Dia + " de " + Mes + " del " + Anio });
		}
	}
}
