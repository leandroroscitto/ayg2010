package enumerados;

public enum ECategoriaPedido {
	MENSAJERIA, REPARTO, REMISERIA, FLETES;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Mensajer�a";
		case 1:
			return "Reparto";
		case 2:
			return "Remiser�a";
		case 3:
			return "Fletes";
		default:
			return "No determinado";
		}
	}
}
