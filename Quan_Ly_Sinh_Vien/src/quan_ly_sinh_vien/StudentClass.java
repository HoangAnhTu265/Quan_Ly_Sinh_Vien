/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quan_ly_sinh_vien;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public final class StudentClass extends javax.swing.JFrame {

    //lưu trữ dữ liêu từ bảng
    DefaultTableModel TableModel;

    DefaultTableModel ClassList;

    DefaultTableModel CLASS;

    PreparedStatement pst;

    ResultSet rs;

    List<Student> studentList = new ArrayList<>();

    List<ClassStudent> ClassStudent = new ArrayList<>();

    List<ClassList> classList = new ArrayList<>();

    /**
     * Creates new form StudentClass
     */
    public StudentClass() {
        initComponents();

        showStudentClass();

        showStudent();

        showClassList();

        TableModel = (DefaultTableModel) tblClass.getModel();

        ClassList = (DefaultTableModel) tblClassList.getModel();

        CLASS = (DefaultTableModel) tblStudent.getModel();
    }

    public void showStudentClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            String sql = "Select studentclass.Id_StudentClass, studentclass.Id_Class , studentclass.Id_Student , manage.Id_Manage , manage.ManageName "
                    + "From manage "
                    + "Inner join studentclass "
                    + "On manage. Id_Manage = studentclass. Id_Manage";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //rs chứa kết quả sau khi thực hiện câu lệnh truy vấn
            // tạo DefaultTableModel để lưu trữ dữ liệu của bảng tblclass
            DefaultTableModel tm = (DefaultTableModel) tblClass.getModel();

            // xóa hết hàng trong bảng tblclass
            tm.setRowCount(0);

            while (rs.next()) {

                //tạo mảng o kiểu object rồi lấy thông tin cần thiết
                Object o[] = {rs.getInt("Id_StudentClass"), rs.getInt("Id_Class"), rs.getString("Id_Student"), rs.getInt("Id_Manage"), rs.getString("ManageName")};

                // thêm mảng o vào bảng tm 
                tm.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showClassList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            PreparedStatement ps = con.prepareStatement("select classlist.Id_Class , manage.Id_Manage , manage.ManageName , "
                    + "classlist.ClassName FROM manage INNER JOIN classlist ON manage.Id_Manage = classlist.Id_Manage");
            ResultSet rs = ps.executeQuery();

            // tạo DefaultTableModel để lưu trữ dữ liệu của bảng tblClassList
            DefaultTableModel tm = (DefaultTableModel) tblClassList.getModel();

            // xóa hết hàng trong bảng tblClassList
            tm.setRowCount(0);
            while (rs.next()) {

                //tạo mảng o kiểu object rồi lấy thông tin cần thiết
                Object o[] = {rs.getInt("Id_Class"), rs.getInt("Id_Manage"), rs.getString("ManageName"), rs.getString("ClassName")};

                // thêm mảng o vào bảng tm 
                tm.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showStudent() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();

            //ép kiểu defaultTableModel cho tblStudent
            DefaultTableModel tm = (DefaultTableModel) tblStudent.getModel();

            // xóa hết hàng trong bảng tblStudent
            tm.setRowCount(0);

            while (rs.next()) {
                //tạo mảng o kiểu object rồi lấy thông tin cần thiết

                Object o[] = {rs.getInt("Id_Student"), rs.getString("StudentName"), rs.getString("Gender"), rs.getString("Account"), rs.getInt("Status")};

                // thêm mảng o vào bảng tm 
                tm.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClass = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        FindButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClassList = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id_Student = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        id_Class = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        manage_name = new javax.swing.JTextField();
        id_manage = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStudent.setBackground(new java.awt.Color(255, 153, 102));
        tblStudent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_Student", "Student Name", "Gender", "Account", "Status"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        tblClass.setBackground(new java.awt.Color(255, 153, 102));
        tblClass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_StudentClass", "Id_Class", "Id_Student", "Id_Manage", "Manage Name"
            }
        ));
        tblClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClass);

        BackButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        FindButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        FindButton.setText("Find");
        FindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        tblClassList.setBackground(new java.awt.Color(255, 153, 102));
        tblClassList.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblClassList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_Class", "Id_Manage", "Manage Name", "Class Name"
            }
        ));
        tblClassList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblClassList);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Class List");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Student");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Student Class");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Id_Student");

        id_Student.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setText("Id_Class");

        id_Class.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        id_Class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_ClassActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Id_manage");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("Manage Name");

        manage_name.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        manage_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_nameActionPerformed(evt);
            }
        });

        id_manage.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        id_manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_manageActionPerformed(evt);
            }
        });

        status.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("Status");

        Reset.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel3)
                        .addGap(547, 547, 547)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(74, 74, 74)
                                    .addComponent(id_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1))
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(id_Student)
                                            .addComponent(manage_name)
                                            .addComponent(id_manage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FindButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(Reset)
                        .addGap(18, 18, 18)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_Class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_manage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manage_name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(FindButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        InfoForAdmin stdInfo = new InfoForAdmin();
        stdInfo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        int Id_Student = Integer.parseInt(id_Student.getText());
        int Id_Class = Integer.parseInt(id_Class.getText());
        int Id_Manage = Integer.parseInt(id_manage.getText().toString());
        String ManageName = manage_name.getText();
        if (status.getText().equals("1")) {
            JOptionPane.showMessageDialog(null, "đã có lớp");
            return;
        }
        StudentClassContruc SCC = new StudentClassContruc(Id_Class, Id_Student, Id_Manage, ManageName);

        Modify.addClass(SCC);

        status.setText("1");

        showStudent();
        //là bảng chứa xem quan hệ của manage với học sinh cũng 
        //như chứa quan hệ của manage với class
        showStudentClass();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void FindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindButtonActionPerformed
        String input = JOptionPane.showInputDialog(this, "Enter ID Student to search");
        
        if (input != null && input.length() > 0) {
            //gọi hàm findById_Student đã truyền tham số rồi gán vào ClassStudent 
            ClassStudent = Modify.findById_Student(Integer.valueOf(input));

            //xóa hết hàng trong bảng tblstudentclass
            TableModel.setRowCount(0);

            // biến student sẽ lặp qua mảng studentList 
            ClassStudent.forEach((studentclass) -> {
                // lấy các giá trị của các cột rồi add vào bảng 
                // tạo mảng kiểu object mới rồi add những thông tin vừa lấy được vào 
                // mỗi lần get xong thì nó sẽ + 1 lên hàng mới 
                TableModel.addRow(new Object[]{tblClass.getRowCount() + 1,
                    studentclass.getId_Class(), studentclass.getId_Student(), studentclass.getId_Manage(), studentclass.getManageName()});
            });
        }
    }//GEN-LAST:event_FindButtonActionPerformed

    public static void deleteClass(String Id_StudentClass) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");

            // tạo statement
            Statement stateMent = connection.createStatement();

            // update status của thằng mình xóa từ 1 thành 0
            stateMent.executeUpdate("update student inner join studentclass on student.Id_Student = studentclass.Id_Student set student.Status = 0 where Id_StudentClass = '" + Id_StudentClass + "'");

            // xóa thằng học sinh có id bằng cái thằng mình vừa chọn
            stateMent.executeUpdate("delete from studentclass where Id_StudentClass = '" + Id_StudentClass + "' ");

        } catch (SQLException ex) {
            Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // lấy thứ tự của cái dòng đang chọn
        int row = tblClass.getSelectedRow();

        int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this student?");
        // chứa lựa chọn , nếu bấm yes thì option == 0
        if (option == 0) {
            String id = (tblClass.getModel().getValueAt(row, 0).toString());
            StudentClass.deleteClass(String.valueOf(id));
            showStudent();
            showStudentClass();
        }

    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void tblClassListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassListMouseClicked

        // lấy thứ tự của cái hàng đang được chọn 
        int index = tblClassList.getSelectedRow();

        // lấy thông tin của bảng tblclasslist 
        TableModel model = tblClassList.getModel();

        // lấy giá trị của hàng đang chọn cột thứ 1
        String Id_Manage = model.getValueAt(tblClassList.getSelectedRow(), 1).toString();

        // set Id_manage vào cái ô id_manage
        id_manage.setText(Id_Manage);

        // lấy giá trị hàng đang chọn ô thứ 0 
        String Id_Class = model.getValueAt(tblClassList.getSelectedRow(), 0).toString();
        id_Class.setText(Id_Class);

        // lấy giá trị hàng đang chọn cột thứ 2
        String ManageName = model.getValueAt(tblClassList.getSelectedRow(), 2).toString();
        manage_name.setText(ManageName);
    }//GEN-LAST:event_tblClassListMouseClicked

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // lấy thứ tự của cái hàng đang được chọn 
        int index = tblStudent.getSelectedRow();

        // lấy thông tin của bảng tblStudent 
        TableModel model = tblStudent.getModel();

        // lấy giá trị hàng đang chọn ô thứ 0 
        String Id_Student = model.getValueAt(tblStudent.getSelectedRow(), 0).toString();

        // set Id_Student vào cái ô id_Student
        id_Student.setText(Id_Student);

        // lấy giá trị hàng đang chọn ô thứ 4
        String Status = model.getValueAt(tblStudent.getSelectedRow(), 4).toString();
            
        // set Status vào cái ô status
        status.setText(Status);


    }//GEN-LAST:event_tblStudentMouseClicked

    private void id_ClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_ClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_ClassActionPerformed

    private void manage_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_nameActionPerformed
        // TODO add your handling code here:
        String.valueOf(WIDTH)
    }//GEN-LAST:event_manage_nameActionPerformed

    private void id_manageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_manageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_manageActionPerformed

    private void tblClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblClassMouseClicked

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        id_Class.setText("");
        id_Student.setText("");
        id_manage.setText("");
        manage_name.setText("");
        status.setText("");
        showStudentClass();
    }//GEN-LAST:event_ResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton FindButton;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField id_Class;
    private javax.swing.JTextField id_Student;
    private javax.swing.JTextField id_manage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField manage_name;
    private javax.swing.JTextField status;
    private javax.swing.JTable tblClass;
    private javax.swing.JTable tblClassList;
    private javax.swing.JTable tblStudent;
    // End of variables declaration//GEN-END:variables
}
