package control;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manejadores.MPedidos;
import modelo.TCliente;
import modelo.TEmpleado;
import modelo.TGasto;
import modelo.TPedido;
import modelo.TVehiculo;
import ventanas.VentanaCliente;
import ventanas.VentanaGasto;
import ventanas.VentanaLEmpleados;
import ventanas.VentanaLVehiculos;
import ventanas.VentanaPOperador;
import ventanas.VentanaPedido;
import datos.TGestorDeDatos;
import enumerados.EEstadoCliente;
import enumerados.EEstadoPedido;

public class coperador {
	private VentanaPOperador ventana;
	@SuppressWarnings("unused")
	private VentanaGasto vgasto;
	@SuppressWarnings("unused")
	private VentanaCliente vcliente;
	@SuppressWarnings("unused")
	private VentanaPedido vpedido;
	@SuppressWarnings("unused")
	private VentanaLEmpleados vlempleados;
	@SuppressWarnings("unused")
	private VentanaLVehiculos vlvehiculos;

	private int indicemodf = -1;

	private TGestorDeDatos GDatos;
	@SuppressWarnings("unused")
	private MPedidos ManejadorP;

	public coperador(TGestorDeDatos GD) {
		GDatos = GD;
		ManejadorP = new MPedidos(GDatos.getDatos());

		ventana = new VentanaPOperador(this);
		actualizartablas();
	}

	// ===================GASTOS=============================================

