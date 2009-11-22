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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.TEmpleado;
import modelo.THorario;
import control.cadministrador;
import enumerados.ECategoriaEmpleado;
import enumerados.EDia;
import enumerados.EEstadoEmpleado;
import formateadores.FormateadorTel;

/*
 * Created by JFormDesigner on Mon Nov 16 18:56:26 GYT 2009
 */

public class VentanaEmpleado {
	private cadministrador controlador;
	private THorario horariolocal;

	@SuppressWarnings("serial")
	private void inicilizarModelo(cadministrador P) {
		controlador = P;
		horariolocal = new THorario();

		DefaultTableModel TM = new DefaultTableModel(new String[] { "Día",
				"Entrada", "Salida" }, 0) {
			boolean[] columnEditable = new boolean[] { false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnEditable[columnIndex];
			}
		};
		DefaultComboBoxModel CMCat = new DefaultComboBoxModel(
				ECategoriaEmpleado.values());
		DefaultComboBoxModel CMEst = new DefaultComboBoxModel(EEstadoEmpleado
				.values());
		THorarios = new JTable(TM);
		CBCategoria = new JComboBox(CMCat);
		CBEstado = new JComboBox(CMEst);
	}

	public THorario getHorarioLocal() {
		return horariolocal;
	}

	public JTable getTHorarios() {
		return THorarios;
	}

	public void agregarRHorario(EDia Dia, int HI, int HF) {
		horariolocal.agregar_rango_horario(Dia, HI, HF);
	}

	public JFrame getFramePrincipal() {
		return FActEmpleado;
	}

	public VentanaEmpleado(cadministrador P) {
		inicilizarModelo(P);

		initComponents();

		FActEmpleado.setVisible(true);
	}

	public VentanaEmpleado(cadministrador P, TEmpleado Emp) {
		inicilizarModelo(P);

		initComponents();

		TFNombre.setText(Emp.getNombre());
		TFDireccion.setText(Emp.getDireccion());
		FTDNI.setValue(Emp.getDni());
		FTLegajo.setValue(Emp.getLegajo());
		FTTelefeno.setValue(Emp.getTelefono());
		CBCategoria.setSelectedItem(Emp.getCategoria());
		CBEstado.setSelectedItem(Emp.getEstado());

		horariolocal=Emp.getRangosHorarios();

		FActEmpleado.setVisible(true);
	}

	private void FActEmpleadoWindowClosing(WindowEvent e) {
		controlador.cerroventanaEmpleado(false);
	}

	private void BAgregarHActionPerformed(ActionEvent e) {
		controlador.crearHorario();
	}

	private void BQuitarHActionPerformed(ActionEvent e) {
		int indicevista = THorarios.getSelectedRow();
		if (indicevista < 0) {
			JOptionPane.showMessageDialog(FActEmpleado,
					"Seleccione un rango horario primero.");
		} else {
			int indice = THorarios.getRowSorter().convertRowIndexToModel(
					indicevista);
			controlador.quitoHorario(indice);
		}
	}

	private void BActEmpleadoOKActionPerformed(ActionEvent e) {
		String nom = TFNombre.getText();
		String dir = TFDireccion.getText();
		String tel = FTTelefeno.getValue().toString();
		long dni = (Long) FTDNI.getValue();
		long leg = (Long) FTLegajo.getValue();
		ECategoriaEmpleado cat = (ECategoriaEmpleado) CBCategoria
				.getSelectedItem();
		EEstadoEmpleado est = (EEstadoEmpleado) CBEstado.getSelectedItem();

		boolean novacio = ((nom != "") && (dir != "")
				&& (tel != "0" || tel != "") && (dni != 0) && (leg != 0));
		if (novacio) {
			TEmpleado Empleado = new TEmpleado(leg, dni, nom, dir, tel, cat,
					est, 0);
			Empleado.setHorario(horariolocal);

			controlador.actualizoEmpleado(Empleado);
			FActEmpleado.dispose();
		} else {
			JOptionPane.showMessageDialog(FActEmpleado,
					"Ingrese todos los campos obligatorios.");
		}
	}

