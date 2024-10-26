package br.com.flarom.passport;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import org.flywaydb.core.Flyway;

public class frmMain extends javax.swing.JFrame {

    public frmMain() {
        initComponents();
        pnlPassword pnl = new pnlPassword();
        pnlPassword pnl2 = new pnlPassword("Google", "Flarom", "123", "#EB3324");
        pnlPassword pnl3 = new pnlPassword("Google", "Flarom", "123", "#ffff00");
        pnlPasswordsContainer.add(pnl);
        pnlPasswordsContainer.add(pnl2);
        pnlPasswordsContainer.add(pnl3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 200));
        btnFilter = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 200));
        btnSearch = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnSettings = new javax.swing.JButton();
        pnlPasswordsContainer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblPlaceholderTitle = new javax.swing.JLabel();
        lblPlaceholderDescription = new javax.swing.JLabel();
        btnPlaceholderNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Passport");

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnAdd.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnAdd.setMnemonic('n');
        btnAdd.setText("");
        btnAdd.setToolTipText("New password");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);
        jToolBar1.add(filler2);

        btnFilter.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnFilter.setMnemonic('f');
        btnFilter.setText("");
        btnFilter.setToolTipText("Filter");
        btnFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilter.setFocusable(false);
        btnFilter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFilter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnFilter);
        jToolBar1.add(filler3);

        btnSearch.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnSearch.setMnemonic('s');
        btnSearch.setText("");
        btnSearch.setToolTipText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSearch);
        jToolBar1.add(filler1);

        btnSettings.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnSettings.setMnemonic('p');
        btnSettings.setText("");
        btnSettings.setToolTipText("Settings");
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSettings.setFocusable(false);
        btnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSettings);

        pnlPasswordsContainer.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlPasswordsContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 194, 194)));
        jPanel2.setPreferredSize(new java.awt.Dimension(286, 123));

        lblPlaceholderTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPlaceholderTitle.setText("No secrets here");

        lblPlaceholderDescription.setText("how about adding the first one?");

        btnPlaceholderNew.setBackground(new java.awt.Color(34, 133, 225));
        btnPlaceholderNew.setForeground(java.awt.Color.white);
        btnPlaceholderNew.setText("New password");
        btnPlaceholderNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlaceholderNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaceholderTitle)
                    .addComponent(lblPlaceholderDescription)
                    .addComponent(btnPlaceholderNew))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlaceholderTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlaceholderDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnPlaceholderNew)
                .addContainerGap())
        );

        pnlPasswordsContainer.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPasswordsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPasswordsContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dlgPasswordEditor dlg = new dlgPasswordEditor(this);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
        
        Flyway.configure()
                .dataSource("jdbc:sqlite:appPsswrd.db", "", "")
                .load()
                .migrate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnPlaceholderNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSettings;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPlaceholderDescription;
    private javax.swing.JLabel lblPlaceholderTitle;
    private javax.swing.JPanel pnlPasswordsContainer;
    // End of variables declaration//GEN-END:variables
}
