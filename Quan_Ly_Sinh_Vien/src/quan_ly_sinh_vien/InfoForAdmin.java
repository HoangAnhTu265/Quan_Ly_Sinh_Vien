package quan_ly_sinh_vien;

import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static quan_ly_sinh_vien.Login_form.getMd5;
//import javax.swing.table.DefaultTableModel;

public final class InfoForAdmin extends javax.swing.JFrame {

    DefaultTableModel TableModel;

    List<Student> studentList = new ArrayList<>();

    public InfoForAdmin() {
        initComponents();

        showStudent();

        TableModel = (DefaultTableModel) tblStudent.getModel();
    }

    public void showStudent() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            
            // tạo DefaultTableModel để lưu trữ dữ liệu của bảng tblStudent
            DefaultTableModel tm = (DefaultTableModel) tblStudent.getModel();
            
            // xóa hết hàng trong bảng tblStudent
            tm.setRowCount(0);
            
            while (rs.next()) {
                //tạo mảng o kiểu object rồi lấy thông tin cần thiết
                Object o[] = {rs.getInt("Id_Student"), rs.getString("StudentName"), rs.getString("Gender"), rs.getString("Email"), rs.getString("Account"), rs.getInt("Status")};
                
                // thêm mảng o vào bảng tm 
                tm.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        FindButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        account = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        re_pass = new javax.swing.JPasswordField();
        AddClass = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Student Name");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Gender");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Email");

        name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        gender.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "khác" }));

        AddButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ResetButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        FindButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        FindButton.setText("Find");
        FindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindButtonActionPerformed(evt);
            }
        });

        LogoutButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        LogoutButton.setText(" Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("Go to student class ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Account");

        account.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("Re-pass");

        pass.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        re_pass.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        AddClass.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AddClass.setText("Go To Add Class");
        AddClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gender, 0, 234, Short.MAX_VALUE)
                            .addComponent(email)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(account)
                            .addComponent(re_pass)
                            .addComponent(pass)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(AddClass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addGap(18, 18, 18)
                        .addComponent(ResetButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(FindButton)
                        .addGap(18, 18, 18)
                        .addComponent(LogoutButton)))
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(re_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton)
                    .addComponent(DeleteButton)
                    .addComponent(FindButton)
                    .addComponent(LogoutButton)
                    .addComponent(AddButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        tblStudent.setAutoCreateRowSorter(true);
        tblStudent.setBackground(new java.awt.Color(255, 153, 102));
        tblStudent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_Student", "Student Name", "Gender", "Email", "Account", "Status"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed

    }//GEN-LAST:event_nameActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        Login_form lf = new Login_form();
        lf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        name.setText("");
        email.setText("");
        gender.setSelectedIndex(0);
        showStudent();
    }//GEN-LAST:event_ResetButtonActionPerformed


    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String StudentName = name.getText();
        String Gender = gender.getSelectedItem().toString();
        String Email = email.getText();
        String Account = account.getText();
        String Password = String.valueOf(pass.getPassword());
        String repass = String.valueOf(re_pass.getPassword());
        String pass_nhap_maHoa;
        pass_nhap_maHoa = getMd5(Password, Password);
        Connection connection = null;
        if (!(StudentName.length() > 0)) {
            JOptionPane.showMessageDialog(null, "tên học sinh không được rỗng");
            return;
        }
        if (!(Email.contains("@"))) {
            JOptionPane.showMessageDialog(null, "sai kiểu gmail");
            return;
        }
        if (Email.length() == 0) {
            JOptionPane.showMessageDialog(null, "gamil không được trống");
            return;
        }
        if (!(account.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "tài khoản không được trống");
            return;
        }

        if (account.equals(account)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
                Statement stateMent = con.createStatement();
                String sql = "SELECT Account from student WHERE Account ='" + Account + "'";
                System.out.println(sql);
                ResultSet rs = stateMent.executeQuery(sql);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại!");
                    return;
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }

        if (!(pass.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "mật khẩu không được trống");
            return;
        }
        if (repass.equals(Password)) {
            showStudent();
        } else {
            JOptionPane.showMessageDialog(null, "mật khẩu không khớp");
            return;
        }
        
        Student std = new Student(StudentName, Gender, Email, Account, Password);
        Modify.addStudent(std);
        
        showStudent();
    }//GEN-LAST:event_AddButtonActionPerformed

    public static void deleteStudent(String Id_Student) {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            // tạo statement 
            Statement stateMent = connection.createStatement();

            //xóa thằng học sinh mà có id bằng cái thằng học sinh mình vừa chọn
            stateMent.executeUpdate("delete from student where Id_Student='" + Id_Student + "'");

        } catch (SQLException ex) {
            Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int row = tblStudent.getSelectedRow();

        // chứa lựa chọn , nếu bấm yes thì option == 0
        int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this student?");

        if (option == 0) {
            //lúc này id được chuyển thành kiểu string vì có .toString()
            //lấy ID của hàng mình vừa chọn , cột đầu tiên
            String id = (tblStudent.getModel().getValueAt(row, 0).toString());
            InfoForAdmin.deleteStudent(String.valueOf(id));
            showStudent();
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void FindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindButtonActionPerformed
        String input = JOptionPane.showInputDialog(this, "Enter Student name to search");

        if (input != null && input.length() > 0) {

            //gọi hàm findforadmin đã truyền tham số rồi gán vào studentList 
            studentList = Modify.findForAdmin(input);

            //xóa hết hàng trong bảng tblstudent
            TableModel.setRowCount(0);

            // biến student sẽ lặp qua mảng studentList 
            studentList.forEach((student) -> {
                // lấy các giá trị của các cột rồi add vào bảng 
                // tạo mảng kiểu object mới rồi add những thông tin vừa lấy được vào 
                // mỗi lần get xong thì nó sẽ + 1 lên hàng mới 
                TableModel.addRow(new Object[]{tblStudent.getRowCount() + 1,
                    student.getStudentName(),
                    student.getGender(),
                    student.getEmail(),
                    student.getStatus(),
                    student.getAccount(),
                    student.getPassword()});
            });
        }
    }//GEN-LAST:event_FindButtonActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed

    }//GEN-LAST:event_emailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StudentClass stdCls = new StudentClass();
        stdCls.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStudentMouseClicked

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void AddClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClassActionPerformed
        AddClass ac = new AddClass();
        ac.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddClassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InfoForAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton AddClass;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton FindButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTextField account;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField re_pass;
    private javax.swing.JTable tblStudent;
    // End of variables declaration//GEN-END:variables
}
