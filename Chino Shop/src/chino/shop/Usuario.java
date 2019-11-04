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
public class Usuario {
    private String Cui;
    private String User;
    private String Pass;    

    public Usuario(String Cui, String User, String Pass) {
        this.Cui = Cui;
        this.User = User;
        this.Pass = Pass;
    }

    public String getCui() {
        return Cui;
    }

    public void setCui(String Cui) {
        this.Cui = Cui;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
}
