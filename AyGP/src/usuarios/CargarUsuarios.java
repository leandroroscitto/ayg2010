package usuarios;

import enumerados.ETipoUsuario;

public class CargarUsuarios {
	private static TGestorDeUsuarios GUsuarios;
	
	//Carga un usuario de cada tipo para realizar pruebas
	public static void main(String[] args) {
		GUsuarios = new TGestorDeUsuarios();
		GUsuarios.crear_estado();
		GUsuarios.agregarUsuario("operador", "operador", ETipoUsuario.OPERADOR);
		GUsuarios.agregarUsuario("administrador", "administrador", ETipoUsuario.ADMINISTRADOR);
	}
}
