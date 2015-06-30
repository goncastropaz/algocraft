package fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.HashMap;

import fiuba.algo3.modelo.complementos.Posicion;
import fiuba.algo3.modelo.construcciones.Construccion;
import fiuba.algo3.modelo.excepciones.CeldaEspacial;
import fiuba.algo3.modelo.excepciones.CeldaOcupada;
import fiuba.algo3.modelo.excepciones.CeldaSinRecurso;
import fiuba.algo3.modelo.excepciones.FueraDeMatriz;
import fiuba.algo3.modelo.unidades.Unidad;

public class Mapa {

	private Celda[][] matriz;
	private static int tamanio = 50;
	private static int baseSuperior = 4;
	private static int baseInferior = 45;
	private static HashMap<Integer, Posicion> baseJugadores;

	public Mapa() {

		Celda mat[][] = new Celda[tamanio][tamanio];
		for (int f = 0; f < tamanio; f++) {
			for (int c = 0; c < tamanio; c++) {
				Celda unaCelda;
				try {
					unaCelda = new Celda(new Posicion(f, c));
					mat[f][c] = unaCelda;
				} catch (FueraDeMatriz e) {
					e.printStackTrace();
				}
			};
		};

		matriz = mat;
		baseJugadores = new HashMap<Integer, Posicion>();
		try {
			baseJugadores.put(1, new Posicion(baseSuperior, baseSuperior));
			baseJugadores.put(2, new Posicion(baseInferior, baseInferior));
		} catch (FueraDeMatriz e) {

			e.printStackTrace();
		}

		this.setRecursosEnMapa();
		this.setAreasEspaciales();

	}

	private void setRecursosEnMapa() {
		matriz[baseSuperior][baseSuperior].setMineral();
		matriz[baseSuperior][baseSuperior + 1].setMineral();
		matriz[baseSuperior + 1][baseSuperior].setMineral();
		matriz[baseSuperior + 1][baseSuperior + 1].setGas();
		matriz[baseInferior][baseInferior].setMineral();
		matriz[baseInferior][baseInferior + 1].setMineral();
		matriz[baseInferior + 1][baseInferior].setMineral();
		matriz[baseInferior + 1][baseInferior + 1].setGas();
	}

	private void setAreasEspaciales() {
		for (int fil = 1; fil < 41; fil++) {
			for (int col = 18; col < 31; col++) {
				matriz[fil][col].setAsEspacial();
			}
		}
	}

	public Celda devolverCelda(Posicion pos) {
		int fila = pos.getFila();
		int columna = pos.getColumna();
		return matriz[fila][columna];
	}

	public int getTamanio() {
		return this.tamanio;
	}

	public Posicion getBaseJugador(int jugador) {
		return this.baseJugadores.get(jugador);
	}

	public ArrayList<Celda> devolverCeldasRadio(Posicion pos, int radio) {
		ArrayList<Celda> listaDeCeldas = new ArrayList<Celda>();
		int filaInicial = 0;
		int filaFinal = tamanio - 1;
		int colInicial = 0;
		int colFinal = tamanio - 1;
		if (!((pos.getFila() - radio) < 0))
			filaInicial = (pos.getFila() - radio);
		if (!((pos.getFila() + radio) > (tamanio - 1)))
			filaFinal = (pos.getFila() + radio);
		if (!((pos.getColumna() - radio) < 0))
			colInicial = (pos.getColumna() - radio);
		if (!((pos.getColumna() + radio) > (tamanio - 1)))
			colFinal = (pos.getColumna() + radio);
		for (int fil = filaInicial; fil < filaFinal + 1; fil++) {
			for (int col = colInicial; col < colFinal + 1; col++) {
				try {
					listaDeCeldas.add(this
							.devolverCelda(new Posicion(fil, col)));
				} catch (FueraDeMatriz e) {
					e.printStackTrace();
				}
			}
		}
		return listaDeCeldas;

	}

	public void agregarUnidad(Unidad unidad, Posicion pos) throws CeldaOcupada {
		this.matriz[pos.getFila()][pos.getColumna()].setUnidad(unidad);

	}

	public void agregarConstruccion(Construccion construccion, Posicion pos)
			throws CeldaOcupada, CeldaSinRecurso, CeldaEspacial {
		this.matriz[pos.getFila()][pos.getColumna()]
				.setConstruccion(construccion);

	}

}