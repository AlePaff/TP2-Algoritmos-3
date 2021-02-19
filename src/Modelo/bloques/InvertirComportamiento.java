package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class InvertirComportamiento extends Conjunto {
    Movimiento movimiento = new MovimientoInvertido();

    @Override
    public void ejecutar(Movimiento movimiento, Personaje personaje, Tablero tablero) {
        for (Bloque bloque : bloques) {
            bloque.ejecutar(this.movimiento, personaje, tablero);
        }
    }
}