package usuarios;

import java.io.Serializable;

import enumerados.ETipoUsuario;

/**
 * Representa un usuario del sistema. Tiene operaciones para determinar si un
 * nombre de ususario y password validan con respecto a él, y para cambiar el
 * password dado el antigo y nuevo password. Esta última funcionalidad no tiene
 * interfaz gráfica todavía.
 */
public class TUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String Nombre;
	private String Password;
	private ETipoUsuario Tipo;

	public TUsuario(String N, String P, ETipoUsuario T) {
		Nombre = N;
		Password = P;
		Tipo = T;
	}

	public ETipoUsuario getTipo() {
		return Tipo;
	}

	public boolean setPassword(String OldPass, String NewPass) {
		if (OldPass.equals(Password)) {
			Password = NewPass;
			return true;
		} else {
			return false;
		}
	}

	public boolean validar(String usuario, String pass) {
		return ((Nombre.equals(usuario)) && (Password.equals(pass)));
	}
}
