/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kode_project;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author riand
 */
public class QUIZ extends javax.swing.JFrame {

    /**
     * Creates new form QUIZ
     */
    public String questionId = "1";
    public String answer;
    public int sec = 0;
    public int min = 0;
    public int marks = 0;
    public int IdQuiz = 0;
    public int absen_siswa = 1;
    public String jumlah_soal;
    Timer time;

    public void answerCheck() {
        String studentAns = "";
        if (ans1.isSelected()) {
            studentAns = ans1.getText();
        } else if (ans2.isSelected()) {
            studentAns = ans2.getText();
        } else if (ans3.isSelected()) {
            studentAns = ans3.getText();
        } else if (ans4.isSelected()) {
            studentAns = ans4.getText();
        }
        if (studentAns.equals(answer)) {
            marks = marks + 1;
            String marks1 = String.valueOf(marks);
            marksLB.setText(marks1);
        }

        int questionID1 = Integer.parseInt(questionId);
        questionID1 = questionID1 + 1;
        questionId = String.valueOf(questionID1);
        numberLB.setText(questionId);

        if (questionId.equals(jumlah_soal)) {
            nextBT.setEnabled(false);
        }

        ans1.setSelected(false);
        ans2.setSelected(false);
        ans3.setSelected(false);
        ans4.setSelected(false);
    }

    public void question() {

        try {
            String sql = "SELECT * FROM question WHERE QuizID= '" + IdQuiz + "' AND  nomor_soal='" + questionId + "'";
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                questionLB.setText(rs.getString("Question"));
                ans1.setText(rs.getString("OptionA"));
                ans2.setText(rs.getString("OptionB"));
                ans3.setText(rs.getString("OptionC"));
                ans4.setText(rs.getString("OptionD"));
                answer = rs.getString("CorrectAnswer");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void submit() {
        try {
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            Statement st = (Statement) conn.createStatement();
            st.executeUpdate("UPDATE user SET marks = '" + marks + "' WHERE absen = '" + absen_siswa + "' ");
            this.dispose();
            new homepage(absen_siswa).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public QUIZ() {
        initComponents();
    }

    public QUIZ(int QuizID, int absen) {
        IdQuiz = QuizID;
        absen_siswa = absen;
        initComponents();
        numberLB.setText(questionId);
        try {
            String sql = "SELECT * FROM user WHERE absen= ? ";
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,absen_siswa);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                namaLB.setText(rs.getString("nama"));
                absenLB.setText(rs.getString("absen"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

        try {
            String sql = "SELECT * FROM question WHERE QuizID = '" + IdQuiz + "' AND  nomor_soal='" + questionId + "'";
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                questionLB.setText(rs.getString("Question"));
                ans1.setText(rs.getString("OptionA"));
                ans2.setText(rs.getString("OptionB"));
                ans3.setText(rs.getString("OptionC"));
                ans4.setText(rs.getString("OptionD"));
                answer = rs.getString("CorrectAnswer");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

        try {
            String sql = "SELECT COUNT(*) AS total_soal FROM question WHERE QuizID = '" + IdQuiz + "'";
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                jumlah_soal = rs.getString("total_soal");
                QuizTotal.setText(jumlah_soal);
            }
            if (questionId.equals(jumlah_soal)) {
                nextBT.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        //time
        setLocationRelativeTo(this);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetikLB.setText(String.valueOf(sec));
                MenitLB.setText(String.valueOf(min));
                if (sec == 60) {
                    sec = 0;
                    min++;
                    if (min == 10) {
                        time.stop();
                        answerCheck();
                        submit();
                    }
                }
                sec++;
            }
        });
        time.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Answer = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numberLB = new javax.swing.JLabel();
        marksLB = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        QuizTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        questionLB = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ans1 = new javax.swing.JRadioButton();
        ans2 = new javax.swing.JRadioButton();
        ans3 = new javax.swing.JRadioButton();
        ans4 = new javax.swing.JRadioButton();
        nextBT = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        namaLB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MenitLB = new javax.swing.JLabel();
        DetikLB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        absenLB = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setForeground(java.awt.Color.orange);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1440, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(1440, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 31, 52));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUIZ NUMBER:");

        jLabel7.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("YOUR MARK:");

        numberLB.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        numberLB.setForeground(new java.awt.Color(255, 255, 255));
        numberLB.setText("0");

        marksLB.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        marksLB.setForeground(new java.awt.Color(255, 255, 255));
        marksLB.setText("0");

        jLabel8.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("QUIZ TOTAL:");

        QuizTotal.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        QuizTotal.setForeground(new java.awt.Color(255, 255, 255));
        QuizTotal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(marksLB))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuizTotal)
                            .addComponent(numberLB))))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(QuizTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numberLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(marksLB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 150, -1, 562));

