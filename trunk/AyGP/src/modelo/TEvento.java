package modelo;

import java.util.Date;

import datos.TElemento;
import enumerados.ETipoElemento;

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

	
	public String get_nombre(){
		return nombre;
	}
	
	public void set_nombre(String n){
		nombre = n;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Object getEID(){
		return id_evento;
	}

}
