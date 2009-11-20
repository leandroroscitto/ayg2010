package modelo;

import datos.TElemento;
import enumerados.ECategoriaPedido;
import enumerados.ETipoElemento;

public class TGasto extends TElemento {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ECategoriaPedido categoria;
	private int id_gasto;
	private String descripcion;
	private float monto;

	public TGasto(int id, String nom, ECategoriaPedido cat, String des, float m) {
		super(ETipoElemento.GASTO);

		id_gasto = id;
		nombre = nom;
		categoria = cat;
		descripcion = des;
		monto = m;
	}

	public int getId_gasto() {
		return id_gasto;
	}

	public void setId_gasto(int id_gasto) {
		this.id_gasto = id_gasto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ECategoriaPedido getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoriaPedido categoria) {
		this.categoria = categoria;
	}

	@Override
	public int getEID() {
		return id_gasto;
	}
}
