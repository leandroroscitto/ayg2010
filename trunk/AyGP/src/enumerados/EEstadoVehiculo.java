package enumerados;

public enum EEstadoVehiculo {
	DISPONIBLE, EN_REPARACION, FUERA_DE_SERVICIO, RETENIDO_INFRACCIONES, TRABAJANDO, NO_DISPONIBLE;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Disponible";
		case 1:
			return "En Reparación";
		case 2:
			return "Fuera de servicio";
		case 3:
			return "Retenido por infracciones";
		case 4:
			return "Trabajando";
		case 5:
			return "No disponible";
		default:
			return "No determinado";
		}
	}
}
