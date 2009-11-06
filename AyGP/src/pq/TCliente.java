package pq;


enum tipo_estado_cliente{
	ACTIVO, 
	INACTIVO	
}

public class TCliente extends TElemento{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String dni;
	private String cuil_cuit;
	private tipo_estado_cliente estado;
	
	
	public TCliente(String nom, String dir, String tel, String d, String c){
		super(TElementotipo.CLIENTE);		
		nombre = nom;
		direccion = dir;
		telefono = tel;
		dni = d;
		cuil_cuit = c;
		estado = tipo_estado_cliente.ACTIVO;
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


	public tipo_estado_cliente getEstado() {
		return estado;
	}


	public void setEstado(tipo_estado_cliente estado) {
		this.estado = estado;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
	

}
