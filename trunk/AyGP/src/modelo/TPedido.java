package modelo;

import java.util.ArrayList;
import java.util.Date;

import datos.TElemento;
import enumerados.ECategoriaPedido;
import enumerados.EEstadoPedido;
import enumerados.ETipoElemento;

public class TPedido extends TElemento {

	private static final long serialVersionUID = 1L;

	private int id_pedido;
	private String origen;
	private String destino;
	private EEstadoPedido estado;
	private ECategoriaPedido categoria;
	private Date ini;
	private Date fin;
	private float costo;

	private ArrayList<TEmpleado> empleados;
	private TCliente cliente;
	private ArrayList<TVehiculo> vehiculos;

	public TPedido(int id, String O, String D, EEstadoPedido E,ECategoriaPedido cat, Date I,
			Date F, TCliente C, float cos) {
		super(ETipoElemento.PEDIDO);
		
		assert (I.before(F) || I.equals(F));
		
		id_pedido=id;
		origen=O;
		destino=D;
		estado=E;
		categoria=cat;
		ini=I;
		fin=F;
		cliente=C;
		costo= cos;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getLista_Tipo(ETipoElemento T) {
		switch (T) {
		case EMPLEADO:
			return getEmpleados();
		case VEHICULO:
			return getVehiculos();
		}
		return null;
	}

	public boolean superpone_IF(Date Ini, Date Fin) {
		Date iniP, finP;

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

	public Date get_ini() {
		return ini;
	}

	public void set_ini(Date Ini) {
		assert (Ini.before(fin) || Ini.equals(fin));
		this.ini = Ini;
	}

	public Date get_fin() {
		return fin;
	}

	public void set_fin(Date Fin) {
		assert (ini.before(Fin) || ini.equals(Fin));
		this.fin = Fin;
	}
	
	public int getId_pedido() {
		return id_pedido;
	}
	
	public void setId_pedido(int i){
		id_pedido=i;
	}

	public ArrayList<TEmpleado> getEmpleados() {
		return empleados;
	}

	public TCliente getCliente() {
		return cliente;
	}

	public ArrayList<TVehiculo> getVehiculos() {
		return vehiculos;
	}
	
	@Override
	public Object getEID(){
		return id_pedido;
	}

	public ECategoriaPedido getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoriaPedido categoria) {
		this.categoria = categoria;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
}
