package enumerados;

public enum EDia {
	LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;

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
}