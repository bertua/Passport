package br.com.flarom.passport.Dialogs;

import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class dlgCreditCardEditor extends javax.swing.JDialog {

    public dlgCreditCardEditor(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    private boolean confirmed = false;

    public void Create() {
        this.setVisible(true);

        if (confirmed) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHolder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIssuer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCVV = new javax.swing.JFormattedTextField();
        chk4digit = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        txtExpirationDate = new javax.swing.JFormattedTextField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Credit card - Passport");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Credit Card Details");

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jLabel2.setText("Alias:");

        jLabel3.setText("Name on card:");

        jLabel4.setText("Issuer:");

        jLabel5.setText("Card number:");

        try {
            txtNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("CVV:");

        try {
            txtCVV.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        chk4digit.setText("Use 4-Digit CVV");
        chk4digit.setToolTipText("Select this option if your card has a 4-digit CVV. Some card providers use 4 digits for added security.");
        chk4digit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk4digitActionPerformed(evt);
            }
        });

        jLabel7.setText("Expiry date (Month/Year):");

        try {
            txtExpirationDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 48, Short.MAX_VALUE))
                            .addComponent(txtExpirationDate)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(chk4digit))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtAlias)
                    .addComponent(txtIssuer, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(txtHolder)
                    .addComponent(txtNumber))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssuer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk4digit)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chk4digitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk4digitActionPerformed
        try {
            if (chk4digit.isSelected()) {
                MaskFormatter cvvFormatter = new MaskFormatter("####");
                txtCVV.setFormatterFactory(new DefaultFormatterFactory(cvvFormatter));
            } else {
                MaskFormatter cvvFormatter = new MaskFormatter("###");
                txtCVV.setFormatterFactory(new DefaultFormatterFactory(cvvFormatter));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_chk4digitActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
//        if (txtTitle.getText().isBlank()) {
//            JOptionPane.showMessageDialog(parent, "Title cannot be empty");
//            return;
//        }
//        if (cbxCategory.getSelectedItem() == null) {
//            JOptionPane.showMessageDialog(rootPane, "Category cannot be empty");
//            return;
//        }
//        if (txtDocument.getText().isBlank()) {
//            JOptionPane.showMessageDialog(rootPane, "Write something... don't be shy!");
//            return;
//        }

        confirmed = true;
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgCreditCardEditor dialog = new dlgCreditCardEditor(new javax.swing.JFrame());
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
    private javax.swing.JCheckBox chk4digit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JFormattedTextField txtCVV;
    private javax.swing.JFormattedTextField txtExpirationDate;
    private javax.swing.JTextField txtHolder;
    private javax.swing.JTextField txtIssuer;
    private javax.swing.JFormattedTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
