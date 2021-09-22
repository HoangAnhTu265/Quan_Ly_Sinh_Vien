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
public class Manage {
    int Id_Manage ,Id_User;
    String ManageName, Email, Account , Password ;

    public Manage(int Id_Manage, int Id_User, String ManageName, String Email, String Account, String Password) {
        this.Id_Manage = Id_Manage;
        this.Id_User = Id_User;
        this.ManageName = ManageName;
        this.Email = Email;
        this.Account = Account;
        this.Password = Password;
    }

    public Manage(int Id_User, String ManageName, String Email, String Account, String Password) {
        this.Id_User = Id_User;
        this.ManageName = ManageName;
        this.Email = Email;
        this.Account = Account;
        this.Password = Password;
    }

    public int getId_Manage() {
        return Id_Manage;
    }

    public int getId_User() {
        return Id_User;
    }

    public String getManageName() {
        return ManageName;
    }

    public String getEmail() {
        return Email;
    }

    public String getAccount() {
        return Account;
    }

    public String getPassword() {
        return Password;
    }

    public void setId_Manage(int Id_Manage) {
        this.Id_Manage = Id_Manage;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public void setManageName(String ManageName) {
        this.ManageName = ManageName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    

    
}
