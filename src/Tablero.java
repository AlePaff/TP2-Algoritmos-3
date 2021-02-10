
public class Tablero {
	
	private ArrayList<Bloque> bloques = new ArrayList<>();
	private ArrayList<Posicion> posiciones = new ArrayList<>();
	
	void dibujar(Personaje personaje) {
		for (Bloque bloque : bloques) { /* ponele*/
            personaje.dibujar(bloque); 
        }
	}
	
	void agregarBloqueDerecho(){
		bloques.add(new BloqueDerecho());
	}
	void agregarBloqueIzquierdo(){
		bloques.add(new BloqueIzquierdo());
	}
	void agregarBloqueArriba(){
		bloques.add(new BloqueArriba());
	}
	void agregarBloqueAbajo(){
		bloques.add(new BloqueAbajo());
	}
	void agregarBloqueSubirLapiz(){
		bloques.add(new BloqueSubirLapiz());
	}
	void agregarBloqueBajarLapiz(){
		bloques.add(new BloqueBajarLapiz());
	}
	void agregarBloqueInvertirComportamiento(){
		bloques.add(new BloqueInvertirComportamiento());
	}
	void agregarBloquePersonalizado(){
		bloques.add(new BloquePersonalizado());
	}
	void agregarBloqueRepetir(){
		bloques.add(new BloqueRepetir());
	}
	

}
