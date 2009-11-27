package usuarios;

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
		GUsuarios.crear_estado();
		GUsuarios.agregarUsuario("operador", "operador", ETipoUsuario.OPERADOR);
		GUsuarios.agregarUsuario("administrador", "administrador",
				ETipoUsuario.ADMINISTRADOR);
	}
}
