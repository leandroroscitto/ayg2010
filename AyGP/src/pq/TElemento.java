package pq;

import java.io.Serializable;

enum TElementotipo{
	EMPLEADO,
	PEDIDO,
	EVENTO,
	GASTO,
	CLIENTE,
	VEHICULO,
	EQUIPO
}

public class TElemento implements Serializable{

	private static final long serialVersionUID = 1L;

	public TElementotipo tipo;

	public TElemento(TElementotipo t) {
		tipo = t;
	}

	public TElementotipo getTipo() {
		return tipo;
	}

}
