package pq;

import java.io.*;
import javax.swing.JOptionPane;

public class GestorDeDatos {

	public Datos dat;

	public GestorDeDatos() {

	}

	public boolean guardar_estado() {
		ObjectOutputStream obj;
		try {
			obj = new ObjectOutputStream(new FileOutputStream("Datos.dat"));
			obj.writeObject(dat);
			obj.close();
			return true;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontr� el archivo");
			return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Guardado: No se pudo acceder a el archivo");
			return false;
		}
	}

	public boolean cargar_estado() {
		File file;
		ObjectInputStream obj;

		try {
			file = new File("Datos.dat");
			obj = new ObjectInputStream(new FileInputStream(file));
			dat = (Datos) obj.readObject();
			obj.close();
		} catch (FileNotFoundException e) {
			return crear_estado();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Cargado: No se pudo accceder al archivo");
			return false;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Error interno (Clase no encontrada)");
			return false;
		}
		return true;
	}

	private boolean crear_estado() {
		File file;

		file = new File("Datos.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
				InicializarDatos();
				guardar_estado();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"No se pudo crear el archivo");
				return false;
			}
		}
		return true;
	}

	private void InicializarDatos() {
		dat = new Datos();
	}

	public boolean agregar_elemento(TElemento e) {

		switch (e.getTipo()) {
		case EMPLEADO:
			dat.getLista_empleados().add((TEmpleado)e);
			break;
		case PEDIDO:
			dat.getLista_pedidos().add((TPedido)e);
			break;
		case EVENTO:
			dat.getLista_eventos().add((TEvento)e);
			break;
		case GASTO:
			dat.getLista_gastos().add((TGasto)e);
			break;
		case CLIENTE:
			dat.getLista_clientes().add((TCliente)e);
			break;
		case VEHICULO:
			dat.getLista_vehiculos().add((TVehiculo)e);
			break;
		case EQUIPO:
			dat.getLista_equipos().add((TEquipo)e);
			break;
		}
		return true;
	}

	public boolean quitar_elemento(TElemento e) {

		switch (e.getTipo()) {
		case EMPLEADO:
			dat.getLista_empleados().remove(e);
			break;
		case PEDIDO:
			dat.getLista_pedidos().remove(e);
			break;
		case EVENTO:
			dat.getLista_eventos().remove(e);
			break;
		case GASTO:
			dat.getLista_gastos().remove(e);
			break;
		case CLIENTE:
			dat.getLista_clientes().remove(e);
			break;
		case VEHICULO:
			dat.getLista_vehiculos().remove(e);
			break;
		case EQUIPO:
			dat.getLista_equipos().remove(e);
			break;
		}
		return true;
	}

} // class
