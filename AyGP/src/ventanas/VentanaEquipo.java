package ventanas;

/*
 * Created by JFormDesigner on Mon Nov 16 19:21:44 GYT 2009
 */

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.TEquipo;
import control.cadministrador;
import enumerados.ECategoriaEquipo;
import enumerados.EEstadoEquipo;

public class VentanaEquipo {
	private cadministrador controlador;

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActEquipo;

	private JScrollPane SPAtributosEquipo;

	private JPanel PAtributosEquipo;

	private JLabel LNombre;

	private JTextField TFNombre;

	private JLabel LCategoria;

	private JComboBox CBCategoria;

	private JLabel LEstado;

	private JComboBox CBEstado;
	private JPanel PBotonesEquipo;
	private JButton BActEquipoOK;
	private JButton BActEquipoCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
	public VentanaEquipo(String titulo, String boton, cadministrador P) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		FActEquipo.setVisible(true);
	}
	public VentanaEquipo(String titulo, String boton, cadministrador P,
			TEquipo Equipo) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		TFNombre.setText(Equipo.getNombre());
		CBCategoria.setSelectedItem(Equipo.getTipo_equipo());
		CBEstado.setSelectedItem(Equipo.getEstado());

		FActEquipo.setVisible(true);
	}
	private void BActEquipoCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaEquipo(false);
		FActEquipo.dispose();
	}
	private void BActEquipoOKActionPerformed(ActionEvent e) {
		String nom = TFNombre.getText();
		EEstadoEquipo est = (EEstadoEquipo) CBEstado.getSelectedItem();
		ECategoriaEquipo cat = (ECategoriaEquipo) CBCategoria.getSelectedItem();

		boolean novacio = (!nom.equals(""));

		if (novacio) {
			TEquipo Equipo = new TEquipo(0, nom, cat, est);

			FActEquipo.setEnabled(false);
			controlador.actualizoEquipo(Equipo);
			FActEquipo.dispose();
		} else {
			JOptionPane.showMessageDialog(FActEquipo,
					"Ingrese todos los campos obligatorios.");
		}
	}
	private void FActEquipoWindowClosing(WindowEvent e) {
		controlador.cerroventanaEquipo(false);
	}
	public JFrame getFramePrincipal() {
		return FActEquipo;
	}
	private void inicializarModelo(String titulo, String boton, cadministrador P) {
		controlador = P;

		FActEquipo = new JFrame(titulo);
		BActEquipoOK = new JButton(boton);

		DefaultComboBoxModel CMCat = new DefaultComboBoxModel(ECategoriaEquipo
				.values());
		DefaultComboBoxModel CMEst = new DefaultComboBoxModel(EEstadoEquipo
				.values());

		CBEstado = new JComboBox(CMEst);
		CBCategoria = new JComboBox(CMCat);
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// FActEquipo = new JFrame();
		SPAtributosEquipo = new JScrollPane();
		PAtributosEquipo = new JPanel();
		LNombre = new JLabel();
		TFNombre = new JTextField();
		LCategoria = new JLabel();
		// CBCategoria = new JComboBox();
		LEstado = new JLabel();
		// CBEstado = new JComboBox();
		PBotonesEquipo = new JPanel();
		// BActEquipoOK = new JButton();
		BActEquipoCancel = new JButton();

		// ======== FActEquipo ========
		{
			// FActEquipo.setTitle("Alta/Modificaci\u00f3n de Equipo");
			FActEquipo
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActEquipo
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActEquipo.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActEquipoWindowClosing(e);
				}
			});
			Container FActEquipoContentPane = FActEquipo.getContentPane();
			FActEquipoContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActEquipoContentPane.getLayout()).columnWidths = new int[] {
					400, 0 };
			((GridBagLayout) FActEquipoContentPane.getLayout()).rowHeights = new int[] {
					100, 40, 0 };
			((GridBagLayout) FActEquipoContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActEquipoContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPAtributosEquipo ========
			{
				SPAtributosEquipo.setViewportBorder(null);

				// ======== PAtributosEquipo ========
				{
					PAtributosEquipo.setBorder(null);
					PAtributosEquipo.setLayout(new GridBagLayout());
					((GridBagLayout) PAtributosEquipo.getLayout()).columnWidths = new int[] {
							10, 85, 85, 5, 0 };
					((GridBagLayout) PAtributosEquipo.getLayout()).rowHeights = new int[] {
							10, 30, 30, 30, 0, 0 };
					((GridBagLayout) PAtributosEquipo.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAtributosEquipo.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4 };

					// ---- LNombre ----
					LNombre.setText("Nombre:");
					PAtributosEquipo.add(LNombre, new GridBagConstraints(1, 1,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFNombre ----
					TFNombre.setToolTipText("Nombre del equipo");
					PAtributosEquipo.add(TFNombre, new GridBagConstraints(2, 1,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LCategoria ----
					LCategoria.setText("Categor\u00eda:");
					PAtributosEquipo.add(LCategoria, new GridBagConstraints(1,
							2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosEquipo.add(CBCategoria, new GridBagConstraints(2,
							2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LEstado ----
					LEstado.setText("Estado:");
					PAtributosEquipo.add(LEstado, new GridBagConstraints(1, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAtributosEquipo.add(CBEstado, new GridBagConstraints(2, 3,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPAtributosEquipo.setViewportView(PAtributosEquipo);
			}
			FActEquipoContentPane.add(SPAtributosEquipo,
					new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesEquipo ========
			{
				PBotonesEquipo.setLayout(new FlowLayout(FlowLayout.CENTER, 30,
						5));

				// ---- BActEquipoOK ----
				// BActEquipoOK.setText("Crear");
				BActEquipoOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActEquipoOKActionPerformed(e);
					}
				});
				PBotonesEquipo.add(BActEquipoOK);

				// ---- BActEquipoCancel ----
				BActEquipoCancel.setText("Cancelar");
				BActEquipoCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActEquipoCancelActionPerformed(e);
					}
				});
				PBotonesEquipo.add(BActEquipoCancel);
			}
			FActEquipoContentPane.add(PBotonesEquipo, new GridBagConstraints(0,
					1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			FActEquipo.setSize(340, 200);
			FActEquipo.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}
}
