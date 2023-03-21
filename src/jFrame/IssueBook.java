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
import java.util.Date;

/**
 *
 * @author HP
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    public void getBookDetails() {
        String bookId = jtxtBookId.getText();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setString(1, bookId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lblBookId.setText(rs.getString("book_id"));
                lblBookName.setText(rs.getString("name"));
                lblAuthor.setText(rs.getString("author"));
                lblQuantity.setText(rs.getString("quantity"));
            } else {
                lblBookError.setText("Invalid Book ID!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentDetails() {
        String studentId = jtxtStudentId.getText();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setString(1, studentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lblStudentId.setText(rs.getString("student_id"));
                lblName.setText(rs.getString("student_name"));
                lblCourse.setText(rs.getString("student_course"));
                lblSchool.setText(rs.getString("student_school"));
            } else {
                lblStudentError.setText("Invalid Student ID!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean issueBook() {
        boolean isIssued = false;
        String studentId = lblStudentId.getText();
        String studentName = lblName.getText();

        String bookId = lblBookId.getText();
        String bookName = lblBookName.getText();

        Date uIssueDate = issueDate.getDatoFecha();
        Date uDueDate = dueDate.getDatoFecha();

        Long l1 = uIssueDate.getTime();
        Long l2 = uDueDate.getTime();

        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id, book_name, student_id, student_name, issue_date, due_date, status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "Pending");

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isIssued;

    }

    public void updateBookCount() {
        String bookId = lblBookId.getText();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, bookId);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book count updated successfully");
                int initialCount = Integer.parseInt(lblQuantity.getText());
                lblQuantity.setText(Integer.toString(initialCount - 1));
            } else {
                JOptionPane.showMessageDialog(this, "Cant't update the book");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAlreadyIssued() {
        boolean isAlreadyIssued = false;
        String bookId = lblBookId.getText();
        String studentId = lblStudentId.getText();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, bookId);
            pst.setString(2, studentId);
            pst.setString(3, "pending");

            ResultSet rs  = pst.executeQuery();
            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSCalendarBeanInfo1 = new rojeru_san.componentes.RSCalendarBeanInfo();
        rSButtonPaneBeanInfo1 = new rojerusan.RSButtonPaneBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblBookId = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblBookError = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblStudentId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCourse = new javax.swing.JLabel();
        lblSchool = new javax.swing.JLabel();
        lblStudentError = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        issueDate = new rojeru_san.componentes.RSDateChooser();
        jtxtStudentId = new app.bolivia.swing.JCTextField();
        jtxtBookId = new app.bolivia.swing.JCTextField();
        dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel31 = new javax.swing.JLabel();
        btnIssueBook = new rojeru_san.complementos.RSButtonHover();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Back");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 78, -1, 74));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 111, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 178, -1, -1));

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Id :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 264, -1, -1));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Name :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 361, -1, -1));

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Author :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 452, -1, -1));

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 546, -1, -1));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 255, -1, -1));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 361, -1, -1));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 452, -1, -1));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 546, -1, -1));
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 255, 85, -1));

        lblBookId.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jPanel2.add(lblBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 140, 35));

        lblBookName.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jPanel2.add(lblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 130, 50));

        lblAuthor.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jPanel2.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 140, 50));

        lblQuantity.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jPanel2.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 120, 50));

        lblBookError.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        lblBookError.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(lblBookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 220, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 780));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 72, -1, 74));

        jLabel16.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("student Details");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 111, -1, -1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 178, -1, -1));

        jLabel17.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("student Id :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 255, -1, -1));

        jLabel18.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("student Name :");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 345, -1, -1));

        jLabel19.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("course :");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 436, -1, -1));

        jLabel20.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("school :");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 530, -1, -1));
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 255, -1, -1));
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 345, -1, -1));
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 436, -1, -1));
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 530, -1, -1));
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 100, -1));

        lblStudentId.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jPanel5.add(lblStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, 40));

        lblName.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jPanel5.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 120, 40));

        lblCourse.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jPanel5.add(lblCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 120, 40));

        lblSchool.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jPanel5.add(lblSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 110, 40));

        lblStudentError.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        lblStudentError.setForeground(new java.awt.Color(255, 0, 51));
        jPanel5.add(lblStudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 240, 70));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 0, 354, 780));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1304, 269, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons (1)/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, -1, -1));

        jLabel27.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setText("ISSUE BOOK");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 0, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 260, 10));

        jLabel28.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 102));
        jLabel28.setText("Book Id");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        jLabel29.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 102));
        jLabel29.setText("Student Id");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        jLabel30.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 102));
        jLabel30.setText("Issue Date");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, -1, -1));

        issueDate.setColorBackground(new java.awt.Color(255, 0, 51));
        issueDate.setPlaceholder("Select Issue Date");
        jPanel1.add(issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, -1, -1));

        jtxtStudentId.setPlaceholder("Enter Student Id");
        jtxtStudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtStudentIdFocusLost(evt);
            }
        });
        jPanel1.add(jtxtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, -1, -1));

        jtxtBookId.setPlaceholder("Enter Book Id");
        jtxtBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtBookIdFocusLost(evt);
            }
        });
        jPanel1.add(jtxtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, -1, -1));

        dueDate.setColorBackground(new java.awt.Color(255, 0, 51));
        dueDate.setPlaceholder("Select Due Date");
        jPanel1.add(dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, -1, -1));

        jLabel31.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 51));
        jLabel31.setText("Due Date");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, -1, -1));

        btnIssueBook.setBackground(new java.awt.Color(255, 0, 51));
        btnIssueBook.setText("ISSUE BOOK");
        btnIssueBook.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        btnIssueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueBookActionPerformed(evt);
            }
        });
        jPanel1.add(btnIssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 560, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 51));
        jLabel32.setText("X");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1350, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jtxtBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtBookIdFocusLost
        // TODO add your handling code here:
        if (!jtxtBookId.getText().equals("")) {
            getBookDetails();
        }

    }//GEN-LAST:event_jtxtBookIdFocusLost

    private void jtxtStudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtStudentIdFocusLost
        // TODO add your handling code here:
        if (!jtxtStudentId.getText().equals("")) {
            getStudentDetails();

        }
    }//GEN-LAST:event_jtxtStudentIdFocusLost

    private void btnIssueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueBookActionPerformed
        // TODO add your handling code here:
        if (isAlreadyIssued() == false) {
            if (issueBook() == true) {
                JOptionPane.showMessageDialog(this, "The book is issued successfully");
                updateBookCount();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Issue the book");
            }
        } else {
            JOptionPane.showMessageDialog(this, "The book is already issued");
        }

    }//GEN-LAST:event_btnIssueBookActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btnIssueBook;
    private rojeru_san.componentes.RSDateChooser dueDate;
    private rojeru_san.componentes.RSDateChooser issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private app.bolivia.swing.JCTextField jtxtBookId;
    private app.bolivia.swing.JCTextField jtxtStudentId;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookError;
    private javax.swing.JLabel lblBookId;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSchool;
    private javax.swing.JLabel lblStudentError;
    private javax.swing.JLabel lblStudentId;
    private rojerusan.RSButtonPaneBeanInfo rSButtonPaneBeanInfo1;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    // End of variables declaration//GEN-END:variables
}
