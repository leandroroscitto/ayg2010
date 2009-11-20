package modelo;

import datos.TElemento;
import enumerados.EEstadoCliente;
import enumerados.ETipoElemento;

public class TCliente extends TElemento {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String direccion;
	private String telefono;
	private String dni;
	private String cuil_cuit;
	private EEstadoCliente estado;
	private int id_cliente;

	public TCliente(String nom, String dir, String tel, String d, String c,int id) {
		super(ETipoElemento.CLIENTE);
		nombre = nom;
		direccion = dir;
		telefono = tel;
		dni = d;
		cuil_cuit = c;
		estado = EEstadoCliente.ACTIVO;
		id_cliente=id;
	}
	
	public TCliente(String nom, String dir, String tel, String d,int id) {
		super(ETipoElemento.CLIENTE);
		nombre = nom;
		direccion = dir;
		telefono = tel;
		dni = d;
		cuil_cuit = "";
		estado = EEstadoCliente.ACTIVO;
		id_cliente=id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuil_cuit() {
		return cuil_cuit;
	}

	public void setCuil_cuit(String cuil_cuit) {
		this.cuil_cuit = cuil_cuit;
	}

	public EEstadoCliente getEstado() {
		return estado;
	}

	public void setEstado(EEstadoCliente estado) {
		this.estado = estado;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public int getEID() {
		return id_cliente;
	}

}
