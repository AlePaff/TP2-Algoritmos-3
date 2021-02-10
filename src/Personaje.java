
public class Personaje {

	private Estado estado = new LapizArriba();

	void dibujar(Bloque bloque) {
		/* ? */
		this.hacerMovimiento(bloque); /* ? */
	}
	
	void hacerMovimiento(Bloque bloque) {
		this.estado.hacerMovimiento(this, bloque);
	}
	
	void subirLapiz() {
		this.estado = new LapizArriba();
	}
	
	void bajarLapiz() {
		this.estado = new LapizAbajo();
	}

}
