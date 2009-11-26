package ventanas;

import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import control.clogin;

public class VentanaLogin {
	clogin controlador;

	public VentanaLogin(clogin P) {
		controlador = P;

		initComponents();

		JFrame_Login.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void JButton_EntrarActionPerformed(ActionEvent e) {
		String usuario = JTextF_Usuario.getText();
		String pass = JPassword_Password.getText();

		if (!usuario.equals("") && !pass.equals("")) {
			controlador.intentaringreso(usuario, pass);
		} else {
			JOptionPane.showMessageDialog(JFrame_Login,
					"Ingrese un usuario y contraseña");
		}
	}

	private void JButton_SalirMouseClicked(MouseEvent e) {
		JFrame_Login.dispose();
		controlador.cerroVentanaLogin();
	}
	

	public void descartar() {
		JFrame_Login.dispose();
	}

	public VentanaLogin() {
		initComponents();
		JFrame_Login.setVisible(true);
	}
	
	public Component getFramePrincipal() {
		return JFrame_Login;
	}

	private void FActEventoWindowClosing(WindowEvent e) {
		controlador.cerroVentanaLogin();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		JFrame_Login = new JFrame();
		JPanel_Login = new JPanel();
		JPanel_UP = new JPanel();
		JPanel_Labels = new JPanel();
		JLabel_Usuario = new JLabel();
		JLabel_Password = new JLabel();
		JPanel_Fields = new JPanel();
		JTextF_Usuario = new JTextField();
		JPassword_Password = new JPasswordField();
		JPanel_Botones = new JPanel();
		JButton_Entrar = new JButton();
		JButton_Salir = new JButton();

		// ======== JFrame_Login ========
		{
			JFrame_Login.setTitle("Entrar al sistema");
			JFrame_Login
					.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			JFrame_Login.setResizable(false);
			JFrame_Login.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FActEventoWindowClosing(e);
				}
			});
			Container JFrame_LoginContentPane = JFrame_Login.getContentPane();
			JFrame_LoginContentPane.setLayout(new GridLayout());

			// ======== JPanel_Login ========
			{
				JPanel_Login.setLayout(new TableLayout(new double[][] {
						{ TableLayout.FILL }, { 55, 50 } }));
				((TableLayout) JPanel_Login.getLayout()).setVGap(5);

				// ======== JPanel_UP ========
				{
					JPanel_UP.setBorder(new EmptyBorder(5, 5, 5, 5));
					JPanel_UP.setLayout(new TableLayout(new double[][] {
							{ 69, TableLayout.FILL }, { TableLayout.FILL } }));
					((TableLayout) JPanel_UP.getLayout()).setHGap(5);

					// ======== JPanel_Labels ========
					{
						JPanel_Labels.setLayout(new GridLayout(2, 1, 0, 5));

						// ---- JLabel_Usuario ----
						JLabel_Usuario.setText("Usuario:");
						JLabel_Usuario
								.setHorizontalAlignment(SwingConstants.RIGHT);
						JPanel_Labels.add(JLabel_Usuario);

						// ---- JLabel_Password ----
						JLabel_Password.setText("Password:");
						JLabel_Password
								.setHorizontalAlignment(SwingConstants.RIGHT);
						JPanel_Labels.add(JLabel_Password);
					}
					JPanel_UP.add(JPanel_Labels, new TableLayoutConstraints(0,
							0, 0, 0, TableLayoutConstraints.FULL,
							TableLayoutConstraints.FULL));

					// ======== JPanel_Fields ========
					{
						JPanel_Fields.setLayout(new GridLayout(2, 1, 0, 5));
						JPanel_Fields.add(JTextF_Usuario);
						JPanel_Fields.add(JPassword_Password);
					}
					JPanel_UP.add(JPanel_Fields, new TableLayoutConstraints(1,
							0, 1, 0, TableLayoutConstraints.FULL,
							TableLayoutConstraints.FULL));
				}
				JPanel_Login.add(JPanel_UP, new TableLayoutConstraints(0, 0, 0,
						0, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));

				// ======== JPanel_Botones ========
				{
					JPanel_Botones.setLayout(new FlowLayout(FlowLayout.RIGHT,
							10, 10));

					// ---- JButton_Entrar ----
					JButton_Entrar.setText("Entrar");
					JButton_Entrar.setHorizontalAlignment(SwingConstants.LEFT);
					JButton_Entrar.setIcon(UIManager
							.getIcon("Slider.verticalThumbIcon"));
					JButton_Entrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton_EntrarActionPerformed(e);
						}
					});
					JPanel_Botones.add(JButton_Entrar);

					// ---- JButton_Salir ----
					JButton_Salir.setText("Salir");
					JButton_Salir.setHorizontalAlignment(SwingConstants.RIGHT);
					JButton_Salir.setIcon(UIManager
							.getIcon("Table.descendingSortIcon"));
					JButton_Salir.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							JButton_SalirMouseClicked(e);
						}
					});
					JPanel_Botones.add(JButton_Salir);
				}
				JPanel_Login.add(JPanel_Botones, new TableLayoutConstraints(0,
						1, 0, 1, TableLayoutConstraints.FULL,
						TableLayoutConstraints.FULL));
			}
			JFrame_LoginContentPane.add(JPanel_Login);
			JFrame_Login.setSize(310, 145);
			JFrame_Login.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JFrame JFrame_Login;
	private JPanel JPanel_Login;
	private JPanel JPanel_UP;
	private JPanel JPanel_Labels;
	private JLabel JLabel_Usuario;
	private JLabel JLabel_Password;
	private JPanel JPanel_Fields;
	private JTextField JTextF_Usuario;
	private JPasswordField JPassword_Password;
	private JPanel JPanel_Botones;
	private JButton JButton_Entrar;
	private JButton JButton_Salir;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
