package br.com.flarom.passport;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import br.com.flarom.passport.Helpers.MiscHelper;
import static br.com.flarom.passport.Helpers.MiscHelper.openWebsite;
import br.com.flarom.passport.Helpers.VersionHelper;
import br.com.flarom.passport.Dialogs.Logon.dlgUpdateAccount;
import br.com.flarom.passport.Dialogs.Misc.dlgDocumentView;
import br.com.flarom.passport.Dialogs.Misc.dlgTableView;
import br.com.flarom.passport.Dialogs.Misc.dlgTextInput;
import br.com.flarom.passport.Objects.LoginAttempt;
import br.com.flarom.passport.Objects.User;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class frmSettings extends javax.swing.JFrame {

    public frmSettings() {
        initComponents();
        lblDisplayname.setText(User.getLoggedUser().getNickname());
        lblUsername.setText("@" + User.getLoggedUser().getUsername());
        pnlUpdate.setVisible(false);

        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);
    }

    private void updateVersion() {
        VersionHelper vh = new VersionHelper();
        String localVersion = vh.getLocalVersion();

        lblInfo.setText(String.format("""
        <html>
            <p>
                Passport Password Manager v%s<br>
                © 2024 Passport. Licensed under Apache 2.0.
            </p>                
        """, localVersion));

        this.setTitle("Settings - Passport [Checking for updates...]");

        try {
            if (vh.isVersionDifferent(localVersion)) {
                pnlUpdate.setVisible(true);
                btnUpdate.setText("Update to " + vh.getLatestVersion());
            } else {
                pnlUpdate.setVisible(false);
            }
        } catch (Exception ex) {
            pnlUpdate.setVisible(false);
            System.err.print("Failed to check for updates");
        }

        this.setTitle("Settings - Passport");
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
        lblInfo = new javax.swing.JLabel();
        lblGithub = new javax.swing.JLabel();
        pnlUpdate = new javax.swing.JPanel();
        lblUpdate = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lblLicense = new javax.swing.JLabel();

        mnuLoginHistory.setText("Login history");
        mnuLoginHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoginHistoryActionPerformed(evt);
            }
        });
        popAccountOptions.add(mnuLoginHistory);

        mnuDeleteAccount.setForeground(new java.awt.Color(252, 70, 70));
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jButton1.setMnemonic('e');
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
        btnAccountOptions.setToolTipText("More options");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
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

        lblInfo.setText("<html>\n<p>\nPassport Password Manager v1.0<br>\n© 2024 Passport. Licensed under Apache 2.0.\n</p>");

        lblGithub.setForeground(new java.awt.Color(70, 206, 252));
        lblGithub.setText("Github repository");
        lblGithub.setToolTipText("");
        lblGithub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGithubMouseClicked(evt);
            }
        });

        lblUpdate.setText("Passport is outdated!");

        btnUpdate.setText("Update now");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUpdateLayout = new javax.swing.GroupLayout(pnlUpdate);
        pnlUpdate.setLayout(pnlUpdateLayout);
        pnlUpdateLayout.setHorizontalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUpdate)
                    .addComponent(btnUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUpdateLayout.setVerticalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        lblLicense.setForeground(new java.awt.Color(70, 206, 252));
        lblLicense.setText("Opensource license");
        lblLicense.setToolTipText("");
        lblLicense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLicenseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGithub))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLicense)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGithub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLicense)
                .addGap(35, 35, 35)
                .addComponent(pnlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        openWebsite(rootPane, "https://github.com/flarom/passport");
    }//GEN-LAST:event_lblGithubMouseClicked

    private void mnuDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteAccountActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Are you sure?\nThis will delete all your Passwords, Notes, Credit cards and tags.\nThere is no way to restore it latter,", "Delete account", JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            User u = User.getLoggedUser();

            dlgTextInput ti = new dlgTextInput(this);
            String password = ti.Show("Confirm deletion", "Enter your password to confirm deletion", "", "Delete account", false);

            if (password == null) {
                return;
            }

            if (!MiscHelper.decryptPassword(u.getPassword()).equals(password)) {
                JOptionPane.showMessageDialog(rootPane, "Wrong password");
                return;
            };

            u.Delete();
            JOptionPane.showMessageDialog(rootPane, "Your account was deleted\nWe'll miss you 💔");
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        updateVersion();
    }//GEN-LAST:event_formWindowOpened

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        openWebsite(rootPane, "https://github.com/flarom/passport/releases/latest");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblLicenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLicenseMouseClicked
        dlgDocumentView dv = new dlgDocumentView(this, false);
        String mitLicense;

        try {
            Path licensePath = Paths.get("license.md");
            mitLicense = Files.readString(licensePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            openWebsite(rootPane, "https://github.com/flarom/passport/blob/main/license.md");
            return;
        }

        dv.readMarkdown(mitLicense, "Passport");
    }//GEN-LAST:event_lblLicenseMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccountOptions;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDisplayname;
    private javax.swing.JLabel lblGithub;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLicense;
    private javax.swing.JLabel lblUpdate;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenuItem mnuDeleteAccount;
    private javax.swing.JMenuItem mnuLoginHistory;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlUpdate;
    private javax.swing.JPopupMenu popAccountOptions;
    // End of variables declaration//GEN-END:variables
}
