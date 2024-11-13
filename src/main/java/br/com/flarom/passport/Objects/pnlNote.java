package br.com.flarom.passport.Objects;

import static br.com.flarom.passport.Helpers.MiscHelper.stringToColor;
import br.com.flarom.passport.MiscDialogs.dlgTextView;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class pnlNote extends javax.swing.JPanel {

    private Color color;
    private Note note;
    
    public pnlNote(Note n) {
        this.note = n;
        
        initComponents();
        
        lblTitle.setText(n.getTitle());
        color = stringToColor(n.getColor());
        
        updateColor();
    }
    
    public void updateColor() {
        pnlTools.setBackground(this.color);
        btnOptions.setBackground(this.color);
        btnRead.setBackground(this.color);

        double luminance = (0.299 * this.color.getRed() + 0.587 * this.color.getGreen() + 0.114 * this.color.getBlue()) / 255;
        Color textColor = luminance > 0.5 ? Color.BLACK : Color.WHITE;

        btnOptions.setForeground(textColor);
        btnRead.setForeground(textColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmnOptions = new javax.swing.JPopupMenu();
        mnuRead = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuColor = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenuItem();
        mnuProperties = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuDelete = new javax.swing.JMenuItem();
        lblTitle = new javax.swing.JTextField();
        pnlTools = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        mnuRead.setText("Read");
        mnuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuRead);
        cmnOptions.add(jSeparator2);

        mnuColor.setText("Change color");
        mnuColor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuColorActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuColor);

        mnuEdit.setText("Edit");
        mnuEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuEdit);

        mnuProperties.setText("Properties");
        mnuProperties.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPropertiesActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuProperties);
        cmnOptions.add(jSeparator1);

        mnuDelete.setForeground(new java.awt.Color(220, 53, 69));
        mnuDelete.setText("Delete");
        mnuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuDelete);

        setBackground(new java.awt.Color(43, 43, 43));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        lblTitle.setEditable(false);
        lblTitle.setBackground(new java.awt.Color(43, 43, 43));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setForeground(java.awt.Color.white);
        lblTitle.setText("Title");
        lblTitle.setBorder(null);

        pnlTools.setBackground(new java.awt.Color(0, 0, 0));
        pnlTools.setPreferredSize(new java.awt.Dimension(0, 30));

        btnOptions.setBackground(new java.awt.Color(0, 0, 0));
        btnOptions.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnOptions.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions.setText("");
        btnOptions.setToolTipText("Options");
        btnOptions.setBorder(null);
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOptionsMousePressed(evt);
            }
        });

        btnRead.setBackground(new java.awt.Color(0, 0, 0));
        btnRead.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnRead.setForeground(new java.awt.Color(255, 255, 255));
        btnRead.setText("");
        btnRead.setToolTipText("Read");
        btnRead.setBorder(null);
        btnRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlToolsLayout = new javax.swing.GroupLayout(pnlTools);
        pnlTools.setLayout(pnlToolsLayout);
        pnlToolsLayout.setHorizontalGroup(
            pnlToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        pnlToolsLayout.setVerticalGroup(
            pnlToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToolsLayout.createSequentialGroup()
                .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(43, 43, 43));
        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton1.setText("Click to read");
        jButton1.setBorder(null);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTools, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 183, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTools, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mnuColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuColorActionPerformed
        
    }//GEN-LAST:event_mnuColorActionPerformed

    private void mnuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditActionPerformed
        
    }//GEN-LAST:event_mnuEditActionPerformed

    private void mnuPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPropertiesActionPerformed
        
    }//GEN-LAST:event_mnuPropertiesActionPerformed

    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
        
    }//GEN-LAST:event_mnuDeleteActionPerformed

    private void btnOptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionsMousePressed
        if (!cmnOptions.isVisible())
            cmnOptions.show(btnOptions, btnOptions.getWidth(), -1);
    }//GEN-LAST:event_btnOptionsMousePressed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        dlgTextView tv = new dlgTextView((JFrame) SwingUtilities.getWindowAncestor(pnlTools), false);
        tv.displayText(note.getDocument(), note.getTitle());
    }//GEN-LAST:event_btnReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnRead;
    private javax.swing.JPopupMenu cmnOptions;
    private javax.swing.JButton jButton1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField lblTitle;
    private javax.swing.JMenuItem mnuColor;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuProperties;
    private javax.swing.JMenuItem mnuRead;
    private javax.swing.JPanel pnlTools;
    // End of variables declaration//GEN-END:variables
}
