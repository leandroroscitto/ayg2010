package enumerados;

public enum EEstadoEmpleado {
	DISPONIBLE, LICENCIA_ENFERMEDAD, LICENCIA_VACACIONES, TRABAJANDO, NO_DISPONIBLE;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Disponible";
		case 1:
			return "Licencia por enfermedad";
		case 2:
			return "Licencia por vacaciones";
		case 3:
			return "Trabajando";
		case 4:
			return "No disponible";
		default:
			return "No determinado";
		}
	}
}