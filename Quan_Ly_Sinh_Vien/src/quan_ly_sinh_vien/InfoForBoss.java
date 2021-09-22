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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static quan_ly_sinh_vien.Login_form.getMd5;

/**
 *
 * @author Admin
 */
public class InfoForBoss extends javax.swing.JFrame {

    DefaultTableModel TableModel;

    List<Manage> manageList = new ArrayList<>();

    PreparedStatement std;
    Connection con;

    public InfoForBoss() {
        initComponents();

        TableModel = (DefaultTableModel) tblManage.getModel();

        try {
            con = ketNoi();
        } catch (Exception e) {
            System.out.println(e);
        }

        showUser();
    }

    public Connection ketNoi() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
        return con;
    }

    public void showUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from manage");
            ResultSet rs = ps.executeQuery();

            // tạo DefaultTableModel để lưu trữ dữ liệu của bảng tblManage
            DefaultTableModel tm = (DefaultTableModel) tblManage.getModel();

            // xóa hết hàng trong bảng tblManage
            tm.setRowCount(0);
            while (rs.next()) {
                //tạo mảng o kiểu object rồi lấy thông tin cần thiết
                Object o[] = {rs.getInt("Id_Manage"), rs.getInt("Id_User"), rs.getString("ManageName"), rs.getString("Email"), rs.getString("Account"), rs.getString("Password")};

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        account = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        FindButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        rePass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        manage_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManage = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Manage Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Account");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Password");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Re-Pass");

        account.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountActionPerformed(evt);
            }
        });

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

        rePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rePassActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Email");

        email.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        manage_name.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        manage_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_nameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Manage Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(rePass, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(manage_name)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addGap(27, 27, 27)
                        .addComponent(ResetButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(FindButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LogoutButton)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(manage_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(account)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(rePass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(ResetButton)
                    .addComponent(DeleteButton)
                    .addComponent(FindButton)
                    .addComponent(LogoutButton))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tblManage.setBackground(new java.awt.Color(255, 153, 102));
        tblManage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblManage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_Manage", "Id_User", "Manage Name", "Email", "Account", "Password"
            }
        ));
        tblManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblManage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 227, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountActionPerformed

    }//GEN-LAST:event_accountActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try {
            int Id_User = 9;
            String ManageName = manage_name.getText().trim();
            String Account = account.getText().trim();
            String Password = String.valueOf(pass.getPassword()).trim();
            String Email = email.getText().trim();
            String repass = String.valueOf(rePass.getPassword()).trim();
            String pass_nhap_maHoa;
            pass_nhap_maHoa = getMd5(Password, Password).trim();
            Statement stmt;

            stmt = con.createStatement();
            if (!(ManageName.length() > 0)) {
                JOptionPane.showMessageDialog(null, "tên manage không được rỗng");
                return;
            }

            if (!(Account.length() > 0)) {
                JOptionPane.showMessageDialog(null, "tài khoản không được rỗng");
                return;
            }
            if (Account.equals(Account)) {
                Statement stateMent = con.createStatement();
                String sql = "SELECT Account from manage WHERE Account ='" + Account + "'";
                ResultSet rs = stateMent.executeQuery(sql);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại,hãy chọn một tên khác!");
                    return;
                }
            }

            if (repass.equals(Password)) {
                showUser();
            } else {
                JOptionPane.showMessageDialog(null, "mật khẩu không khớp");
                return;
            }

            if (!repass.equals(Password)) {
                JOptionPane.showMessageDialog(null, "sai mật khẩu");
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

            if (account.equals(account)) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
                    Statement stateMent = con.createStatement();
                    String sql = "SELECT Account from manage WHERE Account ='" + Account + "'";
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

            int executeUpdate = stmt.executeUpdate("insert into sinhviendemo.manage(ManageName, Id_User, Email, Account, Password) values('" + ManageName + "','" + Id_User + "','" + Email + "','" + Account + "' ,'" + getMd5(Password, Password) + "')");
            showUser();
        } catch (SQLException ex) {
            Logger.getLogger(InfoForBoss.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        account.setText("");
        pass.setText("");
        rePass.setText("");
        email.setText("");
        manage_name.setText("");
        showUser();
    }//GEN-LAST:event_ResetButtonActionPerformed

    public static void deleteAdmin(String Id_Manage) {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            // tạo statement
            Statement stateMent = connection.createStatement();

            //xóa thằng học sinh mà có id bằng cái thằng học sinh mình vừa chọn
            stateMent.executeUpdate("delete from manage where Id_Manage='" + Id_Manage + "'");

        } catch (SQLException ex) {
            Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int row = tblManage.getSelectedRow();
        int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this manage?");

        if (option == 0) {
            //lúc này id được chuyển thành kiểu string vì có .toString()
            String id = (tblManage.getModel().getValueAt(row, 0).toString());
            InfoForBoss.deleteAdmin(String.valueOf(id));
            showUser();
        }

    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void FindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindButtonActionPerformed
        String input = JOptionPane.showInputDialog(this, "Enter Account to search");
        if (input != null && input.length() > 0) {
            manageList = Modify.findForBoss(input);

            TableModel.setRowCount(0);

            manageList.forEach((manage) -> {
                TableModel.addRow(new Object[]{tblManage.getRowCount() + 1, manage.getId_User(),
                    manage.getManageName(), manage.getEmail(), manage.getAccount(),
                    manage.getPassword()});
            });
        } 
    }//GEN-LAST:event_FindButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        Login_form lf = new Login_form();
        lf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void tblManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManageMouseClicked
    }//GEN-LAST:event_tblManageMouseClicked

    private void rePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rePassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rePassActionPerformed

    private void manage_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manage_nameActionPerformed

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
            java.util.logging.Logger.getLogger(InfoForBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoForBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoForBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoForBoss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoForBoss().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton FindButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTextField account;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField manage_name;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField rePass;
    private javax.swing.JTable tblManage;
    // End of variables declaration//GEN-END:variables
}
