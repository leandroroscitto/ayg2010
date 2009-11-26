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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import control.coperador;


public class VentanaPOperador  {
	private coperador controlador;
	
	public VentanaPOperador(coperador P){
		initComponents();
		
		BModificarG.setEnabled(false);
		BBajaG.setEnabled(false);
		
		controlador=P;
		JVentanaPOperador.setVisible(true);
	}
	
	public JFrame getFramePrincipal(){
		return JVentanaPOperador;
	}

	private void BRegistrarPActionPerformed(ActionEvent e) {
		controlador.crearPedido();
	}

	private void BModificarPActionPerformed(ActionEvent e) {
		int indicevista = TPedidos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPOperador,
					"Seleccione un pedido primero.");
		} else {
			int indice = TPedidos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.modificarPedido(indice);
		}
	}

	private void BBajaPActionPerformed(ActionEvent e) {
		int indicevista = TPedidos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPOperador,
					"Seleccione un pedido primero.");
		} else {
			int indice = TPedidos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoPedido(indice);
		}
	}

	private void BRegistrarCActionPerformed(ActionEvent e) {
		controlador.crearCliente();
	}

	private void BModificarCActionPerformed(ActionEvent e) {
		int indicevista = TClientes.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPOperador,
					"Seleccione un cliente primero.");
		} else {
			int indice = TClientes.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.modificarCliente(indice);
		}
	}

	private void BBajaCActionPerformed(ActionEvent e) {
		int indicevista = TClientes.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPOperador,
					"Seleccione un cliente primero.");
		} else {
			int indice = TClientes.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoCliente(indice);
		}
	}

	private void BRegistrarGActionPerformed(ActionEvent e) {
		controlador.crearGasto();
	}

	private void BModificarGActionPerformed(ActionEvent e) {
		int indicevista = TGastos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPOperador,
					"Seleccione un gasto primero.");
		} else {
			int indice = TGastos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.modificarGasto(indice);
		}
	}

	private void BBajaGActionPerformed(ActionEvent e) {
		int indicevista = TGastos.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(JVentanaPOperador,
					"Seleccione un gasto primero.");
		} else {
			int indice = TGastos.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoGasto(indice);
		}
	}

	@SuppressWarnings("serial")
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		JVentanaPOperador = new JFrame();
		TPOperador = new JTabbedPane();
		PPedidos = new JPanel();
		PLPedidos = new JPanel();
		SPTablaP = new JScrollPane();
		TPedidos = new JTable();
		BRegistrarP = new JButton();
		BModificarP = new JButton();
		BBajaP = new JButton();
		PClientes = new JPanel();
		PLClientes = new JPanel();
		SPTablaC = new JScrollPane();
		TClientes = new JTable();
		BRegistrarC = new JButton();
		BModificarC = new JButton();
		BBajaC = new JButton();
		PGastos = new JPanel();
		PLGastos = new JPanel();
		SPTablaG = new JScrollPane();
		TGastos = new JTable();
		BRegistrarG = new JButton();
		BModificarG = new JButton();
		BBajaG = new JButton();

		//======== JVentanaPOperador ========
		{
			JVentanaPOperador.setTitle("Usuario: <Nombre> - Operador");
			JVentanaPOperador.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			Container JVentanaPOperadorContentPane = JVentanaPOperador.getContentPane();
			JVentanaPOperadorContentPane.setLayout(new BoxLayout(JVentanaPOperadorContentPane, BoxLayout.X_AXIS));

			//======== TPOperador ========
			{

				//======== PPedidos ========
				{
					PPedidos.setLayout(new GridBagLayout());
					((GridBagLayout)PPedidos.getLayout()).columnWidths = new int[] {25, 150, 0, 150, 0, 150, 25, 0};
					((GridBagLayout)PPedidos.getLayout()).rowHeights = new int[] {238, 45, 0};
					((GridBagLayout)PPedidos.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};
					((GridBagLayout)PPedidos.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

					//======== PLPedidos ========
					{
						PLPedidos.setBorder(new TitledBorder("Lista de Pedidos"));
						PLPedidos.setLayout(new CardLayout());

						//======== SPTablaP ========
						{

							//---- TPedidos ----
							TPedidos.setModel(new DefaultTableModel(
								new Object[][] {
									{null, null, null, null, null, null, null, ""},
								},
								new String[] {
									"ID", "Origen", "Destino", "Categoria", "Estado", "Cliente", "Fecha Inicio", "Fecha Fin"
								}
							) {
								boolean[] columnEditable = new boolean[] {
									false, false, false, false, false, false, false, false
								};
								@Override
								public boolean isCellEditable(int rowIndex, int columnIndex) {
									return columnEditable[columnIndex];
								}
							});
							{
								TableColumnModel cm = TPedidos.getColumnModel();
								cm.getColumn(0).setMinWidth(40);
								cm.getColumn(0).setPreferredWidth(35);
								cm.getColumn(1).setMinWidth(35);
								cm.getColumn(2).setMinWidth(35);
								cm.getColumn(3).setMinWidth(20);
								cm.getColumn(5).setMinWidth(35);
								cm.getColumn(6).setMinWidth(40);
								cm.getColumn(7).setMinWidth(40);
							}
							TPedidos.setFillsViewportHeight(true);
							TPedidos.setAutoCreateRowSorter(true);
							TPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPTablaP.setViewportView(TPedidos);
						}
						PLPedidos.add(SPTablaP, "card1");
					}
					PPedidos.add(PLPedidos, new GridBagConstraints(1, 0, 5, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BRegistrarP ----
					BRegistrarP.setText("Registrar Pedido");
					BRegistrarP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarPActionPerformed(e);
						}
					});
					PPedidos.add(BRegistrarP, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BModificarP ----
					BModificarP.setText("Modificar Pedido");
					BModificarP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarPActionPerformed(e);
						}
					});
					PPedidos.add(BModificarP, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BBajaP ----
					BBajaP.setText("Dar de baja Pedido");
					BBajaP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaPActionPerformed(e);
						}
					});
					PPedidos.add(BBajaP, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				TPOperador.addTab("Administraci\u00f3n de Pedidos", PPedidos);


				//======== PClientes ========
				{
					PClientes.setLayout(new GridBagLayout());
					((GridBagLayout)PClientes.getLayout()).columnWidths = new int[] {25, 150, 0, 150, 0, 150, 25, 0};
					((GridBagLayout)PClientes.getLayout()).rowHeights = new int[] {238, 45, 0};
					((GridBagLayout)PClientes.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};
					((GridBagLayout)PClientes.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

					//======== PLClientes ========
					{
						PLClientes.setBorder(new TitledBorder("Lista de Pedidos"));
						PLClientes.setLayout(new CardLayout());

						//======== SPTablaC ========
						{

							//---- TClientes ----
							TClientes.setModel(new DefaultTableModel(
								new Object[][] {
									{null, null, null, null, null, null},
								},
								new String[] {
									"ID", "Nombre", "Direccion", "Telefono", "DNI", "CUIT/CUIL"
								}
							) {
								boolean[] columnEditable = new boolean[] {
									false, false, false, false, false, false
								};
								@Override
								public boolean isCellEditable(int rowIndex, int columnIndex) {
									return columnEditable[columnIndex];
								}
							});
							{
								TableColumnModel cm = TClientes.getColumnModel();
								cm.getColumn(0).setMinWidth(40);
								cm.getColumn(0).setPreferredWidth(35);
								cm.getColumn(1).setMinWidth(35);
								cm.getColumn(2).setMinWidth(35);
								cm.getColumn(3).setMinWidth(20);
								cm.getColumn(5).setMinWidth(35);
							}
							TClientes.setAutoCreateRowSorter(true);
							TClientes.setFillsViewportHeight(true);
							TClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPTablaC.setViewportView(TClientes);
						}
						PLClientes.add(SPTablaC, "card1");
					}
					PClientes.add(PLClientes, new GridBagConstraints(1, 0, 5, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BRegistrarC ----
					BRegistrarC.setText("Registrar Cliente");
					BRegistrarC.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarCActionPerformed(e);
						}
					});
					PClientes.add(BRegistrarC, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BModificarC ----
					BModificarC.setText("Modificar Cliente");
					BModificarC.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarCActionPerformed(e);
						}
					});
					PClientes.add(BModificarC, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BBajaC ----
					BBajaC.setText("Dar de baja Cliente");
					BBajaC.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaCActionPerformed(e);
						}
					});
					PClientes.add(BBajaC, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				TPOperador.addTab("Administraci\u00f3n de Clientes", PClientes);


				//======== PGastos ========
				{
					PGastos.setLayout(new GridBagLayout());
					((GridBagLayout)PGastos.getLayout()).columnWidths = new int[] {25, 150, 0, 150, 0, 150, 25, 0};
					((GridBagLayout)PGastos.getLayout()).rowHeights = new int[] {238, 45, 0};
					((GridBagLayout)PGastos.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};
					((GridBagLayout)PGastos.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

					//======== PLGastos ========
					{
						PLGastos.setBorder(new TitledBorder("Lista de Pedidos"));
						PLGastos.setLayout(new CardLayout());

						//======== SPTablaG ========
						{

							//---- TGastos ----
							TGastos.setModel(new DefaultTableModel(
								new Object[][] {
									{null, null, null},
								},
								new String[] {
									"ID", "Nombre", "Monto"
								}
							) {
								boolean[] columnEditable = new boolean[] {
									false, false, false
								};
								@Override
								public boolean isCellEditable(int rowIndex, int columnIndex) {
									return columnEditable[columnIndex];
								}
							});
							{
								TableColumnModel cm = TGastos.getColumnModel();
								cm.getColumn(1).setMinWidth(35);
								cm.getColumn(2).setMinWidth(35);
							}
							TGastos.setAutoCreateRowSorter(true);
							TGastos.setFillsViewportHeight(true);
							TGastos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							SPTablaG.setViewportView(TGastos);
						}
						PLGastos.add(SPTablaG, "card1");
					}
					PGastos.add(PLGastos, new GridBagConstraints(1, 0, 5, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BRegistrarG ----
					BRegistrarG.setText("Registrar Gasto");
					BRegistrarG.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BRegistrarGActionPerformed(e);
						}
					});
					PGastos.add(BRegistrarG, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BModificarG ----
					BModificarG.setText("Modificar informaci\u00f3n de Gasto");
					BModificarG.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BModificarGActionPerformed(e);
						}
					});
					PGastos.add(BModificarG, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- BBajaG ----
					BBajaG.setText("Eliminar Gasto");
					BBajaG.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							BBajaGActionPerformed(e);
						}
					});
					PGastos.add(BBajaG, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				TPOperador.addTab("Administraci\u00f3n de Gastos", PGastos);

			}
			JVentanaPOperadorContentPane.add(TPOperador);
			JVentanaPOperador.setSize(640, 345);
			JVentanaPOperador.setLocationRelativeTo(JVentanaPOperador.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame JVentanaPOperador;
	private JTabbedPane TPOperador;
	private JPanel PPedidos;
	private JPanel PLPedidos;
	private JScrollPane SPTablaP;
	private JTable TPedidos;
	private JButton BRegistrarP;
	private JButton BModificarP;
	private JButton BBajaP;
	private JPanel PClientes;
	private JPanel PLClientes;
	private JScrollPane SPTablaC;
	private JTable TClientes;
	private JButton BRegistrarC;
	private JButton BModificarC;
	private JButton BBajaC;
	private JPanel PGastos;
	private JPanel PLGastos;
	private JScrollPane SPTablaG;
	private JTable TGastos;
	private JButton BRegistrarG;
	private JButton BModificarG;
	private JButton BBajaG;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	public JTable getTPedidos() {
		return TPedidos;
	}

	public JTable getTClientes() {
		return TClientes;
	}

	public JTable getTGastos() {
		return TGastos;
	}
}
