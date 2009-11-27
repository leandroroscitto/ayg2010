package enumerados;

public enum EDia {
	DOMINGO, LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO;
	
	// Convierte un dia de Calendar.DAY_OF_WEEK
	public static EDia to_EDia(int Day) {
		switch (Day) {
		case 1:
			return DOMINGO;
		case 2:
			return LUNES;
		case 3:
			return MARTES;
		case 4:
			return MIERCOLES;
		case 5:
			return JUEVES;
		case 6:
			return VIERNES;
		case 7:
			return SABADO;
		}
		return null;
	}

	// Devuelve el próximo día al actual.
	public EDia proximo() {
		switch (this) {
		case DOMINGO:
			return LUNES;
		case LUNES:
			return MARTES;
		case MARTES:
			return MIERCOLES;
		case MIERCOLES:
			return JUEVES;
		case JUEVES:
			return VIERNES;
		case VIERNES:
			return SABADO;
		case SABADO:
			return DOMINGO;
		}
		return null;
	}
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Lunes";
		case 1:
			return "Martes";
		case 2:
			return "Miércoles";
		case 3:
			return "Jueves";
		case 4:
			return "Viernes";
		case 5:
			return "Sabado";
		case 6:
			return "Domingo";
		default:
			return "No determinado";
		}
	}
}