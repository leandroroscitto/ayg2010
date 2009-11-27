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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import control.cadministrador;
import enumerados.EDia;

public class VentanaHorarios {
	private cadministrador controlador;

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame FActHorarios;

	private JScrollPane SPHorarios;

	private JPanel PAHorarios;

	private JLabel LDia;
	
	private JComboBox CBDia;

	private JLabel LRInicio;

	private JPanel PRInicio;
	private JSpinner SHoraI;
	private JLabel LDosPuntos1;
	private JSpinner SMinutosI;
	private JLabel LRFin;
	private JPanel PRFin;
	private JSpinner SHoraF;
	private JLabel LDosPuntos2;
	private JSpinner SMinutosF;
	private JPanel PBotonesHorarios;
	private JButton BActHorariosOK;
	private JButton BActHorariosCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
	public VentanaHorarios(cadministrador P) {
		inicilizarModelo(P);
		initComponents();

		FActHorarios.setVisible(true);
	}
	private void BActHorariosCancelActionPerformed(ActionEvent e) {
		controlador.cerroventanaHorarios();
		FActHorarios.dispose();
	}
	private void BActHorariosOKActionPerformed(ActionEvent e) {
		EDia Dia = (EDia) CBDia.getSelectedItem();
		int HI = (Integer) (SHoraI.getValue()) * 100
				+ (Integer) (SMinutosI.getValue());
		int HF = (Integer) (SHoraF.getValue()) * 100
				+ (Integer) (SMinutosF.getValue());

		boolean rangoval=(HI<=HF);
		if (rangoval){
			controlador.creoHorario(Dia, HI, HF);
			FActHorarios.dispose();
		}else{
			JOptionPane.showMessageDialog(FActHorarios, "La hora de inicio debe ser anterior o igual a la de fin.");
		}
	}
	private void FActHorariosWindowClosing(WindowEvent e) {
		controlador.cerroventanaHorarios();		
	}
	private void inicilizarModelo(cadministrador P) {
		controlador = P;

		DefaultComboBoxModel CM = new DefaultComboBoxModel(EDia.values());
		CBDia = new JComboBox(CM);
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		FActHorarios = new JFrame();
		SPHorarios = new JScrollPane();
		PAHorarios = new JPanel();
		LDia = new JLabel();
		// CBDia = new JComboBox();
		LRInicio = new JLabel();
		PRInicio = new JPanel();
		SHoraI = new JSpinner();
		LDosPuntos1 = new JLabel();
		SMinutosI = new JSpinner();
		LRFin = new JLabel();
		PRFin = new JPanel();
		SHoraF = new JSpinner();
		LDosPuntos2 = new JLabel();
		SMinutosF = new JSpinner();
		PBotonesHorarios = new JPanel();
		BActHorariosOK = new JButton();
		BActHorariosCancel = new JButton();

		// ======== FActHorarios ========
		{
			FActHorarios.setTitle("Asignar Horarios de Empleado");
			FActHorarios
					.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			FActHorarios
					.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			FActHorarios.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActHorariosWindowClosing(e);
				}
			});
			Container FActHorariosContentPane = FActHorarios.getContentPane();
			FActHorariosContentPane.setLayout(new GridBagLayout());
			((GridBagLayout) FActHorariosContentPane.getLayout()).columnWidths = new int[] {
					254, 0 };
			((GridBagLayout) FActHorariosContentPane.getLayout()).rowHeights = new int[] {
					100, 40, 0 };
			((GridBagLayout) FActHorariosContentPane.getLayout()).columnWeights = new double[] {
					1.0, 1.0E-4 };
			((GridBagLayout) FActHorariosContentPane.getLayout()).rowWeights = new double[] {
					1.0, 0.0, 1.0E-4 };

			// ======== SPHorarios ========
			{
				SPHorarios.setViewportBorder(null);

				// ======== PAHorarios ========
				{
					PAHorarios.setBorder(null);
					PAHorarios.setLayout(new GridBagLayout());
					((GridBagLayout) PAHorarios.getLayout()).columnWidths = new int[] {
							10, 85, 85, 5, 0 };
					((GridBagLayout) PAHorarios.getLayout()).rowHeights = new int[] {
							10, 30, 30, 30, 0, 0 };
					((GridBagLayout) PAHorarios.getLayout()).columnWeights = new double[] {
							0.0, 0.0, 1.0, 0.0, 1.0E-4 };
					((GridBagLayout) PAHorarios.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4 };

					// ---- LDia ----
					LDia.setText("Dia:");
					PAHorarios.add(LDia, new GridBagConstraints(1, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
					PAHorarios.add(CBDia, new GridBagConstraints(2, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));

					// ---- LRInicio ----
					LRInicio.setText("Rango Inicio:");
					PAHorarios.add(LRInicio, new GridBagConstraints(1, 2, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ======== PRInicio ========
					{
						PRInicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5,
								0));

						// ---- SHoraI ----
						SHoraI.setModel(new SpinnerNumberModel(0, 0, 23, 1));
						SHoraI.setToolTipText("Hora");
						PRInicio.add(SHoraI);

						// ---- LDosPuntos1 ----
						LDosPuntos1.setText(":");
						PRInicio.add(LDosPuntos1);

						// ---- SMinutosI ----
						SMinutosI
								.setModel(new SpinnerNumberModel(0, 0, 59, 10));
						SMinutosI.setToolTipText("Minutos");
						PRInicio.add(SMinutosI);
					}
					PAHorarios.add(PRInicio, new GridBagConstraints(2, 2, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5,
									5), 0, 0));

					// ---- LRFin ----
					LRFin.setText("Rango Fin:");
					PAHorarios.add(LRFin, new GridBagConstraints(1, 3, 1, 1,
							0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));

					// ======== PRFin ========
					{
						PRFin
								.setLayout(new FlowLayout(FlowLayout.CENTER, 5,
										0));

						// ---- SHoraF ----
						SHoraF.setModel(new SpinnerNumberModel(0, 0, 23, 1));
						SHoraF.setToolTipText("Hora");
						PRFin.add(SHoraF);

						// ---- LDosPuntos2 ----
						LDosPuntos2.setText(":");
						PRFin.add(LDosPuntos2);

						// ---- SMinutosF ----
						SMinutosF
								.setModel(new SpinnerNumberModel(0, 0, 59, 10));
						SMinutosF.setToolTipText("Minutos");
						PRFin.add(SMinutosF);
					}
					PAHorarios.add(PRFin, new GridBagConstraints(2, 3, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
							0));
				}
				SPHorarios.setViewportView(PAHorarios);
			}
			FActHorariosContentPane.add(SPHorarios, new GridBagConstraints(0,
					0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

			// ======== PBotonesHorarios ========
			{
				PBotonesHorarios.setLayout(new FlowLayout(FlowLayout.CENTER,
						30, 5));

				// ---- BActHorariosOK ----
				BActHorariosOK.setText("Aceptar");
				BActHorariosOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActHorariosOKActionPerformed(e);
					}
				});
				PBotonesHorarios.add(BActHorariosOK);

				// ---- BActHorariosCancel ----
				BActHorariosCancel.setText("Cancelar");
				BActHorariosCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BActHorariosCancelActionPerformed(e);
					}
				});
				PBotonesHorarios.add(BActHorariosCancel);
			}
			FActHorariosContentPane.add(PBotonesHorarios,
					new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
			FActHorarios.setSize(310, 200);
			FActHorarios.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}
}
