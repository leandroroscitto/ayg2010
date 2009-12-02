package ventanas;

/*
 * Created by JFormDesigner on Mon Nov 16 19:37:38 GYT 2009
 */
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import modelo.TEvento;

import com.toedter.calendar.JDateChooser;

import control.cadministrador;

public class VentanaEvento {
	private cadministrador controlador;

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActEvento;

	private JScrollPane SPAtributosEvento;

	private JPanel PAtributosEvento;

	private JPanel PNombre;

	private JLabel LNombre;

	private JTextField TFNombre;

	private JLabel LDescripcion;

	private JScrollPane SPDescripcion;

	private JTextPane TPDescripcion;
	private JPanel PFecha;
	private JLabel LFecha;
	private JDateChooser DCFecha;
	private JPanel PBotonesEvento;
	private JButton BActEventoOK;
	private JButton BActEventoCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
	public VentanaEvento(String titulo, String boton, cadministrador P) {
		inicializarModelo(titulo, boton, P);

		initComponents();

		FActEvento.setVisible(true);
	}
	public VentanaEvento(String titulo, String boton, cadministrador P,
			TEvento Evento) {
		inicializarModelo(titulo, boton, P);

		initComponents();
		
		TFNombre.setText(Evento.get_nombre());
		TPDescripcion.setText(Evento.getDescripcion());
		DCFecha.setDate(Evento.getFecha());

		SPAtributosEvento.setPreferredSize(new Dimension(300,250));
		FActEvento.pack();
		FActEvento.setVisible(true);
	}
	private void BActEventoCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaEvento(false);
		FActEvento.dispose();
	}
	private void BActEventoOKActionPerformed(ActionEvent e) {
		String nom = TFNombre.getText();
		String des = TPDescripcion.getText();
		Date fec = DCFecha.getDate();

		boolean novacio = ((!nom.equals("")) && (!des.equals("")));	
		if (novacio) {
			TEvento Evento = new TEvento(0, nom, des, fec);

			FActEvento.setEnabled(false);
			controlador.actualizoEvento(Evento);
			FActEvento.dispose();
		} else {
			JOptionPane.showMessageDialog(FActEvento,
					"Ingrese todos los campos obligatorios.");
		}
	}
	private void FActEventoWindowClosing(WindowEvent e) {
		controlador.cerroventanaEvento(false);
	}
	public JFrame getFramePrincipal() {
		return FActEvento;
	}
	private void inicializarModelo(String titulo, String boton, cadministrador P) {
		controlador = P;

		FActEvento = new JFrame(titulo);
		BActEventoOK = new JButton(boton);
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// FActEvento = new JFrame();
		SPAtributosEvento = new JScrollPane();
		PAtributosEvento = new JPanel();
		PNombre = new JPanel();
		LNombre = new JLabel();
		TFNombre = new JTextField();
		LDescripcion = new JLabel();
		SPDescripcion = new JScrollPane();
		TPDescripcion = new JTextPane();
		PFecha = new JPanel();
		LFecha = new JLabel();
		DCFecha = new JDateChooser();
		PBotonesEvento = new JPanel();
		// BActEventoOK = new JButton();
		BActEventoCancel = new JButton();

		// ======== FActEvento ========
		{
			// FActEvento.setTitle("Alta/Modificaci\u00f3n de Evento");
			FActEvento.setResizable(false);
			FActEvento.setPreferredSize(new Dimension(380,270));
			FActEvento
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActEvento
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActEvento.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActEventoWindowClosing(e);
				}
			});
			Container FActEventoContentPane = FActEvento.getContentPane();
			FActEventoContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)FActEventoContentPane.getLayout()).columnWidths = new int[] {200, 0};
			((GridBagLayout)FActEventoContentPane.getLayout()).rowHeights = new int[] {100, 40, 0};
			((GridBagLayout)FActEventoContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)FActEventoContentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

			// ======== SPAtributosEvento ========
			{
				//SPAtributosEvento.setViewportBorder(null);
				SPAtributosEvento.setViewportView(PAtributosEvento);
				SPAtributosEvento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				// ======== PAtributosEvento ========
				{
					PAtributosEvento.setBorder(null);
					PAtributosEvento.setLayout(new GridBagLayout());
					((GridBagLayout)PAtributosEvento.getLayout()).columnWidths = new int[] {10, 315, 5, 0};
					((GridBagLayout)PAtributosEvento.getLayout()).rowHeights = new int[] {10, 30, 30, 85, 30, 0, 0};
					((GridBagLayout)PAtributosEvento.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
					((GridBagLayout)PAtributosEvento.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

					// ======== PNombre ========
					{
						PNombre.setLayout(new GridLayout(1, 2, 5, 0));
						TFNombre.setToolTipText("Nombre del evento");

						// ---- LNombre ----
						LNombre.setText("Nombre:");
						PNombre.add(LNombre);
						PNombre.add(TFNombre);
					}
					PAtributosEvento.add(PNombre, new GridBagConstraints(1, 1,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LDescripcion ----
					LDescripcion.setText("Descripci\u00f3n:");
					PAtributosEvento.add(LDescripcion, new GridBagConstraints(
							1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== SPDescripcion ========
					{
						SPDescripcion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						SPDescripcion.setViewportView(TPDescripcion);
						TPDescripcion.setToolTipText("Descripción resumida del evento");
					}
					PAtributosEvento.add(SPDescripcion, new GridBagConstraints(
							1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ======== PFecha ========
					{
						PFecha.setLayout(new GridLayout(1, 0, 10, 0));

						// ---- LFecha ----
						LFecha.setText("Fecha:");
						LFecha.setHorizontalAlignment(SwingConstants.RIGHT);
						PFecha.add(LFecha);

						// ---- DCFecha ----
						DCFecha
								.setToolTipText("Fecha en la que ocurri\u00f3 el evento");
						PFecha.add(DCFecha);
					}
					PAtributosEvento.add(PFecha, new GridBagConstraints(1, 4,
							1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPAtributosEvento.setViewportView(PAtributosEvento);
			}
			FActEventoContentPane.add(SPAtributosEvento,
					new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesEvento ========
			{
				PBotonesEvento.setLayout(new FlowLayout(FlowLayout.CENTER, 30,
						5));

				// ---- BActEventoOK ----
				// BActEventoOK.setText("Crear");
				BActEventoOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActEventoOKActionPerformed(e);
					}
				});
				PBotonesEvento.add(BActEventoOK);

				// ---- BActEventoCancel ----
				BActEventoCancel.setText("Cancelar");
				BActEventoCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActEventoCancelActionPerformed(e);
					}
				});
				PBotonesEvento.add(BActEventoCancel);
			}
			FActEventoContentPane.add(PBotonesEvento, new GridBagConstraints(0,
					1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			FActEvento.setSize(340, 280);
			FActEvento.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}
}
