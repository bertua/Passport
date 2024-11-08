package br.com.flarom.passport.Dialogs;

import br.com.flarom.passport.Objects.Category;
import br.com.flarom.passport.Objects.User;
import java.security.SecureRandom;
import java.util.ArrayList;

public class dlgPasswordEditor extends javax.swing.JDialog {

    private boolean confirmed = false;
    private java.awt.Frame parent;
    
    public dlgPasswordEditor(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.parent = parent;
        
        refreshCategories();
    }

    private ArrayList<Category> userCategories = new ArrayList<Category>();
    private void refreshCategories(){
        userCategories.clear();
        cbxCategories.removeAllItems();
        
        ArrayList<Category> categories = Category.ListFromUser(User.getLoggedUser().getId_user());
        for(Category cat : categories){
            userCategories.add(cat);
            cbxCategories.addItem(cat.getName());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtServiceName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        pnlGenerateRandom = new javax.swing.JPanel();
        cbxLower = new javax.swing.JCheckBox();
        cbxUpper = new javax.swing.JCheckBox();
        cbxNumbr = new javax.swing.JCheckBox();
        cbxSpecl = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sldPassLenght = new javax.swing.JSlider();
        btnGenerate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnViewPassword = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxCategories = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Password editor");
        setMinimumSize(new java.awt.Dimension(342, 607));

        jLabel1.setText("Service:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        pnlGenerateRandom.setBackground(java.awt.Color.white);
        pnlGenerateRandom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 194, 194)));

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

        sldPassLenght.setMaximum(50);
        sldPassLenght.setMinimum(1);
        sldPassLenght.setValue(10);

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
                    .addComponent(sldPassLenght, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(pnlGenerateRandomLayout.createSequentialGroup()
                        .addGroup(pnlGenerateRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlGenerateRandomLayout.createSequentialGroup()
                        .addComponent(cbxLower)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxUpper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNumbr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSpecl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerate)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate)
                .addContainerGap())
        );

        jLabel4.setText("Generate random");

        btnOk.setBackground(new java.awt.Color(34, 133, 225));
        btnOk.setForeground(java.awt.Color.white);
        btnOk.setText("OK");
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnViewPassword.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnViewPassword.setText("");
        btnViewPassword.setToolTipText("Show password");
        btnViewPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnViewPassword.setPreferredSize(new java.awt.Dimension(22, 22));
        btnViewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPasswordActionPerformed(evt);
            }
        });

        jLabel8.setText("Category:");

        btnAddCategory.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnAddCategory.setText("");
        btnAddCategory.setToolTipText("Show password");
        btnAddCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddCategory.setPreferredSize(new java.awt.Dimension(22, 22));
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServiceName)
                    .addComponent(txtUsername)
                    .addComponent(pnlGenerateRandom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxCategories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGenerateRandom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Create(){
        this.setVisible(true);
        if(confirmed){
            dispose();
        }
    }
    
    public void Edit(int id){
        this.setVisible(true);
        if(confirmed){
            dispose();
        }
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
        boolean useLowerCase = cbxLower.isSelected();
        boolean useUpperCase = cbxUpper.isSelected();
        boolean useNumbers = cbxNumbr.isSelected();
        boolean useSpecial = cbxSpecl.isSelected();
        
        String pass = getRandomPassword(lenght, useLowerCase, useUpperCase, useNumbers, useSpecial);
        
        if(pass == null) return;
        
        txtPassword.setText(pass);
    }//GEN-LAST:event_updateRandomPass

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        dlgCategories ct = new dlgCategories(this.parent);
        ct.setVisible(true);
        refreshCategories();
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private static final SecureRandom random = new SecureRandom();
    
    private String getRandomPassword(int length, boolean useLowerCase, boolean useUpperCase, boolean useNumbers, boolean useSpecial) {
        StringBuilder passwordPool = new StringBuilder();
        
        if (useLowerCase) passwordPool.append("abcdefghijklmnopqrstuvwxyz");
        if (useUpperCase) passwordPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (useNumbers) passwordPool.append("1234567890");
        if (useSpecial) passwordPool.append("!@#$%&*-_");

        if (passwordPool.length() == 0) {
            return null;
        }

        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordPool.length());
            password.append(passwordPool.charAt(index));
        }

        return password.toString();
    }
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(dlgPasswordEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgPasswordEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgPasswordEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgPasswordEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
    private javax.swing.JComboBox<String> cbxCategories;
    private javax.swing.JCheckBox cbxLower;
    private javax.swing.JCheckBox cbxNumbr;
    private javax.swing.JCheckBox cbxSpecl;
    private javax.swing.JCheckBox cbxUpper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlGenerateRandom;
    private javax.swing.JSlider sldPassLenght;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtServiceName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
