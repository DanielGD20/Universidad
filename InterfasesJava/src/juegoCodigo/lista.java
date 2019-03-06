package juegoCodigo;

import java.util.Iterator;

//el iterador nos permite recorrer la lista y nos devuelve su valor
public class lista<T> implements Iterable<T> {

    //Atributos
    private nodo<T> primero;
    private nodo<T> ultimo;
    private int tamanio;

    public lista() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    //indica si esta vacia o no
    public boolean isEmpty() {
        return tamanio == 0;
    }

    //devuelve el tamaño de la lista
    public int size() {
        return tamanio;
    }

    // devuelve el elemento en la posicion indicada
    public T get(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return getFirst(); //Cojo el primero
        } else if (index == size() - 1) {
            return getLast(); //Cojo el ultimo
        } else {

            //Uso la funcion getNode para coger el nodo deseado
            nodo<T> buscado = getNode(index);

            return buscado.getElemento();
        }
    }

    //devuelve el primer elemento
    public T getFirst() {
        //Si esta vacia, no hay primero que coger
        if (isEmpty()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }

    //devuelve el ultimo elemento
    public T getLast() {
        //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }

    //devuelve el nodo completo en una posicion en concreto
    private nodo<T> getNode(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelvo el primero
        } else if (index == size() - 1) {
            return ultimo; //devuelvo el ultimo
        } else {

            nodo<T> buscado = primero;

            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }

            //Me devuelve el buscado
            return buscado;

        }

    }
//añade un elemento al final de la lista

    public T addLast(T elemento) {

        nodo<T> aux;

        //Si esta vacia, hago lo mismo que si fuera aÃ±adir el primero
        if (isEmpty()) {
            return addFirst(elemento);
        } else {

            //Hago el intercambio
            aux = new nodo<>(elemento, null);

            ultimo.setSiguiente(aux);
            ultimo = aux;

        }

        //Aumento el tamanÃ±o
        tamanio++;
        return ultimo.getElemento();

    }
//añade un elemento al inicio de la lista

    public T addFirst(T elemento) {

        nodo<T> aux;

        //si esta vacia, el nodo serÃ¡ el primero y ultimo
        if (isEmpty()) {
            aux = new nodo<>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            //Hago el intercambio
            nodo<T> primeroActual = primero;
            aux = new nodo<>(elemento, primeroActual);
            primero = aux;

        }

        //Aumento el tamanÃ±o
        tamanio++;
        return primero.getElemento();

    }
//añade un elemento en la posicion indicada

    public T add(T elemento, int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (index == 0) {
            return addFirst(elemento); //AÃ±ade en la primera posicion
        } else if (index == size()) {
            return addLast(elemento); //aÃ±ade en la ultima posicion
        } else if ((index < 0 || index >= size())) {
            return null;
        } else {

            //Cojo el anterior nodo al que estoy buscando
            nodo<T> buscado_anterior = getNode(index - 1);

            //Cojo el nodo de la posicion indicada
            nodo<T> buscado_actual = getNode(index);

            //Creo el nuevo novo, este apuntara al de la posicion actual
            nodo<T> aux = new nodo<>(elemento, buscado_actual);

            //el nodo anterior apunta a nuestro nuevo nodo
            buscado_anterior.setSiguiente(aux);

            //Aumento el tamaÃ±o
            tamanio++;
            return getNode(index).getElemento();

        }

    }
//devuelve el estado de la lista

    public String toString() {

        String contenido = "";

        //Si esta vacia, lo indica
        if (isEmpty()) {
            contenido = "Lista vacia";
        } else {

            nodo<T> aux = primero;

            //Recorre la lista, mostrando el contenido
            while (aux != null) {
                contenido += aux.toString();
                aux = aux.getSiguiente();
            }

        }

        return contenido;

    }
