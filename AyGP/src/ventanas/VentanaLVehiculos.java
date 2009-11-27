package ventanas;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import modelo.TVehiculo;
import control.coperador;
import enumerados.EEstadoVehiculo;

public class VentanaLVehiculos  {
	private coperador controlador;
	private ArrayList<TVehiculo> vehiculos;
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame JFListaVehiculos;
	
	private JScrollPane SPListaVehiculos;

	private JList LVehiculos;

	private JButton BAgregarVe;

	private JButton BCerrarVe;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public VentanaLVehiculos(coperador P,ArrayList<TVehiculo> listVehi){
		vehiculos=listVehi;
		controlador=P;
		initComponents();
		mostrarLista();
		
		JFListaVehiculos.setVisible(true);
	}

	private void BAgregarVeActionPerformed(ActionEvent e) {
		int seleccionado=LVehiculos.getSelectedIndex();
		LVehiculos.getModel().getSize();
		if ((seleccionado<LVehiculos.getModel().getSize()) && (seleccionado>=0)){
			TVehiculo Vehiculo=vehiculos.get(seleccionado);
			vehiculos.remove(Vehiculo);
			mostrarLista();
			controlador.anadioVehiculo(Vehiculo);
		}else{
			JOptionPane.showMessageDialog(JFListaVehiculos, "Seleccione un vehículo a añadir");
		}
	}
	private void BCerrarVeActionPerformed(ActionEvent e) {
		controlador.cerroVLEmpleados();
		JFListaVehiculos.dispose();
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		JFListaVehiculos = new JFrame();
		SPListaVehiculos = new JScrollPane();
		LVehiculos = new JList();
		BAgregarVe = new JButton();
		BCerrarVe = new JButton();

		//======== JFListaVehiculos ========
		{
			JFListaVehiculos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			JFListaVehiculos.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			JFListaVehiculos.setResizable(false);
			JFListaVehiculos.setTitle("Lista de veh\u00edculos");
			JFListaVehiculos.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JFListaVehiculosWindowClosing(e);
				}
			});
			Container JFListaVehiculosContentPane = JFListaVehiculos.getContentPane();
			JFListaVehiculosContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)JFListaVehiculosContentPane.getLayout()).columnWidths = new int[] {5, 271, 140, 5, 0};
			((GridBagLayout)JFListaVehiculosContentPane.getLayout()).rowHeights = new int[] {5, 30, 5, 30, 0, 0};
			((GridBagLayout)JFListaVehiculosContentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)JFListaVehiculosContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

			//======== SPListaVehiculos ========
			{

				//---- LVehiculos ----
				LVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				SPListaVehiculos.setViewportView(LVehiculos);
			}
			JFListaVehiculosContentPane.add(SPListaVehiculos, new GridBagConstraints(1, 1, 1, 4, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- BAgregarVe ----
			BAgregarVe.setText("Agregar veh\u00edculos");
			BAgregarVe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BAgregarVeActionPerformed(e);
				}
			});
			JFListaVehiculosContentPane.add(BAgregarVe, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- BCerrarVe ----
			BCerrarVe.setText("Cerrar");
			BCerrarVe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BCerrarVeActionPerformed(e);
				}
			});
			JFListaVehiculosContentPane.add(BCerrarVe, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
			JFListaVehiculos.setSize(355, 270);
			JFListaVehiculos.setLocationRelativeTo(JFListaVehiculos.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	private void JFListaVehiculosWindowClosing(WindowEvent e) {
		controlador.cerroVLEmpleados();
		JFListaVehiculos.dispose();
	}
	public void mostrarLista(){
		DefaultListModel LM = new DefaultListModel();
		LM.clear();
		
		for (TVehiculo veh:vehiculos){
			if ((veh.getEstado()==EEstadoVehiculo.DISPONIBLE) || (veh.getEstado()==EEstadoVehiculo.DISPONIBLE)) {
				LM.addElement(veh.getPatente()+" - "+veh.getTipoVehiculo());
			}
		}
		LVehiculos.setModel(LM);
	}
}
