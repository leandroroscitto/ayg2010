package pq;

import java.io.Serializable;

public class TElemento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	static final int EMPLEADO = 0;
	static final int PEDIDO = 1;
	static final int EVENTO = 2;
	static final int GASTO = 3;
	static final int CLIENTE = 4;
	static final int VEHICULO = 5;
	static final int EQUIPO = 6;

	public int tipo;

	public TElemento(int t) {
		tipo = t;
	}

	public int getTipo() {
		return tipo;
	}

}
