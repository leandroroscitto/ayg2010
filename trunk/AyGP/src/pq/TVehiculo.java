package pq;

import java.awt.Color;

enum tipo_estado_vehiculo{
	DISPONIBLE,
	EN_REPARACION,
	FUERA_DE_SERVICIO,
	RETENIDO_INFRACCIONES,
	TRABAJANDO,
	NO_DISPONIBLE
	}

public class TVehiculo extends TElemento{

	private static final long serialVersionUID = 1L;
	
	private String patente;
	private String marca;
	private String modelo;
	private Color color;
	private long kilometraje;
	private tipo_estado_vehiculo estado;

public TVehiculo(String pat,String mar,String mod,Color col,long kil,tipo_estado_vehiculo est){
	super(TElemento.VEHICULO);
	patente=pat;
	marca=mar;
	modelo=mod;
	color=col;
	kilometraje=kil;
	estado=est;
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

public tipo_estado_vehiculo getEstado() {
	return estado;
}

public void setEstado(tipo_estado_vehiculo estado) {
	this.estado = estado;
}

}