package br.com.flarom.passport;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class pnlPassword extends javax.swing.JPanel {

    private Integer id;
    private String serviceName;
    private String userName;
    private String password;
    private Color color;

    public pnlPassword() {
        this(null, null, null, "#000000");
    }

    public pnlPassword(String serviceName, String userName, String password, String colorHex) {
        this.serviceName = serviceName;
        this.userName = userName;
        this.password = password;
        this.color = Color.decode(colorHex);

        initComponents();

        lblServiceName.setText(this.serviceName);
        lblUsername.setText(this.userName);
        lblPassword.setText(this.password);

        updateColor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmnOptions = new javax.swing.JPopupMenu();
        mnuCopy = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuColor = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenuItem();
        mnuProperties = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuDelete = new javax.swing.JMenuItem();
        pnlSidebar = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        lblServiceName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JPasswordField();

        mnuCopy.setText("Copy");
        mnuCopy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuCopy);
        cmnOptions.add(jSeparator2);

        mnuColor.setText("Change color");
        mnuColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuColorActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuColor);

        mnuEdit.setText("Edit");
        mnuEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmnOptions.add(mnuEdit);

        mnuProperties.setText("Properties");
        mnuProperties.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmnOptions.add(mnuProperties);
        cmnOptions.add(jSeparator1);

        mnuDelete.setText("Delete");
        mnuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmnOptions.add(mnuDelete);

        setBackground(java.awt.Color.white);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 194, 194)));
        setMaximumSize(new java.awt.Dimension(286, 123));
        setMinimumSize(new java.awt.Dimension(286, 123));

        pnlSidebar.setBackground(new java.awt.Color(0, 0, 0));

        btnOptions.setBackground(new java.awt.Color(0, 0, 0));
        btnOptions.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnOptions.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions.setText("");
        btnOptions.setToolTipText("Options");
        btnOptions.setBorder(null);
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOptionsMousePressed(evt);
            }
        });

        btnCopy.setBackground(new java.awt.Color(0, 0, 0));
        btnCopy.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnCopy.setForeground(new java.awt.Color(255, 255, 255));
        btnCopy.setText("");
        btnCopy.setToolTipText("Copy");
        btnCopy.setBorder(null);
        btnCopy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(0, 0, 0));
        btnView.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("");
        btnView.setToolTipText("Show password");
        btnView.setBorder(null);
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(btnCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblServiceName.setEditable(false);
        lblServiceName.setBackground(java.awt.Color.white);
        lblServiceName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblServiceName.setText("Service name");
        lblServiceName.setBorder(null);

        lblUsername.setEditable(false);
        lblUsername.setBackground(java.awt.Color.white);
        lblUsername.setText("Username");
        lblUsername.setBorder(null);

        lblPassword.setEditable(false);
        lblPassword.setBackground(java.awt.Color.white);
        lblPassword.setText("Password");
        lblPassword.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServiceName, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Crypto">     
    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }
    
    public static String encrypt(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedText = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }
    
     public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedText);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="database">
    
    //</editor-fold>
     
    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        StringSelection stringSelection = new StringSelection(password);

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_btnCopyActionPerformed

    private boolean showing = false;
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if (showing) {
            lblPassword.setEchoChar('\u2022');
            btnView.setToolTipText("Show password");
            btnView.setText("\ue052");
        } else {
            lblPassword.setEchoChar((char) 0);
            btnView.setToolTipText("Hide password");
            btnView.setText("\ued1a");
        }
        showing = !showing;
    }//GEN-LAST:event_btnViewActionPerformed

    private void mnuColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuColorActionPerformed
        dlgColor dlg = new dlgColor((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar));
        Color newColor = dlg.getColor();

        if (newColor == null) {
            return;
        }

        this.color = newColor;
        updateColor();
    }//GEN-LAST:event_mnuColorActionPerformed

    private void btnOptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionsMousePressed
        if(!cmnOptions.isVisible()) cmnOptions.show(btnOptions, btnOptions.getWidth(), -1);
    }//GEN-LAST:event_btnOptionsMousePressed

    public void updateColor() {
        pnlSidebar.setBackground(this.color);
        btnOptions.setBackground(this.color);
        btnCopy.setBackground(this.color);
        btnView.setBackground(this.color);

        double luminance = (0.299 * this.color.getRed() + 0.587 * this.color.getGreen() + 0.114 * this.color.getBlue()) / 255;
        Color textColor = luminance > 0.5 ? Color.BLACK : Color.WHITE;

        btnOptions.setForeground(textColor);
        btnCopy.setForeground(textColor);
        btnView.setForeground(textColor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnView;
    private javax.swing.JPopupMenu cmnOptions;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPasswordField lblPassword;
    private javax.swing.JTextField lblServiceName;
    private javax.swing.JTextField lblUsername;
    private javax.swing.JMenuItem mnuColor;
    private javax.swing.JMenuItem mnuCopy;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuProperties;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}
