package enumerados;

public enum ETipoVehiculo {
	BICICLETA, MOTO, COCHE, COMBI, MINIBUS, UTILITARIO, CAMIONETA;

	public String toString(){
		switch (ordinal()){
		case 0:
			return "Bicicleta";
		case 1:
			return "Moto";
		case 2:
			return "Coche";
		case 3:
			return "Combi";
		case 4:
			return "Minibus";
		case 5:
			return "Utilitario";
		case 6:
			return "Camioneta";
		default:
			return "No determinado";
		}
	}
}
