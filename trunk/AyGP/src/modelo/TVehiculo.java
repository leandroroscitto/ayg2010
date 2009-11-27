package modelo;

import datos.TElemento;
import enumerados.EEstadoVehiculo;
import enumerados.ETipoElemento;
import enumerados.ETipoVehiculo;

/**
 * Representa los vehículos utilizado durante la realización de los pedidos.
 * Poseen una patante única, una marca, modelo, color, kilometraje, id, un
 * estado actual y el la clase de vehículo (camioneta, utilitario, bicicleta,
 * etc).
 */
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
			EEstadoVehiculo est, ETipoVehiculo tip, int id) {
		super(ETipoElemento.VEHICULO);
		patente = pat;
		marca = mar;
		modelo = mod;
		color = col;
		kilometraje = kil;
		estado = est;
		tvehiculo = tip;
		id_vehiculo = id;
	}

	// Determina si el estado del equipo permite su planificación en un pedido.
	// TRABAJANDO se considera porque la planificación puede ser a futuro.
	public boolean estado_disp() {
		if ((estado == EEstadoVehiculo.DISPONIBLE)
				|| (estado == EEstadoVehiculo.TRABAJANDO)) {
			return true;
		} else {
			return false;
		}
	}

	public String getColor() {
		return color;
	}

	@Override
	public Object getEID() {
		return patente;
	}

	public EEstadoVehiculo getEstado() {
		return estado;
	}

	public int getId_vehiculo() {
		return id_vehiculo;
	}

	public long getKilometraje() {
		return kilometraje;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPatente() {
		return patente;
	}

	public ETipoVehiculo getTipoVehiculo() {
		return tvehiculo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setEstado(EEstadoVehiculo estado) {
		this.estado = estado;
	}

	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public void setKilometraje(long kilometraje) {
		this.kilometraje = kilometraje;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setTipoVehiculo(ETipoVehiculo t) {
		tvehiculo = t;
	}

}