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
public class ClassStudent {
    int Id_StudentClass;
    int Id_Class;
    int Id_Student;
    int Id_Manage;
    String ManageName;

    public ClassStudent(int Id_StudentClass, int Id_Class, int Id_Student, int Id_Manage, String ManageName) {
        this.Id_StudentClass = Id_StudentClass;
        this.Id_Class = Id_Class;
        this.Id_Student = Id_Student;
        this.Id_Manage = Id_Manage;
        this.ManageName = ManageName;
    }

    public ClassStudent(int Id_Class, int Id_Student, int Id_Manage, String ManageName) {
        this.Id_Class = Id_Class;
        this.Id_Student = Id_Student;
        this.Id_Manage = Id_Manage;
        this.ManageName = ManageName;
    }

    public int getId_StudentClass() {
        return Id_StudentClass;
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

    public void setId_StudentClass(int Id_StudentClass) {
        this.Id_StudentClass = Id_StudentClass;
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
