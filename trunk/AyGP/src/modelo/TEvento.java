package modelo;

import java.util.Calendar;

import datos.TElemento;
import enumerados.ETipoElemento;

public class TEvento extends TElemento {

	private static final long serialVersionUID = 1L;

	private int id_evento;
	private String descripcion;
	private Calendar fecha;

	public TEvento(int id, String des, Calendar d) {
		super(ETipoElemento.EVENTO);

		id_evento = id;
		descripcion = des;
		fecha = d;
	}

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
