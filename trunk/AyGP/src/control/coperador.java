package control;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.TCliente;
import modelo.TGasto;
import modelo.TPedido;
import ventanas.VentanaPOperador;
import datos.TGestorDeDatos;

public class coperador {

	private VentanaPOperador ventana;

	private TGestorDeDatos GDatos;

	public coperador(TGestorDeDatos GD) {
		GDatos = GD;

		ventana = new VentanaPOperador();
		actualizartablas();

	}

	public void actualizartablas() {
		actualizartpedidos();
		actualizartclientes();
		actualizartgastos();
	}

	@SuppressWarnings("serial")
	public void actualizartpedidos() {
		ArrayList<TPedido> lista_pedidos = GDatos.getDatos().getLista_pedidos();
		JTable pedidos = ventana.getTPedidos();

		pedidos.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Cliente",
				"Origen", "Destino", "Estado", "Fecha Ini", "Fecha Fin" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false,
					false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		pedidos.setModel(TM);

		String months[] = { "Diciembre", "Enero", "Febrero", "Marzo", "Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
				"Noviembre" };

		for (TPedido P : lista_pedidos) {
			String Cliente = P.getCliente().getNombre();
			String Origen = P.getOrigen();
			String Destino = P.getDestino();
			String Estado = P.getEstado().toString();

			Calendar Fechai = P.get_ini();
			String DiaI = String.valueOf(Fechai.get(Calendar.DATE));
			String MesI = months[Fechai.get(Calendar.MONTH)];
			String AnioI = String.valueOf(Fechai.get(Calendar.YEAR));

			Calendar FechaF = P.get_fin();
			String DiaF = String.valueOf(FechaF.get(Calendar.DATE));
			String MesF = months[FechaF.get(Calendar.MONTH)];
			String AnioF = String.valueOf(FechaF.get(Calendar.YEAR));

			TM.addRow(new String[] { Cliente, Origen, Destino, Estado,
					DiaI + "/" + MesI + "/" + AnioI,
					DiaF + "/" + MesF + "/" + AnioF });
		}
	}

	@SuppressWarnings("serial")
	public void actualizartclientes() {
		ArrayList<TCliente> lista_clientes = GDatos.getDatos()
				.getLista_clientes();
		JTable clientes = ventana.getTClientes();

		clientes.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Nombre",
				"DNI", "CUIT/CUIL", "Dirección", "Teléfono", "Estado" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false,
					false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		clientes.setModel(TM);
		for (TCliente Cliente : lista_clientes) {
			String Nombre=Cliente.getNombre();
			String DNI = Cliente.getDni();
			String Direccion=Cliente.getDireccion();
			String Telefono=Cliente.getTelefono();
			String Estado = Cliente.getEstado().toString();
			String CUID = Cliente.getCuil_cuit();
			
			TM.addRow(new String[] { Nombre,DNI,CUID,Direccion,Telefono,Estado});
		}
	}

	@SuppressWarnings("serial")
	public void actualizartgastos() {
		ArrayList<TGasto> lista_gastos = GDatos.getDatos().getLista_gastos();
		JTable gastos = ventana.getTGastos();

		gastos.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Id",
				"Categoría de Servicio", "Nombre", "Monto" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false,
					false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		gastos.setModel(TM);
		for (TGasto Gasto : lista_gastos) {
			String ID = String.valueOf(Gasto.getId_gasto());
			String Categoria = Gasto.getCategoria().toString();
			String Nombre = Gasto.getNombre();
			String Monto = String.valueOf(Gasto.getMonto());

			TM.addRow(new String[] { ID, Categoria, Nombre, Monto });
		}
	}
}
