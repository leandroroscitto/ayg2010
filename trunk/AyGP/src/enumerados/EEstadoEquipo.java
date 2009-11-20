package enumerados;

public enum EEstadoEquipo {
	DISPONIBLE, EN_REPARACION, FUERA_DE_SERVICIO, TRABAJANDO, NO_DISPONIBLE;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Disponible";
		case 1:
			return "En reparación";
		case 2:
			return "Fuera de servicio";
		case 3:
			return "Trabajando";
		case 4:
			return "No disponible";
		default:
			return "No determinado";
		}
	}
}