        jPanel2.setBackground(new java.awt.Color(14, 31, 52));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        questionLB.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        questionLB.setForeground(new java.awt.Color(255, 255, 255));
        questionLB.setText("LOREM IPSUM DOLOR SIT AMET LOREM IPSUM DOLOR SIT AMET");
        questionLB.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Answer");

        ans1.setForeground(new java.awt.Color(255, 255, 255));
        ans1.setText("A");
        ans1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans1ActionPerformed(evt);
            }
        });

        ans2.setForeground(new java.awt.Color(255, 255, 255));
        ans2.setText("B");
        ans2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans2ActionPerformed(evt);
            }
        });

        ans3.setForeground(new java.awt.Color(255, 255, 255));
        ans3.setText("C");
        ans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans3ActionPerformed(evt);
            }
        });

        ans4.setForeground(new java.awt.Color(255, 255, 255));
        ans4.setText("D");
        ans4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans4ActionPerformed(evt);
            }
        });

        nextBT.setBackground(new java.awt.Color(25, 48, 78));
        nextBT.setForeground(new java.awt.Color(255, 255, 255));
        nextBT.setText("Next");
        nextBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(25, 48, 78));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(questionLB, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ans1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ans2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ans3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ans4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nextBT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(questionLB, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(ans1)
                .addGap(26, 26, 26)
                .addComponent(ans2)
                .addGap(26, 26, 26)
                .addComponent(ans3)
                .addGap(26, 26, 26)
                .addComponent(ans4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 150, -1, 560));

        namaLB.setFont(new java.awt.Font("Asus Rog", 0, 24)); // NOI18N
        namaLB.setForeground(new java.awt.Color(255, 255, 255));
        namaLB.setText("NICKNAME");
        getContentPane().add(namaLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 35, -1, -1));

        jLabel3.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("10MIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1297, 34, -1, -1));

        jLabel5.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TIME LIMIT :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1151, 34, 140, -1));

        jLabel6.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TIME TAKEN:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1151, 71, 140, -1));

        MenitLB.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        MenitLB.setForeground(new java.awt.Color(255, 255, 255));
        MenitLB.setText("00");
        getContentPane().add(MenitLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1297, 71, -1, -1));

        DetikLB.setFont(new java.awt.Font("VALORANT", 0, 18)); // NOI18N
        DetikLB.setForeground(new java.awt.Color(255, 255, 255));
        DetikLB.setText("00");
        getContentPane().add(DetikLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1333, 71, -1, -1));

        jLabel9.setFont(new java.awt.Font("Asus Rog", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ABSEN");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 68, -1, -1));

        absenLB.setFont(new java.awt.Font("VALORANT", 0, 24)); // NOI18N
        absenLB.setForeground(new java.awt.Color(255, 255, 255));
        absenLB.setText("0");
        getContentPane().add(absenLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 67, -1, -1));

        jPanel3.setBackground(new java.awt.Color(10, 14, 24));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1430, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 770));

        setSize(new java.awt.Dimension(1424, 752));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTActionPerformed

        answerCheck();
        question();
    }//GEN-LAST:event_nextBTActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Yakin?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans1ActionPerformed
        if (ans1.isSelected()) {
            ans2.setSelected(false);
            ans3.setSelected(false);
            ans4.setSelected(false);
        }
    }//GEN-LAST:event_ans1ActionPerformed

    private void ans2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans2ActionPerformed
        if (ans2.isSelected()) {
            ans1.setSelected(false);
            ans3.setSelected(false);
            ans4.setSelected(false);
        }
    }//GEN-LAST:event_ans2ActionPerformed

    private void ans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans3ActionPerformed
        if (ans3.isSelected()) {
            ans1.setSelected(false);
            ans2.setSelected(false);
            ans4.setSelected(false);
        }
    }//GEN-LAST:event_ans3ActionPerformed

    private void ans4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans4ActionPerformed
        if (ans4.isSelected()) {
            ans2.setSelected(false);
            ans3.setSelected(false);
            ans1.setSelected(false);
        }
    }//GEN-LAST:event_ans4ActionPerformed

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
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QUIZ(901,1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Answer;
    private javax.swing.JLabel DetikLB;
    private javax.swing.JLabel MenitLB;
    private javax.swing.JLabel QuizTotal;
    private javax.swing.JLabel absenLB;
    private javax.swing.JRadioButton ans1;
    private javax.swing.JRadioButton ans2;
    private javax.swing.JRadioButton ans3;
    private javax.swing.JRadioButton ans4;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel marksLB;
    private javax.swing.JLabel namaLB;
    private javax.swing.JButton nextBT;
    private javax.swing.JLabel numberLB;
    private javax.swing.JLabel questionLB;
    // End of variables declaration//GEN-END:variables
}
