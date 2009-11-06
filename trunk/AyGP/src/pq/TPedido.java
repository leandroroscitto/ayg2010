package pq;

import java.util.ArrayList;
import java.util.Date;

enum tipo_estado_pedido{
	EN_ESPERA,
	DESPACHADO,
	ENTREGADO,
	DEMORADO,
	CANCELADO
}

public class TPedido extends TElemento{
	
	private static final long serialVersionUID = 1L;
	
	
	private int id_pedido;
	private String origen;
	private String destino;
	private tipo_estado_pedido estado;
	private Date hora_ini;
	private Date hora_fin;
	
	private ArrayList<TEmpleado> empleados; //TEmpleado
	private ArrayList<TGasto> gastos; //TGasto
	private TCliente cliente;
	private ArrayList<TVehiculo> vehiculos; //TVehiculo
	private ArrayList<TEquipo> equipos; //TEquipo

	private TPedido(){
		super(TElementotipo.PEDIDO);		
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

	public tipo_estado_pedido getEstado() {
		return estado;
	}

	public void setEstado(tipo_estado_pedido estado) {
		this.estado = estado;
	}

	public Date getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(Date hora_ini) {
		this.hora_ini = hora_ini;
	}

	public Date getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Date hora_fin) {
		this.hora_fin = hora_fin;
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
