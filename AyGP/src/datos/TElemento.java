package datos;

import java.io.Serializable;

import enumerados.ETipoElemento;

/**
 * Clase abstract heredada por todos los elementos del modelo que permite
 * agilizar las operaciones de inclusión, modificación y eliminación de
 * elementos del almacenamiento de datos. Al heredar de esta clase, es posible
 * determinar el tipo de cada elemento y su id sin conocer su clase.
 */
public abstract class TElemento implements Serializable {

	private static final long serialVersionUID = 1L;

	public ETipoElemento tipo;

	public TElemento(ETipoElemento t) {
		tipo = t;
	}

	public abstract Object getEID();

	public ETipoElemento getTipo() {
		return tipo;
	}
}
