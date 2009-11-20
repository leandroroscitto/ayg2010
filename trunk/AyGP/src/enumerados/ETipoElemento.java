package enumerados;

public enum ETipoElemento {
	EMPLEADO, PEDIDO, EVENTO, GASTO, CLIENTE, VEHICULO, EQUIPO;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Empleado";
		case 1:
			return "Pedido";
		case 2:
			return "Evento";
		case 3:
			return "Gasto";
		case 4:
			return "Cliente";
		case 5:
			return "Vehículo";
		case 6:
			return "Equipo";
		default:
			return "No determinado";
		}
	}
}