package ventanas;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import modelo.TGasto;

import com.toedter.calendar.JDateChooser;

import control.coperador;
import enumerados.ECategoriaPedido;

public class VentanaGasto {
	private coperador controlador;

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActGasto;

	private JScrollPane SPAtributosGasto;

	private JPanel PAtributosGasto;

	private JPanel PNombre;
	
	private JLabel LNombre;

	private JTextField TFNombre;

	private JPanel PServicio;

	private JLabel LServicio;

	private JComboBox CBServicio;
	private JPanel PFecha;
	private JLabel LFecha;
	private JDateChooser DCFecha;
	private JLabel LDescripcion;
	private JScrollPane SPDescripcion;
	private JTextPane TPDescripcion;
	private JPanel PMonto;
	private JLabel LMonto;
	private JFormattedTextField FTMonto;
	private JPanel PBotonesGasto;
	private JButton BActGastoOK;
	private JButton BActGastoCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
	public VentanaGasto(String titulo, String boton, coperador P) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		FActGasto.setVisible(true);
	}
	public VentanaGasto(String titulo, String boton, coperador P, TGasto Gasto) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		TFNombre.setText(Gasto.getNombre());
		TPDescripcion.setText(Gasto.getDescripcion());
		DCFecha.setDate(Gasto.getFecha());
		CBServicio.setSelectedItem(Gasto.getCategoria());
		FTMonto.setValue(Gasto.getMonto());

		SPAtributosGasto.setPreferredSize(new Dimension(300, 250));
		FActGasto.pack();
		FActGasto.setVisible(true);
	}
	private void BActGastoCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaGasto(false);
		FActGasto.dispose();
	}
	private void BActGastoOKActionPerformed(ActionEvent e) {
		String nom = TFNombre.getText();
		String des = TPDescripcion.getText();
		Date fec = DCFecha.getDate();
		float mont = (Float) FTMonto.getValue();
		ECategoriaPedido tipo = (ECategoriaPedido) CBServicio.getSelectedItem();		

		boolean novacio = ((!nom.equals("")) && (!des.equals("")));
		if (novacio) {
			TGasto Gasto = new TGasto(0,nom,tipo,des,mont,fec);

			FActGasto.setEnabled(false);
			controlador.actualizoGasto(Gasto);
			FActGasto.dispose();
		} else {
			JOptionPane.showMessageDialog(FActGasto,
					"Ingrese todos los campos obligatorios.");
		}
	}
	private void FActGastoWindowClosing(WindowEvent e) {
		controlador.cerroventanaGasto(false);
	}
	public JFrame getFramePrincipal() {
		return FActGasto;
	}
	private void inicializarModelo(String titulo, String boton, coperador P) {
		controlador = P;
		
		CBServicio = new JComboBox(ECategoriaPedido.values());

		FActGasto = new JFrame(titulo);
		BActGastoOK = new JButton(boton);
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		//FActGasto = new JFrame();
		SPAtributosGasto = new JScrollPane();
		PAtributosGasto = new JPanel();
		PNombre = new JPanel();
		LNombre = new JLabel();
		TFNombre = new JTextField();
		PServicio = new JPanel();
		LServicio = new JLabel();
		//CBServicio = new JComboBox();
		PFecha = new JPanel();
		LFecha = new JLabel();
		DCFecha = new JDateChooser();
		LDescripcion = new JLabel();
		SPDescripcion = new JScrollPane();
		TPDescripcion = new JTextPane();
		PMonto = new JPanel();
		LMonto = new JLabel();
		FTMonto = new JFormattedTextField(new Float(0.0));
		PBotonesGasto = new JPanel();
		//BActGastoOK = new JButton();
		BActGastoCancel = new JButton();

		// ======== FActGasto ========
		{
			//FActGasto.setTitle("Alta/Modificaci\u00f3n de Gasto");
			FActGasto.setResizable(false);
			FActGasto
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActGasto
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActGasto.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActGastoWindowClosing(e);
				}
			});
			Container FActGastoContentPane = FActGasto.getContentPane();
			FActGastoContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActGastoContentPane.getLayout()).columnWidths = new int[] {
					254, 0 };
			((GridBagLayout) FActGastoContentPane.getLayout()).rowHeights = new int[] {
					100, 40, 0 };
			((GridBagLayout) FActGastoContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActGastoContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPAtributosGasto ========
			{
				SPAtributosGasto.setViewportBorder(null);

				// ======== PAtributosGasto ========
				{
					PAtributosGasto.setBorder(null);
					PAtributosGasto.setLayout(new GridBagLayout());
					((GridBagLayout) PAtributosGasto.getLayout()).columnWidths = new int[] {
							10, 85, 5, 0 };
					((GridBagLayout) PAtributosGasto.getLayout()).rowHeights = new int[] {
							10, 30, 30, 30, 30, 85, 30, 0, 0 };
					((GridBagLayout) PAtributosGasto.getLayout()).columnWeights = new double[] {
							0.0, 1.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAtributosGasto.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4 };

					// ======== PNombre ========
					{
						PNombre.setLayout(new GridLayout(1, 2, 5, 0));
						TFNombre.setToolTipText("Nombre representativo del gasto");

						// ---- LNombre ----
						LNombre.setText("Nombre:");
						PNombre.add(LNombre);
						PNombre.add(TFNombre);
					}
					PAtributosGasto.add(PNombre, new GridBagConstraints(1, 1,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PServicio ========
					{
						PServicio.setLayout(new GridLayout(1, 2, 5, 5));

						// ---- LServicio ----
						LServicio.setText("Tipo de servicio asociado:");
						PServicio.add(LServicio);
						PServicio.add(CBServicio);
					}
					PAtributosGasto.add(PServicio, new GridBagConstraints(1, 2,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PFecha ========
					{
						PFecha.setLayout(new GridLayout(1, 2, 5, 5));

						// ---- LFecha ----
						LFecha.setText("Fecha:");
						PFecha.add(LFecha);
						PFecha.add(DCFecha);
					}
					PAtributosGasto.add(PFecha, new GridBagConstraints(1, 3, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDescripcion ----
					LDescripcion.setText("Descripci\u00f3n:");
					PAtributosGasto.add(LDescripcion, new GridBagConstraints(1,
							4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== SPDescripcion ========
					{
						SPDescripcion.setViewportView(TPDescripcion);
						TPDescripcion.setToolTipText("Descripción del origen del gasto");
					}
					PAtributosGasto.add(SPDescripcion, new GridBagConstraints(
							1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PMonto ========
					{
						PMonto.setLayout(new GridLayout(1, 0, 10, 0));

						// ---- LMonto ----
						LMonto.setText("Monto: $");
						LMonto.setHorizontalAlignment(SwingConstants.RIGHT);
						FTMonto.setToolTipText("Monto del gasto, en pesos");
						PMonto.add(LMonto);
						PMonto.add(FTMonto);
					}
					PAtributosGasto.add(PMonto, new GridBagConstraints(1, 6, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPAtributosGasto.setViewportView(PAtributosGasto);
			}
			FActGastoContentPane.add(SPAtributosGasto, new GridBagConstraints(
					0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesGasto ========
			{
				PBotonesGasto
						.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

				// ---- BActGastoOK ----
				BActGastoOK.setText("Crear");
				BActGastoOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActGastoOKActionPerformed(e);
					}
				});
				PBotonesGasto.add(BActGastoOK);

				// ---- BActGastoCancel ----
				BActGastoCancel.setText("Cancelar");
				BActGastoCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActGastoCancelActionPerformed(e);
					}
				});
				PBotonesGasto.add(BActGastoCancel);
			}
			FActGastoContentPane.add(PBotonesGasto, new GridBagConstraints(0,
					1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			FActGasto.setSize(340, 340);
			FActGasto.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}
}
