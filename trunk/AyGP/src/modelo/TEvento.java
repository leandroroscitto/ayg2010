package modelo;

import java.util.Date;

import datos.TElemento;
import enumerados.ETipoElemento;

/**
 * Representa eventos o sucedos relacionados con la brindación de los servicios.
 * Se identifican por un id único, y poseen una descripción, un nombre resumido
 * y la fecha en la que se produjo tal evento. Son manejados por el ususario
 * administrativo.
 * 
 */
public class TEvento extends TElemento {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private int id_evento;
	private String descripcion;
	private Date fecha;

	public TEvento(int id, String nom, String des, Date d) {
		super(ETipoElemento.EVENTO);

		nombre = nom;
		id_evento = id;
		descripcion = des;
		fecha = d;
	}

	public String get_nombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Object getEID() {
		return id_evento;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getId_evento() {
		return id_evento;
	}

	public void set_nombre(String n) {
		nombre = n;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

}
