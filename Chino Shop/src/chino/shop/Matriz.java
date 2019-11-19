/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chino.shop;

import static chino.shop.ChinoShop.categoria;

/**
 *
 * @author Davis
 */
public class Matriz {
        class Nodo {
                 String Categoria;
                 String Nombre;
                 double Precio;
                 int Existencias;
                 Nodo sig, ant;
               }
        private Nodo raiz;
    
    public Matriz () {
        raiz=null;
    }
      
    void insertar (int pos, String Categoria,String Nombre,double Precio,int Existencias)
    {
        if (pos <= cantidad () + 1)    {
            Nodo nuevo = new Nodo ();
            nuevo.Categoria = Categoria;
            nuevo.Nombre = Nombre;
            nuevo.Precio = Precio;
            nuevo.Existencias=Existencias;
            if (pos == 1){
                nuevo.sig = raiz;
                if (raiz!=null)
                    raiz.ant=nuevo;
                raiz = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    Nodo reco = raiz;
                    while (reco.sig != null) {
                        reco = reco.sig;
                    }
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = null;
                } else {
                    Nodo reco = raiz;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.sig;
                    Nodo siguiente = reco.sig;
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = siguiente;
                    siguiente.ant=nuevo;
                }
        }
    }

    public String extraer (int pos) {
        if (pos <= cantidad ())    {
            String informacion;
            if (pos == 1) {
                informacion = raiz.Nombre;
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = prox.Nombre;
            }
            return informacion;
        }
        else
            return "No esta";
    }

    public void borrar (int pos)
    {
        if (pos <= cantidad ())    {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                prox=prox.sig;
                reco.sig = prox;
                if (prox!=null)
                    prox.ant=reco;
            }
        }
    }
    
    public int cantidad ()
    {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
    
    public boolean ordenada() {
        if (cantidad()>1) {
            Nodo reco1=raiz;
            Nodo reco2=raiz.sig;
            while (reco2!=null) {
                if (reco2.Nombre.compareTo(reco1.Nombre)<0) {
                    return false;
                }
                reco2=reco2.sig;
                reco1=reco1.sig;
            }
        }
        return true;
    }
    
    public boolean existe(String x) {
        Nodo reco=raiz;
        while (reco!=null) {
            if (reco.Nombre.equalsIgnoreCase(x))
                return true;
            reco=reco.sig;
        }
        return false;
    }
    
    public boolean vacia ()
    {
        if (raiz == null)
            return true;
        else
            return false;
    }
    
    
    
    public void imprimir (){
        for(int i=0;i<categoria.tam();i++){
        Nodo reco = raiz;
        while (reco != null) {
            if(reco.Categoria.equalsIgnoreCase(categoria.getCat(i))){
            System.out.print(reco.Nombre+"-Q"+reco.Precio);
            }
            reco = reco.sig;
        }
        System.out.println();
        }
    }
}
