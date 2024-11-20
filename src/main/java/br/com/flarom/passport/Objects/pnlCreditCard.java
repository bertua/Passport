package br.com.flarom.passport.Objects;

import static br.com.flarom.passport.Helpers.MiscHelper.colorToString;
import static br.com.flarom.passport.Helpers.MiscHelper.stringToColor;
import br.com.flarom.passport.MiscDialogs.dlgColorInput;
import br.com.flarom.passport.MiscDialogs.dlgTableView;
import java.awt.Color;
import java.awt.Container;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class pnlCreditCard extends javax.swing.JPanel {

    private Color color;
    private CreditCard card;

    public pnlCreditCard(CreditCard c) {
        this.card = c;

        initComponents();

        lblIssuer.setText(card.getIssuer());
        lblAlias.setText(card.getAlias());
        lblHolder.setText(card.getHolder());
        color = stringToColor(card.getColor());

        updateColor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popOptions = new javax.swing.JPopupMenu();
        mnuRead = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuColor = new javax.swing.JMenuItem();
        mnuProperties = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuDelete = new javax.swing.JMenuItem();
        pnlSidebar = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        lblAlias = new javax.swing.JTextField();
        lblIssuer = new javax.swing.JTextField();
        lblHolder = new javax.swing.JTextField();

        mnuRead.setText("Read");
        mnuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        popOptions.add(mnuRead);
        popOptions.add(jSeparator2);

        mnuColor.setText("Change color");
        mnuColor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuColorActionPerformed(evt);
            }
        });
        popOptions.add(mnuColor);

        mnuProperties.setText("Properties");
        mnuProperties.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPropertiesActionPerformed(evt);
            }
        });
        popOptions.add(mnuProperties);
        popOptions.add(jSeparator1);

        mnuDelete.setForeground(new java.awt.Color(252, 70, 70));
        mnuDelete.setText("Delete");
        mnuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        popOptions.add(mnuDelete);

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

        lblHolder.setEditable(false);
        lblHolder.setBackground(new java.awt.Color(43, 43, 43));
        lblHolder.setText("Holder");
        lblHolder.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlias, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(lblIssuer)
                    .addComponent(lblHolder)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIssuer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionsMousePressed
        if (!popOptions.isVisible())
        popOptions.show(btnOptions, btnOptions.getWidth(), -1);
    }//GEN-LAST:event_btnOptionsMousePressed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
            dlgTableView tv = new dlgTableView((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar), false);
            
            String[][] table = {
                {"Property", "Value"},
                {"Label", card.getAlias()},
                {"Issuer", card.getIssuer()},
                {"Card number", card.getNumber()},
                {"CVV", card.getCvv()},
                {"Expiry date (Month/Year)", card.getExpiration_date()},
                {"Holder", card.getHolder()}
            };
            
            updateViewDate();
            
            tv.displayMatrix(table, card.getAlias());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnReadActionPerformed

    private void mnuColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuColorActionPerformed
        dlgColorInput ci = new dlgColorInput((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar));
        Color newColor = ci.getColor();

        if (newColor == null) {
            return;
        }

        this.color = newColor;
        updateColor();

        try {
            card.setColor(colorToString(newColor));
            card.Update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mnuColorActionPerformed

    private void mnuPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPropertiesActionPerformed
        try {
            dlgTableView tv = new dlgTableView((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar), false);
//
//            String tag = "Null";
//            String relatedPassword = "Null";
//
//            if (Category.Read(note.getId_category()) != null) {
//                tag = Category.Read(note.getId_category()).getName();
//            }
//            if (Password.Read(note.getId_password()) != null) {
//                relatedPassword = Password.Read(note.getId_password()).getService_name();
//            }
//
            String[][] table = {
                {"Property", "Value"},
                {"Owner", "@" + User.Read(card.getId_user()).getUsername()},
                {"Alias", card.getAlias()},
//                {"Tag", tag},
//                {"Related password", relatedPassword},
                {"Created in", card.getCreation_date().toString()},
//                {"Last edited in", note.getEdit_date().toString()},
                {"Last viewed in", card.getView_date().toString()}
            };

            tv.displayMatrix(table, card.getAlias() + " properties");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnuPropertiesActionPerformed

    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(btnOptions, "Are you sure you want to delete '" + card.getAlias() + "'?", "Delete note", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        card.Delete();
        Container c = this.getParent();
        c.remove(this);
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_mnuDeleteActionPerformed

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
        lblHolder.setBackground(desaturated);

        double luminance = (0.299 * this.color.getRed() + 0.587 * this.color.getGreen() + 0.114 * this.color.getBlue()) / 255;
        Color textColor = luminance > 0.5 ? Color.BLACK : Color.WHITE;

        btnOptions.setForeground(textColor);
        btnRead.setForeground(textColor);
    }
    
    private void updateViewDate(){
        try {
            this.card.setView_date(new Timestamp(System.currentTimeMillis()));
            this.card.Update();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnRead;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField lblAlias;
    private javax.swing.JTextField lblHolder;
    private javax.swing.JTextField lblIssuer;
    private javax.swing.JMenuItem mnuColor;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuProperties;
    private javax.swing.JMenuItem mnuRead;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPopupMenu popOptions;
    // End of variables declaration//GEN-END:variables
}
