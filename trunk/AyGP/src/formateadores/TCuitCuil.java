package formateadores;

public class TCuitCuil {
	private String valor = "";

	public TCuitCuil(String cadena, String cadenaOriginal) {
		int longitud = cadena.length();
		char[] cdn = new char[longitud];

		int i;
		int d = 0;
		boolean error = false;

		if (es_digito(cadena.charAt(0)) && es_digito(cadena.charAt(1))
				&& es_digito(cadena.charAt(longitud - 1))
				&& es_digito(cadena.charAt(longitud - 2))
				&& (cadena.charAt(2) == '-')
				&& (cadena.charAt(longitud - 3) == '-')) {
			cdn[0] = cadena.charAt(0);
			cdn[1] = cadena.charAt(1);
			cdn[2] = cadena.charAt(2);
			for (i = 3; i < (longitud - 3); i++) {
				if (es_digito(cadena.charAt(i))) {
					cdn[i] = cadena.charAt(i);
				} else {
					error = true;
					break;
				}
				d = i;
			}
			cdn[d + 1] = cadena.charAt(longitud - 3);
			cdn[d + 2] = cadena.charAt(longitud - 2);
			cdn[d + 3] = cadena.charAt(longitud - 1);

			if (error) {
				valor = cadenaOriginal;
			} else {
				valor = new String(cdn, 0, d + 4);
			}
		} else {
			valor = cadenaOriginal;
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

	// Devuelve la cadena
	public String toString() {
		return valor;
	}
}
