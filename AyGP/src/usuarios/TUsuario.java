package usuarios;

import java.io.Serializable;

import enumerados.ETipoUsuario;

public class TUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String Nombre;
	private String Password;
	private ETipoUsuario Tipo;
	
	public TUsuario(String N,String P,ETipoUsuario T){
		Nombre=N;
		Password=P;
		Tipo=T;
	}
	
	public ETipoUsuario getTipo(){
		return Tipo;
	}
	
	public boolean setPassword(String OldPass,String NewPass){
		if (OldPass.equals(Password)){
			Password=NewPass;
			return true;
		}else{
			return false;
		}
	}

	public boolean validar(String usuario, String pass) {
		return ((Nombre.equals(usuario)) && (Password.equals(pass)));
	}
}
