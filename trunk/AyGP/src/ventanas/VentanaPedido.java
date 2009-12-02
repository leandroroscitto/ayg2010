package ventanas;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.TCliente;
import modelo.TEmpleado;
import modelo.TPedido;
import modelo.TVehiculo;

import com.toedter.calendar.JDateChooser;

import control.coperador;
import enumerados.ECategoriaPedido;
import enumerados.EEstadoCliente;
import enumerados.EEstadoPedido;

public class VentanaPedido {
	private coperador controlador;
	private TCliente cliente;
	private ArrayList<TEmpleado> empleadosasig;
	private ArrayList<TVehiculo> vehiculosasig;
	private ArrayList<TEmpleado> empleadosSinasig;
	private ArrayList<TVehiculo> vehiculosSinasig;

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActPedido;

	private JScrollPane SPAtributosP;

	private JPanel PAtributosP;

	private JLabel LOrigen;

	private JTextField TFOrigen;

	private JLabel LDestino;

	private JTextField TFDestino;

	private JLabel LFInicio;

	private JDateChooser DCInicio;

	private JLabel LHInicio;

	private JPanel PHoraI;

	private JSpinner SHoraI;

	private JLabel LDosP;

	private JSpinner SMinI;

	private JLabel LFFin;

	private JDateChooser DCFin;

	private JLabel LHFin;

	private JPanel PHoraF;

	private JSpinner SHoraF;

	private JLabel LDosP2;
	private JSpinner SMinF;
	private JLabel LCategoria;
	private JComboBox CBCategoria;
	private JLabel LEstado;
	private JComboBox CBEstado;
	private JLabel LCosto;
	private JFormattedTextField FTCosto;
	private JPanel PCliente;
	private JLabel LDni;
	private JFormattedTextField FTDNI;
	private JButton BCrearCliente;
	private JLabel LNombre;
	private JTextField TFNombre;
	private JButton BSeleccionarCliente;
	private JPanel PEmpleados;
	private JScrollPane SPTablaEmp;
	private JTable TEmpleados;
	private JButton BAnadirE;
	private JButton BQuitarE;
	private JPanel PVehiculos;
	private JScrollPane SPTablaVehi;
	private JTable TVehiculos;
	private JButton BAnadirV;
	private JButton BQuitarV;
	private JPanel PBotonesPedido;
	private JButton BActPedidoOK;
	private JButton BActPedidoCancel;

	// JFormDesigner - End of variables declaration //GEN-END:variables
	public VentanaPedido(String titulo, String boton, coperador P) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		empleadosasig = new ArrayList<TEmpleado>();
		vehiculosasig = new ArrayList<TVehiculo>();

