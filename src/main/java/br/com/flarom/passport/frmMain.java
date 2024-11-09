package br.com.flarom.passport;

import br.com.flarom.passport.Objects.pnlPassword;
import br.com.flarom.passport.Dialogs.dlgCategories;
import br.com.flarom.passport.MiscDialogs.dlgTextInput;
import br.com.flarom.passport.Dialogs.dlgPasswordEditor;
import br.com.flarom.passport.Helpers.KeyboardHelper;
import br.com.flarom.passport.LogonDialogs.dlgLogin;
import br.com.flarom.passport.Objects.Password;
import br.com.flarom.passport.Objects.User;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import org.flywaydb.core.Flyway;

public class frmMain extends javax.swing.JFrame {

    private User loggedUser;

    public frmMain() {
        initComponents();

        login();

        loadPasswords();

        updateScrollBar();
        
        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setShortcutButton(btnAdd, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnSearch, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
    }

    private void login() {
        dlgLogin dl = new dlgLogin(this);
        User u = dl.LogIn();

        if (u == null) System.exit(0);

        loggedUser = User.getLoggedUser();
    }

    private void loadPasswords() {
        pnlPasswordsContainer.removeAll();
        
        try {
            ArrayList<Password> userPasswords = Password.ListFromUser(loggedUser.getId_user());

            for (Password p : userPasswords) {
                String service_name = p.getService_name();
                String user_name = p.getUser_name();
                String password = p.getPassword();
                String color = p.getColor();
                
                pnlPassword pass = new pnlPassword(service_name, user_name, password, color);

                pnlPasswordsContainer.add(pass);

                updateScrollBar();
            }

        } catch (Exception ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuNew = new javax.swing.JPopupMenu();
        mnuTitle = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        mnuNewPassword = new javax.swing.JMenuItem();
        mnuNewCreditCard = new javax.swing.JMenuItem();
        mnuNewNote = new javax.swing.JMenuItem();
        mnuNewCategory = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 200));
        btnFilter = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 200));
        btnSearch = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnSettings = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPasswordsContainer = new javax.swing.JPanel();
        pnlPlaceholder = new javax.swing.JPanel();
        lblPlaceholderTitle = new javax.swing.JLabel();
        lblPlaceholderDescription = new javax.swing.JLabel();
        btnPlaceholderNew = new javax.swing.JButton();

        mnuTitle.setText("Create new");
        mnuTitle.setEnabled(false);
        mnuNew.add(mnuTitle);
        mnuNew.add(separator);

        mnuNewPassword.setText("Password");
        mnuNewPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        mnuNew.add(mnuNewPassword);

        mnuNewCreditCard.setText("Credit card");
        mnuNewCreditCard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuNew.add(mnuNewCreditCard);

        mnuNewNote.setText("Text note");
        mnuNewNote.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuNew.add(mnuNewNote);

        mnuNewCategory.setText("Category");
        mnuNewCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewCategoryActionPerformed(evt);
            }
        });
        mnuNew.add(mnuNewCategory);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Passport");
        setMinimumSize(new java.awt.Dimension(364, 250));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnAdd.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnAdd.setMnemonic('n');
        btnAdd.setText("");
        btnAdd.setToolTipText("Create new (Ctrl+N)");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddMousePressed(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed1(evt);
            }
        });
        jToolBar1.add(btnAdd);
        jToolBar1.add(filler2);

        btnFilter.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnFilter.setMnemonic('f');
        btnFilter.setText("");
        btnFilter.setToolTipText("Filter");
        btnFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFilter.setFocusable(false);
        btnFilter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFilter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnFilter);
        jToolBar1.add(filler3);

        btnSearch.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnSearch.setMnemonic('s');
        btnSearch.setText("");
        btnSearch.setToolTipText("Search (Ctrl+F)");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSearch);
        jToolBar1.add(filler1);

        btnSettings.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnSettings.setMnemonic('p');
        btnSettings.setText("");
        btnSettings.setToolTipText("Settings");
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSettings.setFocusable(false);
        btnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSettings);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlPasswordsContainer.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlPasswordsContainer.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                pnlPasswordsContainerComponentAdded(evt);
            }
        });
        pnlPasswordsContainer.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pnlPasswordsContainerAncestorResized(evt);
            }
        });
        pnlPasswordsContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pnlPlaceholder.setBackground(new java.awt.Color(251, 251, 251));
        pnlPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(194, 194, 194)));
        pnlPlaceholder.setPreferredSize(new java.awt.Dimension(286, 123));

        lblPlaceholderTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPlaceholderTitle.setText("No secrets here");

        lblPlaceholderDescription.setText("how about adding the first one?");

        btnPlaceholderNew.setBackground(new java.awt.Color(34, 133, 225));
        btnPlaceholderNew.setForeground(java.awt.Color.white);
        btnPlaceholderNew.setText("New password");
        btnPlaceholderNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPlaceholderNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPlaceholderLayout = new javax.swing.GroupLayout(pnlPlaceholder);
        pnlPlaceholder.setLayout(pnlPlaceholderLayout);
        pnlPlaceholderLayout.setHorizontalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaceholderTitle)
                    .addComponent(lblPlaceholderDescription)
                    .addComponent(btnPlaceholderNew))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        pnlPlaceholderLayout.setVerticalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlaceholderTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlaceholderDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnPlaceholderNew)
                .addContainerGap())
        );

        pnlPasswordsContainer.add(pnlPlaceholder);

        jScrollPane1.setViewportView(pnlPasswordsContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dlgPasswordEditor dlg = new dlgPasswordEditor(this);
        dlg.Create();
        loadPasswords();
    }//GEN-LAST:event_btnAddActionPerformed

    private void pnlPasswordsContainerComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnlPasswordsContainerComponentAdded
        if (pnlPasswordsContainer.getComponentCount() >= 2) {
            pnlPasswordsContainer.remove(pnlPlaceholder);
            updateScrollBar();
        }
    }//GEN-LAST:event_pnlPasswordsContainerComponentAdded

    private void pnlPasswordsContainerAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_pnlPasswordsContainerAncestorResized
        updateScrollBar();
    }//GEN-LAST:event_pnlPasswordsContainerAncestorResized

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        dlgTextInput dlg = new dlgTextInput(this);
        String searchTerm = dlg.Show("Search", "Enter what are you looking for bellow:", "\ue11a", "Search");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMousePressed
        mnuNew.show(btnAdd, btnAdd.getLocation().x + btnAdd.getWidth(), btnAdd.getLocation().y);
    }//GEN-LAST:event_btnAddMousePressed

    private void mnuNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewCategoryActionPerformed
        dlgCategories ce = new dlgCategories(this);
        ce.setVisible(true);
    }//GEN-LAST:event_mnuNewCategoryActionPerformed

    private void btnAddActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed1
        mnuNew.show(btnAdd, btnAdd.getLocation().x + btnAdd.getWidth(), btnAdd.getLocation().y);
    }//GEN-LAST:event_btnAddActionPerformed1

    private void updateScrollBar() {
        int buttonHeight = 123;
        int buttonWidth = 286;
        int spacing = 5;
        int lineHeight = buttonHeight + spacing;

        int availableWidth = pnlPasswordsContainer.getWidth();

        int buttonsPerLine = availableWidth / (buttonWidth + spacing);

        int totalButtons = pnlPasswordsContainer.getComponentCount();

        int rows = (int) Math.ceil((double) totalButtons / buttonsPerLine);

        int preferredHeight = rows * lineHeight;

        pnlPasswordsContainer.setPreferredSize(new Dimension(pnlPasswordsContainer.getPreferredSize().width, preferredHeight));

        pnlPasswordsContainer.revalidate();
        pnlPasswordsContainer.repaint();
    }

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
                .dataSource("jdbc:sqlite:passportdata.db", "", "")
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPlaceholderDescription;
    private javax.swing.JLabel lblPlaceholderTitle;
    private javax.swing.JPopupMenu mnuNew;
    private javax.swing.JMenuItem mnuNewCategory;
    private javax.swing.JMenuItem mnuNewCreditCard;
    private javax.swing.JMenuItem mnuNewNote;
    private javax.swing.JMenuItem mnuNewPassword;
    private javax.swing.JMenuItem mnuTitle;
    private javax.swing.JPanel pnlPasswordsContainer;
    private javax.swing.JPanel pnlPlaceholder;
    private javax.swing.JPopupMenu.Separator separator;
    // End of variables declaration//GEN-END:variables
}
