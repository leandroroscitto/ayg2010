package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import enumerados.EDia;

/**
 * Representa el rango de horarios de trabajo para un empleado. Esta compuesto
 * de una lista de pares <Dia,HoraInicio,HoraFin>, que indican que el empleado
 * est� disponible para realizar un pedido desde la HoraInicio hasta la HoraFin
 * en el d�a Dia.
 */
public class THorario implements Serializable {

	public class TRangoHorario implements Serializable {

		private static final long serialVersionUID = 1L;

		private int HoraIni;
		private int HoraFin;
		private EDia Dia;

		public TRangoHorario(EDia D, int HI, int HF) {
			assert (HI >= 0) && (HI <= 2359 && ((HI % 100) <= 59)) : System.out
					.printf("Error hora inicio %d", HI);
			assert (HF >= 0) && (HF <= 2359) && ((HF % 100) <= 59) : System.out
					.printf("Error hora fin %d", HF);
			assert (HI <= HF) : System.out.printf("Error en el rango");

			HoraIni = HI;
			HoraFin = HF;
			Dia = D;
		}

		public EDia getDia() {
			return Dia;
		}

		public int getHoraFin() {
			return HoraFin;
		}

		public int getHoraIni() {
			return HoraIni;
		}
	}

	private static final long serialVersionUID = 1L;

	private ArrayList<TRangoHorario> Asignacion;

	public THorario() {
		Asignacion = new ArrayList<TRangoHorario>();
	}

	public void agregar_rango_horario(EDia Dia, int HI, int HF) {
		TRangoHorario rango = new TRangoHorario(Dia, HI, HF);

		Asignacion.add(rango);
	}

	public THorario clonar() {
		ArrayList<TRangoHorario> ListaR = new ArrayList<TRangoHorario>();
		for (TRangoHorario R : Asignacion) {
			ListaR.add(R);
		}

		THorario Clon = new THorario();
		Clon.Asignacion = ListaR;

		return Clon;
	}

	public ArrayList<TRangoHorario> get_rangos_dia(EDia Dia) {
		ArrayList<TRangoHorario> listaR = new ArrayList<TRangoHorario>();

		int i = 0;
		int tam = Asignacion.size();
		TRangoHorario rh;

		while (i < tam) {
			rh = Asignacion.get(i);
			if (rh.getDia().equals(Dia)) {
				listaR.add(rh);
			}
			i++;
		}

		return listaR;
	}

	public ArrayList<TRangoHorario> getAsignacion() {
		return Asignacion;
	}

	public TRangoHorario getvaloren(int indice) {
		assert indice >= 0;
		assert indice < Asignacion.size();

		return Asignacion.get(indice);
	}

	public void quitar_rango_horario(EDia Dia, int HI, int HF) {
		int i = 0;
		int tam = Asignacion.size();
		boolean encontro = false;
		TRangoHorario rh;

		while ((i < tam) || !encontro) {
			rh = Asignacion.get(i);
			encontro = (rh.getDia().equals(Dia) && rh.getHoraIni() == HI && rh
					.getHoraFin() == HF);
			i++;
		}

		Asignacion.remove(i--);
	}

	public void quitar_rango_horario(int indice) {
		assert indice >= 0;
		assert indice < Asignacion.size();

		Asignacion.remove(indice);
	}

	public boolean rangos_validos(int HI1, int HF1, int HI2, int HF2) {
		return !((HI1 > HI2 && HI1 < HF2) || (HI2 > HI1 && HI2 < HF1));
	}

	public boolean trabaja_en_rango(EDia Dia, int HI, int HF) {
		int i = 0;
		int tam = Asignacion.size();
		boolean encontro = false;
		TRangoHorario rh;

		while ((i < tam) && !encontro) {
			rh = Asignacion.get(i);
			encontro = (rh.getDia().equals(Dia) && (rh.getHoraIni() <= HI) && (rh
					.getHoraFin() >= HF));
			i++;
		}

		return encontro;
	}
}
