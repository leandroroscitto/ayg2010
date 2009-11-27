package control;

import javax.swing.JOptionPane;

import datos.TGestorDeDatos;
import enumerados.ETipoUsuario;
import usuarios.TGestorDeUsuarios;
import usuarios.TUsuario;
import ventanas.VentanaLogin;

//CLASE PRINCIPAL
public class clogin {
	public static void main(String[] args) {
		new clogin();
	}
	@SuppressWarnings("unused")
	private VentanaLogin vlogin;
	private TGestorDeDatos GDatos;
	private TGestorDeUsuarios GUsuarios;
	@SuppressWarnings("unused")
	private cadministrador CAdministrador;
	
	@SuppressWarnings("unused")
	private coperador COperador;

	public clogin() {
		GDatos = new TGestorDeDatos();
		GUsuarios = new TGestorDeUsuarios();

		if (!GDatos.cargar_estado()) {
			System.out.println("Se produjo un error en la carga de los datos");
		} else {
			if (!GUsuarios.cargar_estado()) {
				System.out
						.println("Se produjo un error en la carga de los usuarios");
			} else {
				vlogin= new VentanaLogin(this);
			}
		}

	}

	public void cerroVentanaLogin() {
		GDatos.guardar_estado();
		GUsuarios.guardar_estado();
	}

	public void intentaringreso(String nombre, String pass) {
		TUsuario Usuario=GUsuarios.valida(nombre,pass);
		if (Usuario!=null){
			ETipoUsuario TUsuario=Usuario.getTipo();
			if (TUsuario==ETipoUsuario.ADMINISTRADOR){
				vlogin.descartar();
				CAdministrador = new cadministrador(GDatos);
			};
			if (TUsuario==ETipoUsuario.OPERADOR){
				vlogin.descartar();
				COperador = new coperador(GDatos);
			}
		}else{
			JOptionPane.showMessageDialog(vlogin.getFramePrincipal(), "Usuario o contraseña incorrectos");
		}
	}
}
