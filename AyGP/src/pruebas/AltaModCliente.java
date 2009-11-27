package pruebas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import formateadores.FormateadorCuitCuil;
import formateadores.FormateadorTel;



/**
 * @author Graham
 */
public class AltaModCliente  {
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
	private JComboBox CBCUIT;
	private JCheckBox CBoxCUIT;
	private JPanel PBotonesCliente;
	private JButton BActClienteOK;
	private JButton BActClienteCancel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	public AltaModCliente(){
		this.initComponents();
		FActCliente.setVisible(true);
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		FActCliente = new JFrame();
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
		FTDNI = new JFormattedTextField(new FormateadorCuitCuil());		
		FTDNI.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		FTDNI.setValue("##-####-##");
		LCUIT = new JLabel();
		CBCUIT = new JComboBox();
		CBoxCUIT = new JCheckBox();
		PBotonesCliente = new JPanel();
		BActClienteOK = new JButton();
		BActClienteCancel = new JButton();

		//======== FActCliente ========
		{
			FActCliente.setTitle("Alta/Modificaci\u00f3n de Cliente");
			FActCliente.setResizable(false);
			Container FActClienteContentPane = FActCliente.getContentPane();
			FActClienteContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)FActClienteContentPane.getLayout()).columnWidths = new int[] {254, 0};
			((GridBagLayout)FActClienteContentPane.getLayout()).rowHeights = new int[] {341, 40, 0};
			((GridBagLayout)FActClienteContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)FActClienteContentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

			//======== SPAtributosCliente ========
			{
				SPAtributosCliente.setViewportBorder(null);

				//======== PAtributosCliente ========
				{
					PAtributosCliente.setBorder(null);
					PAtributosCliente.setLayout(new GridBagLayout());
					((GridBagLayout)PAtributosCliente.getLayout()).columnWidths = new int[] {10, 84, 147, 25, 5, 0};
					((GridBagLayout)PAtributosCliente.getLayout()).rowHeights = new int[] {10, 30, 30, 30, 30, 25, 0};
					((GridBagLayout)PAtributosCliente.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};
					((GridBagLayout)PAtributosCliente.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

					//---- LNombre ----
					LNombre.setText("Nombre:");
					PAtributosCliente.add(LNombre, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
						new Insets(0, 0, 5, 5), 0, 0));

					//---- TFNombre ----
					TFNombre.setHorizontalAlignment(SwingConstants.LEFT);
					PAtributosCliente.add(TFNombre, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));

					//---- LDireccion ----
					LDireccion.setText("Direcci\u00f3n:");
					PAtributosCliente.add(LDireccion, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
						new Insets(0, 0, 5, 5), 0, 0));
					PAtributosCliente.add(TFDireccion, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));

					//---- LTelefono ----
					LTelefono.setText("Tel\u00e9fono:");
					PAtributosCliente.add(LTelefono, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
						GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
						new Insets(0, 0, 5, 5), 0, 0));
					PAtributosCliente.add(FTTelefeno, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));

					//---- LDNI ----
					LDNI.setText("DNI:");
					PAtributosCliente.add(LDNI, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
						new Insets(0, 0, 5, 5), 0, 0));
					PAtributosCliente.add(FTDNI, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));

					//---- LCUIT ----
					LCUIT.setText("CUIL/CUIT:");
					PAtributosCliente.add(LCUIT, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
						GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
						new Insets(0, 0, 0, 5), 0, 0));
					PAtributosCliente.add(CBCUIT, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));

					//---- CBoxCUIT ----
					CBoxCUIT.setSelected(true);
					CBoxCUIT.setToolTipText("Tiene CUIT/CUIL");
					PAtributosCliente.add(CBoxCUIT, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
						new Insets(0, 0, 0, 5), 0, 0));
				}
				SPAtributosCliente.setViewportView(PAtributosCliente);
			}
			FActClienteContentPane.add(SPAtributosCliente, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//======== PBotonesCliente ========
			{
				PBotonesCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

				//---- BActClienteOK ----
				BActClienteOK.setText("Crear");
				PBotonesCliente.add(BActClienteOK);

				//---- BActClienteCancel ----
				BActClienteCancel.setText("Cancelar");
				PBotonesCliente.add(BActClienteCancel);
			}
			FActClienteContentPane.add(PBotonesCliente, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
			FActCliente.setSize(285, 235);
			FActCliente.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
}