//indica si existe el elemento indicado

    public boolean exists(T elemento) {

        //Si esta vacio, devuelve el false
        if (isEmpty()) {
            return false;
        } else {

            nodo<T> aux = primero;

            //Recorremos la lista
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return true; //Existe
                }
                aux = aux.getSiguiente();
            }

            //Si no lo encuentra devuelve false
            return false;

        }
    }

    //indica la posicion del elemento
    public int indexOf(T elemento) {

        //Si esta vacio, devuelvemos -1
        if (isEmpty()) {
            return -1;
        } else {

            nodo<T> aux = primero;

            int posicion = 0;
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return posicion; //Existe
                }
                posicion++;
                aux = aux.getSiguiente();
            }
            //Si no lo encuentra devuelve -1
            return -1;

        }

    }

    //elimina el primer elemento de la lista
    public T removeFirst() {

        //Si la lista esta vacia, devolvemos null
        if (isEmpty()) {
            return null;
        } else {

            //Guardo el elemento antes
            T elemento = primero.getElemento();

            //Cojo el segundo
            nodo<T> aux = primero.getSiguiente();
            primero = null; //Lo marco como null para el recolector
            primero = aux; //Este es mi nuevo primero

            //En caso de que borremos el ultimo elemento,el ultimo tambiÃ©n
            if (size() == 1) {
                ultimo = null;
            }

            tamanio--;

            return elemento;

        }

    }
//elimina el ultimo elemento de la lista

    public T removeLast() {

        if (isEmpty()) {
            return null;
        } else {

            //Coge el elemento antes de borrar
            T elemento = ultimo.getElemento();

            //Cojo el penultimo
            nodo<T> aux = getNode(size() - 2);

            //En caso de que sea null
            //Hay 1 o dos elementos
            if (aux == null) {

                //marco el ultimo como nulo
                ultimo = null;
                //Si hay dos, el primero y el ultimo seran el mismo
                //Si hay 1 elemento, significa que borramos la lista
                if (size() == 2) {
                    ultimo = primero;
                } else {
                    primero = null;
                }

            } else {
                //el penultimo es el nuevo ultimo 
                //y le ponemos como siguiente nulo
                ultimo = null;
                ultimo = aux;
                ultimo.setSiguiente(null);
            }

            tamanio--;

            return elemento;

        }

    }
//elimina un nodo de la lista en una posicion en concreto

    public T remove(int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {

            //Cojo el nodo anterior al que quiero borrar
            nodo<T> nodo_anterior = getNode(index - 1);

            //Cojo el nodo que quiero borrar
            nodo<T> nodo_actual = getNode(index);

            //Cojo el elemento antes de borrar
            T elemento = nodo_actual.getElemento();

            //Cojo el nodo siguiente al que quiero borrar
            nodo<T> nodo_siguiente = nodo_actual.getSiguiente();

            //Lo marco para borrar para el recolector
            nodo_actual = null;

            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);

            tamanio--;

            return elemento;

        }
    }

    //modifico un nodo sin afectar a la estructura
    public T modify(T elemento, int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else {

            //nodo actual
            nodo<T> aux = getNode(index);

            //modifico
            aux.setElemento(elemento);

            return aux.getElemento();

        }

    }
    
    //este metodo sirve para eliminar toda la lista de una sola
    
    public void removeAll(){
        
        if(isEmpty()){
            System.out.println("La lista esta vacia");
        }else {
            
            int contador = size();
            while(contador > -1){
                removeFirst();
                contador--;
            }
            
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //Creo la clase interna MyIterator, que implementa la interfaz Iterator
    private class MyIterator<ListaDinamica> implements Iterator<T> {

        //Indica el siguiente elemento que se va a devolver 
        private int siguiente;

        //Indica si hay un elemento
        @Override
        public boolean hasNext() {
            return getNode(siguiente) != null;
        }

        //Devuelve el elemento actual e incrementa al siguiente
        @Override
        public T next() {
            T elemento = getNode(siguiente).getElemento();
            siguiente++;
            return elemento;
        }

    }

}
