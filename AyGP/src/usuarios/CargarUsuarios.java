package usuarios;

import javax.swing.JOptionPane;

import enumerados.ETipoUsuario;

/**
 * Aplicaci�n auxiliar que restaura los dos usuarios b�sicos del sistema, un
 * operador y un administrador, con contrase�a igual a nombre de usuario.
 */
public class CargarUsuarios {
	private static TGestorDeUsuarios GUsuarios;

	// Carga un usuario de cada tipo para realizar pruebas
	public static void main(String[] args) {
		GUsuarios = new TGestorDeUsuarios();
		if (GUsuarios.crear_estado()) {
			GUsuarios.agregarUsuario("operador", "operador",
					ETipoUsuario.OPERADOR);
			GUsuarios.agregarUsuario("administrador", "administrador",
					ETipoUsuario.ADMINISTRADOR);
			if (GUsuarios.guardar_estado()) {
				JOptionPane
						.showMessageDialog(null,
								"Se crear los usuarios operador y administrador con �xito");
			}else{
				JOptionPane
				.showMessageDialog(null,
						"Error al crear los usuarios b�sico");
			}
		}else{
			JOptionPane
			.showMessageDialog(null,
					"Error al crear los usuarios b�sico");
		}
	}
}
