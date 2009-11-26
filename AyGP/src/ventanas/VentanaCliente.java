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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.TCliente;
import control.coperador;
import formateadores.FormateadorCuitCuil;
import formateadores.FormateadorTel;

/**
 * @author Graham
 */
public class VentanaCliente {
	private coperador controlador;
	// Determina si fue creada en la ventana principal, o a través del pedido
	private boolean principal;

	private void inicializarModelo(String titulo, String boton, coperador P) {
		controlador = P;

		FActCliente = new JFrame(titulo);
		BActClienteOK = new JButton(boton);
	}

	public JFrame getFramePrincipal() {
		return FActCliente;
	}

	public VentanaCliente(boolean prin, String titulo, String boton, coperador P) {
		principal = prin;
		inicializarModelo(titulo, boton, P);

		initComponents();

		FActCliente.setVisible(true);
	}

	public VentanaCliente(boolean prin, String titulo, String boton,
			coperador P, TCliente Cliente) {
		principal = prin;
		inicializarModelo(titulo, boton, P);

		initComponents();

		TFNombre.setText(Cliente.getNombre());
		TFDireccion.setText(Cliente.getDireccion());
		FTTelefeno.setValue(Cliente.getTelefono());
		FTDNI.setValue(Cliente.getDni());
		if (Cliente.getCuil_cuit().equals("")) {
			CBoxCUIT.setSelected(false);
			FTCUIT.setEnabled(false);
		} else {
			FTCUIT.setValue(Cliente.getCuil_cuit());
		}

		// FActCliente.pack();
		FActCliente.setVisible(true);
	}

	private void FActClienteWindowClosing(WindowEvent e) {
		if (principal) {
			controlador.cerroventanaGasto(false);
		} else {
			// Se llamó desde la creación/modificación de pedido
			controlador.cerroventanaClienteEnPedido(false);
		}

	}

	private void CBoxCUITActionPerformed(ActionEvent e) {
		FTCUIT.setEnabled(CBoxCUIT.isSelected());
	}

	private void BActClienteOKActionPerformed(ActionEvent e) {
		String nom = TFNombre.getText();
		String dir = TFDireccion.getText();
		String tel = FTTelefeno.getText();
		long dni = (Long) FTDNI.getValue();
		String cuit = FTCUIT.getText();

		boolean novacio = ((!nom.equals("")) && (!dir.equals("") && (dni > 0) && (!tel
				.equals(""))));
		if (novacio) {
			TCliente Cliente;
			if (CBoxCUIT.isSelected()) {
				Cliente = new TCliente(nom, dir, tel, dni, cuit, 0);
			} else {
				Cliente = new TCliente(nom, dir, tel, dni, 0);
			}

			FActCliente.setEnabled(false);
			if (principal) {
				controlador.actualizoCliente(Cliente);
			} else {
				controlador.actualizoClienteEnPedido(Cliente);
			}
			FActCliente.dispose();
		} else {
			JOptionPane.showMessageDialog(FActCliente,
					"Ingrese todos los campos obligatorios.");
		}
	}

