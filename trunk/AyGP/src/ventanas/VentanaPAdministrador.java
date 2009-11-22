package ventanas;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import control.cadministrador;

public class VentanaPAdministrador {
	private cadministrador controlador;

	public VentanaPAdministrador(cadministrador P) {
		initComponents();

		controlador = P;
		JVentanaPAdministrador.setVisible(true);
	}

	public JFrame getFramePrincipal() {
		return JVentanaPAdministrador;
	}

	private void BRegistrarEActionPerformed(ActionEvent e) {
		controlador.crearEmpleado();
	}

	private void BModificarEActionPerformed(ActionEvent e) {
		int indicevista = TEmpleados.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPAdministrador,
					"Seleccione un empleado primero.");
		} else {
			int indice = TEmpleados.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.modificarEmpleado(indice);
		}
	}

	private void BBajaEActionPerformed(ActionEvent e) {
		int indicevista = TEmpleados.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPAdministrador,
					"Seleccione un empleado primero.");
		} else {
			int indice = TEmpleados.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoEmpleado(indice);
		}
	}

	private void BRegistrarVActionPerformed(ActionEvent e) {
		controlador.crearVehiculo();
	}

	private void BModificarVActionPerformed(ActionEvent e) {
		int indicevista = TVehiculos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPAdministrador,
					"Seleccione un vehículo primero.");
		} else {
			int indice = TVehiculos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.modificarVehiculo(indice);
		}
	}

	private void BBajaVActionPerformed(ActionEvent e) {
		int indicevista = TVehiculos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPAdministrador,
					"Seleccione un vehículo primero.");
		} else {
			int indice = TVehiculos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoVehiculo(indice);
		}
	}

	private void BRegistrarEqActionPerformed(ActionEvent e) {
		controlador.crearEquipo();
	}

	private void BModificarEqActionPerformed(ActionEvent e) {
		int indicevista = TEquipos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPAdministrador,
					"Seleccione un equipo primero.");
		} else {
			int indice = TEquipos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.modificarEquipo(indice);
		}
	}

	private void BBajaEqActionPerformed(ActionEvent e) {
		int indicevista = TEquipos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPAdministrador,
					"Seleccione un equipo primero.");
		} else {
			int indice = TEquipos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoEquipo(indice);
		}
	}

	private void BRegistrarEvActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void BModificarEvActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void BBajaEvActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	@SuppressWarnings("serial")
	public void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		JVentanaPAdministrador = new JFrame();
		TPAdministrador = new JTabbedPane();
		PEmpleados = new JPanel();
		PLEmpleados = new JPanel();
		SPTablaE = new JScrollPane();
		TEmpleados = new JTable();
		BRegistrarE = new JButton();
		BModificarE = new JButton();
		BBajaE = new JButton();
		PVehiculos = new JPanel();
		PLVehiculos = new JPanel();
		SPTablaV = new JScrollPane();
		TVehiculos = new JTable();
		BRegistrarV = new JButton();
		BModificarV = new JButton();
		BBajaV = new JButton();
		PEquipos = new JPanel();
		PLEquipos = new JPanel();
		SPTablaEq = new JScrollPane();
		TEquipos = new JTable();
		BRegistrarEq = new JButton();
		BModificarEq = new JButton();
		BBajaEq = new JButton();
		PEventos = new JPanel();
		PLEventos = new JPanel();
		SPEventos = new JScrollPane();
		TEventos = new JTable();
		BRegistrarEv = new JButton();
		BModificarEv = new JButton();
		BBajaEv = new JButton();

		// ======== JVentanaPAdministrador ========
		{
			JVentanaPAdministrador
					.setTitle("Usuario: <Nombre> - Administrador");
			JVentanaPAdministrador
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			JVentanaPAdministrador
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			Container JVentanaPAdministradorContentPane = JVentanaPAdministrador
					.getContentPane();
			JVentanaPAdministradorContentPane.setLayout(new BoxLayout(
					JVentanaPAdministradorContentPane, BoxLayout.X_AXIS));

			// ======== TPAdministrador ========
			{
				TPAdministrador
						.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

				// ======== PEmpleados ========
				{
					PEmpleados.setLayout(new GridBagLayout());
					((GridBagLayout) PEmpleados.getLayout()).columnWidths = new int[] {
							25, 150, 0, 150, 0, 150, 25, 0 };
					((GridBagLayout) PEmpleados.getLayout()).rowHeights = new int[] {
							238, 45, 0 };
					((GridBagLayout) PEmpleados.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4 };
					((GridBagLayout) PEmpleados.getLayout()).rowWeights = new double[] {
							1.0, 0.0, 1.0E-4 };

					// ======== PLEmpleados ========
					{
						PLEmpleados.setBorder(new TitledBorder(
								"Lista de Pedidos"));
						PLEmpleados.setLayout(new CardLayout());

						// ======== SPTablaE ========
						{

							// ---- TEmpleados ----
							TEmpleados
									.setModel(new DefaultTableModel(
											new Object[][] { { null, null,
													null, null, null, null }, },
											new String[] { "Legajo", "Nombre",
													"Direccion", "Telefono",
													"Categoria", "Estado" }) {
										boolean[] columnEditable = new boolean[] {
												false, false, false, false,
												false, false };

										@Override
										public boolean isCellEditable(
												int rowIndex, int columnIndex) {
											return columnEditable[columnIndex];
										}
									});
							{
								TableColumnModel cm = TEmpleados
										.getColumnModel();
								cm.getColumn(1).setMinWidth(35);
								cm.getColumn(2).setMinWidth(35);
								cm.getColumn(3).setMinWidth(20);
								cm.getColumn(5).setMinWidth(35);
							}
							TEmpleados.setFillsViewportHeight(true);
							TEmpleados.setAutoCreateRowSorter(true);
							TEmpleados
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPTablaE.setViewportView(TEmpleados);
						}
						PLEmpleados.add(SPTablaE, "card1");
					}
					PEmpleados.add(PLEmpleados, new GridBagConstraints(1, 0, 5,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));

					// ---- BRegistrarE ----
					BRegistrarE.setText("Alta de Empleado");
					BRegistrarE.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarEActionPerformed(e);
						}
					});
					PEmpleados.add(BRegistrarE, new GridBagConstraints(1, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BModificarE ----
					BModificarE.setText("Modificar datos de Empleado");
					BModificarE.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarEActionPerformed(e);
						}
					});
					PEmpleados.add(BModificarE, new GridBagConstraints(3, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BBajaE ----
					BBajaE.setText("Dar de baja Empleado");
					BBajaE.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaEActionPerformed(e);
						}
					});
					PEmpleados.add(BBajaE, new GridBagConstraints(5, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));
				}
				TPAdministrador.addTab("Administraci\u00f3n de Empleados",
						PEmpleados);

				// ======== PVehiculos ========
				{
					PVehiculos.setLayout(new GridBagLayout());
					((GridBagLayout) PVehiculos.getLayout()).columnWidths = new int[] {
							25, 150, 0, 150, 0, 150, 25, 0 };
					((GridBagLayout) PVehiculos.getLayout()).rowHeights = new int[] {
							238, 45, 0 };
					((GridBagLayout) PVehiculos.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4 };
					((GridBagLayout) PVehiculos.getLayout()).rowWeights = new double[] {
							1.0, 0.0, 1.0E-4 };

					// ======== PLVehiculos ========
					{
						PLVehiculos.setBorder(new TitledBorder(
								"Lista de Pedidos"));
						PLVehiculos.setLayout(new CardLayout());

						// ======== SPTablaV ========
						{

							// ---- TVehiculos ----
							TVehiculos.setModel(new DefaultTableModel(
									new Object[][] { { null, null, null, null,
											null, null, null }, },
									new String[] { "Patente", "Marca",
											"Modelo", "Color", "Kilometraje",
											"Estado", "Tipo" }) {
								boolean[] columnEditable = new boolean[] {
										false, false, false, false, false,
										false, false };

								@Override
								public boolean isCellEditable(int rowIndex,
										int columnIndex) {
									return columnEditable[columnIndex];
								}
							});
							{
								TableColumnModel cm = TVehiculos
										.getColumnModel();
								cm.getColumn(1).setMinWidth(35);
								cm.getColumn(2).setMinWidth(35);
								cm.getColumn(3).setMinWidth(20);
								cm.getColumn(5).setMinWidth(35);
							}
							TVehiculos.setAutoCreateRowSorter(true);
							TVehiculos.setFillsViewportHeight(true);
							TVehiculos
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPTablaV.setViewportView(TVehiculos);
						}
						PLVehiculos.add(SPTablaV, "card1");
					}
					PVehiculos.add(PLVehiculos, new GridBagConstraints(1, 0, 5,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));

					// ---- BRegistrarV ----
					BRegistrarV.setText("Alta de Veh\u00edculo");
					BRegistrarV.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarVActionPerformed(e);
						}
					});
					PVehiculos.add(BRegistrarV, new GridBagConstraints(1, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BModificarV ----
					BModificarV.setText("Modificar datos de Veh\u00edculo");
					BModificarV.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarVActionPerformed(e);
						}
					});
					PVehiculos.add(BModificarV, new GridBagConstraints(3, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BBajaV ----
					BBajaV.setText("Dar de baja Veh\u00edculo");
					BBajaV.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaVActionPerformed(e);
						}
					});
					PVehiculos.add(BBajaV, new GridBagConstraints(5, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));
				}
				TPAdministrador.addTab("Administraci\u00f3n de Veh\u00edculos",
						PVehiculos);

				// ======== PEquipos ========
				{
					PEquipos.setLayout(new GridBagLayout());
					((GridBagLayout) PEquipos.getLayout()).columnWidths = new int[] {
							25, 150, 0, 150, 0, 150, 25, 0 };
					((GridBagLayout) PEquipos.getLayout()).rowHeights = new int[] {
							238, 45, 0 };
					((GridBagLayout) PEquipos.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4 };
					((GridBagLayout) PEquipos.getLayout()).rowWeights = new double[] {
							1.0, 0.0, 1.0E-4 };

					// ======== PLEquipos ========
					{
						PLEquipos
								.setBorder(new TitledBorder("Lista de Pedidos"));
						PLEquipos.setLayout(new CardLayout());

						// ======== SPTablaEq ========
						{

							// ---- TEquipos ----
							TEquipos
									.setModel(new DefaultTableModel(
											new Object[][] { { null, null,
													null, "" }, },
											new String[] { "ID", "Nombre",
													"Categoria", "Estado" }) {
										boolean[] columnEditable = new boolean[] {
												false, false, false, false };

										@Override
										public boolean isCellEditable(
												int rowIndex, int columnIndex) {
											return columnEditable[columnIndex];
										}
									});
							{
								TableColumnModel cm = TEquipos.getColumnModel();
								cm.getColumn(1).setMinWidth(35);
								cm.getColumn(2).setMinWidth(35);
								cm.getColumn(3).setMinWidth(35);
							}
							TEquipos.setAutoCreateRowSorter(true);
							TEquipos.setFillsViewportHeight(true);
							TEquipos
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPTablaEq.setViewportView(TEquipos);
						}
						PLEquipos.add(SPTablaEq, "card1");
					}
					PEquipos.add(PLEquipos, new GridBagConstraints(1, 0, 5, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));

					// ---- BRegistrarEq ----
					BRegistrarEq.setText("Alta de Equipo");
					BRegistrarEq.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarEqActionPerformed(e);
						}
					});
					PEquipos.add(BRegistrarEq, new GridBagConstraints(1, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BModificarEq ----
					BModificarEq.setText("Modificar datos de Equipo");
					BModificarEq.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarEqActionPerformed(e);
						}
					});
					PEquipos.add(BModificarEq, new GridBagConstraints(3, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BBajaEq ----
					BBajaEq.setText("Dar de baja Equipo");
					BBajaEq.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaEqActionPerformed(e);
						}
					});
					PEquipos.add(BBajaEq, new GridBagConstraints(5, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));
				}
				TPAdministrador.addTab("Administraci\u00f3n de Equipos",
						PEquipos);

				// ======== PEventos ========
				{
					PEventos.setLayout(new GridBagLayout());
					((GridBagLayout) PEventos.getLayout()).columnWidths = new int[] {
							25, 150, 0, 150, 0, 150, 25, 0 };
					((GridBagLayout) PEventos.getLayout()).rowHeights = new int[] {
							238, 45, 0 };
					((GridBagLayout) PEventos.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4 };
					((GridBagLayout) PEventos.getLayout()).rowWeights = new double[] {
							1.0, 0.0, 1.0E-4 };

					// ======== PLEventos ========
					{
						PLEventos
								.setBorder(new TitledBorder("Lista de Pedidos"));
						PLEventos.setLayout(new CardLayout());

						// ======== SPEventos ========
						{

							// ---- TEventos ----
							TEventos.setModel(new DefaultTableModel(
									new Object[][] { { null, null, "" }, },
									new String[] { "ID", "Nombre", "Fecha" }) {
								boolean[] columnEditable = new boolean[] {
										false, false, false };

								@Override
								public boolean isCellEditable(int rowIndex,
										int columnIndex) {
									return columnEditable[columnIndex];
								}
							});
							{
								TableColumnModel cm = TEventos.getColumnModel();
								cm.getColumn(1).setMinWidth(35);
							}
							TEventos.setAutoCreateRowSorter(true);
							TEventos.setFillsViewportHeight(true);
							TEventos
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPEventos.setViewportView(TEventos);
						}
						PLEventos.add(SPEventos, "card1");
					}
					PEventos.add(PLEventos, new GridBagConstraints(1, 0, 5, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
							0));

					// ---- BRegistrarEv ----
					BRegistrarEv.setText("Registrar Evento");
					BRegistrarEv.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarEvActionPerformed(e);
						}
					});
					PEventos.add(BRegistrarEv, new GridBagConstraints(1, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BModificarEv ----
					BModificarEv
							.setText("Modificar informaci\u00f3n de Evento");
					BModificarEv.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarEvActionPerformed(e);
						}
					});
					PEventos.add(BModificarEv, new GridBagConstraints(3, 1, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

					// ---- BBajaEv ----
					BBajaEv.setText("Eliminar Evento");
					BBajaEv.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaEvActionPerformed(e);
						}
					});
					PEventos.add(BBajaEv, new GridBagConstraints(5, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));
				}
				TPAdministrador.addTab("Administraci\u00f3n de Eventos",
						PEventos);
			}
			JVentanaPAdministradorContentPane.add(TPAdministrador);
			JVentanaPAdministrador.setSize(900, 345);
			JVentanaPAdministrador.setLocationRelativeTo(JVentanaPAdministrador
					.getOwner());
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame JVentanaPAdministrador;
	private JTabbedPane TPAdministrador;
	private JPanel PEmpleados;
	private JPanel PLEmpleados;
	private JScrollPane SPTablaE;
	private JTable TEmpleados;
	private JButton BRegistrarE;
	private JButton BModificarE;
	private JButton BBajaE;
	private JPanel PVehiculos;
	private JPanel PLVehiculos;
	private JScrollPane SPTablaV;
	private JTable TVehiculos;
	private JButton BRegistrarV;
	private JButton BModificarV;
	private JButton BBajaV;
	private JPanel PEquipos;
	private JPanel PLEquipos;
	private JScrollPane SPTablaEq;
	private JTable TEquipos;
	private JButton BRegistrarEq;
	private JButton BModificarEq;
	private JButton BBajaEq;
	private JPanel PEventos;
	private JPanel PLEventos;
	private JScrollPane SPEventos;
	private JTable TEventos;
	private JButton BRegistrarEv;
	private JButton BModificarEv;
	private JButton BBajaEv;

	// JFormDesigner - End of variables declaration //GEN-END:variables
	public JTabbedPane getTPAdministrador() {
		return TPAdministrador;
	}

	public JTable getTEmpleados() {
		return TEmpleados;
	}

	public JTable getTVehiculos() {
		return TVehiculos;
	}

	public JTable getTEquipos() {
		return TEquipos;
	}

	public JTable getTEventos() {
		return TEventos;
	}
}
