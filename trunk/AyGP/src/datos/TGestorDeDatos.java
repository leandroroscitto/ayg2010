package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.TCliente;
import modelo.TEmpleado;
import modelo.TEquipo;
import modelo.TEvento;
import modelo.TGasto;
import modelo.TPedido;
import modelo.TVehiculo;
import enumerados.ETipoElemento;

public class TGestorDeDatos {

	private TDatos dat;

	public TGestorDeDatos() {

	}

	public boolean guardar_estado() {
		ObjectOutputStream obj;
		try {
			obj = new ObjectOutputStream(new FileOutputStream("Datos.dat"));
			obj.writeObject(dat);
			obj.close();
			return true;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontró el archivo");
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
			dat = (TDatos) obj.readObject();
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
		dat = new TDatos();
	}

	@SuppressWarnings("unchecked")
	public TElemento buscar_elemento(int indice, ETipoElemento T) {
		assert indice >= 0;
		ArrayList Lista = null;

		switch (T) {
		case EMPLEADO:
			Lista = dat.getLista_empleados();
			break;
		case PEDIDO:
			Lista = dat.getLista_pedidos();
			break;
		case EVENTO:
			Lista = dat.getLista_eventos();
			break;
		case GASTO:
			Lista = dat.getLista_gastos();
			break;
		case CLIENTE:
			Lista = dat.getLista_clientes();
			break;
		case VEHICULO:
			Lista = dat.getLista_vehiculos();
			break;
		case EQUIPO:
			Lista = dat.getLista_equipos();
			break;
		}

		if (indice > Lista.size()) {
			return null;
		} else {
			return (TElemento) Lista.get(indice);
		}
	}

	@SuppressWarnings("unchecked")
	public TElemento buscar_elemento(Object ID, ETipoElemento T) {
		ArrayList Lista = null;

		switch (T) {
		case EMPLEADO:
			Lista = dat.getLista_empleados();
			break;
		case PEDIDO:
			Lista = dat.getLista_pedidos();
			break;
		case EVENTO:
			Lista = dat.getLista_eventos();
			break;
		case GASTO:
			Lista = dat.getLista_gastos();
			break;
		case CLIENTE:
			Lista = dat.getLista_clientes();
			break;
		case VEHICULO:
			Lista = dat.getLista_vehiculos();
			break;
		case EQUIPO:
			Lista = dat.getLista_equipos();
			break;
		}

		int i = 0;
		boolean encontro = false;
		int tam = Lista.size();
		TElemento E;
		while ((i < tam) && (!encontro)) {
			E = ((TElemento) Lista.get(i));
			encontro = (E.getEID().equals(ID));
			i++;
		}

		if (!encontro) {
			return null;
		} else {
			return ((TElemento) Lista.get(i - 1));
		}
	}

	public void agregar_elemento(TElemento e) throws Exception {
		// Si ya existe un elemento con ese id,
		// no se puede agregar el nuevo elemento
		// No puede haber elementos con id repetido
		// El id depende del tipo de elemento,
		// por ejemplo el id del empleado es el legajo
		TElemento E = buscar_elemento(e.getEID(), e.getTipo());
		if (E != null) {
			throw (new Exception("Ya existe un elemento ingresado del tipo "
					+ e.getTipo().toString() + " con la misma clave."));
		} else {

			switch (e.getTipo()) {
			case EMPLEADO:
				dat.getLista_empleados().add((TEmpleado) e);
				break;
			case PEDIDO:
				dat.getLista_pedidos().add((TPedido) e);
				break;
			case EVENTO:
				dat.getLista_eventos().add((TEvento) e);
				break;
			case GASTO:
				dat.getLista_gastos().add((TGasto) e);
				break;
			case CLIENTE:
				dat.getLista_clientes().add((TCliente) e);
				break;
			case VEHICULO:
				dat.getLista_vehiculos().add((TVehiculo) e);
				break;
			case EQUIPO:
				dat.getLista_equipos().add((TEquipo) e);
				break;
			}
		}
	}
	
	public void agregar_elemento(int indice,TElemento e) throws Exception {
		// Si ya existe un elemento con ese id,
		// no se puede agregar el nuevo elemento
		// No puede haber elementos con id repetido
		// El id depende del tipo de elemento,
		// por ejemplo el id del empleado es el legajo
		TElemento E = buscar_elemento(e.getEID(), e.getTipo());
		if (E != null) {
			throw (new Exception("Ya existe un elemento ingresado del tipo "
					+ e.getTipo().toString() + " con la misma clave."));
		} else {

			switch (e.getTipo()) {
			case EMPLEADO:
				dat.getLista_empleados().add(indice,(TEmpleado) e);
				break;
			case PEDIDO:
				dat.getLista_pedidos().add(indice,(TPedido) e);
				break;
			case EVENTO:
				dat.getLista_eventos().add(indice,(TEvento) e);
				break;
			case GASTO:
				dat.getLista_gastos().add(indice,(TGasto) e);
				break;
			case CLIENTE:
				dat.getLista_clientes().add(indice,(TCliente) e);
				break;
			case VEHICULO:
				dat.getLista_vehiculos().add(indice,(TVehiculo) e);
				break;
			case EQUIPO:
				dat.getLista_equipos().add(indice,(TEquipo) e);
				break;
			}
		}
	}

	public void modificar_elemento(int indice, TElemento E) throws Exception {
		// Primero saca al elemento originar de la lista
		// Asi no se encuentra a si mismo en la búsqueda que sigue
		TElemento Eori = buscar_elemento(indice, E.getTipo());
		quitar_elemento(Eori);

		// Luego se agrega el nuevo elemento
		// Trata de agregarlo, si ya existe la clave
		// del elemento, no va ser posible, por lo
		// que se restaura el elemento original
		try {
			agregar_elemento(indice,E);
		} catch (Exception exep) {
			// No deberia fallar, ya estaba en la lista
			agregar_elemento(indice,Eori);
			// Envia la esepción para que la maneje el controlador
			throw exep;
		}
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

	public TDatos getDatos() {
		return dat;
	}

} // class

