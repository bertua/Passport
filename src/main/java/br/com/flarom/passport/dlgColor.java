package br.com.flarom.passport;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class dlgColor extends javax.swing.JDialog {

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
        "#00b7c3",
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
        "#7e735f"
    };
    private boolean confirmed = false;
    private Color selected;

    public dlgColor(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
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

        pnlColors = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Color palette");

        pnlColors.setBackground(java.awt.Color.white);
        pnlColors.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 194, 194)));
        pnlColors.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlColors.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlColors, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlColors, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(dlgColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dlgColor(new javax.swing.JFrame()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlColors;
    // End of variables declaration//GEN-END:variables
}
