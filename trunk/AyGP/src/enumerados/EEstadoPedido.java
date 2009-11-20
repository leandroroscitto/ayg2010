package enumerados;

public enum EEstadoPedido {
	EN_ESPERA, DESPACHADO, ENTREGADO, DEMORADO, CANCELADO;

	public String toString(){
		switch (ordinal()){
		case 0:
			return "En espera";
		case 1:
			return "Despachado";
		case 2:
			return "Entregado";
		case 3:
			return "Demorado";
		case 4:
			return "Cancelado";
		default:
			return "No determinado";
		}
	}
}
