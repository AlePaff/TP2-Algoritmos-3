
public abstract class BloquesContenedores implements Bloque{

	protected ArrayList<Bloques> bloques = new ArrayList<>();
	
	void agregarBloques(Bloque bloque){
		bloques.add(bloque);
	}
	
	void ejecutar();
	
}
