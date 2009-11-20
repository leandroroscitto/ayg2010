package enumerados;

public enum ECategoriaEmpleado {
	CHOFER, PEON, MOTOCICLISTA, CICLISTA, ADMINISTRATIVO, OPERADOR;


	public String toString(){
		switch (ordinal()){
		case 0:
			return "Chofer";
		case 1:
			return "Peón";
		case 2:
			return "Motociclista";
		case 3:
			return "Ciclista";
		case 4:
			return "Administrativo";
		case 5:
			return "Operador";
		default:
			return "No determinado";
		}
	}
}