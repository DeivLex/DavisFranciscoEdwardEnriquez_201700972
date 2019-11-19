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
public class Lista { 
    class Nodo {
        String Nombre;
        Nodo sig;
    }
 
    private Nodo raiz;
    
    public Lista () {
        raiz=null;
    }
    
    public void insertar(String Nombre) {
     if(Existe(Nombre)==false){
     Nodo nuevo;
        nuevo = new Nodo();
        nuevo.Nombre = Nombre;
        
        if (raiz==null)
        {
            nuevo.sig = null;
            raiz = nuevo;
        }
        else
        {
            nuevo.sig=raiz;
            raiz=nuevo;
        }
    }
    }
    
    public String getCat(int j){
    String retorna="";
    int i=0;
        Nodo reco=raiz;
        while (reco!=null) {
            if(j==i){
            retorna=reco.Nombre;
            return retorna;
            }
            i++;
            reco=reco.sig;
        }
    return retorna;
    }
        
    public String imprimir() {
        String get="";
        Nodo reco=raiz;
        while (reco!=null) {
            get+="Nombre: "+reco.Nombre+"\n";
            reco=reco.sig;
        }
        return get;
    }
    public int tam() {
        int i=0;
        Nodo reco=raiz;
        while (reco!=null) {
            i++;
            reco=reco.sig;
        }
        return i;
    }
    public boolean Existe(String a) {
        boolean si=false;
        Nodo reco=raiz;
        while (reco!=null) {
            if(reco.Nombre.equalsIgnoreCase(a)){
            si=true;
            return si;
            }
            reco=reco.sig;
        }
        return si;
    }
    
}
