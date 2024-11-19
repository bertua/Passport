package br.com.flarom.passport.Objects;

import java.awt.Color;

public class pnlCreditCard extends javax.swing.JPanel {

    private Color color;
    private CreditCard creditCard;

    public pnlCreditCard(CreditCard c) {
        this.creditCard = c;

        initComponents();

        lblIssuer.setText(creditCard.getIssuer());
        lblAlias.setText(creditCard.getAlias());

        updateColor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSidebar = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        lblAlias = new javax.swing.JTextField();
        lblIssuer = new javax.swing.JTextField();

        setBackground(new java.awt.Color(43, 43, 43));

        pnlSidebar.setBackground(new java.awt.Color(0, 0, 0));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(0, 30));

        btnOptions.setBackground(new java.awt.Color(0, 0, 0));
        btnOptions.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnOptions.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions.setText("");
        btnOptions.setToolTipText("Options");
        btnOptions.setBorder(null);
        btnOptions.setBorderPainted(false);
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOptionsMousePressed(evt);
            }
        });

        btnRead.setBackground(new java.awt.Color(0, 0, 0));
        btnRead.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnRead.setForeground(new java.awt.Color(255, 255, 255));
        btnRead.setText("");
        btnRead.setToolTipText("Read");
        btnRead.setBorder(null);
        btnRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        lblAlias.setEditable(false);
        lblAlias.setBackground(new java.awt.Color(43, 43, 43));
        lblAlias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAlias.setForeground(java.awt.Color.white);
        lblAlias.setText("Alias");
        lblAlias.setBorder(null);

        lblIssuer.setEditable(false);
        lblIssuer.setBackground(new java.awt.Color(43, 43, 43));
        lblIssuer.setText("Issuer");
        lblIssuer.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlias, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(lblIssuer)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIssuer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionsMousePressed
//        if (!cmnOptions.isVisible())
//        cmnOptions.show(btnOptions, btnOptions.getWidth(), -1);
    }//GEN-LAST:event_btnOptionsMousePressed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
//        try {
//            dlgDocumentView dv = new dlgDocumentView((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar), false);
//            updateViewDate();
//            dv.readMarkdown(decryptPassword(note.getDocument()), note.getTitle());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }//GEN-LAST:event_btnReadActionPerformed

    public void updateColor() {
        pnlSidebar.setBackground(this.color);
        btnOptions.setBackground(this.color);
        btnRead.setBackground(this.color);

        Color darker = this.color.darker().darker().darker().darker();

        float[] hsbVals = Color.RGBtoHSB(darker.getRed(), darker.getGreen(), darker.getBlue(), null);

        hsbVals[1] *= 0.5f;

        Color desaturated = Color.getHSBColor(hsbVals[0], hsbVals[1], hsbVals[2]);

        this.setBackground(desaturated);
        lblAlias.setBackground(desaturated);
        lblIssuer.setBackground(desaturated);

        double luminance = (0.299 * this.color.getRed() + 0.587 * this.color.getGreen() + 0.114 * this.color.getBlue()) / 255;
        Color textColor = luminance > 0.5 ? Color.BLACK : Color.WHITE;

        btnOptions.setForeground(textColor);
        btnRead.setForeground(textColor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnRead;
    private javax.swing.JTextField lblAlias;
    private javax.swing.JTextField lblIssuer;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}
