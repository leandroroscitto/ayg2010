package formateadores;

public class TPatente {
	private String valor = "";

	public TPatente(String cadena, String cadenaOriginal) {
		int longitud = cadena.length();
		boolean ok;

		ok=(longitud==6);
		ok=ok && ((es_letra(cadena.charAt(0)) && es_letra(cadena.charAt(1)) && es_letra(cadena.charAt(2))));
		ok=ok && ((es_digito(cadena.charAt(3)) && es_digito(cadena.charAt(4)) && es_digito(cadena.charAt(5))));
		
		if (ok){
			valor=cadena;
		}else{
			valor=cadenaOriginal;
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

	public boolean es_letra(char C){
		return ((C>='A') && (C<='Z'));
	}

	// Devuelve la cadena
	public String toString() {
		//return (valor.substring(0, 3)+"-"+valor.subSequence(3, 6));
		return (valor);
	}
}

