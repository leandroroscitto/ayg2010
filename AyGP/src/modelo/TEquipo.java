package modelo;

import datos.TElemento;
import enumerados.ECategoriaEquipo;
import enumerados.EEstadoEquipo;
import enumerados.ETipoElemento;

/**
 * Representa los equipos utilizados durante los trabajos brindados por la
 * empresa. Poseen un id único y si identifican a paritir de este número.
 * 
 */
public class TEquipo extends TElemento {

	private static final long serialVersionUID = 1L;

	private int id_equipo;
	private String nombre;
	private ECategoriaEquipo tipo_equipo;
	private EEstadoEquipo estado;

	public TEquipo(int id, String nom, ECategoriaEquipo tip, EEstadoEquipo est) {
		super(ETipoElemento.EQUIPO);
		id_equipo = id;
		nombre = nom;
		tipo_equipo = tip;
		estado = est;
	}

	// Determina si el estado del equipo permite su planificación en un pedido.
	// TRABAJANDO se considera porque la planificación puede ser a futuro.
	public boolean estado_disp() {
		if ((estado == EEstadoEquipo.DISPONIBLE)
				|| (estado == EEstadoEquipo.TRABAJANDO)) {
			return true;
		} else {
			return false;
		}
	}

	public Object getEID() {
		return id_equipo;
	}

	public EEstadoEquipo getEstado() {
		return estado;
	}

	public int getId_equipo() {
		return id_equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public ECategoriaEquipo getTipo_equipo() {
		return this.tipo_equipo;
	}

	public void setEstado(EEstadoEquipo estado) {
		this.estado = estado;
	}

	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(ECategoriaEquipo tipo) {
		this.tipo_equipo = tipo;
	}

	public String toString() {
		return (estado.toString() + ", " + nombre + ", "
				+ tipo_equipo.toString() + ", " + id_equipo);
	}

}