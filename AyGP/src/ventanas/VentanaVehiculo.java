package ventanas;

import java.awt.Container;
import java.awt.Dialog;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.TVehiculo;
import control.cadministrador;
import enumerados.EEstadoVehiculo;
import enumerados.ETipoVehiculo;
import formateadores.FormateadorPatente;

/**
 * @author Graham
 */
public class VentanaVehiculo {
	private cadministrador controlador;

	private void inicializarModelo(String titulo,String boton,cadministrador P) {
		controlador = P;
		
		FActVehiculo = new JFrame(titulo);
		BActVehiculoOK = new JButton(boton);
		
		DefaultComboBoxModel CMEst = new DefaultComboBoxModel(EEstadoVehiculo
				.values());
		DefaultComboBoxModel CMTipo = new DefaultComboBoxModel(ETipoVehiculo
				.values());

		CBEstado = new JComboBox(CMEst);
		CBTipo = new JComboBox(CMTipo);
	}

	public JFrame getFramePrincipal() {
		return FActVehiculo;
	}

	public VentanaVehiculo(String titulo,String boton,cadministrador P) {
		inicializarModelo(titulo,boton,P);

		initComponents();

		FActVehiculo.pack();
		FActVehiculo.setVisible(true);
	}

	public VentanaVehiculo(String titulo,String boton,cadministrador P, TVehiculo vehiculo) {
		inicializarModelo(titulo,boton,P);

		initComponents();

		FTPatente.setValue(vehiculo.getPatente());
		try {
			FTPatente.commitEdit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		TFMarca.setText(vehiculo.getMarca());
		TFModelo.setText(vehiculo.getModelo());
		TFColor.setText(vehiculo.getColor());
		SKilometraje.setValue(vehiculo.getKilometraje());
		CBEstado.setSelectedItem(vehiculo.getEstado());
		CBTipo.setSelectedItem(vehiculo.getTipoVehiculo());
		
		FActVehiculo.pack();
		FActVehiculo.setVisible(true);
	}

	private void FActVehiculoWindowClosing(WindowEvent e) {
		controlador.cerroventanaVehiculo(false);
	}

	private void BActVehiculoOKActionPerformed(ActionEvent e) {
		String pat = FTPatente.getValue().toString();
		String mar = TFMarca.getText();
		String mod = TFModelo.getText();
		String col = TFColor.getText();
		long kil = (Long) SKilometraje.getValue();
		EEstadoVehiculo est = (EEstadoVehiculo) CBEstado.getSelectedItem();
		ETipoVehiculo tip = (ETipoVehiculo) CBTipo.getSelectedItem();

		boolean novacio = ((!pat.equals("")) && (!mar.equals("")) && (!mod.equals("")) && (!col.equals("")));

		if (novacio) {
			TVehiculo Vehiculo = new TVehiculo(pat, mar, mod, col, kil, est,
					tip, 0);

			FActVehiculo.setEnabled(false);
			controlador.actualizoVehiculo(Vehiculo);
			FActVehiculo.dispose();
		} else {
			JOptionPane.showMessageDialog(FActVehiculo,
					"Ingrese todos los campos obligatorios.");
		}
	}

	private void BActVehiculoCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaVehiculo(false);
		FActVehiculo.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		
		//FActVehiculo = new JFrame();
		SPAtributosVehiculo = new JScrollPane();
		PAtributosVehiculo = new JPanel();
		LPatente = new JLabel();
		FTPatente = new JFormattedTextField(new FormateadorPatente());
		FTPatente.setValue("AAA000");
		FTPatente.setText("");
		LMarca = new JLabel();
		TFMarca = new JTextField();
		LModelo = new JLabel();
		TFModelo = new JTextField();
		LColor = new JLabel();
		TFColor = new JTextField();
		LKilometraje = new JLabel();
		SKilometraje = new JFormattedTextField(new Long(0));
		LEstado = new JLabel();
		// CBEstado = new JComboBox();
		LTipo = new JLabel();
		// CBTipo = new JComboBox();
		PBotonesVehiculo = new JPanel();
		//BActVehiculoOK = new JButton();
		BActVehiculoCancel = new JButton();

		// ======== FActVehiculo ========
		{
			//FActVehiculo.setTitle("Alta/Modificaci\u00f3n de Veh\u00edculo");
			FActVehiculo
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActVehiculo
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActVehiculo.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActVehiculoWindowClosing(e);
				}
			});
			Container FActVehiculoContentPane = FActVehiculo.getContentPane();
			FActVehiculoContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActVehiculoContentPane.getLayout()).columnWidths = new int[] {
					254, 0 };
			((GridBagLayout) FActVehiculoContentPane.getLayout()).rowHeights = new int[] {
					100, 40, 0 };
			((GridBagLayout) FActVehiculoContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActVehiculoContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPAtributosVehiculo ========
			{
				SPAtributosVehiculo.setViewportBorder(null);

				// ======== PAtributosVehiculo ========
				{
					PAtributosVehiculo.setBorder(null);
					PAtributosVehiculo.setLayout(new GridBagLayout());
					((GridBagLayout) PAtributosVehiculo.getLayout()).columnWidths = new int[] {
							10, 84, 147, 5, 0 };
					((GridBagLayout) PAtributosVehiculo.getLayout()).rowHeights = new int[] {
							10, 30, 30, 30, 30, 30, 30, 30, 0, 0 };
					((GridBagLayout) PAtributosVehiculo.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAtributosVehiculo.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4 };

					// ---- LPatente ----
					LPatente.setText("Patente:");
					PAtributosVehiculo.add(LPatente, new GridBagConstraints(1,
							1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosVehiculo.add(FTPatente, new GridBagConstraints(2,
							1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LMarca ----
					LMarca.setText("Marca:");
					PAtributosVehiculo.add(LMarca, new GridBagConstraints(1, 2,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFMarca ----
					TFMarca.setToolTipText("Direcci\u00f3n del empleado");
					PAtributosVehiculo.add(TFMarca, new GridBagConstraints(2,
							2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LModelo ----
					LModelo.setText("Modelo:");
					PAtributosVehiculo.add(LModelo, new GridBagConstraints(1,
							3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosVehiculo.add(TFModelo, new GridBagConstraints(2,
							3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LColor ----
					LColor.setText("Color:");
					PAtributosVehiculo.add(LColor, new GridBagConstraints(1, 4,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFColor ----
					TFColor
							.setToolTipText("Tel\u00e9fono del empleado - n\u00fameros y s\u00edmbolos \u00fanicamente");
					PAtributosVehiculo.add(TFColor, new GridBagConstraints(2,
							4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LKilometraje ----
					LKilometraje.setText("Kilometraje:");
					PAtributosVehiculo.add(LKilometraje,
							new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.EAST,
									GridBagConstraints.VERTICAL, new Insets(0,
											0, 5, 5), 0, 0));

					// ---- SKilometraje ----
					/*
					SKilometraje.setModel(new SpinnerNumberModel(0, null, null,
							5));
					PAtributosVehiculo.add(SKilometraje,
							new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.BOTH, new Insets(0, 0,
											5, 5), 0, 0));
					*/
					PAtributosVehiculo.add(SKilometraje,
							new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER,
									GridBagConstraints.BOTH, new Insets(0, 0,
											5, 5), 0, 0));

					// ---- LEstado ----
					LEstado.setText("Estado:");
					PAtributosVehiculo.add(LEstado, new GridBagConstraints(1,
							6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosVehiculo.add(CBEstado, new GridBagConstraints(2,
							6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LTipo ----
					LTipo.setText("Tipo:");
					PAtributosVehiculo.add(LTipo, new GridBagConstraints(1, 7,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosVehiculo.add(CBTipo, new GridBagConstraints(2, 7,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPAtributosVehiculo.setViewportView(PAtributosVehiculo);
			}
			FActVehiculoContentPane.add(SPAtributosVehiculo,
					new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesVehiculo ========
			{
				PBotonesVehiculo.setLayout(new FlowLayout(FlowLayout.CENTER,
						30, 5));

				// ---- BActVehiculoOK ----
				//BActVehiculoOK.setText("Crear");
				BActVehiculoOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActVehiculoOKActionPerformed(e);
					}
				});
				PBotonesVehiculo.add(BActVehiculoOK);

				// ---- BActVehiculoCancel ----
				BActVehiculoCancel.setText("Cancelar");
				BActVehiculoCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActVehiculoCancelActionPerformed(e);
					}
				});
				PBotonesVehiculo.add(BActVehiculoCancel);
			}
			FActVehiculoContentPane.add(PBotonesVehiculo,
					new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
			FActVehiculo.setSize(340, 315);
			FActVehiculo.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActVehiculo;
	private JScrollPane SPAtributosVehiculo;
	private JPanel PAtributosVehiculo;
	private JLabel LPatente;
	private JFormattedTextField FTPatente;
	private JLabel LMarca;
	private JTextField TFMarca;
	private JLabel LModelo;
	private JTextField TFModelo;
	private JLabel LColor;
	private JTextField TFColor;
	private JLabel LKilometraje;
	private JFormattedTextField SKilometraje;
	private JLabel LEstado;
	private JComboBox CBEstado;
	private JLabel LTipo;
	private JComboBox CBTipo;
	private JPanel PBotonesVehiculo;
	private JButton BActVehiculoOK;
	private JButton BActVehiculoCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
