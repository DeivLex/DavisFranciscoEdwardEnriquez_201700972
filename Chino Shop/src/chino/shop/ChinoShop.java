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
    public static Lista categoria = new Lista();
    public static Matriz productos = new Matriz();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista_Usuarios.Crear_usuario(new Usuario("1","",""));
        Login ventana = new Login();
        ventana.show();
        //------------------------------
        
    }
    
}
