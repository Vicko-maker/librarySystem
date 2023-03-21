/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author HP
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0, 0, 0);
    Color mouseExitColor = new Color(51, 51, 51);

    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDataToCards();
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select book_name, count(*) as issue_count from issue_book_details group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
            }
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
  

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details", barDataset, true, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
        piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }

    public void setStudentDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms?allowPublicKeyRetrieval=true&useSSL=false", "root", "Korir#001");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from student_details");

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String name = rs.getString("student_name");
                String course = rs.getString("student_course");
                String school = rs.getString("student_school");

                Object[] obj = {studentId, name, course, school};
                DefaultTableModel model = (DefaultTableModel) tblStudentDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBookDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms?allowPublicKeyRetrieval=true&useSSL=false", "root", "Korir#001");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from book_details");

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("name");
                String author = rs.getString("author");
                String quantity = rs.getString("quantity");

                Object[] obj = {bookId, bookName, author, quantity};
                DefaultTableModel model = (DefaultTableModel) tblBookDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataToCards() {
        Statement st = null;
        ResultSet rs = null;

        long l1 = System.currentTimeMillis();
        java.sql.Date todaysDate = new java.sql.Date(l1);

        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from book_details");
            rs.last();
            lblBooks.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from student_details");
            rs.last();
            lblStudents.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from issue_book_details");
            rs.last();
            lblIssuedBooks.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status = '"+"pending"+"'");
            rs.last();
            lblDefaulterList.setText(Integer.toString(rs.getRow()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblBooks = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblIssuedBooks = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lblDefaulterList = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lblStudents = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentDetails = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookDetails = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 822));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1300, 780));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 255));
        jPanel7.setMinimumSize(new java.awt.Dimension(1300, 54));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 6, -1, 48));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Library Management System");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 19, -1, -1));

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome, Admin");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 0, 51));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Home Page");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 257, -1));

        jLabel10.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LMS Dashboard");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 98, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 89, -1, -1));

        jLabel12.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Features");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 146, -1, -1));

        lbl1.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Manage Books");
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl1MouseExited(evt);
            }
        });
        jPanel6.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 191, -1, -1));

        lbl2.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("Manage Students");
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl2MouseExited(evt);
            }
        });
        jPanel6.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        lbl3.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setText("Issue Books");
        lbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl3MouseExited(evt);
            }
        });
        jPanel6.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        lbl4.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setText("Return Book");
        lbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl4MouseExited(evt);
            }
        });
        jPanel6.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        lbl5.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 255, 255));
        lbl5.setText("View Records");
        lbl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl5MouseExited(evt);
            }
        });
        jPanel6.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        lbl6.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl6.setForeground(new java.awt.Color(255, 255, 255));
        lbl6.setText("View Issued Books");
        lbl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl6MouseExited(evt);
            }
        });
        jPanel6.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        lbl7.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl7.setForeground(new java.awt.Color(255, 255, 255));
        lbl7.setText("Defaulter List");
        lbl7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl7MouseExited(evt);
            }
        });
        jPanel6.add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, -1, -1));

        lbl8.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        lbl8.setForeground(new java.awt.Color(255, 255, 255));
        lbl8.setText("Logout");
        lbl8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl8MouseExited(evt);
            }
        });
        jPanel6.add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 191, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, -1, 760));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 102)));
        jPanel10.setPreferredSize(new java.awt.Dimension(260, 140));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblBooks.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lblBooks.setText("10");
        jPanel10.add(lblBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 41, 182, 95));

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 102)));
        jPanel11.setPreferredSize(new java.awt.Dimension(260, 140));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        lblIssuedBooks.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lblIssuedBooks.setText("10");
        jPanel11.add(lblIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 41, 182, 95));

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        jPanel12.setPreferredSize(new java.awt.Dimension(260, 140));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblDefaulterList.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lblDefaulterList.setText("10");
        jPanel12.add(lblDefaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 41, 182, 95));

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        jPanel13.setPreferredSize(new java.awt.Dimension(260, 140));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        lblStudents.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lblStudents.setText("10");
        jPanel13.add(lblStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 41, 182, 95));

        jLabel38.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel38.setText("NO OF BOOKS");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel39.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel39.setText("DEFAULTER LIST");
        jPanel9.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jLabel40.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel40.setText("NO OF STUDENTS");
        jPanel9.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        tblStudentDetails.setBackground(new java.awt.Color(0, 102, 255));
        tblStudentDetails.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        tblStudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "School"
            }
        ));
        jScrollPane1.setViewportView(tblStudentDetails);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 492, 170));

        tblBookDetails.setBackground(new java.awt.Color(255, 0, 51));
        tblBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBookDetails);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 492, 150));

        jLabel41.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel41.setText("Student Details");
        jPanel9.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 179, -1, -1));

        jLabel42.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel42.setText("Book Details");
        jPanel9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel9.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 410, 340));

        jLabel29.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel29.setText("ISSUED BOOKS");
        jPanel9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 1070, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseClicked
        // TODO add your handling code here:
        ManageBooks books = new ManageBooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl1MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void lbl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseEntered
        // TODO add your handling code here:
        lbl1.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl1MouseEntered

    private void lbl1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseExited
        // TODO add your handling code here:
        lbl1.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl1MouseExited

    private void lbl2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseEntered
        // TODO add your handling code here:
        lbl2.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl2MouseEntered

    private void lbl3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseExited
        // TODO add your handling code here:
        lbl3.setBackground(mouseExitColor);

    }//GEN-LAST:event_lbl3MouseExited

    private void lbl2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseExited
        // TODO add your handling code here:
        lbl2.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl2MouseExited

    private void lbl3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseEntered
        // TODO add your handling code here:
        lbl3.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl3MouseEntered

    private void lbl4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseEntered
        // TODO add your handling code here:
        lbl4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl4MouseEntered

    private void lbl4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseExited
        // TODO add your handling code here:
        lbl4.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl4MouseExited

    private void lbl5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5MouseEntered
        // TODO add your handling code here:
        lbl5.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl5MouseEntered

    private void lbl5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5MouseExited
        // TODO add your handling code here:
        lbl5.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl5MouseExited

    private void lbl6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl6MouseEntered
        // TODO add your handling code here:
        lbl6.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl6MouseEntered

    private void lbl6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl6MouseExited
        // TODO add your handling code here:
        lbl6.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl6MouseExited

    private void lbl7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl7MouseEntered
        // TODO add your handling code here:
        lbl7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl7MouseEntered

    private void lbl7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl7MouseExited
        // TODO add your handling code here:
        lbl7.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl7MouseExited

    private void lbl8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl8MouseEntered
        // TODO add your handling code here:
        lbl8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl8MouseEntered

    private void lbl8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl8MouseExited
        // TODO add your handling code here:
        lbl8.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl8MouseExited

    private void lbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseClicked
        // TODO add your handling code here:
        ManageStudents students = new ManageStudents();
        students.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl2MouseClicked

    private void lbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseClicked
        // TODO add your handling code here:
        IssueBook issue = new IssueBook();
        issue.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl3MouseClicked

    private void lbl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseClicked
        // TODO add your handling code here:
        ReturnBook returned = new ReturnBook();
        returned.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl4MouseClicked

    private void lbl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5MouseClicked
        // TODO add your handling code here:
        ViewAllRecord view = new ViewAllRecord();
        view.setVisible(true);
        dispose();

    }//GEN-LAST:event_lbl5MouseClicked

    private void lbl6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl6MouseClicked
        // TODO add your handling code here:
        IssueBookDetails details = new IssueBookDetails();
        details.setVisible(true);
        dispose();

    }//GEN-LAST:event_lbl6MouseClicked

    private void lbl7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl7MouseClicked
        // TODO add your handling code here:
        DefaulterList defaulter = new DefaulterList();
        defaulter.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl7MouseClicked

    private void lbl8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl8MouseClicked
        // TODO add your handling code here:
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl8MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lblBooks;
    private javax.swing.JLabel lblDefaulterList;
    private javax.swing.JLabel lblIssuedBooks;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JPanel panelPieChart;
    private javax.swing.JTable tblBookDetails;
    private javax.swing.JTable tblStudentDetails;
    // End of variables declaration//GEN-END:variables
}
