package modelo;

import datos.TElemento;
import enumerados.ECategoriaEquipo;
import enumerados.EEstadoEquipo;
import enumerados.ETipoElemento;

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

	public int getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ECategoriaEquipo getTipo_equipo() {
		return this.tipo_equipo;
	}

	public void setTipo(ECategoriaEquipo tipo) {
		this.tipo_equipo = tipo;
	}

	public EEstadoEquipo getEstado() {
		return estado;
	}

	public void setEstado(EEstadoEquipo estado) {
		this.estado = estado;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}