/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kode_project;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author riand
 */
public class editQuiz extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    int absen_siswa = 0;
    String QuizCode;
    int nomor_soal = 1;

    public editQuiz(int absen_siswa) {
        initComponents();

        this.absen_siswa = absen_siswa;
        disableALL();
        try {
            String sql = "SELECT * FROM quizid WHERE user_id = ?";
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, absen_siswa);
            ResultSet rs = psmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("QuizID"));
            }
            quizSelector.setModel(model);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
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

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        QuestionTXT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Opt1TXT = new javax.swing.JTextField();
        Opt2TXT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Opt3TXT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Opt4TXT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        AnswerTXT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nomorSoalTXT = new javax.swing.JLabel();
        QuizIdTXT = new javax.swing.JLabel();
        saveBut = new javax.swing.JButton();
        clearBut = new javax.swing.JButton();
        nextBut = new javax.swing.JButton();
        prevBut = new javax.swing.JButton();
        quizSelector = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exitBut1 = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1440, 760));

        jPanel1.setBackground(new java.awt.Color(14, 31, 52));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(10, 14, 24));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Quiz ID :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nomor Soal :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Question :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        QuestionTXT.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(QuestionTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 690, 36));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Option 1 :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        Opt1TXT.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Opt1TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 690, 36));

        Opt2TXT.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Opt2TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 690, 36));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Option 2 :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        Opt3TXT.setBackground(new java.awt.Color(255, 255, 255));
        Opt3TXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Opt3TXTActionPerformed(evt);
            }
        });
        jPanel2.add(Opt3TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 690, 36));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Option 3 :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        Opt4TXT.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Opt4TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 690, 36));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Option 4 :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        AnswerTXT.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(AnswerTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 690, 36));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Answer :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        nomorSoalTXT.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        nomorSoalTXT.setForeground(new java.awt.Color(255, 255, 255));
        nomorSoalTXT.setText("00");
        jPanel2.add(nomorSoalTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        QuizIdTXT.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        QuizIdTXT.setForeground(new java.awt.Color(255, 255, 255));
        QuizIdTXT.setText("00");
        jPanel2.add(QuizIdTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        saveBut.setBackground(new java.awt.Color(25, 48, 78));
        saveBut.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        saveBut.setForeground(new java.awt.Color(255, 255, 255));
        saveBut.setText("Save");
        saveBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButActionPerformed(evt);
            }
        });
        jPanel2.add(saveBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 109, 50));

        clearBut.setBackground(new java.awt.Color(25, 48, 78));
        clearBut.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        clearBut.setForeground(new java.awt.Color(255, 255, 255));
        clearBut.setText("Clear");
        clearBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButActionPerformed(evt);
            }
        });
        jPanel2.add(clearBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 110, 50));

        nextBut.setBackground(new java.awt.Color(25, 48, 78));
        nextBut.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        nextBut.setForeground(new java.awt.Color(255, 255, 255));
        nextBut.setText(">>");
        nextBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButActionPerformed(evt);
            }
        });
        jPanel2.add(nextBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 550, 110, 50));

        prevBut.setBackground(new java.awt.Color(25, 48, 78));
        prevBut.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        prevBut.setForeground(new java.awt.Color(255, 255, 255));
        prevBut.setText("<<");
        prevBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButActionPerformed(evt);
            }
        });
        jPanel2.add(prevBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 109, 50));

        quizSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizSelectorActionPerformed(evt);
            }
        });
        jPanel2.add(quizSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 60, 190, 40));

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quiz ID :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 111, 1430, 660));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edit Quiz");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        exitBut1.setBackground(new java.awt.Color(25, 48, 78));
        exitBut1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        exitBut1.setForeground(new java.awt.Color(255, 255, 255));
        exitBut1.setText("EXIT");
        exitBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBut1ActionPerformed(evt);
            }
        });
        jPanel1.add(exitBut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, 137, 73));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1436, 779));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public int countQuestions(String QuizID) {
        try {
            String sql = "SELECT COUNT(*) AS total FROM question WHERE QuizID = ?";
            Connection conn = koneksi.koneksiDB(); // Sesuaikan ini dengan cara Anda mendapatkan koneksi
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, QuizID);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return 0; // Jika terjadi kesalahan atau tidak ada soal, kembalikan 0
    }

    public String displayQuestion(String QuizID, int nomor_soal) {
        try {
            int nomor = 1;
            String sql = "SELECT * FROM question WHERE QuizID = ? AND nomor_soal = ?";
            java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, QuizID);
            psmt.setInt(2, nomor_soal);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                nomorSoalTXT.setText(rs.getString("nomor_soal"));
                QuestionTXT.setText(rs.getString("Question"));
                Opt1TXT.setText(rs.getString("OptionA"));
                Opt2TXT.setText(rs.getString("OptionB"));
                Opt3TXT.setText(rs.getString("OptionC"));
                Opt4TXT.setText(rs.getString("OptionD"));
                AnswerTXT.setText(rs.getString("CorrectAnswer"));
            }

            nomor = countQuestions(QuizID);
            int nomorTXT = Integer.parseInt(nomorSoalTXT.getText());

            nextBut.setEnabled(true);
            prevBut.setEnabled(true);

            if (nomorTXT >= nomor) {
                nextBut.setEnabled(false);
                prevBut.setEnabled(true);
            }
            if (nomorTXT == 1) {
                prevBut.setEnabled(false);
                nextBut.setEnabled(true);
            }

            QuizIdTXT.setText(QuizID);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
        return null;

    }

    public void disableALL() {
        nextBut.setEnabled(false);
        prevBut.setEnabled(false);
        saveBut.setEnabled(false);
        clearBut.setEnabled(false);
        QuestionTXT.setEnabled(false);
        Opt1TXT.setEnabled(false);
        Opt2TXT.setEnabled(false);
        Opt3TXT.setEnabled(false);
        Opt4TXT.setEnabled(false);
        AnswerTXT.setEnabled(false);
    }

    public void enableALL() {
        nextBut.setEnabled(true);
        prevBut.setEnabled(true);
        saveBut.setEnabled(true);
        clearBut.setEnabled(true);
        QuestionTXT.setEnabled(true);
        Opt1TXT.setEnabled(true);
        Opt2TXT.setEnabled(true);
        Opt3TXT.setEnabled(true);
        Opt4TXT.setEnabled(true);
        AnswerTXT.setEnabled(true);
    }


    private void saveButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Are you sure want to save?", "Select", JOptionPane.OK_CANCEL_OPTION);
        if (a == 0) {
            try {
                String ID = QuizIdTXT.getText();
                String nomor = nomorSoalTXT.getText();
                int nomorINT = Integer.parseInt(nomor);
                String question = QuestionTXT.getText();
                String opt1 = Opt1TXT.getText();
                String opt2 = Opt2TXT.getText();
                String opt3 = Opt3TXT.getText();
                String opt4 = Opt4TXT.getText();
                String answer = AnswerTXT.getText();

//                 question(QuizID, nomor_soal, Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer)
                java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
                PreparedStatement psmt = conn.prepareStatement("UPDATE question SET Question = ?, OptionA = ?, OptionB = ?, OptionC = ?, OptionD = ?, CorrectAnswer = ? WHERE QuizID = ?  AND nomor_soal = ?");

                psmt.setString(1, question);
                psmt.setString(2, opt1);
                psmt.setString(3, opt2);
                psmt.setString(4, opt3);
                psmt.setString(5, opt4);
                psmt.setString(6, answer);
                psmt.setString(7, ID);
                psmt.setInt(8, nomorINT);
                psmt.execute();
                JOptionPane.showConfirmDialog(this, "Succes Update Soal");

                displayQuestion(ID, Integer.parseInt(nomor));

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(this, e);
                System.out.print(e);
            }
        }

    }//GEN-LAST:event_saveButActionPerformed

    private void exitBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBut1ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Are you sure want to exit?", "Select", JOptionPane.OK_CANCEL_OPTION);
        if (a == 0) {
            this.dispose();
            new dash_admin(absen_siswa).setVisible(true);
        }
    }//GEN-LAST:event_exitBut1ActionPerformed

    private void clearButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButActionPerformed
        QuestionTXT.setText("");
        Opt1TXT.setText("");
        Opt2TXT.setText("");
        Opt3TXT.setText("");
        Opt4TXT.setText("");
        AnswerTXT.setText("");
    }//GEN-LAST:event_clearButActionPerformed

    private void Opt3TXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Opt3TXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Opt3TXTActionPerformed

    private void nextButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButActionPerformed
        nomor_soal++;
        displayQuestion(QuizCode, nomor_soal);
    }//GEN-LAST:event_nextButActionPerformed

    private void prevButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButActionPerformed
        nomor_soal--;
        displayQuestion(QuizCode, nomor_soal);
    }//GEN-LAST:event_prevButActionPerformed

    private void quizSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizSelectorActionPerformed
        QuizCode = String.valueOf(quizSelector.getSelectedItem());
        nomor_soal = 1;
        enableALL();
        displayQuestion(QuizCode, nomor_soal);
    }//GEN-LAST:event_quizSelectorActionPerformed

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
            java.util.logging.Logger.getLogger(editQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editQuiz(99).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnswerTXT;
    private javax.swing.JTextField Opt1TXT;
    private javax.swing.JTextField Opt2TXT;
    private javax.swing.JTextField Opt3TXT;
    private javax.swing.JTextField Opt4TXT;
    private javax.swing.JTextField QuestionTXT;
    private javax.swing.JLabel QuizIdTXT;
    private javax.swing.JButton clearBut;
    private javax.swing.JButton exitBut1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JButton nextBut;
    private javax.swing.JLabel nomorSoalTXT;
    private javax.swing.JButton prevBut;
    private javax.swing.JComboBox<String> quizSelector;
    private javax.swing.JButton saveBut;
    // End of variables declaration//GEN-END:variables
}
