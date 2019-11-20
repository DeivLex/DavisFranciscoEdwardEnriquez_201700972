/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chino.shop;

import static chino.shop.ChinoShop.Desencriptar;
import static chino.shop.ChinoShop.Encriptar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davis
 */
public class ListaEnlazada {
    private Nodo Inicio;
    private Nodo Fin;

    public ListaEnlazada() {
        this.Inicio = null;
        this.Fin = null;
    }

    public Nodo getInicio() {
        return Inicio;
    }

    public void setInicio(Nodo Inicio) {
        this.Inicio = Inicio;
    }


    public Nodo getFin() {
        return Fin;
    }

 
    public void setFin(Nodo Fin) {
        this.Fin = Fin;
    }
    
    public boolean vacia(){
        return(Inicio==null);
    }
    public void Crear_usuario(Object Nuevo_user){
        Nodo nuevoNodo=new Nodo(Nuevo_user,null,Inicio);//Envia el objeto, nodo anteror, nodo siguiente
        if (vacia()) {
        Fin=nuevoNodo;//si la lista esta vacia entonces el inicio va ser igual al final
        }else{
        Inicio.setAnt(nuevoNodo);//conecta hacia antras el nodo nuevo de inicio con el nodo nuevo            
        }
        Inicio=nuevoNodo;
        System.out.println("usuario creado");
    }
    
        public void eliminar_user(String cui_rec){
        Nodo actual = Inicio;
        Usuario aux;
        boolean existe=false;
        while(actual!=null){
            aux=(Usuario)actual.getcont();
            if (aux.getCui().equals(cui_rec)) {
                //------------------------------------Proceso de eliminar----------------------------
                if (getInicio()==getFin()) {
                    setInicio(null);
                    setFin(null);
                    System.out.println("ultimo");
                }else
                if (actual==Inicio) {//si anterior es null entonces es el primero                   
                    Inicio=actual.getSig();
                    actual.getSig().setAnt(null);
                    actual.setSig(null);
                    System.out.println("inicio");
                }else if(actual==Fin){
                    Fin=actual.getAnt();
                    actual.getAnt().setSig(null);
                    actual.setAnt(null);
                    System.out.println("final");
                    
                }else{
                    actual.getAnt().setSig(actual.getSig());
                    actual.getSig().setAnt(actual.getAnt());
                    actual.setAnt(null);
                    actual.setSig(null);                    
                    System.out.println("medio");
                }
                //-----------------------------------------------------------------------------------                
                existe=true;
                
            }
            if (getInicio()!=getFin()) {
                actual=actual.getSig();                
            }else{
                actual=null;
            }

        }
        
        
        if (existe==true) {
 
            System.out.println("Usuario eliminado.");
        }else{
            System.out.println("No se encontro un usuraio con los datos ingresado.");
        }
    }
    
        public Usuario obtener_user(String cui_rec){
            Nodo actual=Inicio;
            String aux;
            Usuario regresar=null;
            while(actual!=null){
                aux=((Usuario)actual.getcont()).getCui();
                if (cui_rec.equals(aux)) {
                    regresar=((Usuario)actual.getcont());
                }
                actual=actual.getSig();
            }
            return(regresar);
            
        }
        
        public boolean existe_enlista(String cui_rec){
            boolean existe=false;
            Nodo actual=Inicio;
            String aux;
            while(actual!=null){
                aux=((Usuario)actual.getcont()).getCui();
                if (cui_rec.equals(aux)) {
                    existe=true;
                }
                actual=actual.getSig();
            }            
            return(existe);
        }        
        
            public boolean existe_enlista_login(String id_rec,String contra_rec){//se usa solo en el login
            boolean existe=false;
            Nodo actual=Inicio;
            Usuario aux;
            while(actual!=null){
                aux=(Usuario)actual.getcont();
                String des="";
                try {
                    des = Encriptar(contra_rec);
                } catch (Exception ex) {
                    Logger.getLogger(ListaEnlazada.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (id_rec.equals(aux.getUser())&&des.equals(aux.getPass())) {
                    existe=true;
                }
                actual=actual.getSig();
            }            
            return(existe);
        }
        
        public Usuario obtener_user_login(String id_rec,String contra_rec){//se usa solo en el login
            Nodo actual=Inicio;
            Usuario aux;
            Usuario regresar=null;
            while(actual!=null){
                aux=(Usuario)actual.getcont();
                String des="";
                try {
                    des = Encriptar(contra_rec);
                } catch (Exception ex) {
                    Logger.getLogger(ListaEnlazada.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (id_rec.equals(aux.getUser())&&des.equals(aux.getPass())) {
                    regresar=((Usuario)actual.getcont());
                }
                actual=actual.getSig();
            }
            return(regresar);
        }
        
        public String Imprimir(){
            int i=1;
            String cui,name,pass;
            String rep="";
            Nodo actual=Inicio;
            while(actual!=null){
                cui =((Usuario)actual.getcont()).getCui();
                name =((Usuario)actual.getcont()).getUser();
                pass=((Usuario)actual.getcont()).getPass();
                rep+=i+"[label=\"Cui: "+cui+"\\nNombre: "+name+"\\nContraseña:"+pass+"\"];";
                i++;
                actual=actual.getSig();
            }
            return rep;
        }
        public String Imprimir2(){
            int i=1;
            String rep="Inicio";
            Nodo actual=Inicio;
            while(actual!=null){
                rep+="->"+(i);
                i++;
                actual=actual.getSig();
            }
            rep+=";";
            return rep;
        }
}
