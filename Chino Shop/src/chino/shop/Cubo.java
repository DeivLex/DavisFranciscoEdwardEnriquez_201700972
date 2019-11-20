/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chino.shop;

import static chino.shop.ChinoShop.fecha_;
import static chino.shop.ChinoShop.hora_;

/**
 *
 * @author Davis
 */
public class Cubo {
            class Nodo {
                 String Cliente;
                 String Dia;
                 String Hora;
                 String Producto;
                 double Total;
                 Nodo sig, ant;
               }
        private Nodo raiz;
    public Cubo () {
        raiz=null;
    }
     void insertar (int pos,String Cliente, String Dia,String Hora,String Producto,double Total)
    {
        if (pos <= cantidad () + 1)    {
            Nodo nuevo = new Nodo ();
            nuevo.Cliente=Cliente;
            nuevo.Dia = Dia;
            nuevo.Hora=Hora;
            nuevo.Producto=Producto;
            nuevo.Total=Total;
            
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
                informacion = raiz.Hora;
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
                informacion = prox.Hora;
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
                if (reco2.Hora.compareTo(reco1.Hora)<0) {
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
            if (reco.Cliente.equalsIgnoreCase(x))
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
    
    
    
    public String imprimir (String date){
        String ret="";
        int cont=0;
        for(int i=0;i<hora_.tam();i++){
        ret+="P"+i+"[label=\"Hora: "+hora_.getCat(i)+":00\"pos=\""+(i*2)+",0!\"];";
        Nodo reco = raiz;
        int j=1;
        while (reco != null) {
            if(reco.Hora.equalsIgnoreCase(hora_.getCat(i))&&reco.Dia.equalsIgnoreCase(date)){
            ret+=cont+"[label=\"Cliente: "+reco.Cliente+"\\nProductos: "+reco.Producto+"\\nTotal: Q"+reco.Total+"\"pos=\""+(i*2)+",-"+(j*2)+"!\"];";
            cont++;
            j++;
            }
            reco = reco.sig;
        }
        }
        return ret;
    }
            public String imprimir2(String date){
        String ret="";
        String pa="";
        String tot="";
        int cont=0;
        for(int i=0;i<hora_.tam();i++){
        pa+="P"+i;
        ret+="P"+i;
        Nodo reco = raiz;
        while (reco != null) {
            if(reco.Hora.equalsIgnoreCase(hora_.getCat(i))&&reco.Dia.equalsIgnoreCase(date)){
            ret+="->"+cont;
            cont++;
            }
            reco = reco.sig;
        }
        ret+=";";
        if(i<hora_.tam()-1){
        pa+="->";
        }
        }
        pa+=";";
        tot=pa+ret;
        return tot;
    }
        public int tam (){
        int i=0;
        Nodo reco = raiz;
        while (reco != null) {
            i++;
            reco = reco.sig;
        }
        return i;
    }
}
