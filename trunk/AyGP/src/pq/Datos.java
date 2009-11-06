package pq;

import java.io.Serializable;
import java.util.ArrayList;

public class Datos implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList<TEmpleado> lista_empleados;

	private ArrayList<TPedido> lista_pedidos;

	private ArrayList<TEvento> lista_eventos;

	private ArrayList<TGasto> lista_gastos;

	private ArrayList<TCliente> lista_clientes;

	private ArrayList<TVehiculo> lista_vehiculos;

	private ArrayList<TEquipo> lista_equipos;

	public Datos() {
		lista_empleados = new ArrayList<TEmpleado>();
		lista_pedidos = new ArrayList<TPedido>();
		lista_eventos = new ArrayList<TEvento>();
		lista_gastos = new ArrayList<TGasto>();
		lista_clientes = new ArrayList<TCliente>();
		lista_vehiculos = new ArrayList<TVehiculo>();
		lista_equipos = new ArrayList<TEquipo>();
	}

	// Getters de los atribuso

	public ArrayList<TEmpleado> getLista_empleados() {
		return lista_empleados;
	}

	public ArrayList<TPedido> getLista_pedidos() {
		return lista_pedidos;
	}

	public ArrayList<TEvento> getLista_eventos() {
		return lista_eventos;
	}

	public ArrayList<TGasto> getLista_gastos() {
		return lista_gastos;
	}

	public ArrayList<TCliente> getLista_clientes() {
		return lista_clientes;
	}

	public ArrayList<TVehiculo> getLista_vehiculos() {
		return lista_vehiculos;
	}

	public ArrayList<TEquipo> getLista_equipos() {
		return lista_equipos;
	}

}
