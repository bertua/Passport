package br.com.flarom.passport.MiscDialogs;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class dlgColorInput extends javax.swing.JDialog {

    private String[] defaultColors = new String[]{
        "#ffb900",
        "#ff8c00",
        "#f7630c",
        "#ca5010",
        "#da3b01",
        "#ef6950",
        "#d13438",
        "#ff4343",
        "#e74856",
        "#e81123",
        "#ea005e",
        "#c30052",
        "#e3008c",
        "#bf0077",
        "#c239b3",
        "#9a0089",
        "#0078d4",
        "#0063b1",
        "#8e8cd8",
        "#6b69d6",
        "#8764b8",
        "#744da9",
        "#b146c2",
        "#881798",
        "#0099bc",
        "#2d7d9a",
        "#46CEFC",
        "#038387",
        "#00b294",
        "#018574",
        "#00cc6a",
        "#10893e",
        "#7a7574",
        "#5d5a58",
        "#68768a",
        "#515c6b",
        "#567c73",
        "#486860",
        "#498205",
        "#107c10",
        "#767676",
        "#4c4a48",
        "#69797e",
        "#4a5459",
        "#647c64",
        "#525e54",
        "#847545",
        "#7e735f",
        "#ffffff",
        "#e6e6e6",
        "#cccccc",
        "#b3b3b3",
        "#999999",
        "#666666",
        "#333333",
        "#000000",};
    private boolean confirmed = false;
    private Color selected;

    public dlgColorInput(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        
        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);
        
        for (String color : defaultColors) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(32, 32));
            btn.setBackground(Color.decode(color));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selected = Color.decode(color);
                    confirmed = true;
                    dispose();
                }
            });
            pnlColors.add(btn);
            updateScrollBar();
        }
    }

    public Color getColor() {
        this.setVisible(true);

        if (confirmed) {
            return selected;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlColors = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Color palette - Passport");
        setMinimumSize(new java.awt.Dimension(346, 426));
        setModal(true);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlColors.setBackground(new java.awt.Color(32, 32, 32));
        pnlColors.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlColors.setPreferredSize(new java.awt.Dimension(40, 1000));
        pnlColors.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pnlColorsAncestorResized(evt);
            }
        });
        jScrollPane1.setViewportView(pnlColors);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlColorsAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_pnlColorsAncestorResized
        updateScrollBar();
    }//GEN-LAST:event_pnlColorsAncestorResized

    private void updateScrollBar() {
        int buttonHeight = 32;
        int buttonWidth = 32;
        int spacing = 5;
        int lineHeight = buttonHeight + spacing;

        int availableWidth = pnlColors.getWidth();

        int buttonsPerLine = availableWidth / (buttonWidth + spacing);

        int totalButtons = pnlColors.getComponentCount();

        int rows = (int) Math.ceil((double) totalButtons / buttonsPerLine);

        int preferredHeight = rows * lineHeight;

        pnlColors.setPreferredSize(new Dimension(pnlColors.getPreferredSize().width, preferredHeight));

        pnlColors.revalidate();
        pnlColors.repaint();
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
            java.util.logging.Logger.getLogger(dlgColorInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgColorInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgColorInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgColorInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dlgColorInput(new javax.swing.JFrame()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlColors;
    // End of variables declaration//GEN-END:variables
}
