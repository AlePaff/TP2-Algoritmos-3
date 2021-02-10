
public class LapizArriba implements EstadoLapiz {

	void dibujar(){}
	
	void hacerMovimiento(Personaje personaje, Bloque bloque){
		/* tiene que moverse*/
	}
	
	void hacerMovimiento(Personaje personaje, BajarLapiz bloque){
		personaje.bajarLapiz();
	}
	
	void hacerMovimiento(Personaje personaje, SubirLapiz bloque){
		/* no hace nada, es necesario ponerlo?*/
	}
}
