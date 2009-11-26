package modelo;

import datos.TElemento;
import enumerados.EEstadoCliente;
import enumerados.ETipoElemento;
import formateadores.TTelefono;

public class TCliente extends TElemento {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String direccion;
	private String telefono;
	private long dni;
	private String cuil_cuit;
	private EEstadoCliente estado;
	private int id_cliente;

	public TCliente(String nom, String dir, String tel, long d, String c,int id) {
		super(ETipoElemento.CLIENTE);
		nombre = nom;
		direccion = dir;
		telefono = tel;
		dni = d;
		cuil_cuit = c;
		estado = EEstadoCliente.ACTIVO;
		id_cliente=id;
	}
	
	public TCliente(String nom, String dir, String tel, long d,int id) {
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
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
	public Object getEID() {
		return dni;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
