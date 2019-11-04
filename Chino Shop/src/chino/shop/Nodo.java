/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chino.shop;

/**
 *
 * @author Davis
 */
public class Nodo {
    public Object contenido;
    private Nodo sig; 
    private Nodo ant;

    public Nodo(Object contenido,Nodo anterior,Nodo siguiente) {
        this.contenido=contenido;
        this.ant=anterior;
        this.sig=siguiente;
    }
    
    public Object mostrarNodo(){
        return(contenido);
    }

    /**
     * @return the sig
     */
    public Nodo getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public Nodo getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Object getcont() {
        return contenido;
    }

    public void secont(Object contenido) {
        this.contenido = contenido;
    }    
    
}
