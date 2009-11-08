package modelo;

import java.util.ArrayList;
import java.util.Calendar;

import datos.TElemento;
import enumerados.EEstadoPedido;
import enumerados.ETipoElemento;

public class TPedido extends TElemento {

	private static final long serialVersionUID = 1L;

	private int id_pedido;
	private String origen;
	private String destino;
	private EEstadoPedido estado;
	private Calendar ini;
	private Calendar fin;

	private ArrayList<TEmpleado> empleados;
	private ArrayList<TGasto> gastos;
	private TCliente cliente;
	private ArrayList<TVehiculo> vehiculos;
	private ArrayList<TEquipo> equipos;

	public TPedido() {
		super(ETipoElemento.PEDIDO);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getLista_Tipo(ETipoElemento T){
		switch (T){
		case EMPLEADO:
			return getEmpleados();
		case VEHICULO:
			return getVehiculos();
		case EQUIPO:
			return getEquipos();
		case GASTO:
			return getGastos();
		}
		return null;
	}

	public boolean superpone_IF(Calendar Ini, Calendar Fin) {
		Calendar iniP, finP;

		iniP = get_ini();
		finP = get_fin();
		if (Ini.after(iniP) && Ini.before(finP)) {
			return false;
		}
		if (Fin.after(iniP) && Fin.before(finP)) {
			return false;
		}

		return true;
	}
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public EEstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EEstadoPedido estado) {
		this.estado = estado;
	}

	public Calendar get_ini() {
		return ini;
	}

	public void set_ini(Calendar Ini) {
		this.ini = Ini;
	}

	public Calendar get_fin() {
		return fin;
	}

	public void set_fin(Calendar Fin) {
		this.fin = Fin;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public ArrayList<TEmpleado> getEmpleados() {
		return empleados;
	}

	public ArrayList<TGasto> getGastos() {
		return gastos;
	}

	public TCliente getCliente() {
		return cliente;
	}

	public ArrayList<TVehiculo> getVehiculos() {
		return vehiculos;
	}

	public ArrayList<TEquipo> getEquipos() {
		return equipos;
	}
}
