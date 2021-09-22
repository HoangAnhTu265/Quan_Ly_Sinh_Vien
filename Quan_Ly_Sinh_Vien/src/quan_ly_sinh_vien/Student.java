/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quan_ly_sinh_vien;

import javax.swing.JComboBox;

/**
 *
 * @author Diep.Tran
 */
public class Student {
    int Id_Student ; 
    String StudentName, Gender, Email;
    String Account , Password;
    int Status;

    public Student(int Id_Student, int Id_Manage, String StudentName, String Gender, String Email, String Account, String Password, int Status) {
        this.Id_Student = Id_Student;
        this.StudentName = StudentName;
        this.Gender = Gender;
        this.Email = Email;
        this.Account = Account;
        this.Password = Password;
        this.Status = Status;
    }

    public Student( String StudentName, String Gender, String Email, String Account, String Password, int Status) {
        
        this.StudentName = StudentName;
        this.Gender = Gender;
        this.Email = Email;
        this.Account = Account;
        this.Password = Password;
        this.Status = Status;
    }

    public Student(String StudentName, String Gender, String Email, String Account, String Password) {
        
        this.StudentName = StudentName;
        this.Gender = Gender;
        this.Email = Email;
        this.Account = Account;
        this.Password = Password;
    }

   
    
    

    Student(JComboBox<String> id_Manage, String ClassName, String Comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getId_Student() {
        return Id_Student;
    }

    
    public String getStudentName() {
        return StudentName;
    }

    public String getGender() {
        return Gender;
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

    public int getStatus() {
        return Status;
    }

    public void setId_Student(int Id_Student) {
        this.Id_Student = Id_Student;
    }

    
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
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

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
   
   
    
}
