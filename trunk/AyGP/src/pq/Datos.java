package pq;

import java.io.Serializable;
import java.util.ArrayList;

public class Datos implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList lista_empleados;

	private ArrayList lista_pedidos;

	private ArrayList lista_eventos;

	private ArrayList lista_gastos;

	private ArrayList lista_clientes;

	private ArrayList lista_vehiculos;

	private ArrayList lista_equipos;

	public Datos() {
		lista_empleados = new ArrayList();
		lista_pedidos = new ArrayList();
		lista_eventos = new ArrayList();
		lista_gastos = new ArrayList();
		lista_clientes = new ArrayList();
		lista_vehiculos = new ArrayList();
		lista_equipos = new ArrayList();
	}

	// Getters de los atribuso

	public ArrayList getLista_empleados() {
		return lista_empleados;
	}

	public ArrayList getLista_pedidos() {
		return lista_pedidos;
	}

	public ArrayList getLista_eventos() {
		return lista_eventos;
	}

	public ArrayList getLista_gastos() {
		return lista_gastos;
	}

	public ArrayList getLista_clientes() {
		return lista_clientes;
	}

	public ArrayList getLista_vehiculos() {
		return lista_vehiculos;
	}

	public ArrayList getLista_equipos() {
		return lista_equipos;
	}

}
