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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class AddClass extends javax.swing.JFrame {

    DefaultTableModel TableModel;

    List<ClassList> classList = new ArrayList<>();

    /**
     * Creates new form AddClass
     */
    public AddClass() {
        initComponents();

        TableModel = (DefaultTableModel) tblManage.getModel();

        showClassList();
        
        fill_IdManage();
    }

    public void showClassList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from classlist");
            ResultSet rs = ps.executeQuery();
            
            // tạo DefaultTableModel để lưu trữ dữ liệu của bảng tblManage
            DefaultTableModel tm = (DefaultTableModel) tblManage.getModel();
            
            // xóa hết hàng trong bảng tblclass
            tm.setRowCount(0);
            while (rs.next()) {
                //tạo mảng o kiểu object rồi lấy thông tin cần thiết
                Object o[] = {rs.getInt("Id_Class"), rs.getInt("Id_Manage"), rs.getString("ClassName"), rs.getString("Comment")};
                
                // thêm mảng o vào bảng tm 
                tm.addRow(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InfoForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fill_IdManage() {
        try {
            //tải động trình kéo dài 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            PreparedStatement pst = null;
            String sql = "select Id_manage from manage";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Id_manage");
                id_Manage.addItem(name);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        classname = new javax.swing.JTextField();
        id_Manage = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        FindButton = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comment = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManage = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Class Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Id_Manage");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Class Name");

        classname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        classname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classnameActionPerformed(evt);
            }
        });

        id_Manage.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

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

        back.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Comment");

        comment.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_Manage, 0, 234, Short.MAX_VALUE)
                            .addComponent(classname)
                            .addComponent(comment)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addGap(18, 18, 18)
                        .addComponent(ResetButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(FindButton)
                        .addGap(18, 18, 18)
                        .addComponent(back)))
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_Manage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton)
                    .addComponent(DeleteButton)
                    .addComponent(FindButton)
                    .addComponent(back)
                    .addComponent(AddButton))
                .addGap(63, 63, 63))
        );

        tblManage.setBackground(new java.awt.Color(255, 153, 102));
        tblManage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblManage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_Class", "Id_Manage", "Class Name", "Comment"
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classnameActionPerformed

    }//GEN-LAST:event_classnameActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String Id_Manage = id_Manage.getSelectedItem().toString();
        String ClassName = classname.getText();
        String Comment = comment.getText();
        

        if (classname.equals(classname)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
                Statement stateMent = con.createStatement();
                String sql = "SELECT ClassName from classlist WHERE ClassName ='" + ClassName + "'";
                System.out.println(sql);
                ResultSet rs = stateMent.executeQuery(sql);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Tên lớp đã tồn tại!");
                    return;
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AddClass.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
          
            System.out.println(Id_Manage);
            
            //TRUYỀN tham số vào constructor
            // đổi Id_Manage từ String thành integer
        ClassList classlist = new ClassList(Integer.parseInt(Id_Manage), ClassName, Comment);
        
        Modify.addClassList(classlist);
        
        showClassList();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        classname.setText("");
        id_Manage.setSelectedIndex(0);
        comment.setText("");
        showClassList();
    }//GEN-LAST:event_ResetButtonActionPerformed
    public static void deleteClass(String Id_Class) {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhviendemo", "root", "");
            
            // tạo statement
            Statement stateMent = connection.createStatement();
                       
            // xóa lớp có id bằng cái thằng mình vừa chọn
            stateMent.executeUpdate("delete from classlist where Id_Class = '" + Id_Class + "' ");
            
            String sql = "select * from student";
            ResultSet rs = stateMent.executeQuery(sql);
            while(!rs.next()) {
                String sqlUpdate = "update student inner join studentclass on student.Id_Student = studentclass.Id_Student set student.Status = 0 where Id_StudentClass = ' + Id_StudentClass + '";
                stateMent.executeQuery(sqlUpdate);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int row = tblManage.getSelectedRow();
        int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this class ?");

        if (option == 0) {
            //lúc này id được chuyển thành kiểu string vì có .toString()
            String id = (tblManage.getModel().getValueAt(row, 0).toString());
            AddClass.deleteClass(String.valueOf(id));
            showClassList();
        }
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void FindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindButtonActionPerformed
        String input = JOptionPane.showInputDialog(this, "Enter class name to search");

        if (input != null && input.length() > 0) {
            classList = Modify.findClass(input);

            TableModel.setRowCount(0);

            classList.forEach((classlist) -> {
                TableModel.addRow(new Object[]{tblManage.getRowCount() + 1, classlist.getId_Manage(), classlist.getClassName(),
                    classlist.getComment()});
            });
        }
        //        else {
        //            showStudent();
        //        }
    }//GEN-LAST:event_FindButtonActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        InfoForAdmin lf = new InfoForAdmin();
        lf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void tblManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblManageMouseClicked

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
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton FindButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton back;
    private javax.swing.JTextField classname;
    private javax.swing.JTextField comment;
    private javax.swing.JComboBox<String> id_Manage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManage;
    // End of variables declaration//GEN-END:variables
}
