package modelo;

import java.util.ArrayList;

import datos.TElemento;
import enumerados.ECategoriaEmpleado;
import enumerados.EDia;
import enumerados.EEstadoEmpleado;
import enumerados.ETipoElemento;

public class TEmpleado extends TElemento {

	private static final long serialVersionUID = 1L;

	private int legajo;
	private String dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private THorario horario;
	private ECategoriaEmpleado categoria;
	private EEstadoEmpleado estado;
	private int id_empleado;

	public TEmpleado(int leg, String dnis, String nom, String dir, String tel,
			ECategoriaEmpleado cat, EEstadoEmpleado est,int id) {
		super(ETipoElemento.EMPLEADO);
		legajo = leg;
		dni = dnis;
		nombre = nom;
		direccion = dir;
		telefono = tel;
		horario = new THorario();
		categoria = cat;
		estado = est;
		id_empleado=id;
	}

	// Determina si el estado del equipo permite su planificación en un pedido.
	// TRABAJANDO se considera porque la planificación puede ser a futuro.
	public boolean estado_disp() {
		if ((estado == EEstadoEmpleado.DISPONIBLE)
				|| (estado == EEstadoEmpleado.TRABAJANDO)) {
			return true;
		} else {
			return false;
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public ArrayList<String> getRangosHorarios(EDia Dia) {
		return horario.get_rangos_dia(Dia);
	}

	public void asignar_horario(EDia Dia, int HI, int HF) {
		horario.agregar_rango_horario(Dia, HI, HF);
	}

	public void eliminar_horario(EDia Dia, int HI, int HF) {
		horario.quitar_rango_horario(Dia, HI, HF);
	}

	public boolean trabaja_en_rango(EDia Dia, int HI, int HF) {
		return horario.trabaja_en_rango(Dia, HI, HF);
	}

	public ECategoriaEmpleado getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoriaEmpleado categoria) {
		this.categoria = categoria;
	}

	public EEstadoEmpleado getEstado() {
		return estado;
	}

	public void setEstado(EEstadoEmpleado estado) {
		this.estado = estado;
	}

	@Override
	public int getEID() {
		return id_empleado;
	}

}
