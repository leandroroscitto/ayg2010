package modelo;

import java.awt.Color;

import datos.TElemento;
import enumerados.EEstadoVehiculo;
import enumerados.ETipoElemento;

public class TVehiculo extends TElemento {

	private static final long serialVersionUID = 1L;

	private String patente;
	private String marca;
	private String modelo;
	private Color color;
	private long kilometraje;
	private EEstadoVehiculo estado;

	public TVehiculo(String pat, String mar, String mod, Color col, long kil,
			EEstadoVehiculo est) {
		super(ETipoElemento.VEHICULO);
		patente = pat;
		marca = mar;
		modelo = mod;
		color = col;
		kilometraje = kil;
		estado = est;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
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

}