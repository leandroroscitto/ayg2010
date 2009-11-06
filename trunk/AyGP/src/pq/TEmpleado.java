package pq;

import java.util.ArrayList;

enum tipo_categoria_empleado {
	CHOFER, PEON, MOTOCICLISTA, CICLISTA, ADMINISTRATIVO, OPERADOR
}

enum tipo_estado_empleado {
	DISPONIBLE, LICENCIA_ENFERMEDAD, LICENCIA_VACACIONES, TRABAJANDO, NO_DISPONIBLE
}

public class TEmpleado extends TElemento {

	private static final long serialVersionUID = 1L;

	private int legajo;
	private String nombre;
	private String direccion;
	private String telefono;
	private THorario horario;
	private tipo_categoria_empleado categoria;
	private tipo_estado_empleado estado;

	public TEmpleado(int leg, String nom, String dir, String tel,
			tipo_categoria_empleado cat, tipo_estado_empleado est) {
		super(TElementotipo.EMPLEADO);
		legajo = leg;
		nombre = nom;
		direccion = dir;
		telefono = tel;
		horario = new THorario();
		categoria = cat;
		estado = est;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
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

	public ArrayList<String> getRangosHorarios(TDia Dia) {
		return horario.get_rangos_dia(Dia);
	}

	public void asignar_horario(TDia Dia, int HI, int HF) {
		horario.agregar_rango_horario(Dia, HI, HF);
	}

	public void eliminar_horario(TDia Dia, int HI, int HF) {
		horario.quitar_rango_horario(Dia, HI, HF);
	}

	public tipo_categoria_empleado getCategoria() {
		return categoria;
	}

	public void setCategoria(tipo_categoria_empleado categoria) {
		this.categoria = categoria;
	}

	public tipo_estado_empleado getEstado() {
		return estado;
	}

	public void setEstado(tipo_estado_empleado estado) {
		this.estado = estado;
	}

}
