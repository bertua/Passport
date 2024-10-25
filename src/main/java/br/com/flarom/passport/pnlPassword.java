package br.com.flarom.passport;

import java.awt.Color;

public class pnlPassword extends javax.swing.JPanel {
    private String serviceName;
    private String userName;
    private String password;
    private Color color;
    
    public pnlPassword(String serviceName, String userName, String password, String colorHex) {
        this.serviceName = serviceName;
        this.userName = userName;
        this.password = password;
        this.color = Color.decode(colorHex);
        
        initComponents();
        
        lblServiceName.setText(this.serviceName);
        lblUsername.setText(this.userName);
        lblPassword.setText(this.password);
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSidebar = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        lblServiceName = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 194, 194)));
        setMaximumSize(new java.awt.Dimension(286, 123));
        setMinimumSize(new java.awt.Dimension(286, 123));

        pnlSidebar.setBackground(new java.awt.Color(0, 0, 0));

        btnOptions.setBackground(new java.awt.Color(0, 0, 0));
        btnOptions.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnOptions.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions.setText("");
        btnOptions.setBorder(null);
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCopy.setBackground(new java.awt.Color(0, 0, 0));
        btnCopy.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnCopy.setForeground(new java.awt.Color(255, 255, 255));
        btnCopy.setText("");
        btnCopy.setBorder(null);
        btnCopy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnView.setBackground(new java.awt.Color(0, 0, 0));
        btnView.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("");
        btnView.setBorder(null);
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        lblServiceName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblServiceName.setText("Service name");

        lblUsername.setText("User name");

        lblPassword.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServiceName, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServiceName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblServiceName;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}