		FActPedido.setVisible(true);
	}

	@SuppressWarnings( { "deprecation" })
	public VentanaPedido(String titulo, String boton, coperador P,
			TPedido Pedido) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		TFOrigen.setText(Pedido.getOrigen());
		TFDestino.setText(Pedido.getDestino());
		DCInicio.setDate(Pedido.get_ini());
		DCFin.setDate(Pedido.get_fin());
		SHoraI.setValue(Pedido.get_ini().getHours());
		SHoraF.setValue(Pedido.get_fin().getHours());
		SMinI.setValue(Pedido.get_ini().getMinutes());
		SMinF.setValue(Pedido.get_fin().getMinutes());
		CBCategoria.setSelectedItem(Pedido.getCategoria());
		CBEstado.setSelectedItem(Pedido.getEstado());
		FTCosto.setValue(Pedido.getCosto());

		cliente = Pedido.getCliente();
		FTDNI.setValue(Pedido.getCliente().getDni());
		TFNombre.setText(Pedido.getCliente().getNombre());

		empleadosasig = new ArrayList<TEmpleado>();
		vehiculosasig = new ArrayList<TVehiculo>();

		for (TEmpleado emp : Pedido.getEmpleados()) {
			empleadosasig.add(emp);
		}

		for (TVehiculo veh : Pedido.getVehiculos()) {
			vehiculosasig.add(veh);
		}
		empleadosSinasig.removeAll(empleadosasig);
		vehiculosSinasig.removeAll(vehiculosasig);

		actualizar_lista_empleados();
		actualizar_lista_vehiculos();

		FActPedido.setVisible(true);
	}

	@SuppressWarnings("serial")
	private void actualizar_lista_empleados() {
		TEmpleados.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Legajo",
				"Nombre" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		TEmpleados.setModel(TM);
		for (TEmpleado emp : empleadosasig) {
			TM.addRow(new String[] { String.valueOf(emp.getLegajo()),
					emp.getNombre() });
		}
	}

	@SuppressWarnings("serial")
	private void actualizar_lista_vehiculos() {
		TVehiculos.removeAll();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Patente",
				"Tipo" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		TVehiculos.setModel(TM);
		for (TVehiculo ve : vehiculosasig) {
			TM.addRow(new String[] { ve.getPatente(),
					ve.getTipoVehiculo().toString() });
		}
	}

	public void agregarEmpleado(TEmpleado Empleado) {
		empleadosasig.add(Empleado);
		empleadosSinasig.remove(Empleado);
		actualizar_lista_empleados();
	}

	public void agregarVehiculo(TVehiculo Vehiculo) {
		vehiculosasig.add(Vehiculo);
		vehiculosSinasig.remove(Vehiculo);
		actualizar_lista_vehiculos();
	}

	private void BActPedidoCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaPedido(false);
		FActPedido.dispose();
	}

	@SuppressWarnings("deprecation")
	private void BActPedidoOKActionPerformed(ActionEvent e) {
		String ori = TFOrigen.getText();
		String des = TFDestino.getText();
		Date ini = DCInicio.getDate();
		Date fin = DCFin.getDate();
		int horai = (Integer) SHoraI.getValue();
		int horaf = (Integer) SHoraF.getValue();
		int mini = (Integer) SMinI.getValue();
		int minf = (Integer) SMinF.getValue();
		ini.setHours(horai);
		ini.setMinutes(mini);
		fin.setHours(horaf);
		fin.setMinutes(minf);
		ECategoriaPedido cat = (ECategoriaPedido) CBCategoria.getSelectedItem();
		EEstadoPedido est = (EEstadoPedido) CBEstado.getSelectedItem();
		float cost = (Float) FTCosto.getValue();

		boolean novacio = ((!ori.equals("") && (!des.equals("") && (cost > 0))));
		novacio = novacio && ini.before(fin);

		if (novacio) {
			if ((cliente != null) && (empleadosasig.size() > 0)) {
				TPedido Pedido = new TPedido(0, ori, des, est, cat, ini, fin,
						cliente, cost);

				for (TEmpleado emp : empleadosasig) {
					Pedido.getEmpleados().add(emp);
				}
				for (TVehiculo veh : vehiculosasig) {
					Pedido.getVehiculos().add(veh);
				}

				FActPedido.setEnabled(false);
				controlador.actualizoPedido(Pedido);
				FActPedido.dispose();
			} else {
				JOptionPane
						.showMessageDialog(FActPedido,
								"Debe seleccionar un cliente válido y por lo menos un empleado");
			}
		} else {
			JOptionPane.showMessageDialog(FActPedido,
					"Ingrese todos los campos obligatorios.");
		}
	}

	private void BAnadirEActionPerformed(ActionEvent e) {
		controlador.anadirEmpleados(empleadosSinasig);
	}

	private void BAnadirVActionPerformed(ActionEvent e) {
		controlador.anadirVehiculos(vehiculosSinasig);
	}

	private void BCrearClienteActionPerformed(ActionEvent e) {
		controlador.crearClienteEnPedido();
	}

	private void BQuitarEActionPerformed(ActionEvent e) {
		int indicevista = TEmpleados.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(FActPedido,
					"Seleccione un empleado primero.");
		} else {
			int indice = TEmpleados.getRowSorter().convertRowIndexToModel(
					indicevista);
			TEmpleado Empleado = empleadosasig.get(indice);
			empleadosasig.remove(Empleado);
			empleadosSinasig.add(Empleado);
			actualizar_lista_empleados();
		}
	}

	private void BQuitarVActionPerformed(ActionEvent e) {
		int indicevista = TVehiculos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(FActPedido,
					"Seleccione un vehículo primero.");
		} else {
			int indice = TVehiculos.getRowSorter().convertRowIndexToModel(
					indicevista);
			TVehiculo Vehiculo = vehiculosasig.get(indice);
			vehiculosasig.remove(Vehiculo);
			vehiculosSinasig.add(Vehiculo);
			actualizar_lista_vehiculos();
		}
	}

	private void BSeleccionarClienteActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void FTDNIPropertyChange(PropertyChangeEvent e) {
		long dni = (Long) FTDNI.getValue();
		if (dni > 0) {
			TCliente Cliente = controlador.getCliente(dni);
			if (Cliente != null) {
				if (Cliente.getEstado() == EEstadoCliente.ACTIVO) {
					// Si el cliente está activo es posible seleccionarlo
					cliente = Cliente;
					TFNombre.setText(Cliente.getNombre());
				} else {
					cliente = null;
					TFNombre.setText("EL CLIENTE SELECCIONADO NO ESTA ACTIVO");
				}

			} else {
				cliente = null;
				TFNombre.setText("ERROR: NO EXITE EL CLIENTE DADO EL DNI");
			}
		} else {
			cliente = null;
			TFNombre.setText("ERROR: DNI NO VÁLIDO");
		}
	}

	public JFrame getFramePrincipal() {
		return FActPedido;
	}

	private void inicializarModelo(String titulo, String boton, coperador P) {
		controlador = P;

		empleadosSinasig = new ArrayList<TEmpleado>();
		for (TEmpleado emp : P.getEmpleados()) {
			empleadosSinasig.add(emp);
		}
		vehiculosSinasig = new ArrayList<TVehiculo>();
		for (TVehiculo veh : P.getVehiculos()) {
			vehiculosSinasig.add(veh);
		}

		CBCategoria = new JComboBox(ECategoriaPedido.values());
		CBEstado = new JComboBox(EEstadoPedido.values());
		DCInicio = new JDateChooser(Calendar.getInstance().getTime());
		DCFin = new JDateChooser(Calendar.getInstance().getTime());

		FActPedido = new JFrame(titulo);
		BActPedidoOK = new JButton(boton);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// FActPedido = new JFrame();
		SPAtributosP = new JScrollPane();
		PAtributosP = new JPanel();
		LOrigen = new JLabel();
		TFOrigen = new JTextField();
		LDestino = new JLabel();
		TFDestino = new JTextField();
		LFInicio = new JLabel();
		// DCInicio = new JDateChooser();
		LHInicio = new JLabel();
		PHoraI = new JPanel();
		SHoraI = new JSpinner();
		LDosP = new JLabel();
		SMinI = new JSpinner();
		LFFin = new JLabel();
		// DCFin = new JDateChooser();
		LHFin = new JLabel();
		PHoraF = new JPanel();
		SHoraF = new JSpinner();
		LDosP2 = new JLabel();
		SMinF = new JSpinner();
		LCategoria = new JLabel();
		// CBCategoria = new JComboBox();
		LEstado = new JLabel();
		// CBEstado = new JComboBox();
		LCosto = new JLabel();
		FTCosto = new JFormattedTextField(new Float(0.0));
		PCliente = new JPanel();
		LDni = new JLabel();
		FTDNI = new JFormattedTextField(new Long(0));
		BCrearCliente = new JButton();
		LNombre = new JLabel();
		TFNombre = new JTextField();
		BSeleccionarCliente = new JButton();
		PEmpleados = new JPanel();
		SPTablaEmp = new JScrollPane();
		TEmpleados = new JTable();
		BAnadirE = new JButton();
		BQuitarE = new JButton();
		PVehiculos = new JPanel();
		SPTablaVehi = new JScrollPane();
		TVehiculos = new JTable();
		BAnadirV = new JButton();
		BQuitarV = new JButton();
		PBotonesPedido = new JPanel();
		// BActPedidoOK = new JButton();
		BActPedidoCancel = new JButton();

		// ======== FActPedido ========
		{
			// FActPedido.setTitle("Alta/Modificaci\u00f3n de Pedido");
			FActPedido
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActPedido
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActPedido.setResizable(false);
			FActPedido.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JFListaPedidossWindowClosing(e);
				}

				private void JFListaPedidossWindowClosing(WindowEvent e) {
					controlador.cerroventanaPedido(false);
				}
			});
			Container FActPedidoContentPane = FActPedido.getContentPane();
			FActPedidoContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActPedidoContentPane.getLayout()).columnWidths = new int[] {
					254, 0 };
			((GridBagLayout) FActPedidoContentPane.getLayout()).rowHeights = new int[] {
					100, 40, 0 };
			((GridBagLayout) FActPedidoContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActPedidoContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPAtributosP ========
			{
				SPAtributosP.setViewportBorder(null);

				// ======== PAtributosP ========
				{
					PAtributosP.setBorder(null);
					PAtributosP.setLayout(new GridBagLayout());
					((GridBagLayout) PAtributosP.getLayout()).columnWidths = new int[] {
							10, 134, 179, 132, 0, 5, 0 };
					((GridBagLayout) PAtributosP.getLayout()).rowHeights = new int[] {
							10, 30, 30, 10, 30, 30, 10, 30, 30, 10, 30, 95,
							117, 0, 0 };
					((GridBagLayout) PAtributosP.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAtributosP.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							0.0, 0.0, 0.0, 0.0, 1.0E-4 };

					// ---- LOrigen ----
					LOrigen.setText("Origen:");
					PAtributosP.add(LOrigen, new GridBagConstraints(1, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					TFOrigen.setToolTipText("Lugar de partida del pedido");
					PAtributosP.add(TFOrigen, new GridBagConstraints(2, 1, 2,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDestino ----
					LDestino.setText("Destino");
					PAtributosP.add(LDestino, new GridBagConstraints(1, 2, 1,
							1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					TFDestino.setToolTipText("Lugar de destino del pedido");
					PAtributosP.add(TFDestino, new GridBagConstraints(2, 2, 2,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LFInicio ----
					LFInicio.setText("Fecha de Inicio:");
					PAtributosP.add(LFInicio, new GridBagConstraints(1, 4, 1,
							1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosP.add(DCInicio, new GridBagConstraints(2, 4, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LHInicio ----
					LHInicio.setText("Hora de Inicio:");
					PAtributosP.add(LHInicio, new GridBagConstraints(3, 4, 1,
							1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ======== PHoraI ========
					{
						PHoraI
								.setLayout(new FlowLayout(FlowLayout.CENTER, 5,
										0));

						// ---- SHoraI ----
						SHoraI.setModel(new SpinnerNumberModel(0, 0, 23, 1));
						PHoraI.add(SHoraI);

						// ---- LDosP ----
						LDosP.setText(":");
						PHoraI.add(LDosP);

						// ---- SMinI ----
						SMinI.setModel(new SpinnerNumberModel(0, 0, 59, 15));
						PHoraI.add(SMinI);
					}
					PAtributosP.add(PHoraI, new GridBagConstraints(4, 4, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5,
									5), 0, 0));

					// ---- LFFin ----
					LFFin.setText("Fecha de Finalizaci\u00f3n:");
					PAtributosP.add(LFFin, new GridBagConstraints(1, 5, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosP.add(DCFin, new GridBagConstraints(2, 5, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LHFin ----
					LHFin.setText("Hora de Finalizaci\u00f3n:");
					PAtributosP.add(LHFin, new GridBagConstraints(3, 5, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ======== PHoraF ========
					{
						PHoraF
								.setLayout(new FlowLayout(FlowLayout.CENTER, 5,
										0));

						// ---- SHoraF ----
						SHoraF.setModel(new SpinnerNumberModel(0, 0, 23, 1));
						PHoraF.add(SHoraF);

						// ---- LDosP2 ----
						LDosP2.setText(":");
						PHoraF.add(LDosP2);

						// ---- SMinF ----
						SMinF.setModel(new SpinnerNumberModel(0, 0, 59, 15));
						PHoraF.add(SMinF);
					}
					PAtributosP.add(PHoraF, new GridBagConstraints(4, 5, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5,
									5), 0, 0));

					// ---- LCategoria ----
					LCategoria.setText("Categoria:");
					PAtributosP.add(LCategoria, new GridBagConstraints(1, 7, 1,
							1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosP.add(CBCategoria, new GridBagConstraints(2, 7,
							2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LEstado ----
					LEstado.setText("Estado:");
					PAtributosP.add(LEstado, new GridBagConstraints(1, 8, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosP.add(CBEstado, new GridBagConstraints(2, 8, 2,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LCosto ----
					LCosto.setText("Costo de pedido: $");
					PAtributosP.add(LCosto, new GridBagConstraints(1, 10, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					FTCosto
							.setToolTipText("Costo del pedido para el cliente en pesos");
					PAtributosP.add(FTCosto, new GridBagConstraints(2, 10, 2,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PCliente ========
					{
						PCliente.setBorder(new TitledBorder("Cliente"));
						PCliente.setLayout(new GridBagLayout());
						((GridBagLayout) PCliente.getLayout()).columnWidths = new int[] {
								75, 278, 100, 0 };
						((GridBagLayout) PCliente.getLayout()).rowHeights = new int[] {
								30, 25, 0 };
						((GridBagLayout) PCliente.getLayout()).columnWeights = new double[] {
								0.0, 1.0, 0.0, 1.0E-4 };
						((GridBagLayout) PCliente.getLayout()).rowWeights = new double[] {
								0.0, 0.0, 1.0E-4 };

						// ---- LDni ----
						LDni.setText("DNI:");
						PCliente.add(LDni, new GridBagConstraints(0, 0, 1, 1,
								0.0, 0.0, GridBagConstraints.EAST,
								GridBagConstraints.VERTICAL, new Insets(0, 0,
										5, 5), 0, 0));

						// ---- FTDNI ----
						FTDNI
								.setToolTipText("DNI del cliente a asignar al pedido");
						FTDNI.addPropertyChangeListener("value",
								new PropertyChangeListener() {
									public void propertyChange(
											PropertyChangeEvent e) {
										FTDNIPropertyChange(e);
									}
								});

						PCliente.add(FTDNI, new GridBagConstraints(1, 0, 1, 1,
								0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 5), 0, 0));

						// ---- BCrearCliente ----
						BCrearCliente.setText("Crear Nuevo Cliente");
						BCrearCliente
								.setToolTipText("Crea un nuevo cliente y lo asigna al pedido");
						BCrearCliente.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BCrearClienteActionPerformed(e);
							}
						});
						PCliente.add(BCrearCliente, new GridBagConstraints(2,
								0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 0), 0, 0));

						// ---- LNombre ----
						LNombre.setText("Nombre:");
						PCliente.add(LNombre, new GridBagConstraints(0, 1, 1,
								1, 0.0, 0.0, GridBagConstraints.EAST,
								GridBagConstraints.VERTICAL, new Insets(0, 0,
										0, 5), 0, 0));

						// ---- TFNombre ----
						TFNombre.setEditable(false);
						TFNombre
								.setToolTipText("Nombre del cliente seleccionado, o informe del error producido");
						PCliente.add(TFNombre, new GridBagConstraints(1, 1, 1,
								1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

						// ---- BSeleccionarCliente ----
						BSeleccionarCliente.setText("Seleccionar Cliente");
						BSeleccionarCliente
								.setToolTipText("No implementado todavía");
						BSeleccionarCliente.setEnabled(false);
						BSeleccionarCliente
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										BSeleccionarClienteActionPerformed(e);
									}
								});
						PCliente.add(BSeleccionarCliente,
								new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
										GridBagConstraints.CENTER,
										GridBagConstraints.BOTH, new Insets(0,
												0, 0, 0), 0, 0));
					}
					PAtributosP.add(PCliente, new GridBagConstraints(1, 11, 4,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PEmpleados ========
					{
						PEmpleados.setBorder(new TitledBorder(
								"Empleados asignados"));
						PEmpleados.setLayout(new GridBagLayout());
						((GridBagLayout) PEmpleados.getLayout()).columnWidths = new int[] {
								0, 0, 0 };
						((GridBagLayout) PEmpleados.getLayout()).rowHeights = new int[] {
								65, 25, 0 };
						((GridBagLayout) PEmpleados.getLayout()).columnWeights = new double[] {
								0.5, 0.5, 1.0E-4 };
						((GridBagLayout) PEmpleados.getLayout()).rowWeights = new double[] {
								0.0, 0.0, 1.0E-4 };

						// ======== SPTablaEmp ========
						{

							// ---- TEmpleados ----
							TEmpleados
									.setPreferredScrollableViewportSize(new Dimension(
											50, 80));
							TEmpleados
									.setToolTipText("Lista de empleados asignados actualmente al pedido");
							TEmpleados
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							TEmpleados.setModel(new DefaultTableModel(
									new Object[] { "Legajo", "Nombre" }, 0));
							TEmpleados.setAutoCreateRowSorter(true);
							SPTablaEmp.setViewportView(TEmpleados);
						}
						PEmpleados.add(SPTablaEmp, new GridBagConstraints(0, 0,
								2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 0), 0, 0));

						// ---- BAnadirE ----
						BAnadirE.setText("A\u00f1adir empleado");
						BAnadirE.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BAnadirEActionPerformed(e);
							}
						});
						PEmpleados.add(BAnadirE, new GridBagConstraints(0, 1,
								1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

						// ---- BQuitarE ----
						BQuitarE.setText("Quitar empleado");
						BQuitarE.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BQuitarEActionPerformed(e);
							}
						});
						PEmpleados.add(BQuitarE, new GridBagConstraints(1, 1,
								1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
					}
					PAtributosP.add(PEmpleados, new GridBagConstraints(1, 12,
							2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PVehiculos ========
					{
						PVehiculos.setBorder(new TitledBorder(
								"Veh\u00edculos asignados"));
						PVehiculos.setLayout(new GridBagLayout());
						((GridBagLayout) PVehiculos.getLayout()).columnWidths = new int[] {
								0, 0, 0 };
						((GridBagLayout) PVehiculos.getLayout()).rowHeights = new int[] {
								65, 25, 0 };
						((GridBagLayout) PVehiculos.getLayout()).columnWeights = new double[] {
								0.5, 0.5, 1.0E-4 };
						((GridBagLayout) PVehiculos.getLayout()).rowWeights = new double[] {
								0.0, 0.0, 1.0E-4 };

						// ======== SPTablaVehi ========
						{

							// ---- TVehiculos ----
							TVehiculos
									.setPreferredScrollableViewportSize(new Dimension(
											50, 80));
							TVehiculos
									.setToolTipText("Lista de vehículos asignados al pedido");
							TVehiculos
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							TVehiculos.setModel(new DefaultTableModel(
									new Object[] { "Patente", "Tipo" }, 0));
							TVehiculos.setAutoCreateRowSorter(true);
							SPTablaVehi.setViewportView(TVehiculos);
						}
						PVehiculos.add(SPTablaVehi, new GridBagConstraints(0,
								0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 0), 0, 0));

						// ---- BAnadirV ----
						BAnadirV.setText("A\u00f1adir veh\u00edculo");
						BAnadirV.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BAnadirVActionPerformed(e);
							}
						});
						PVehiculos.add(BAnadirV, new GridBagConstraints(0, 1,
								1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

						// ---- BQuitarV ----
						BQuitarV.setText("Quitar veh\u00edculo");
						BQuitarV.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BQuitarVActionPerformed(e);
							}
						});
						PVehiculos.add(BQuitarV, new GridBagConstraints(1, 1,
								1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
					}
					PAtributosP.add(PVehiculos, new GridBagConstraints(3, 12,
							2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPAtributosP.setViewportView(PAtributosP);
			}
			FActPedidoContentPane.add(SPAtributosP, new GridBagConstraints(0,
					0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesPedido ========
			{
				PBotonesPedido.setLayout(new FlowLayout(FlowLayout.CENTER, 30,
						5));

				// ---- BActPedidoOK ----
				// BActPedidoOK.setText("Crear");
				BActPedidoOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActPedidoOKActionPerformed(e);
					}
				});
				PBotonesPedido.add(BActPedidoOK);

				// ---- BActPedidoCancel ----
				BActPedidoCancel.setText("Cancelar");
				BActPedidoCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActPedidoCancelActionPerformed(e);
					}
				});
				PBotonesPedido.add(BActPedidoCancel);
			}
			FActPedidoContentPane.add(PBotonesPedido, new GridBagConstraints(0,
					1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			FActPedido.setSize(640, 600);
			FActPedido.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	public void setearCliente(TCliente Cliente) {
		cliente = Cliente;

		FTDNI.setValue(Cliente.getDni());
		TFNombre.setText(Cliente.getNombre());
	}
}
