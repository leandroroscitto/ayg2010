package enumerados;

public enum EEstadoCliente{
	ACTIVO,INACTIVO;
	
	public String toString(){
		switch (ordinal()){
		case 0:
			return "Activo";
		case 1:
			return "Inactivo";
		default:
			return "No determinado";
		}
	}
}