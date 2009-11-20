package enumerados;

public enum ECategoriaPedido {
	MENSAJERIA, REPARTO, REMISERIA, FLETES;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Mensajerķa";
		case 1:
			return "Reparto";
		case 2:
			return "Remiserķa";
		case 3:
			return "Fletes";
		default:
			return "No determinado";
		}
	}
}
