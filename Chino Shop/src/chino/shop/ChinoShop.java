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
public class ChinoShop {
    public static ListaEnlazada Lista_Usuarios = new ListaEnlazada();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista_Usuarios.Crear_usuario(new Usuario("1","",""));
        Grafica ventana = new Grafica();
        ventana.setTitle("Inicio De Sesion");
        ventana.show();
        // TODO code application logic here
    }
    
}
