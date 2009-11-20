package enumerados;

public enum ECategoriaEquipo {
	HANDY, RADIO, CELULAR, CASCO;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Handy";
		case 1:
			return "Radio";
		case 2:
			return "Celular";
		case 3:
			return "Casco";
		default:
			return "No determinado";
		}
	}
}