	private void BActClienteCancelActionPerformed(ActionEvent e) {
		if (principal){
			controlador.cerroventanaCliente(false);
		}else{
			controlador.cerroventanaClienteEnPedido(false);
		}
		FActCliente.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// FActCliente = new JFrame();
		SPAtributosCliente = new JScrollPane();
		PAtributosCliente = new JPanel();
		LNombre = new JLabel();
		TFNombre = new JTextField();
		LDireccion = new JLabel();
		TFDireccion = new JTextField();
		LTelefono = new JLabel();
		FTTelefeno = new JFormattedTextField(new FormateadorTel());
		FTTelefeno.setValue("");
		LDNI = new JLabel();
		FTDNI = new JFormattedTextField();
		FTDNI.setValue(new Long(0));
		LCUIT = new JLabel();
		FTCUIT = new JFormattedTextField(new FormateadorCuitCuil());
		// FTDNI.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		FTCUIT.setValue("00-00000000-00");
		CBoxCUIT = new JCheckBox();
		PBotonesCliente = new JPanel();
		// BActClienteOK = new JButton();
		BActClienteCancel = new JButton();

		// ======== FActCliente ========
		{
			// FActCliente.setTitle("Alta/Modificaci\u00f3n de Cliente");
			FActCliente
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActCliente
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActCliente.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActClienteWindowClosing(e);
				}
			});
			Container FActClienteContentPane = FActCliente.getContentPane();
			FActClienteContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActClienteContentPane.getLayout()).columnWidths = new int[] {
					254, 0 };
			((GridBagLayout) FActClienteContentPane.getLayout()).rowHeights = new int[] {
					100, 40, 0 };
			((GridBagLayout) FActClienteContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActClienteContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPAtributosCliente ========
			{
				SPAtributosCliente.setViewportBorder(null);

				// ======== PAtributosCliente ========
				{
					PAtributosCliente.setBorder(null);
					PAtributosCliente.setLayout(new GridBagLayout());
					((GridBagLayout) PAtributosCliente.getLayout()).columnWidths = new int[] {
							10, 85, 85, 25, 5, 0 };
					((GridBagLayout) PAtributosCliente.getLayout()).rowHeights = new int[] {
							10, 30, 30, 30, 30, 30, 0, 0 };
					((GridBagLayout) PAtributosCliente.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAtributosCliente.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4 };

					// ---- LNombre ----
					LNombre.setText("Nombre:");
					PAtributosCliente.add(LNombre, new GridBagConstraints(1, 1,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFNombre ----
					TFNombre.setToolTipText("Nombre y apellido del cliente");
					PAtributosCliente.add(TFNombre, new GridBagConstraints(2,
							1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDireccion ----
					LDireccion.setText("Direcci\u00f3n:");
					PAtributosCliente.add(LDireccion, new GridBagConstraints(1,
							2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- TFDireccion ----
					TFDireccion.setToolTipText("Direcci\u00f3n del cliente");
					PAtributosCliente.add(TFDireccion, new GridBagConstraints(
							2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LTelefono ----
					LTelefono.setText("Tel\u00e9fono:");
					PAtributosCliente.add(LTelefono, new GridBagConstraints(1,
							3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- FTTelefeno ----
					FTTelefeno
							.setToolTipText("Tel\u00e9fono del cliente - n\u00fameros y s\u00edmbolos \u00fanicamente");
					PAtributosCliente.add(FTTelefeno, new GridBagConstraints(2,
							3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDNI ----
					LDNI.setText("DNI:");
					PAtributosCliente.add(LDNI, new GridBagConstraints(1, 4, 1,
							1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- FTDNI ----
					FTDNI.setToolTipText("DNI del cliente");
					PAtributosCliente.add(FTDNI, new GridBagConstraints(2, 4,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LCUIT ----
					LCUIT.setText("CUIL/CUIT:");
					PAtributosCliente.add(LCUIT, new GridBagConstraints(1, 5,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ---- FTCUIT ----
					FTCUIT.setToolTipText("CUIT o CUIL del cliente, opcional");
					PAtributosCliente.add(FTCUIT, new GridBagConstraints(2, 5,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- CBoxCUIT ----
					CBoxCUIT.setSelected(true);
					CBoxCUIT.setToolTipText("Tiene CUIT/CUIL");
					CBoxCUIT.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							CBoxCUITActionPerformed(e);
						}
					});
					PAtributosCliente.add(CBoxCUIT, new GridBagConstraints(3,
							5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
				}
				SPAtributosCliente.setViewportView(PAtributosCliente);
			}
			FActClienteContentPane.add(SPAtributosCliente,
					new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesCliente ========
			{
				PBotonesCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 30,
						5));

				// ---- BActClienteOK ----
				// BActClienteOK.setText("Crear");
				BActClienteOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActClienteOKActionPerformed(e);
					}
				});
				PBotonesCliente.add(BActClienteOK);

				// ---- BActClienteCancel ----
				BActClienteCancel.setText("Cancelar");
				BActClienteCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActClienteCancelActionPerformed(e);
					}
				});
				PBotonesCliente.add(BActClienteCancel);
			}
			FActClienteContentPane.add(PBotonesCliente, new GridBagConstraints(
					0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			FActCliente.setSize(340, 255);
			FActCliente.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActCliente;
	private JScrollPane SPAtributosCliente;
	private JPanel PAtributosCliente;
	private JLabel LNombre;
	private JTextField TFNombre;
	private JLabel LDireccion;
	private JTextField TFDireccion;
	private JLabel LTelefono;
	private JFormattedTextField FTTelefeno;
	private JLabel LDNI;
	private JFormattedTextField FTDNI;
	private JLabel LCUIT;
	private JFormattedTextField FTCUIT;
	private JCheckBox CBoxCUIT;
	private JPanel PBotonesCliente;
	private JButton BActClienteOK;
	private JButton BActClienteCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
