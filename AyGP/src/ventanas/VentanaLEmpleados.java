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

import modelo.TEmpleado;
import control.coperador;
import enumerados.EEstadoEmpleado;

public class VentanaLEmpleados  {
	private coperador controlador;
	private ArrayList<TEmpleado> empleados;
	
	public VentanaLEmpleados(coperador P,ArrayList<TEmpleado> listEmp){
		empleados=listEmp;
		controlador=P;
		initComponents();
		mostrarLista();
		
		JFListaEmpleados.setVisible(true);
	}
	
	public void mostrarLista(){
		DefaultListModel LM = new DefaultListModel();
		LM.clear();
		
		for (TEmpleado emp:empleados){
			if ((emp.getEstado()==EEstadoEmpleado.DISPONIBLE) || (emp.getEstado()==EEstadoEmpleado.TRABAJANDO)) {
				LM.addElement(emp.getNombre()+" - "+emp.getLegajo());
			}
		}
		LEmpleados.setModel(LM);
	}

	private void BAgregarEmpActionPerformed(ActionEvent e) {
		int seleccionado=LEmpleados.getSelectedIndex();
		LEmpleados.getModel().getSize();
		if ((seleccionado<LEmpleados.getModel().getSize()) && (seleccionado>=0)){
			TEmpleado Empleado=empleados.get(seleccionado);
			empleados.remove(Empleado);
			mostrarLista();
			controlador.anadioEmpleado(Empleado);
		}else{
			JOptionPane.showMessageDialog(JFListaEmpleados, "Seleccione un empleado a añadir");
		}
	}

	private void BCerrarEmpActionPerformed(ActionEvent e) {
		controlador.cerroVLEmpleados();
		JFListaEmpleados.dispose();
	}

	private void JFListaEmpleadosWindowClosing(WindowEvent e) {
		controlador.cerroVLEmpleados();
		JFListaEmpleados.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		JFListaEmpleados = new JFrame();
		SPListaEmpleados = new JScrollPane();
		LEmpleados = new JList();
		BAgregarEmp = new JButton();
		BCerrarEmp = new JButton();

		//======== JFListaEmpleados ========
		{
			JFListaEmpleados.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			JFListaEmpleados.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			JFListaEmpleados.setResizable(false);
			JFListaEmpleados.setTitle("Lista de empleados");
			JFListaEmpleados.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					JFListaEmpleadosWindowClosing(e);
				}
			});
			Container JFListaEmpleadosContentPane = JFListaEmpleados.getContentPane();
			JFListaEmpleadosContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)JFListaEmpleadosContentPane.getLayout()).columnWidths = new int[] {5, 271, 140, 5, 0};
			((GridBagLayout)JFListaEmpleadosContentPane.getLayout()).rowHeights = new int[] {5, 30, 5, 30, 0, 0};
			((GridBagLayout)JFListaEmpleadosContentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)JFListaEmpleadosContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

			//======== SPListaEmpleados ========
			{

				//---- LEmpleados ----
				LEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				SPListaEmpleados.setViewportView(LEmpleados);
			}
			JFListaEmpleadosContentPane.add(SPListaEmpleados, new GridBagConstraints(1, 1, 1, 4, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- BAgregarEmp ----
			BAgregarEmp.setText("Agregar empleado");
			BAgregarEmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BAgregarEmpActionPerformed(e);
				}
			});
			JFListaEmpleadosContentPane.add(BAgregarEmp, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//---- BCerrarEmp ----
			BCerrarEmp.setText("Cerrar");
			BCerrarEmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BCerrarEmpActionPerformed(e);
				}
			});
			JFListaEmpleadosContentPane.add(BCerrarEmp, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
			JFListaEmpleados.setSize(355, 270);
			JFListaEmpleados.setLocationRelativeTo(JFListaEmpleados.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame JFListaEmpleados;
	private JScrollPane SPListaEmpleados;
	private JList LEmpleados;
	private JButton BAgregarEmp;
	private JButton BCerrarEmp;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
