/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import static jFrame.DBConnection.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String studentId, name, course, school;
    DefaultTableModel model;
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    public void setStudentDetailsToTable(){
        try{
            Connection con = DBConnection.getConnection();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms?allowPublicKeyRetrieval=true&useSSL=false","root","Korir#001");
            Statement st = con.createStatement();
             
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String studentId = rs.getString("student_id");
                String name = rs.getString("student_name");
                String course = rs.getString("student_course");
                String school = rs.getString("student_school");
                
                Object[] obj = {studentId, name, course, school};
                model = (DefaultTableModel) tblStudentDetails.getModel();
                model.addRow(obj);
                
                
            }
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean addStudent(){
        boolean isAdded = false;
        studentId = txtStudentId.getText();
        name = txtStudentName.getText();
        course = txtComboCourse.getSelectedItem().toString();
        school = txtSchool.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, studentId);
            pst.setString(2, name);
            pst.setString(3, course);
            pst.setString(4, school);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isAdded = true;
            }else{
                isAdded = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isAdded;
    }
    public void clearDetails(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtSchool.setText("");
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tblStudentDetails.getModel();
        model.setRowCount(0);
    }
    
    public boolean updateDetails(){
        boolean isUpdated = false;
        studentId = txtStudentId.getText();
        name = txtStudentName.getText();
        course = txtComboCourse.getSelectedItem().toString();
        school = txtSchool.getText();
        
        
        try{
           Connection con = DBConnection.getConnection();
           String sql = "update student_details set student_name = ?, student_course = ?, student_school = ? where student_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           
           pst.setString(1, name);
           pst.setString(2, course);
           pst.setString(3, school);
           pst.setString(4, studentId);
           
           int rowCount = pst.executeUpdate();
           if(rowCount > 0){
               isUpdated = true;
           }else{
               isUpdated = false;
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return isUpdated;
    }
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId = txtStudentId.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentId);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0){
                isDeleted = true;
            }else{
                isDeleted = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return isDeleted;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtStudentId = new javax.swing.JTextField();
        txtStudentName = new javax.swing.JTextField();
        txtSchool = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtComboCourse = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentDetails = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1300, 780));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("BACK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter student Id");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 159, 140, -1));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter student Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 264, -1, -1));

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter course");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 372, -1, -1));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ENTER school");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 488, -1, -1));

        btnSave.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 602, -1, 42));

        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 196, 272, -1));

        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 301, 272, -1));
        jPanel2.add(txtSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 529, 272, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 525, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 409, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 301, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 196, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 602, -1, 42));

        btnDelete.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 601, -1, 43));

        txtComboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        jPanel2.add(txtComboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 270, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 0, 102));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 60, 50));

        tblStudentDetails.setBackground(new java.awt.Color(255, 0, 102));
        tblStudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Student Id", "Name", "Course", "School"
            }
        ));
        tblStudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudentDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 240));

        jLabel11.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 102));
        jLabel11.setText("Manage students");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 5));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 300, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(addStudent() == true){
            JOptionPane.showMessageDialog(this, "Successfully Added to the Database");
            clearDetails();
            setStudentDetailsToTable();
            clearTable();
        }else{
            JOptionPane.showMessageDialog(this, "Student Addition failed!!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tblStudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentDetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tblStudentDetails.getSelectedRow();
        TableModel model = tblStudentDetails.getModel();
        
        txtStudentId.setText(model.getValueAt(rowNo, 0).toString());
        txtStudentName.setText(model.getValueAt(rowNo, 1).toString());
        txtComboCourse.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        txtSchool.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tblStudentDetailsMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         if(updateDetails() == true){
            JOptionPane.showMessageDialog(this, "Successfully updated the student");
            clearDetails();
            clearTable();
            setStudentDetailsToTable();
            
        }else{
            JOptionPane.showMessageDialog(this, "Book updation failed!!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(deleteStudent() == true){
            JOptionPane.showMessageDialog(this, "Successfully deleted the student");
            clearDetails();
            clearTable();
            setStudentDetailsToTable();
            
        }else{
            JOptionPane.showMessageDialog(this, "Student deletion failed!!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudentDetails;
    private javax.swing.JComboBox<String> txtComboCourse;
    private javax.swing.JTextField txtSchool;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
