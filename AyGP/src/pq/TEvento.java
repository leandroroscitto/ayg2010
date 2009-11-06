package pq;

import java.util.Date;

public class TEvento extends TElemento {
	
	private static final long serialVersionUID = 1L;
	
	
	private int id_evento;
	private String descripcion;
	private Date fecha;
	
	public TEvento(int id, String des, Date d){
		super(TElemento.EVENTO);
		
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	

}
