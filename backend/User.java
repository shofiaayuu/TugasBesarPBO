/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author shofiatul
 */
public class User {
    int id;
    String nama,email, noTelepon, password;
    
    User(){
    }
    User(String nama, String email,String noTelepon,String password){
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
        this.password = password;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getId(){
        return this.id;
    }
    public String getNama(){
        return this.nama;
    }
    public String getEmail(){
        return this.email;
    }
    public String getNoTelepon(){
        return this.noTelepon;
    }
    public String getPassword(){
        return this.password;
    }
}
