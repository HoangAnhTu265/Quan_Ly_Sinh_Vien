/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quan_ly_sinh_vien;

/**
 *
 * @author Admin
 */
public class User {
    int Id_User ;
    String Account , Password , Email;

    public User(int Id_User, String Account, String Password, String Email) {
        this.Id_User = Id_User;
        this.Account = Account;
        this.Password = Password;
        this.Email = Email;
    }

    public User(String Account, String Password, String Email) {
        this.Account = Account;
        this.Password = Password;
        this.Email = Email;
    }

    public int getId_User() {
        return Id_User;
    }

    public String getAccount() {
        return Account;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    

   
    
}
