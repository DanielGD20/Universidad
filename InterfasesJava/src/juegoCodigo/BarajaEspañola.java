package juegoCodigo;

public class BarajaEspañola extends Baraja {

    //el boolean nos indica que si esta en true esta inclira todas las cartas, esto esta puesto por si luego se quiere jugar
    //sin el 7 u 8
    public boolean incluyeTodo;

    public BarajaEspañola(boolean incluyeTodo) {
        super();

        this.numCartas = 48;
        this.cartasPorPalo = 12;
        crearBaraja();
        super.barajar();
    }

    @Override
    //este metodo crear baraja se deriva de la clase principar de Baraja para crear el mazo
    public void crearBaraja() {

        this.cartas = (Carta<Palos>[]) new Carta[numCartas];

        Palos[] palos = Palos.values();

        for (int i = 0; i < palos.length; i++) {

            for (int j = 0; j < cartasPorPalo; j++) {

                cartas[(i * (cartasPorPalo) + j)] = new Carta(j + 1, palos[i]);

            }

        }

    }

}
