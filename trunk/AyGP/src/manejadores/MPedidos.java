package manejadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelo.TEmpleado;
import modelo.TPedido;
import modelo.TVehiculo;
import datos.TDatos;
import datos.TElemento;
import enumerados.EDia;
import enumerados.EEstadoPedido;

public class MPedidos {
	private TDatos datos;
	private ArrayList<TPedido> lpedidos;

	public MPedidos(TDatos d) {
		datos = d;
		lpedidos = datos.getLista_pedidos();
	}

	private boolean superpone_pedidos_IF(TPedido PAct,ArrayList<TPedido> listaP,
			Date Ini, Date Fin) {
		for (TPedido P : listaP) {
			if ((P.getId_pedido()!=PAct.getId_pedido()) && (P.superpone_IF(Ini, Fin))) {
				return false;
			}
		}

		return true;
	}

	// MAS GENERAL PARA OBTENER LA LISTA DE PEDIDOS
	private ArrayList<TPedido> pedidos_de_elemento(TElemento E) {
		ArrayList<TPedido> lista = new ArrayList<TPedido>();

		for (TPedido pedido : lpedidos) {
			if (((pedido.getEstado()!=EEstadoPedido.CANCELADO) && (pedido.getEstado()!=EEstadoPedido.ENTREGADO)) && (pedido.getLista_Tipo(E.getTipo()).contains(E))) {
				lista.add(pedido);
			}
		}
		return lista;
	}

	/*
	public boolean consultarDispEquipo(TEquipo E, Date Ini, Date Fin) {
		assert (Ini.before(Fin) || Ini.equals(Fin));

		ArrayList<TPedido> pedidosE;

		// En un principio verifica que este disponible mas allá del momento
		if (E.estado_disp()) {
			// Luego verifica que el intervalo Ini-Fin no se superponga con
			// ningún pedido al cual el equipo ya esté asignado

			// Obtiene todos los pedidos en el que aparece E
			pedidosE = pedidos_de_elemento(E);

			// Verifica la superposición
			return superpone_pedidos_IF(pedidosE, Ini, Fin);
		}

		return false;
	}
	*/

	public boolean consultarDispVehiculos(TPedido P,TVehiculo V, Date Ini,
			Date Fin) {
		assert (Ini.before(Fin) || Ini.equals(Fin));

		ArrayList<TPedido> pedidosV;

		if (V.estado_disp()) {
			pedidosV = pedidos_de_elemento(V);

			return superpone_pedidos_IF(P,pedidosV, Ini, Fin);
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean consultarDispEmpleados(TPedido P,TEmpleado Em, Date Ini,
			Date Fin) {
		assert (Ini.before(Fin) || Ini.equals(Fin));

		ArrayList<TPedido> pedidosEm;

		if (Em.estado_disp()) {
			// Verifica que el empleado trabaje en ese rango horario
			EDia DiaWIni = EDia.to_EDia(Ini.getDay());
			EDia DiaWFin = EDia.to_EDia(Fin.getDay());

			// NOSE: PARA EVITAR PROBLEMAS NO PUEDE HABER PEDIDOS ENTRE DOS AÑOS
			Calendar C = Calendar.getInstance();
			
			C.setTime(Ini);			
			int DiaYIni = C.get(Calendar.DAY_OF_YEAR);
			C.setTime(Fin);
			int DiaYFin = C.get(Calendar.DAY_OF_YEAR);

			// PARA CALCULAR HI Y HF
			int HoraI = Ini.getHours();
			int HoraF = Fin.getHours();
			int MinI = Ini.getMinutes();
			int MinF = Fin.getMinutes();

			// Transforma a hora 0000-2359
			int HI = HoraI * 100 + MinI;
			int HF = HoraF * 100 + MinF;

			boolean trabaja = true;

			// REVISAR: ES EL CASO DE QUE EL TRABAJO INVOLUCRE DIAS COMPLETOS
			// (?)
			if (DiaYIni < DiaYFin) {
				int difDia = DiaYFin - DiaYIni;
				int i = 0;

				// TRABAJA DESDE LA HORA DE INICIO HASTA EL FINAL DEL DIA
				trabaja = Em.trabaja_en_rango(DiaWIni, HI, 2359);
				
				// DIAS COMPLETOS
				EDia Dia = DiaWIni;
				while ((i < difDia) || (trabaja)) {
					Dia = Dia.proximo();
					trabaja = Em.trabaja_en_rango(Dia, 0000, 2359);
					i++;
				}

				// ULTIMO DIA
				if (trabaja) {
					trabaja = Em.trabaja_en_rango(DiaWFin, 0000, HF);
				}
			} else {
				// EL CASO DE QUE EL TRABAJO ES EN EL MISMO DIA
				trabaja = Em.trabaja_en_rango(DiaWFin, HI, HF);
			}

			// UNA VEZ QUE SABE QUE PUEDE TRABAJAR EN EL RANGO
			// VERIFICA QUE NO ESTE ASIGNADO A UN PEDIDO SUPERPUESTO
			if (trabaja) {
				pedidosEm = pedidos_de_elemento(Em);
				return superpone_pedidos_IF(P,pedidosEm, Ini, Fin);
			}
			return false;
		}

		return false;
	}
}
