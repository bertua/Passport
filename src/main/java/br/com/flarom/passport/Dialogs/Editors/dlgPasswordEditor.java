package br.com.flarom.passport.Dialogs.Editors;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import static br.com.flarom.passport.Helpers.MiscHelper.getRandomPassword;
import br.com.flarom.passport.Objects.Category;
import br.com.flarom.passport.Objects.Password;
import br.com.flarom.passport.Objects.User;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;

public class dlgPasswordEditor extends javax.swing.JDialog {

    private boolean confirmed = false;
    private java.awt.Frame parent;

    public dlgPasswordEditor(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.parent = parent;

        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);

        refreshCategories();

        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            private void processPasswordChange() {
                int passwordLength = txtPassword.getText().length();

                if (passwordLength <= 6) {
                    pgsPasswordStrongness.setForeground(new Color(220, 53, 69));
                    lblPasswordStrongness.setText("Too short!");
                } else if (passwordLength <= 8) {
                    pgsPasswordStrongness.setForeground(new Color(255, 193, 7));
                    lblPasswordStrongness.setText("Weak");
                } else if (passwordLength <= 12) {
                    pgsPasswordStrongness.setForeground(new Color(40, 167, 69));
                    lblPasswordStrongness.setText("Good");
                } else {
                    pgsPasswordStrongness.setForeground(new Color(0, 138, 221));
                    lblPasswordStrongness.setText("Excelent!");
                }

                pgsPasswordStrongness.setValue(passwordLength);
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                processPasswordChange();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                processPasswordChange();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {

            }
        });
    }

    private ArrayList<Category> userCategories = new ArrayList<Category>();

    private void refreshCategories() {
        userCategories.clear();
        cbxCategory.removeAllItems();

        ArrayList<Category> categories = Category.ListFromUser(User.getLoggedUser().getId_user());
        for (Category cat : categories) {
            userCategories.add(cat);
            cbxCategory.addItem(cat.getName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnViewPassword = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pnlGenerateRandom = new javax.swing.JPanel();
        cbxLower = new javax.swing.JCheckBox();
        cbxUpper = new javax.swing.JCheckBox();
        cbxNumbr = new javax.swing.JCheckBox();
        cbxSpecl = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sldPassLenght = new javax.swing.JSlider();
        btnGenerate = new javax.swing.JButton();
        lblPasswordStrongness = new javax.swing.JLabel();
        pgsPasswordStrongness = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtServiceName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Password - Passport");
        setMinimumSize(new java.awt.Dimension(256, 580));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(70, 206, 252));
        btnOk.setForeground(java.awt.Color.black);
        btnOk.setText("OK");
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

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jLabel3.setText("Password:");

        btnViewPassword.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnViewPassword.setText("");
        btnViewPassword.setToolTipText("Show password");
        btnViewPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnViewPassword.setPreferredSize(new java.awt.Dimension(22, 22));
        btnViewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPasswordActionPerformed(evt);
            }
        });

        jLabel4.setText("Generate random");

        pnlGenerateRandom.setBackground(new java.awt.Color(43, 43, 43));
        pnlGenerateRandom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        cbxLower.setSelected(true);
        cbxLower.setText("a-z");
        cbxLower.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbxUpper.setSelected(true);
        cbxUpper.setText("A-Z");
        cbxUpper.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbxNumbr.setSelected(true);
        cbxNumbr.setText("0-9");
        cbxNumbr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbxSpecl.setText("!@#");
        cbxSpecl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setText("Characters:");

        jLabel6.setText("Lenght:");

        sldPassLenght.setForeground(new java.awt.Color(70, 206, 252));
        sldPassLenght.setMaximum(50);
        sldPassLenght.setMinimum(7);
        sldPassLenght.setValue(13);

        btnGenerate.setText("Generate");
        btnGenerate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRandomPass(evt);
            }
        });

        javax.swing.GroupLayout pnlGenerateRandomLayout = new javax.swing.GroupLayout(pnlGenerateRandom);
        pnlGenerateRandom.setLayout(pnlGenerateRandomLayout);
        pnlGenerateRandomLayout.setHorizontalGroup(
            pnlGenerateRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGenerateRandomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGenerateRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldPassLenght, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(pnlGenerateRandomLayout.createSequentialGroup()
                        .addGroup(pnlGenerateRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(pnlGenerateRandomLayout.createSequentialGroup()
                                .addComponent(cbxLower)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxUpper)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxNumbr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxSpecl)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGenerateRandomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate)
                .addContainerGap())
        );
        pnlGenerateRandomLayout.setVerticalGroup(
            pnlGenerateRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGenerateRandomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGenerateRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxLower)
                    .addComponent(cbxUpper)
                    .addComponent(cbxNumbr)
                    .addComponent(cbxSpecl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldPassLenght, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPasswordStrongness.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPasswordStrongness.setText("Invalid");

        pgsPasswordStrongness.setMaximum(13);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGenerateRandom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(pgsPasswordStrongness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPasswordStrongness))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblPasswordStrongness))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pgsPasswordStrongness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGenerateRandom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Account Details");

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jLabel1.setText("Service name:");

        jLabel2.setText("Username:");

        jLabel8.setText("Tag:");

        btnAddCategory.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnAddCategory.setText("");
        btnAddCategory.setToolTipText("Add tag");
        btnAddCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddCategory.setPreferredSize(new java.awt.Dimension(22, 22));
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServiceName)
                    .addComponent(txtUsername)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(cbxCategory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Create() {
        this.setVisible(true);

        if (confirmed) {
            int id_user = User.getLoggedUser().getId_user();
            int id_category = userCategories.get(cbxCategory.getSelectedIndex()).getId_category();
            String service_name = txtServiceName.getText();
            String user_name = txtUsername.getText();
            String password = txtPassword.getText();
            Timestamp create_date = new Timestamp(System.currentTimeMillis());
            String color = userCategories.get(cbxCategory.getSelectedIndex()).getColor();

            Password p = new Password(id_user, id_category, service_name, user_name, password, create_date, create_date, create_date, color);

            try {
                p.Create();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Password Edit(Password p) {
        txtServiceName.setText(p.getService_name());
        txtUsername.setText(p.getUser_name());
        if (Category.Read(p.getId_category()) != null) {
            cbxCategory.setSelectedItem(Category.Read(p.getId_category()).getName());
        }
        txtPassword.setText(p.getPassword());

        this.setVisible(true);

        if (confirmed) {
            int id_category = userCategories.get(cbxCategory.getSelectedIndex()).getId_category();
            String service_name = txtServiceName.getText();
            String user_name = txtUsername.getText();
            String password = txtPassword.getText();
            Timestamp edit_date = new Timestamp(System.currentTimeMillis());

            p.setId_category(id_category);
            p.setService_name(service_name);
            p.setUser_name(user_name);
            p.setPassword(password);
            p.setEdit_date(edit_date);

            try {
                p.Update();
                return p;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private boolean showing = false;
    private void btnViewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPasswordActionPerformed
        if (showing) {
            txtPassword.setEchoChar('\u2022');
            btnViewPassword.setToolTipText("Show password");
            btnViewPassword.setText("\ue052");
        } else {
            txtPassword.setEchoChar((char) 0);
            btnViewPassword.setToolTipText("Hide password");
            btnViewPassword.setText("\ued1a");
        }
        showing = !showing;
    }//GEN-LAST:event_btnViewPasswordActionPerformed

    private void updateRandomPass(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRandomPass
        int lenght = sldPassLenght.getValue();

        if (cbxLower.isSelected() == false && cbxUpper.isSelected() == false && cbxNumbr.isSelected() == false && cbxSpecl.isSelected() == false) {
            cbxLower.setSelected(true);
        }

        boolean useLowerCase = cbxLower.isSelected();
        boolean useUpperCase = cbxUpper.isSelected();
        boolean useNumbers = cbxNumbr.isSelected();
        boolean useSpecial = cbxSpecl.isSelected();

        String pass = getRandomPassword(lenght, useLowerCase, useUpperCase, useNumbers, useSpecial);

        if (pass == null) {
            return;
        }

        txtPassword.setText(pass);
    }//GEN-LAST:event_updateRandomPass

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        dlgCategoryEditor ce = new dlgCategoryEditor(this.parent);
        Category cat = ce.Create();
        
        if(cat == null) return;
        
        cat.Create();
        refreshCategories();
        
        cbxCategory.setSelectedItem(cat.getName());
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (txtServiceName.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Service name cannot be empty");
            return;
        }
        if (txtUsername.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Username cannot be empty");
            return;
        }
        if (cbxCategory.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Category cannot be empty");
            return;
        }
        if (txtPassword.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a password");
            return;
        }
        if (txtPassword.getText().length() <= 6) {
            JOptionPane.showMessageDialog(rootPane, "Password cannot be shorter than 7 characters");
            return;
        }
        if (txtPassword.getText().contains(" ")) {
            JOptionPane.showMessageDialog(rootPane, "Password cannot contain spaces");
            return;
        }

        confirmed = true;
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        confirmed = false;
        dispose();
    }//GEN-LAST:event_formWindowClosed

    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dlgPasswordEditor(new javax.swing.JFrame()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnViewPassword;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JCheckBox cbxLower;
    private javax.swing.JCheckBox cbxNumbr;
    private javax.swing.JCheckBox cbxSpecl;
    private javax.swing.JCheckBox cbxUpper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPasswordStrongness;
    private javax.swing.JProgressBar pgsPasswordStrongness;
    private javax.swing.JPanel pnlGenerateRandom;
    private javax.swing.JSlider sldPassLenght;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtServiceName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
