package juegoCodigo;

//la clase carta es una clase de tipo generico por lo que los palos no tienen una entidad definida
public class Carta<T> {

    private int numero;
    private T palo;

    //es el constructor de la clase carta
    public Carta(int numero, T palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public T getPalo() {
        return palo;
    }

    //lo que hace esta funcion es generar los caracteres especiales a los numeros de cartas 
    @Override
    public String toString() {
        //los string son para unir los valores finales
        String estado = "";
        String nombreFigura = "";

        //hay que entrar a palos para poder modificar sus valores
        if (palo.getClass().getSimpleName().equals("Palos")) {

            switch (numero) {

                //al generar los numeros de las cartas hay ciertos numeros que tienen simbolos y no un valor numerico
                //esto cambia su valor numerico por el icono de la carta
                case 1:
                    nombreFigura = "As";
                    break;
                case 10:
                    nombreFigura = "Sota";
                    break;
                case 11:
                    nombreFigura = "Caballo";
                    break;
                case 12:
                    nombreFigura = "Rey";
                    break;
                default:
                    nombreFigura = numero + "";

            }

        }
        //unifica los valores en una variable
        estado = nombreFigura + " de " + palo;
        //retorna la variable
        return estado;
    }

}