	public void crearGasto() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vgasto = new VentanaGasto("Creación de gasto", "Crear", this);
	}

	public void modificarGasto(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_gastos().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TGasto Gasto = GDatos.getDatos().getLista_gastos().get(indice);

		ventana.getFramePrincipal().setEnabled(false);
		vgasto = new VentanaGasto("Modificación de gasto", "Modificar", this,
				Gasto);
	}

	public void quitoGasto(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_gastos().size();

		ventana.getFramePrincipal().setEnabled(false);
		if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
				"¿Está seguro que desa eliminar el gasto?") == 0) {

			TGasto Gasto = GDatos.getDatos().getLista_gastos().get(indice);

			GDatos.quitar_elemento(Gasto);
			GDatos.guardar_estado();

			actualizartgastos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	public void actualizoGasto(TGasto Gasto) {
		boolean error = false;
		// Si es una creación
		if (indicemodf == -1) {
			try {
				GDatos.agregar_elemento(Gasto);
			} catch (Exception e) {
				// NO DEBERIA OCURRIR, TODOS LOS GASTOS SON UNICOS
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al gasto ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla para que la modifique
				ventana.getFramePrincipal().setEnabled(false);
				vgasto = new VentanaGasto("Creación de gasto", "Crear", this,
						Gasto);
				error = true;
			}
		} else {
			// Si es una modificación, indicemodf es el indice del
			// elemento a modificar
			try {
				GDatos.modificar_elemento(indicemodf, Gasto);
			} catch (Exception e) {
				// NO DEBERIA OCURRIR, TODOS LOS EQUIPOS SON UNICOS
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al gasto ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vgasto = new VentanaGasto("Modificación de gasto", "Modificar",
						this, Gasto);
				error = true;
			}
		}
		if (!error) {
			// Se actualizan las tablas de gastos
			actualizartgastos();

			// Y se guarda el estado
			GDatos.guardar_estado();

			// Luego de que creo o modificó la ventana devería desaparecer
			ventana.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			ventana.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaGasto(boolean Actualizo) {
		if (Actualizo) {
			actualizartgastos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		ventana.getFramePrincipal().requestFocus();
	}

	// ===============FIN GASTOS=============================================

	// ===================CLIENTE=============================================

	public void crearCliente() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vcliente = new VentanaCliente(true, "Creación de cliente", "Crear",
				this);
	}

	public void modificarCliente(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_clientes().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TCliente Cliente = GDatos.getDatos().getLista_clientes().get(indice);

		ventana.getFramePrincipal().setEnabled(false);
		vcliente = new VentanaCliente(true, "Modificación de cliente",
				"Modificar", this, Cliente);
	}

	public void quitoCliente(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_clientes().size();

		ventana.getFramePrincipal().setEnabled(false);
		if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
				"¿Está seguro que desa eliminar el cliente?") == 0) {

			TCliente Cliente = GDatos.getDatos().getLista_clientes()
					.get(indice);
			
			//Verifica que el cliente no tenga pedidos asignados
			ArrayList<TPedido> pedidoscliente=ManejadorP.consultarPedidosDeCliente(Cliente);
			
			if (pedidoscliente.size()>0){
				Cliente.setEstado(EEstadoCliente.INACTIVO);
				GDatos.guardar_estado();
				actualizartclientes();
			}else{
				//Si no tiene pedidos asignados lo elimina
				GDatos.quitar_elemento(Cliente);
				GDatos.guardar_estado();

				actualizartclientes();
			}
		}
		ventana.getFramePrincipal().setEnabled(true);
		ventana.getFramePrincipal().requestFocus();
	}

	public void actualizoCliente(TCliente Cliente) {
		boolean error = false;
		// Si es una creación
		if (indicemodf == -1) {
			try {
				GDatos.agregar_elemento(Cliente);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al cliente ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla para que la modifique
				ventana.getFramePrincipal().setEnabled(false);
				vcliente = new VentanaCliente(true, "Creación de cliente",
						"Crear", this, Cliente);
				error = true;
			}
		} else {
			// Si es una modificación, indicemodf es el indice del
			// elemento a modificar
			try {
				GDatos.modificar_elemento(indicemodf, Cliente);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
						"La id asignada al cliente ya existe en el sistema.");
				// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
				// la pantalla
				ventana.getFramePrincipal().setEnabled(false);
				vcliente = new VentanaCliente(true, "Modificación de cliente",
						"Modificar", this, Cliente);
				error = true;
			}
		}
		if (!error) {
			// Se actualizan las tablas de clientes
			actualizartclientes();

			// Y se guarda el estado
			GDatos.guardar_estado();

			// Luego de que creo o modificó la ventana devería desaparecer
			ventana.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			ventana.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaCliente(boolean Actualizo) {
		if (Actualizo) {
			actualizartclientes();
		}
		ventana.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		ventana.getFramePrincipal().requestFocus();
	}

	// ===============FIN CLIENTE=============================================

	// ===================PEDIDO=============================================

	public void crearPedido() {
		// Le dice que no está modificando un elemento de alguna tabla
		indicemodf = -1;

		ventana.getFramePrincipal().setEnabled(false);
		vpedido = new VentanaPedido("Creación de pedido", "Crear", this);
	}

	public void modificarPedido(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_pedidos().size();

		// Se está modificando un elemento existente
		indicemodf = indice;

		TPedido Pedido = GDatos.getDatos().getLista_pedidos().get(indice);

		if (Pedido.getEstado() != EEstadoPedido.CANCELADO) {
			ventana.getFramePrincipal().setEnabled(false);
			vpedido = new VentanaPedido("Modificación de pedido", "Modificar",
					this, Pedido);
		} else {
			JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
					"El pedido ya fué cancelado.");
		}
	}

	public void quitoPedido(int indice) {
		assert indice >= 0;
		assert indice < GDatos.getDatos().getLista_pedidos().size();

		if (GDatos.getDatos().getLista_pedidos().get(indice).getEstado() != EEstadoPedido.CANCELADO) {
			ventana.getFramePrincipal().setEnabled(false);
			if (JOptionPane.showConfirmDialog(ventana.getFramePrincipal(),
					"¿Está seguro que desa cancelar el pedido?") == 0) {

				TPedido Pedido = GDatos.getDatos().getLista_pedidos().get(
						indice);

				// GDatos.quitar_elemento(Pedido);
				Pedido.setEstado(EEstadoPedido.CANCELADO);
				GDatos.guardar_estado();

				actualizartpedidos();
			}
			ventana.getFramePrincipal().setEnabled(true);
			ventana.getFramePrincipal().requestFocus();
		} else {
			JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
					"El pedido ya fué cancelado");
		}
	}

	public void actualizoPedido(TPedido Pedido) {
		boolean error = false;

		if (indicemodf != -1) {
			TPedido P = GDatos.getDatos().getLista_pedidos().get(indicemodf);
			Pedido.setId_pedido(P.getId_pedido());
		}

		// Consulta si todos los empleados y vehiculos asignados al pedido están
		// disponibles en el rango
		boolean empleadosdisp = true;
		boolean vehiculosdisp = true;
		for (TEmpleado E : Pedido.getEmpleados()) {
			empleadosdisp = empleadosdisp
					&& ManejadorP.consultarDispEmpleados(Pedido, E, Pedido
							.get_ini(), Pedido.get_fin());
		}
		;
		for (TVehiculo V : Pedido.getVehiculos()) {
			vehiculosdisp = vehiculosdisp
					&& ManejadorP.consultarDispVehiculos(Pedido, V, Pedido
							.get_fin(), Pedido.get_fin());
		}
		if ((!empleadosdisp) || (!vehiculosdisp)) {
			JOptionPane
					.showMessageDialog(
							ventana.getFramePrincipal(),
							"Algunos de los recursos asignados al pedido no están disponibles en el rango de días de su duración");
			if (indicemodf == -1) {
				ventana.getFramePrincipal().setEnabled(false);
				vpedido = new VentanaPedido("Creación de pedido", "Crear",
						this, Pedido);
			} else {
				ventana.getFramePrincipal().setEnabled(false);
				vpedido = new VentanaPedido("Modificación de pedido",
						"Modificar", this, Pedido);
			}
		} else {
			// Si es una creación
			if (indicemodf == -1) {
				try {
					GDatos.agregar_elemento(Pedido);
				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(ventana.getFramePrincipal(),
									"La id asignada al pedido ya existe en el sistema.");
					// Aca hay dos opciones, o cancela todo, o le vuelve a
					// mostrar
					// la pantalla para que la modifique
					ventana.getFramePrincipal().setEnabled(false);
					vpedido = new VentanaPedido("Creación de pedido", "Crear",
							this, Pedido);
					error = true;
				}
			} else {
				// Si es una modificación, indicemodf es el indice del
				// elemento a modificar
				try {
					GDatos.modificar_elemento(indicemodf, Pedido);
				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(ventana.getFramePrincipal(),
									"La id asignada al pedido ya existe en el sistema.");
					// Aca hay dos opciones, o cancela todo, o le vuelve a
					// mostrar
					// la pantalla
					ventana.getFramePrincipal().setEnabled(false);
					vpedido = new VentanaPedido("Modificación de pedido",
							"Modificar", this, Pedido);
					error = true;
				}
			}
			if (!error) {
				// Se actualizan las tablas de pedidos
				actualizartpedidos();

				// Y se guarda el estado
				GDatos.guardar_estado();

				// Luego de que creo o modificó la ventana devería desaparecer
				ventana.getFramePrincipal().setEnabled(true);
				// Se recupera el foco
				ventana.getFramePrincipal().requestFocus();
			}
		}
	}

	public void cerroventanaPedido(boolean Actualizo) {
		if (Actualizo) {
			actualizartpedidos();
		}
		ventana.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		ventana.getFramePrincipal().requestFocus();
	}

	public TCliente getCliente(Long DNI) {
		ArrayList<TCliente> clientes = GDatos.getDatos().getLista_clientes();
		TCliente Cliente = null;

		boolean encontro = false;
		int i = 0;
		int tam = clientes.size();

		while ((!encontro) && (i < tam)) {
			Cliente = clientes.get(i);
			encontro = (Cliente.getDni() == DNI);
			i++;
		}
		;

		if (encontro) {
			return Cliente;
		} else {
			return null;
		}
	}

	public void crearClienteEnPedido() {
		vpedido.getFramePrincipal().setEnabled(false);
		vcliente = new VentanaCliente(false, "Creación de cliente", "Crear",
				this);
	}

	public void actualizoClienteEnPedido(TCliente Cliente) {
		boolean error = false;
		// Solo puede ser una creación
		try {
			GDatos.agregar_elemento(Cliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(ventana.getFramePrincipal(),
					"La id asignada al cliente ya existe en el sistema.");
			// Aca hay dos opciones, o cancela todo, o le vuelve a mostrar
			// la pantalla para que la modifique
			vpedido.getFramePrincipal().setEnabled(false);
			vcliente = new VentanaCliente(false, "Creación de cliente",
					"Crear", this, Cliente);
			error = true;
		}

		if (!error) {
			// Se actualizan las tablas de clientes
			actualizartclientes();

			// Y se guarda el estado
			GDatos.guardar_estado();

			vpedido.setearCliente(Cliente);
			// Luego de que creo o modificó la ventana devería desaparecer
			vpedido.getFramePrincipal().setEnabled(true);
			// Se recupera el foco
			vpedido.getFramePrincipal().requestFocus();
		}
	}

	public void cerroventanaClienteEnPedido(boolean Actualizo) {
		if (Actualizo) {
			actualizartclientes();
		}
		vpedido.getFramePrincipal().setEnabled(true);
		// Se recupera el foco
		vpedido.getFramePrincipal().requestFocus();
	}

	public void anadirEmpleados(ArrayList<TEmpleado> EmpSinAsignar) {
		vpedido.getFramePrincipal().setEnabled(false);
		vlempleados = new VentanaLEmpleados(this, EmpSinAsignar);
	}

	public void anadirVehiculos(ArrayList<TVehiculo> VehSinAsignar) {
		vpedido.getFramePrincipal().setEnabled(false);
		vlvehiculos = new VentanaLVehiculos(this, VehSinAsignar);
	}

	public void anadioEmpleado(TEmpleado Empleado) {
		vpedido.agregarEmpleado(Empleado);
	}

	public void anadioVehiculo(TVehiculo Vehiculo) {
		vpedido.agregarVehiculo(Vehiculo);
	}

	public void cerroVLEmpleados() {
		vpedido.getFramePrincipal().setEnabled(true);
		vpedido.getFramePrincipal().requestFocus();
	}

	public void cerroVLVehiculos() {
		vpedido.getFramePrincipal().setEnabled(false);
		vpedido.getFramePrincipal().requestFocus();
	}

	public ArrayList<TEmpleado> getEmpleados() {
		return GDatos.getDatos().getLista_empleados();
	}

	public ArrayList<TVehiculo> getVehiculos() {
		return GDatos.getDatos().getLista_vehiculos();
	}

	// ===============FIN PEDIDO=============================================

	public void actualizartablas() {
		actualizartpedidos();
		actualizartclientes();
		actualizartgastos();
	}

	@SuppressWarnings( { "serial", "deprecation" })
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

		for (TPedido P : lista_pedidos) {
			String Cliente = P.getCliente().getNombre();
			String Origen = P.getOrigen();
			String Destino = P.getDestino();
			String Estado = P.getEstado().toString();

			Date Fechai = P.get_ini();
			String DiaI = String.valueOf(Fechai.getDate());
			String MesI = String.valueOf(Fechai.getMonth() + 1);
			String AnioI = String.valueOf(Fechai.getYear());

			Date Fechaf = P.get_fin();
			String DiaF = String.valueOf(Fechaf.getDate());
			String MesF = String.valueOf(Fechaf.getMonth() + 1);
			String AnioF = String.valueOf(Fechaf.getYear());

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
					false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		clientes.setModel(TM);
		for (TCliente Cliente : lista_clientes) {
			String Nombre = Cliente.getNombre();
			String DNI = String.valueOf(Cliente.getDni());
			String Direccion = Cliente.getDireccion();
			String Telefono = Cliente.getTelefono();
			String Estado = Cliente.getEstado().toString();
			String CUID = Cliente.getCuil_cuit();

			TM.addRow(new String[] { Nombre, DNI, CUID, Direccion, Telefono,
					Estado });
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
