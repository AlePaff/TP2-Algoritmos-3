
public class LapizAbajo implements EstadoLapiz{
	
	void dibujar(){
		/* hacer algo*/
	}
	
	void hacerMovimiento(Personaje personaje, Bloque bloque){
		/* tiene que moverse*/
	}
	
	void hacerMovimiento(Personaje personaje, SubirLapiz bloque){
		
		personaje.SubirLapiz();
	}
	
	void hacerMovimiento(Personaje personaje, BajarLapiz bloque){
		/* no hace nada como su contraparte, son necesarios?*/
	}
	
}
