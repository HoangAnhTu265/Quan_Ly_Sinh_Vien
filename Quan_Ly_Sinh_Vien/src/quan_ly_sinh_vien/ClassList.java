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
public class ClassList {

    public int Id_Class;
    public int Id_Manage;
    public String ClassName;
    public String Comment;

    public ClassList(int Id_Class, int Id_Manage, String ClassName, String Comment) {
        this.Id_Class = Id_Class;
        this.Id_Manage = Id_Manage;
        this.ClassName = ClassName;
        this.Comment = Comment;
    }

    public ClassList(int Id_Manage, String ClassName, String Comment) {
        this.Id_Manage = Id_Manage;
        this.ClassName = ClassName;
        this.Comment = Comment;
    }
    
    public ClassList() {
    
    }
    
//    ClassList(String Id_Manage, String ClassName, String Comment) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    

    public int getId_Class() {
        return Id_Class;
    }

    public int getId_Manage() {
        return Id_Manage;
    }

    public String getClassName() {
        return ClassName;
    }

    public String getComment() {
        return Comment;
    }

    public void setId_Class(int Id_Class) {
        this.Id_Class = Id_Class;
    }

    public void setId_Manage(int Id_Manage) {
        this.Id_Manage = Id_Manage;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

   
     
}
