package pq;

enum tipo_categoria_equipo {
	HANDY, RADIO, CELULAR, CASCO
}

enum tipo_estado_equipo {
	DISPONIBLE, EN_REPARACION, FUERA_DE_SERVICIO, TRABAJANDO, NO_DISPONIBLE
}

public class TEquipo extends TElemento {

	private static final long serialVersionUID = 1L;

	private int id_equipo;
	private String nombre;
	private tipo_categoria_equipo tipo_equipo;
	private tipo_estado_equipo estado;

	public TEquipo(int id, String nom, tipo_categoria_equipo tip,
			tipo_estado_equipo est) {
		super(TElementotipo.EQUIPO);
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

	public tipo_categoria_equipo getTipo_equipo() {
		return this.tipo_equipo;
	}

	public void setTipo(tipo_categoria_equipo tipo) {
		this.tipo_equipo = tipo;
	}

	public tipo_estado_equipo getEstado() {
		return estado;
	}

	public void setEstado(tipo_estado_equipo estado) {
		this.estado = estado;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	

}