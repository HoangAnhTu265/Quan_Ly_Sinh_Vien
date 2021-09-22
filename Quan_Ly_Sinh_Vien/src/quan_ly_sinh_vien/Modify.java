/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quan_ly_sinh_vien;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static quan_ly_sinh_vien.Login_form.getMd5;

public class Modify {
        public static String getMd5(String input) {
        try {
            // tạo một hàm băm 
            
            //getInstance tạo một đối tượng mesageDisgest
            MessageDigest md = MessageDigest.getInstance("MD5");

            // nếu input không null thì hàm băm sẽ 
            if (input != null) {
                // hàm input sẽ trả về byte 
                md.update(input.getBytes());
            }
            md.update(input.getBytes());
            
            // tạo mảng bytedate kiểu byte rồi gán cá
            byte byteData[] = md.digest();

            
            // tạo string buffer 
            StringBuffer sb = new StringBuffer();
            
            // lặp qua mảng byte
            for (int i = 0; i < byteData.length; i++) {
                
                // đẩy kí tự đã hash vào trong chuỗi sb
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            //trả về chuỗi sb
            return sb.toString();
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void addStudent(Student std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "insert into student(studentName, Gender, Email, Account, Password) values(?, ?, ?, ?, ?)";

            
            // chuẩn bị thực hiện câu sql có tham số 
            statement = connection.prepareCall(sql);

            // truyền tham số vào dấu ?
            
            statement.setString(1, std.getStudentName());
            statement.setString(2, std.getGender());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getAccount());
            statement.setString(5, getMd5(std.getPassword()));
    
            //chạy câu lệnh truy vẫn
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void addClass(StudentClassContruc SCC) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "insert into studentclass( Id_Class , Id_Student  , Id_Manage ,ManageName) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, SCC.getId_Class());
            statement.setInt(2, SCC.getId_Student());
            statement.setInt(3, SCC.getId_Manage());
            statement.setString(4, SCC.getManageName());
            JOptionPane.showMessageDialog(null, "thêm thành công");

            statement.execute();
            
            // câu truy vấn thứ 2 
            // sau khi add xong thì cập nhật status của student thành 1 nghĩa là đã có lớp 
            String sqlUpdate = "update student  inner join studentclass on student.Id_Student = studentclass.Id_Student set student.Status = 1";
            
            // chuẩn bị thực hiện sqlUpdate
            statement = connection.prepareCall(sqlUpdate);
            
            // chạy câu lện truy vẫn
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void addClassList(ClassList classlist) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            
            String sql = "insert into classlist( Id_Manage, ClassName , Comment) values(?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, classlist.getId_Manage());
            statement.setString(2, classlist.getClassName());
            statement.setString(3, classlist.getComment());
            
            
            System.out.println("thêm thành công");
            
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<Student> findForAdmin(String StudentName) {
        List<Student> studentList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "select * from student where StudentName like ?";
            statement = connection.prepareCall(sql);
            
            // truyền %studentname% vào dấu ? 
            // tìm tất cả học sinh có tên bằng với tên nhập vào 
            statement.setString(1, "%" + StudentName + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("StudentName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Email"),
                        resultSet.getString("Account"),
                        resultSet.getString("Password"),
                        resultSet.getInt("Status"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return studentList;
    }

    public static List<ClassStudent> findById_Student(int Id_Student) {
        List<ClassStudent> ClassStudent = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "select * from studentclass where Id_Student = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, Id_Student);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClassStudent cs = new ClassStudent(resultSet.getInt("Id_Class"),
                        resultSet.getInt("Id_Student"),
                        resultSet.getInt("Id_Manage"),
                        resultSet.getString("ManageName"));
                ClassStudent.add(cs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ClassStudent;
    }

    public static List<ClassList> findClass(String ClassName) {
        List<ClassList> classlist = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "select * from classlist where ClassName like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + ClassName + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClassList cl = new ClassList(
                        resultSet.getInt("Id_Class"),
                        resultSet.getInt("Id_Manage"),
                        resultSet.getString("ClassName"),
                        resultSet.getString("Comment"));

                classlist.add(cl);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return classlist;
    }

    public static List<Manage> findForBoss(String Account) {
        List<Manage> manageList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "select * from manage where Account like ? ";

            statement = connection.prepareCall(sql);
            //chuyền % Account % vào dấu ? 
            statement.setString(1, "%" + Account + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Manage manage = new Manage(
                        resultSet.getInt("Id_User"),
                        resultSet.getString("ManageName"),
                        resultSet.getString("Email"),
                        resultSet.getString("Account"),
                        resultSet.getString("Password"));
                manageList.add(manage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return manageList;
    }
}
