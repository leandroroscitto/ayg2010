package usuarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import enumerados.ETipoUsuario;

public class TGestorDeUsuarios {

	private ArrayList<TUsuario> usuarios;
	
	public TGestorDeUsuarios(){
		usuarios=new ArrayList<TUsuario>();
	}
	
	public boolean guardar_estado() {
		ObjectOutputStream obj;
		try {
			obj = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));
			obj.writeObject(usuarios);
			obj.close();
			return true;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontró el archivo de usuarios");
			return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Guardado: No se pudo acceder a el archivo de ususarios");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean cargar_estado() {
		File file;
		ObjectInputStream obj;

		try {
			file = new File("Usuarios.dat");
			obj = new ObjectInputStream(new FileInputStream(file));
			usuarios = (ArrayList<TUsuario>) obj.readObject();
			obj.close();
		} catch (FileNotFoundException e) {
			return crear_estado();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Cargado: No se pudo accceder al archivo de usuarios");
			return false;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Error interno (Clase no encontrada)");
			return false;
		}
		return true;
	}

	public boolean crear_estado() {
		File file;

		file = new File("Usuarios.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
				InicializarDatos();
				guardar_estado();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"No se pudo crear el archivo de usuarios");
				return false;
			}
		}
		return true;
	}

	private void InicializarDatos() {
		usuarios = new ArrayList<TUsuario>();
	}

	public TUsuario valida(String usuario, String pass) {
		for(TUsuario U:usuarios){
			if (U.validar(usuario,pass)){
				return U;
			}
		}
		return null;
	}

	public ETipoUsuario getTipoUsuario(String usuario, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void agregarUsuario(String Nombre,String Pass,ETipoUsuario Tip){
		usuarios.add(new TUsuario(Nombre,Pass,Tip));
		guardar_estado();
	}
	
}
