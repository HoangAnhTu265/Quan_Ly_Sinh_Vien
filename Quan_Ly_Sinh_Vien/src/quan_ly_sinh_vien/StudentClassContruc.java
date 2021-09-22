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
public class StudentClassContruc {

    int Id_ClassStudent;
    int Id_Class;
    int Id_Student;
    int Id_Manage;
    String ManageName;

    public StudentClassContruc(int Id_ClassStudent, int Id_Class, int Id_Student, int Id_Manage, String ManageName) {
        this.Id_ClassStudent = Id_ClassStudent;
        this.Id_Class = Id_Class;
        this.Id_Student = Id_Student;
        this.Id_Manage = Id_Manage;
        this.ManageName = ManageName;
    }

    public StudentClassContruc(int Id_Class, int Id_Student, int Id_Manage, String ManageName) {
        this.Id_Class = Id_Class;
        this.Id_Student = Id_Student;
        this.Id_Manage = Id_Manage;
        this.ManageName = ManageName;
    }

    public StudentClassContruc(int Id_Class, int Id_Student, int Id_Manage) {
        this.Id_Class = Id_Class;
        this.Id_Student = Id_Student;
        this.Id_Manage = Id_Manage;
    }
    
    

    public int getId_ClassStudent() {
        return Id_ClassStudent;
    }

    public int getId_Class() {
        return Id_Class;
    }

    public int getId_Student() {
        return Id_Student;
    }

    public int getId_Manage() {
        return Id_Manage;
    }

    public String getManageName() {
        return ManageName;
    }

    public void setId_ClassStudent(int Id_ClassStudent) {
        this.Id_ClassStudent = Id_ClassStudent;
    }

    public void setId_Class(int Id_Class) {
        this.Id_Class = Id_Class;
    }

    public void setId_Student(int Id_Student) {
        this.Id_Student = Id_Student;
    }

    public void setId_Manage(int Id_Manage) {
        this.Id_Manage = Id_Manage;
    }

    public void setManageName(String ManageName) {
        this.ManageName = ManageName;
    }

    

}
