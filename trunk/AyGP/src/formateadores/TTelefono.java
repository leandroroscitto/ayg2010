package formateadores;


public class TTelefono {
	// Valor de la variable
	private String valor = "";

	// Elimina todo lo que no sea dígitos
	public TTelefono(String cadena, String cadenaOriginal) {
		int longitud = cadena.length();
		char[] cdn = new char[longitud];

		int i;
		int d = 0;
		char C;
		boolean error = false;

		for (i = 0; i < longitud; i++) {
			C = cadena.charAt(i);
			if (es_digito(C) || es_simbolo(C)) {
				cdn[d] = cadena.charAt(i);
				d++;
			} else {
				error = true;
				break;
			}
		}

		if (error) {
			valor = cadenaOriginal;
		} else {
			valor = new String(cdn, 0, d);
		}
	}

	public boolean es_digito(char C) {
		switch (C) {
		case '1':
			return (true);
		case '2':
			return (true);
		case '3':
			return (true);
		case '4':
			return (true);
		case '5':
			return (true);
		case '6':
			return (true);
		case '7':
			return (true);
		case '8':
			return (true);
		case '9':
			return (true);
		case '0':
			return (true);
		default:
			return (false);
		}
	}

	public boolean es_simbolo(char C) {
		switch (C) {
		case ')':
			return (true);
		case '(':
			return (true);
		case '#':
			return (true);
		case '-':
			return (true);
		default:
			return (false);
		}
	}

	// Devuelve la cadena
	public String toString() {
		return valor;
	}
}
