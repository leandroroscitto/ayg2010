package pq;

public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TElemento e = new TElemento(TElemento.CLIENTE);
		
		

		GestorDeDatos g = new GestorDeDatos();

		g.cargar_estado();

		g.agregar_elemento(e);

		g.guardar_estado();

	}

}