	private void BActEmpleadoCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaEmpleado(false);
		FActEmpleado.dispose();
	}

	@SuppressWarnings("serial")
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		FActEmpleado = new JFrame();
		SPAtributosEmpleado = new JScrollPane();
		PAtributosEmpleado = new JPanel();
		LNombre = new JLabel();
		TFNombre = new JTextField();
		LDireccion = new JLabel();
		TFDireccion = new JTextField();
		LDNI = new JLabel();
		FTDNI = new JFormattedTextField(new Long(0));
		FTDNI.setText("");
		LLegajo = new JLabel();
		FTLegajo = new JFormattedTextField(new Long(0));
		FTLegajo.setText("");
		LTelefono = new JLabel();
		FTTelefeno = new JFormattedTextField(new FormateadorTel());
		FTTelefeno.setValue("");
		FTTelefeno.setText("");
		LCategoria = new JLabel();
		// CBCategoria = new JComboBox();
		LEstado = new JLabel();
		// CBEstado = new JComboBox();
		PHorarios = new JPanel();
		SPHorarios = new JScrollPane();
		// THorarios = new JTable();
		PBHorarios = new JPanel();
		BAgregarH = new JButton();
		BQuitarH = new JButton();
		PBotonesEmpleado = new JPanel();
		BActEmpleadoOK = new JButton();
		BActEmpleadoCancel = new JButton();

		// ======== FActEmpleado ========
		{
			FActEmpleado.setTitle("Alta/Modificaci\u00f3n de Empleado");
			FActEmpleado
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActEmpleado
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActEmpleado.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActEmpleadoWindowClosing(e);
				}
			});
			Container FActEmpleadoContentPane = FActEmpleado.getContentPane();
			FActEmpleadoContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActEmpleadoContentPane.getLayout()).columnWidths = new int[] {
					254, 0 };
			((GridBagLayout) FActEmpleadoContentPane.getLayout()).rowHeights = new int[] {
					50, 40, 0 };
			((GridBagLayout) FActEmpleadoContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActEmpleadoContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPAtributosEmpleado ========
			{
				SPAtributosEmpleado.setViewportBorder(null);

				// ======== PAtributosEmpleado ========
				{
					PAtributosEmpleado.setBorder(null);
					PAtributosEmpleado.setLayout(new GridBagLayout());
					((GridBagLayout) PAtributosEmpleado.getLayout()).columnWidths = new int[] {
							10, 84, 147, 5, 0 };
					((GridBagLayout) PAtributosEmpleado.getLayout()).rowHeights = new int[] {
							10, 30, 30, 30, 30, 30, 30, 30, 175, 0, 0 };
					((GridBagLayout) PAtributosEmpleado.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAtributosEmpleado.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
							1.0E-4 };

					// ---- LNombre ----
					LNombre.setText("Nombre:");
					PAtributosEmpleado.add(LNombre, new GridBagConstraints(1,
							1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFNombre ----
					TFNombre.setToolTipText("Nombre y apellido del empleado");
					PAtributosEmpleado.add(TFNombre, new GridBagConstraints(2,
							1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDireccion ----
					LDireccion.setText("Direcci\u00f3n:");
					PAtributosEmpleado.add(LDireccion, new GridBagConstraints(
							1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFDireccion ----
					TFDireccion.setToolTipText("Direcci\u00f3n del empleado");
					PAtributosEmpleado.add(TFDireccion, new GridBagConstraints(
							2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDNI ----
					LDNI.setText("DNI:");
					PAtributosEmpleado.add(LDNI, new GridBagConstraints(1, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosEmpleado.add(FTDNI, new GridBagConstraints(2, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LLegajo ----
					LLegajo.setText("Legajo:");
					PAtributosEmpleado.add(LLegajo, new GridBagConstraints(1,
							4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosEmpleado.add(FTLegajo, new GridBagConstraints(2,
							4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LTelefono ----
					LTelefono.setText("Tel\u00e9fono:");
					PAtributosEmpleado.add(LTelefono, new GridBagConstraints(1,
							5, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- FTTelefeno ----
					FTTelefeno
							.setToolTipText("Tel\u00e9fono del empleado - n\u00fameros y s\u00edmbolos \u00fanicamente");
					PAtributosEmpleado.add(FTTelefeno, new GridBagConstraints(
							2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LCategoria ----
					LCategoria.setText("Categor\u00eda:");
					PAtributosEmpleado.add(LCategoria, new GridBagConstraints(
							1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosEmpleado.add(CBCategoria, new GridBagConstraints(
							2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LEstado ----
					LEstado.setText("Estado:");
					PAtributosEmpleado.add(LEstado, new GridBagConstraints(1,
							7, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosEmpleado.add(CBEstado, new GridBagConstraints(2,
							7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PHorarios ========
					{
						PHorarios.setBorder(new TitledBorder(
								"Horarios de trabajo:"));
						PHorarios.setLayout(new GridBagLayout());
						((GridBagLayout) PHorarios.getLayout()).rowHeights = new int[] {
								58, 35 };
						((GridBagLayout) PHorarios.getLayout()).columnWeights = new double[] { 1.0 };
						((GridBagLayout) PHorarios.getLayout()).rowWeights = new double[] {
								1.0, 0.0 };

						// ======== SPHorarios ========
						{

							// ---- THorarios ----
							THorarios
									.setPreferredScrollableViewportSize(new Dimension(
											140, 50));
							THorarios.setAutoCreateRowSorter(true);
							/*
							 * THorarios .setModel(new DefaultTableModel( new
							 * Object[][] { { null, null, null }, }, new
							 * String[] { "Dia", "Entrada", "Salida" }) {
							 * boolean[] columnEditable = new boolean[] { false,
							 * false, false };
							 * 
							 * @Override public boolean isCellEditable( int
							 * rowIndex, int columnIndex) { return
							 * columnEditable[columnIndex]; } });
							 */
							THorarios
									.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							THorarios.setFillsViewportHeight(true);
							SPHorarios.setViewportView(THorarios);
						}
						PHorarios.add(SPHorarios, new GridBagConstraints(0, 0,
								1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));

						// ======== PBHorarios ========
						{
							PBHorarios.setLayout(new FlowLayout(
									FlowLayout.CENTER, 20, 0));

							// ---- BAgregarH ----
							BAgregarH.setText("Agregar");
							BAgregarH.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									BAgregarHActionPerformed(e);
								}
							});
							PBHorarios.add(BAgregarH);

							// ---- BQuitarH ----
							BQuitarH.setText("Quitar");
							BQuitarH.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									BQuitarHActionPerformed(e);
								}
							});
							PBHorarios.add(BQuitarH);
						}
						PHorarios.add(PBHorarios, new GridBagConstraints(0, 1,
								1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
					}
					PAtributosEmpleado.add(PHorarios, new GridBagConstraints(1,
							8, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPAtributosEmpleado.setViewportView(PAtributosEmpleado);
			}
			FActEmpleadoContentPane.add(SPAtributosEmpleado,
					new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesEmpleado ========
			{
				PBotonesEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER,
						30, 5));

				// ---- BActEmpleadoOK ----
				BActEmpleadoOK.setText("Crear");
				BActEmpleadoOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActEmpleadoOKActionPerformed(e);
					}
				});
				PBotonesEmpleado.add(BActEmpleadoOK);

				// ---- BActEmpleadoCancel ----
				BActEmpleadoCancel.setText("Cancelar");
				BActEmpleadoCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActEmpleadoCancelActionPerformed(e);
					}
				});
				PBotonesEmpleado.add(BActEmpleadoCancel);
			}
			FActEmpleadoContentPane.add(PBotonesEmpleado,
					new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
			FActEmpleado.setSize(340, 490);
			FActEmpleado.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActEmpleado;
	private JScrollPane SPAtributosEmpleado;
	private JPanel PAtributosEmpleado;
	private JLabel LNombre;
	private JTextField TFNombre;
	private JLabel LDireccion;
	private JTextField TFDireccion;
	private JLabel LDNI;
	private JFormattedTextField FTDNI;
	private JLabel LLegajo;
	private JFormattedTextField FTLegajo;
	private JLabel LTelefono;
	private JFormattedTextField FTTelefeno;
	private JLabel LCategoria;
	private JComboBox CBCategoria;
	private JLabel LEstado;
	private JComboBox CBEstado;
	private JPanel PHorarios;
	private JScrollPane SPHorarios;
	private JTable THorarios;
	private JPanel PBHorarios;
	private JButton BAgregarH;
	private JButton BQuitarH;
	private JPanel PBotonesEmpleado;
	private JButton BActEmpleadoOK;
	private JButton BActEmpleadoCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
