package datos;

import java.io.Serializable;
import enumerados.ETipoElemento;

public class TElemento implements Serializable {

	private static final long serialVersionUID = 1L;

	public ETipoElemento tipo;

	public TElemento(ETipoElemento t) {
		tipo = t;
	}

	public ETipoElemento getTipo() {
		return tipo;
	}

}
