package modelo;

import java.util.Date;

import datos.TElemento;
import enumerados.ECategoriaPedido;
import enumerados.ETipoElemento;

/**
 * Representan los gastos extras relacionados con la prestación de los servicios
 * brindados por la empresa de cadetería. Son identificados por un id único, y
 * poseen además un nombre resumido, una descripción, la fecha y el monto del
 * gasto. Además se identifica el tipo de servicio al cual están asociados.
 */
public class TGasto extends TElemento {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ECategoriaPedido categoria;
	private int id_gasto;
	private String descripcion;
	private float monto;
	private Date fecha;

	public TGasto(int id, String nom, ECategoriaPedido cat, String des,
			float m, Date f) {
		super(ETipoElemento.GASTO);

		id_gasto = id;
		nombre = nom;
		categoria = cat;
		descripcion = des;
		monto = m;
		fecha = f;
	}

	public ECategoriaPedido getCategoria() {
		return categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public Object getEID() {
		return id_gasto;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getId_gasto() {
		return id_gasto;
	}

	public float getMonto() {
		return monto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCategoria(ECategoriaPedido categoria) {
		this.categoria = categoria;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setId_gasto(int id_gasto) {
		this.id_gasto = id_gasto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
