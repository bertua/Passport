package br.com.flarom.passport;

import br.com.flarom.passport.Helpers.MiscHelper;
import br.com.flarom.passport.LogonDialogs.dlgUpdateAccount;
import br.com.flarom.passport.MiscDialogs.dlgTableView;
import br.com.flarom.passport.MiscDialogs.dlgTextInput;
import br.com.flarom.passport.Objects.LoginAttempt;
import br.com.flarom.passport.Objects.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmSettings extends javax.swing.JFrame {

    public frmSettings() {
        initComponents();
        lblDisplayname.setText(User.getLoggedUser().getNickname());
        lblUsername.setText("@" + User.getLoggedUser().getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popAccountOptions = new javax.swing.JPopupMenu();
        mnuLoginHistory = new javax.swing.JMenuItem();
        mnuDeleteAccount = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlAccount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDisplayname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        btnAccountOptions = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblGithub = new javax.swing.JLabel();

        mnuLoginHistory.setText("Login history");
        mnuLoginHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoginHistoryActionPerformed(evt);
            }
        });
        popAccountOptions.add(mnuLoginHistory);

        mnuDeleteAccount.setForeground(new java.awt.Color(220, 53, 69));
        mnuDeleteAccount.setText("Delete this account");
        mnuDeleteAccount.setToolTipText("Delete this account and everything related to it");
        mnuDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteAccountActionPerformed(evt);
            }
        });
        popAccountOptions.add(mnuDeleteAccount);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings - Passport");

        jLabel2.setFont(new java.awt.Font("SegoeUI", 0, 36)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Settings");

        jLabel3.setFont(new java.awt.Font("SegoeUI", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Account");

        pnlAccount.setBackground(new java.awt.Color(43, 43, 43));
        pnlAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jLabel1.setText("Logged as:");

        lblDisplayname.setFont(new java.awt.Font("SegoeUI", 0, 18)); // NOI18N
        lblDisplayname.setForeground(java.awt.Color.white);
        lblDisplayname.setText("Dislpayname");

        jButton1.setText("Edit account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblUsername.setText("Username");

        btnAccountOptions.setBackground(new java.awt.Color(43, 43, 43));
        btnAccountOptions.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnAccountOptions.setText("");
        btnAccountOptions.setBorder(null);
        btnAccountOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAccountLayout = new javax.swing.GroupLayout(pnlAccount);
        pnlAccount.setLayout(pnlAccountLayout);
        pnlAccountLayout.setHorizontalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addComponent(lblDisplayname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(btnAccountOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAccountLayout.setVerticalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisplayname)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnAccountOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("SegoeUI", 1, 13)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("About this app");

        jLabel5.setText("<html>\n<p>\nPassport Password Manager v1.0<br>\n© 2024 Passport. Licensed under MIT License.\n</p>");

        lblGithub.setForeground(new java.awt.Color(70, 206, 252));
        lblGithub.setText("Github repository");
        lblGithub.setToolTipText("");
        lblGithub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGithubMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGithub))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGithub)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(pnlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(pnlAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccountOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountOptionsActionPerformed
        popAccountOptions.show(pnlAccount, btnAccountOptions.getLocation().x, btnAccountOptions.getLocation().y + btnAccountOptions.getHeight());
    }//GEN-LAST:event_btnAccountOptionsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dlgUpdateAccount ua = new dlgUpdateAccount(this);
        ua.Edit();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblGithubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGithubMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/flarom/passport"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e, "Failed to open URL", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblGithubMouseClicked

    private void mnuDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteAccountActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Are you sure?\nThis will delete all your Passwords, Notes, Credit cards and tags.\nThere is no way to restore it latter,", "Delete account", JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            User u = User.getLoggedUser();

            dlgTextInput ti = new dlgTextInput(this);
            String password = ti.Show("Confirm deletion", "Enter your password to confirm deletion", "", "Delete account");

            if (password == null) {
                return;
            }

            if (!MiscHelper.decryptPassword(u.getPassword()).equals(password)) {
                JOptionPane.showMessageDialog(rootPane, "Wrong password");
                return;
            };

            u.Delete();
            JOptionPane.showMessageDialog(rootPane, "Your account was deleted\nGoodbye!");
            System.exit(0);
        } catch (Exception ex) {
            Logger.getLogger(frmSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuDeleteAccountActionPerformed

    private void mnuLoginHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoginHistoryActionPerformed
        ArrayList<LoginAttempt> las = LoginAttempt.ListFromUser(User.getLoggedUser().getId_user());
        dlgTableView tv = new dlgTableView(this, false);

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        ArrayList<String> headers = new ArrayList<>();
        headers.add("User");
        headers.add("Time");
        table.add(headers);

        las.sort((la1, la2) -> la2.getEvent().compareTo(la1.getEvent()));

        for (LoginAttempt la : las) {
            ArrayList<String> row = new ArrayList<>();
            row.add(User.Read(la.getId_user()).getUsername());
            row.add(la.getEvent().toString());
            table.add(row);
        }

        tv.displayArrayListMatrix(table, "Login history");
    }//GEN-LAST:event_mnuLoginHistoryActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccountOptions;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDisplayname;
    private javax.swing.JLabel lblGithub;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenuItem mnuDeleteAccount;
    private javax.swing.JMenuItem mnuLoginHistory;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPopupMenu popAccountOptions;
    // End of variables declaration//GEN-END:variables
}
