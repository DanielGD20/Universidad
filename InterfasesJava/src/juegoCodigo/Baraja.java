package juegoCodigo;

//clase mas sifnificativa siendo abstracta con valores genericos
public abstract class Baraja<T> {

    //se utiliza el protected porque hay una clase hija llamada BarajaEspañola y esto nos facilita el acceso a los datos de
    //la clase padre
    protected Carta<T> cartas[];
    protected int posSiguienteCarta;
    protected int numCartas;
    protected int cartasPorPalo;

    //este es el primer metodo de la clase baraja
    public Baraja() {
        posSiguienteCarta = 0;  
    }

    public abstract void crearBaraja();

    //este metodo se encarga de barajar las cartas
    public void barajar() {

        int posAleatoria = 0;
        Carta c;

        for (int i = 0; i < cartas.length; i++) {

            posAleatoria = Metodos.generarNumeroEnteroAleatorio(0, numCartas - 1);

            c = cartas[i];
            cartas[i] = cartas[posAleatoria];
            cartas[posAleatoria] = c;
        }
        this.posSiguienteCarta = 0;
    }

    //este metodo se encarga de pasar a la siguiente carta del mazo
    public Carta siguienteCarta() {

        Carta c = null;

        if (posSiguienteCarta == numCartas) {

            System.out.println("Ya no hay cartas");

        } else {
            c = cartas[posSiguienteCarta++];
        }

        return c;
    }

    //este metodo nos da las cartas disponibles en el momento de ejecucion 
    public int cartasDisponibles() {

        return numCartas - posSiguienteCarta;

    }

    //este metodo es una funcion que dependiendo del numero dado por el usuario se encarga de sacar las cartas del arreglo
    //para luego repartirlas
    public Carta[] darCartas(int numCartas) {

        Carta[] tomar = new Carta[numCartas];

        for (int i = 0; i < tomar.length; i++) {

            //se utiliza un metodo propuesto antes para este metodo
            tomar[i] = siguienteCarta();

        }

        return cartas;
    }

    //este metodo se encarga de mostrar las cartas descartadas
    public void cartasMonton() {

        for (int i = 0; i < posSiguienteCarta; i++) {
            System.out.println(cartas[i]);
        }

    }

    //este metodo muestra toda la baraja
    public void mostrarBaraja() {

        for (int i = posSiguienteCarta; i < cartas.length; i++) {

            System.out.println(cartas[i]);

        }

    }

    public int getNumCartas() {
        return numCartas;
    }

    public int getPosSiguienteCarta() {
        return posSiguienteCarta;
    }
    
    

}
