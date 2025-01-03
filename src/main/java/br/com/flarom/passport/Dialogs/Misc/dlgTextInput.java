package br.com.flarom.passport.Dialogs.Misc;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import java.awt.Color;

public class dlgTextInput extends javax.swing.JDialog {

    public dlgTextInput(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        
        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setConfirmButton(btnOk);
        kh.setCancelButton(btnCancel);
    }

    private boolean confirmed = false;
    
    /**
     * get an string typed by the user
     * @param title window title
     * @param instructions information about what should be inserted
     * @param icon Segoe Fluent Icons character displayed as icon
     * @param okButtonText text of the confirm button
     * @return the string typed by the user | null if the dialog is closed
     */
    public String Show(String title, String instructions, String icon, String okButtonText){
        this.setTitle(title);
        lblInstructions.setText(instructions);
        lblIcon.setText(icon);
        btnOk.setText(okButtonText);
        btnOk.setBackground(new Color(70,206,252));
        
        this.setVisible(true);
        
        if (confirmed){
            return txtInput.getText();
        }
        
        return null;
    }
    
    /**
     * get an string typed by the user
     * @param title window title
     * @param instructions information about what should be inserted
     * @param icon Segoe Fluent Icons character displayed as icon
     * @param okButtonText text of the confirm button
     * @param isPositive if false, the confirm button will be shown in red
     * @return the string typed by the user | null if the dialog is closed
     */
    public String Show(String title, String instructions, String icon, String okButtonText, boolean isPositive){
        this.setTitle(title);
        lblInstructions.setText(instructions);
        lblIcon.setText(icon);
        btnOk.setText(okButtonText);
        btnOk.setBackground(new Color(70,206,252));
        if(!isPositive){
            btnOk.setBackground(new Color(252, 70, 70));
        }
        
        this.setVisible(true);
        
        if (confirmed){
            return txtInput.getText();
        }
        
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblInstructions = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(398, 113));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblIcon.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 36)); // NOI18N
        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setText("");

        lblInstructions.setText("Instructions");
        lblInstructions.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInput)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 158, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk))
                    .addComponent(lblInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
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
                new dlgTextInput(new javax.swing.JFrame()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
