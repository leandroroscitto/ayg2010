package modelo;

import datos.TElemento;
import enumerados.EEstadoVehiculo;
import enumerados.ETipoElemento;
import enumerados.ETipoVehiculo;

public class TVehiculo extends TElemento {

	private static final long serialVersionUID = 1L;

	private String patente;
	private String marca;
	private String modelo;
	private String color;
	private long kilometraje;
	private EEstadoVehiculo estado;
	private ETipoVehiculo tvehiculo;
	private int id_vehiculo;

	public TVehiculo(String pat, String mar, String mod, String col, long kil,
			EEstadoVehiculo est,ETipoVehiculo tip,int id) {
		super(ETipoElemento.VEHICULO);
		patente = pat;
		marca = mar;
		modelo = mod;
		color = col;
		kilometraje = kil;
		estado = est;
		tvehiculo=tip;
		id_vehiculo=id;
	}
	
	//Determina si el estado del equipo permite su planificación en un pedido.
	//TRABAJANDO se considera porque la planificación puede ser a futuro.
	public boolean estado_disp() {
		if ((estado == EEstadoVehiculo.DISPONIBLE)
				|| (estado == EEstadoVehiculo.TRABAJANDO)) {
			return true;
		} else {
			return false;
		}
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(long kilometraje) {
		this.kilometraje = kilometraje;
	}

	public EEstadoVehiculo getEstado() {
		return estado;
	}

	public void setEstado(EEstadoVehiculo estado) {
		this.estado = estado;
	}
	
	public ETipoVehiculo getTipoVehiculo(){
		return tvehiculo;
	}
	
	public void setTipoVehiculo(ETipoVehiculo t){
		tvehiculo = t;
	}

	@Override
	public int getEID() {
		return id_vehiculo;
	}

}