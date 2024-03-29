package datos;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.TCliente;
import modelo.TEmpleado;
import modelo.TEquipo;
import modelo.TEvento;
import modelo.TGasto;
import modelo.TPedido;
import modelo.TVehiculo;

/**
 * Representa el conjunto de datos persistentes de la aplicaci�n, almacenado en
 * lista discriminada por las clases del modelo. Ofrece funcionalidad para
 * obtener elementos de estas listas, y para asignarles id �nicos a los
 * elementos.
 */
public class TDatos implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private ArrayList<TEmpleado> lista_empleados;
	private ArrayList<TPedido> lista_pedidos;
	private ArrayList<TEvento> lista_eventos;
	private ArrayList<TGasto> lista_gastos;
	private ArrayList<TCliente> lista_clientes;
	private ArrayList<TVehiculo> lista_vehiculos;

	private ArrayList<TEquipo> lista_equipos;
	private int ultimoidEmpleados;
	private int ultimoidPedidos;
	private int ultimoidEventos;
	private int ultimoidGastos;
	private int ultimoidClientes;
	private int ultimoidVehiculos;

	private int ultimoidEquipos;

	// Getters de los atribuso

	public TDatos() {
		ultimoidClientes = 0;
		ultimoidEmpleados = 0;
		ultimoidEquipos = 0;
		ultimoidEventos = 0;
		ultimoidGastos = 0;
		ultimoidPedidos = 0;
		ultimoidVehiculos = 0;

		lista_empleados = new ArrayList<TEmpleado>();
		lista_pedidos = new ArrayList<TPedido>();
		lista_eventos = new ArrayList<TEvento>();
		lista_gastos = new ArrayList<TGasto>();
		lista_clientes = new ArrayList<TCliente>();
		lista_vehiculos = new ArrayList<TVehiculo>();
		lista_equipos = new ArrayList<TEquipo>();
	}

	public ArrayList<TCliente> getLista_clientes() {
		return lista_clientes;
	}

	public ArrayList<TEmpleado> getLista_empleados() {
		return lista_empleados;
	}

	public ArrayList<TEquipo> getLista_equipos() {
		return lista_equipos;
	}

	public ArrayList<TEvento> getLista_eventos() {
		return lista_eventos;
	}

	public ArrayList<TGasto> getLista_gastos() {
		return lista_gastos;
	}

	public ArrayList<TPedido> getLista_pedidos() {
		return lista_pedidos;
	}

	public ArrayList<TVehiculo> getLista_vehiculos() {
		return lista_vehiculos;
	}

	public int resevaridClientes() {
		ultimoidClientes++;
		return ultimoidClientes;
	}

	public int resevaridEmpleados() {
		ultimoidEmpleados++;
		return ultimoidEmpleados;
	}

	public int resevaridEquipos() {
		ultimoidEquipos++;
		return ultimoidEquipos;
	}

	public int resevaridEventos() {
		ultimoidEventos++;
		return ultimoidEventos;
	}

	public int resevaridGastos() {
		ultimoidGastos++;
		return ultimoidGastos;
	}

	public int resevaridPedidos() {
		ultimoidPedidos++;
		return ultimoidPedidos;
	}

	public int resevaridVehiculos() {
		ultimoidVehiculos++;
		return ultimoidVehiculos;
	}

}
