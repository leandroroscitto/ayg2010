package usuarios;

import javax.swing.JOptionPane;

import enumerados.ETipoUsuario;

/**
 * Aplicación auxiliar que restaura los dos usuarios básicos del sistema, un
 * operador y un administrador, con contraseña igual a nombre de usuario.
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
								"Se crear los usuarios operador y administrador con éxito");
			}else{
				JOptionPane
				.showMessageDialog(null,
						"Error al crear los usuarios básico");
			}
		}else{
			JOptionPane
			.showMessageDialog(null,
					"Error al crear los usuarios básico");
		}
	}
}
