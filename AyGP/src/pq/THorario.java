package pq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

enum TDia {
	LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
}

public class THorario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public class TRangoHorario implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private int HoraIni;
		private int HoraFin;

		public TRangoHorario(int HI, int HF) {
			assert (HI >= 0) && (HI <= 2359 && ((HI % 100) <= 59)) : System.out
					.printf("Error hora inicio %d", HI);
			assert (HF >= 0) && (HF <= 2359) && ((HF % 100) <= 59) : System.out
					.printf("Error hora fin %d", HF);
			assert (HI <= HF) : System.out.printf("Error en el rango");

			HoraIni = HI;
			HoraFin = HF;
		}

		public int getHoraIni() {
			return HoraIni;
		}

		public int getHoraFin() {
			return HoraFin;
		}
	}

	private Hashtable<TDia, ArrayList<TRangoHorario>> Asignacion;

	public THorario() {
		Asignacion = new Hashtable<TDia, ArrayList<TRangoHorario>>();
		
		Asignacion.put(TDia.LUNES, new ArrayList<TRangoHorario>());
		Asignacion.put(TDia.MARTES, new ArrayList<TRangoHorario>());
		Asignacion.put(TDia.MIERCOLES, new ArrayList<TRangoHorario>());
		Asignacion.put(TDia.JUEVES, new ArrayList<TRangoHorario>());
		Asignacion.put(TDia.VIERNES, new ArrayList<TRangoHorario>());
		Asignacion.put(TDia.SABADO, new ArrayList<TRangoHorario>());
		Asignacion.put(TDia.DOMINGO, new ArrayList<TRangoHorario>());
	}

	public boolean rangos_validos(int HI1, int HF1, int HI2, int HF2) {
		return !((HI1 > HI2 && HI1 < HF2) || (HI2 > HI1 && HI2 < HF1));
	}

	public void agregar_rango_horario(TDia Dia, int HI, int HF) {
		TRangoHorario rango = new TRangoHorario(HI, HF);

		Asignacion.get(Dia).add(rango);
	}

	public void quitar_rango_horario(TDia Dia, int HI, int HF) {
		ArrayList<TRangoHorario> lista = Asignacion.get(Dia);

		int i = 0;
		int tam = lista.size();
		boolean encontro = false;
		TRangoHorario rh;

		while ((i < tam) || !encontro) {
			rh = lista.get(i);
			encontro = (rh.getHoraIni() == HI && rh.getHoraFin() == HF);
			i++;
		}

		lista.remove(i--);
	}

	public ArrayList<String> get_rangos_dia(TDia Dia) {
		ArrayList<TRangoHorario> lista = Asignacion.get(Dia);
		ArrayList<String> listaS = new ArrayList<String>();

		int i = 0;
		int tam = lista.size();
		TRangoHorario rh;
		String cadena;

		while (i < tam) {
			rh = lista.get(i);
			cadena = String.valueOf(rh.getHoraIni()) + ','
					+ String.valueOf(rh.getHoraFin());
			listaS.add(cadena);
			i++;
		}

		return listaS;
	}

	public boolean trabaja_en_rango(TDia Dia, int HI, int HF) {
		ArrayList<TRangoHorario> lista = Asignacion.get(Dia);

		int i = 0;
		int tam = lista.size();
		boolean encontro = false;
		TRangoHorario rh;

		while ((i < tam) || !encontro) {
			rh = lista.get(i);
			encontro = (rh.getHoraIni() <= HI && rh.getHoraFin() >= HF);
			i++;
		}

		return encontro;
	}

}
