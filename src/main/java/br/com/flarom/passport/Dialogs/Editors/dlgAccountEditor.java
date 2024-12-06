package br.com.flarom.passport.Dialogs.Editors;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import static br.com.flarom.passport.Helpers.MiscHelper.decryptPassword;
import static br.com.flarom.passport.Dialogs.Logon.dlgSignup.isEmailValid;
import br.com.flarom.passport.Objects.User;
import javax.swing.JOptionPane;

public class dlgAccountEditor extends javax.swing.JDialog {

    public dlgAccountEditor(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setConfirmButton(btnOk);
        kh.setCloseOnEscape(this);
    }
    private boolean confirmed = false;
    private String defaultEmail;

    public void Edit() {
        User u = User.getLoggedUser();

        txtNickname.setText(u.getNickname());
        txtUsername.setText(u.getUsername());
        txtEmail.setText(u.getEmail());
        defaultEmail = u.getEmail();

        try {
            txtPassword.setText(decryptPassword(u.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setVisible(true);

        if (confirmed) {
            try {
                u.setNickname(txtNickname.getText());
                u.setEmail(txtEmail.getText());
                u.setPassword(txtPassword.getText());

                u.Update();
            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(rootPane, "You are about to be logged out\nPlease log back in with your new account info");
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edit account - Passport");
        setMinimumSize(new java.awt.Dimension(178, 408));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SegoeUI", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Edit account");

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jLabel2.setText("Display name:");

        jLabel3.setText("Username:");

        txtUsername.setEnabled(false);

        jLabel4.setText("Email:");

        jLabel5.setText("Password:");

        jLabel6.setText("Confirm password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNickname)
                    .addComponent(txtUsername)
                    .addComponent(txtEmail)
                    .addComponent(txtPassword)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 274, Short.MAX_VALUE))
                    .addComponent(txtPasswordConfirm))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnOk.setBackground(new java.awt.Color(70, 206, 252));
        btnOk.setForeground(java.awt.Color.black);
        btnOk.setText("Edit");
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (txtNickname.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a display name");
            return;
        }
        if (txtUsername.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a username");
            return;
        }
        if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Email cannot be empty");
            return;
        }
        if (!isEmailValid(txtEmail.getText())) {
            JOptionPane.showMessageDialog(rootPane, "The email address is invalid. Please check the format");
            return;
        }
        if (txtPassword.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a password");
            return;
        }
        if (txtPassword.getText().length() <= 6) {
            JOptionPane.showMessageDialog(rootPane, "Please use a password with at least 7 characters");
            return;
        }
        if (txtPassword.getText().contains(" ")) {
            JOptionPane.showMessageDialog(rootPane, "Password cannot contain spaces");
            return;
        }
        if (txtPasswordConfirm.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Please confirm password");
            return;
        }
        if (!txtPassword.getText().equals(txtPasswordConfirm.getText())) {
            JOptionPane.showMessageDialog(rootPane, "The passwords do not match. Please verify");
            return;
        }

        if (!defaultEmail.equals(txtEmail.getText())) {
            if (User.isEmailTaken(txtEmail.getText())) {
                JOptionPane.showMessageDialog(rootPane, "This email is already in use");
                return;
            }
        }

        confirmed = true;
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!txtNickname.getText().isBlank()
                || !txtEmail.getText().isBlank()
                || !txtPassword.getText().isBlank()
                || !txtPasswordConfirm.getText().isBlank()) {

            int doClose = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure you want to close this editor?\nAlterations will not be saved.",
                    "Discard",
                    JOptionPane.YES_NO_OPTION);

            if (doClose == JOptionPane.YES_OPTION) {
                confirmed = false;
                dispose();
            }
        } else {
            confirmed = false;
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgAccountEditor dialog = new dlgAccountEditor(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
