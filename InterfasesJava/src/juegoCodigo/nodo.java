/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoCodigo;

/**
 *
 * @author user
 */
public class nodo<T> {

    //Atributos
    private T elemento;
    private nodo<T> siguiente; //Apunta al siguiente nodo

    //Contructor
    public nodo(T elemento, nodo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    //Metodos
    //aqui solo se implementa el getter y setter
    
    //obtiene el elemento de nodo
    public T getElemento() {
        return elemento;
    }

    //ubica un elemento en el nodo
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    

    //obiene la direccion del nodo
    public nodo<T> getSiguiente() {
        return siguiente;
    }

    //aplica la direccion del nodo
    public void setSiguiente(nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    //un toString para convertir todo en string
    @Override
    public String toString() {
        return elemento + "\n";
    }
}
