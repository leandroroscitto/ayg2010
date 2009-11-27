package usuarios;

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
		GUsuarios.crear_estado();
		GUsuarios.agregarUsuario("operador", "operador", ETipoUsuario.OPERADOR);
		GUsuarios.agregarUsuario("administrador", "administrador",
				ETipoUsuario.ADMINISTRADOR);
	}
}
