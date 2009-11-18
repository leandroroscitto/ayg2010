package pruebas;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import modelo.TEmpleado;
import enumerados.ECategoriaEmpleado;
import enumerados.EEstadoEmpleado;

/**
 * @author Graham
 */
public class Prot_empleado {

	private void JB_OKActionPerformed(ActionEvent e) {
		TEmpleado empleado = new TEmpleado(Integer.parseInt(textField1.getText()),"3276777", textField2.getText(), textField3.getText(), textField4.getText(),
				ECategoriaEmpleado.valueOf((String)comboBox2.getSelectedItem()), EEstadoEmpleado.valueOf((String)comboBox1.getSelectedItem()));
		prueba.g.agregar_elemento(empleado);
	}

	private void JB_KOMouseClicked(MouseEvent e) {
		// TODO add your code here
	}
	
	private void JDialog_EmpleadoWindowClosing(WindowEvent e) {
		System.out.println("Salgo");
	}

	public Prot_empleado(String[] Cats, String[] Ests) {
		initComponents(Cats, Ests);

		JDialog_Empleado.pack();
		JDialog_Empleado.validate();
		JDialog_Empleado.setVisible(true);
		System.out.println("Yo, ho!");
	}

	private void initComponents(Object[] Cats, Object[] Ests) {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		JDialog_Empleado = new JDialog();
		JPanel_Info = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		textField2 = new JTextField();
		label3 = new JLabel();
		textField3 = new JTextField();
		label4 = new JLabel();
		textField4 = new JTextField();
		label5 = new JLabel();

		ComboBoxModel comboMod2 = new DefaultComboBoxModel(new String[]{});
		comboBox2 = new JComboBox(comboMod2);
		
		comboBox2.removeAllItems();
		for (String item: (String[])Cats){
			comboBox2.addItem(item);
		}
		

		// INICIALZAR
		label6 = new JLabel();

		comboBox1 = new JComboBox(Ests);

		// INICIALIZAR
		JPanel_Botones = new JPanel();
		JB_OK = new JButton();
		JB_KO = new JButton();

		// ======== JDialog_Empleado ========
		{
			JDialog_Empleado
					.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			JDialog_Empleado
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			JDialog_Empleado.setTitle("Agregar Empleado");
			Container JDialog_EmpleadoContentPane = JDialog_Empleado
					.getContentPane();
			JDialog_EmpleadoContentPane.setLayout(new TableLayout(
					new double[][] { { TableLayout.FILL },
							{ TableLayout.FILL, TableLayout.MINIMUM } }));
			JDialog_Empleado.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					super.windowClosing(e);					
					JDialog_EmpleadoWindowClosing(e);
				}
			});

			// ======== JPanel_Info ========
			{
				JPanel_Info.setBorder(new TitledBorder("Datos"));
				JPanel_Info.setLayout(new TableLayout(new double[][] {
						{ TableLayout.MINIMUM, TableLayout.FILL },
						{ TableLayout.FILL, TableLayout.FILL, TableLayout.FILL,
								TableLayout.FILL, TableLayout.FILL,
								TableLayout.FILL } }));
				((TableLayout) JPanel_Info.getLayout()).setHGap(10);

				// ---- label1 ----
				label1.setText("ID:");
				label1.setLabelFor(textField1);
				JPanel_Info.add(label1, new TableLayoutConstraints(0, 0, 0, 0,
						TableLayoutConstraints.RIGHT,
						TableLayoutConstraints.FULL));
				JPanel_Info.add(textField1, new TableLayoutConstraints(1, 0, 1,
						0, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ---- label2 ----
				label2.setText("Nombre:");
				JPanel_Info.add(label2, new TableLayoutConstraints(0, 1, 0, 1,
						TableLayoutConstraints.RIGHT,
						TableLayoutConstraints.FULL));
				JPanel_Info.add(textField2, new TableLayoutConstraints(1, 1, 1,
						1, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ---- label3 ----
				label3.setText("Direcci\u00f3n:");
				JPanel_Info.add(label3, new TableLayoutConstraints(0, 2, 0, 2,
						TableLayoutConstraints.RIGHT,
						TableLayoutConstraints.FULL));
				JPanel_Info.add(textField3, new TableLayoutConstraints(1, 2, 1,
						2, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ---- label4 ----
				label4.setText("Tel\u00e9fono:");
				JPanel_Info.add(label4, new TableLayoutConstraints(0, 3, 0, 3,
						TableLayoutConstraints.RIGHT,
						TableLayoutConstraints.FULL));
				JPanel_Info.add(textField4, new TableLayoutConstraints(1, 3, 1,
						3, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ---- label5 ----
				label5.setText("Categor\u00eda");
				JPanel_Info.add(label5, new TableLayoutConstraints(0, 4, 0, 4,
						TableLayoutConstraints.RIGHT,
						TableLayoutConstraints.FULL));
				JPanel_Info.add(comboBox2, new TableLayoutConstraints(1, 4, 1,
						4, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ---- comboBox2 ----
				comboBox2.setBackground(UIManager
						.getColor("ComboBox.buttonDarkShadow"));
				JPanel_Info.add(comboBox2, new TableLayoutConstraints(1, 4, 1,
						4, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ---- label6 ----
				label6.setText("Estado:");
				JPanel_Info.add(label6, new TableLayoutConstraints(0, 5, 0, 5,
						TableLayoutConstraints.RIGHT,
						TableLayoutConstraints.FULL));
				JPanel_Info.add(comboBox1, new TableLayoutConstraints(1, 5, 1,
						5, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));
			}
			JDialog_EmpleadoContentPane.add(JPanel_Info,
					new TableLayoutConstraints(0, 0, 0, 0,
							TableLayoutConstraints.FULL,
							TableLayoutConstraints.FULL));

			// ======== JPanel_Botones ========
			{
				JPanel_Botones.setLayout(new GridLayout(1, 2, 15, 5));

				// ---- JB_OK ----
				JB_OK.setText("Aceptar");
				JB_OK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JB_OKActionPerformed(e);
					}
				});
				JPanel_Botones.add(JB_OK);

				// ---- JB_KO ----
				JB_KO.setText("Cancelar");
				JB_KO.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JB_KOMouseClicked(e);
					}
				});
				JPanel_Botones.add(JB_KO);
			}
			JDialog_EmpleadoContentPane.add(JPanel_Botones,
					new TableLayoutConstraints(0, 1, 0, 1,
							TableLayoutConstraints.CENTER,
							TableLayoutConstraints.CENTER));
			JDialog_Empleado.setSize(325, 220);
			JDialog_Empleado.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JDialog JDialog_Empleado;
	private JPanel JPanel_Info;
	private JLabel label1;
	private JTextField textField1;
	private JLabel label2;
	private JTextField textField2;
	private JLabel label3;
	private JTextField textField3;
	private JLabel label4;
	private JTextField textField4;
	private JLabel label5;
	private JComboBox comboBox2;
	private JLabel label6;
	private JComboBox comboBox1;
	private JPanel JPanel_Botones;
	private JButton JB_OK;
	private JButton JB_KO;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
