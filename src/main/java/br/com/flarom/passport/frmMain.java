package br.com.flarom.passport;

import br.com.flarom.passport.Dialogs.dlgCategories;
import br.com.flarom.passport.Dialogs.dlgNoteEditor;
import br.com.flarom.passport.Dialogs.dlgPasswordEditor;
import br.com.flarom.passport.MiscDialogs.dlgTextInput;
import br.com.flarom.passport.LogonDialogs.dlgLogin;
import br.com.flarom.passport.Helpers.KeyboardHelper;
import br.com.flarom.passport.Objects.pnlPassword;
import br.com.flarom.passport.Objects.Category;
import br.com.flarom.passport.Objects.Password;
import br.com.flarom.passport.Objects.User;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints; 
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.flywaydb.core.Flyway;

public class frmMain extends javax.swing.JFrame {

    private User loggedUser;

    public frmMain() {
        initComponents();

        login();

        loadPasswords();
        loadCategories();

        updateScrollBar();

        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setShortcutButton(btnAdd, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnSearch, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnFilter, KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnSettings, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
    }

    private void login() {
        dlgLogin dl = new dlgLogin(this);

        User u = dl.LogIn();

        if (u == null) {
            System.exit(0);
        }

        loggedUser = User.getLoggedUser();
    }

    private void loadPasswords() {
        pnlPasswords.removeAll();

        try {
            ArrayList<Password> userPasswords = Password.ListFromUser(loggedUser.getId_user());

            for (Password p : userPasswords) {
                pnlPassword pass = new pnlPassword(p);

                pnlPasswords.add(pass);
            }

            updateScrollBar();

            if (pnlPasswords.getComponentCount() == 0) {
                pnlPasswords.add(pnlPlaceholder);
                updateScrollBar();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadCategories() {
        popTag.removeAll();

        popTag.add(mnuTitle2);
        popTag.add(separator2);

        try {
            ArrayList<Category> userCategories = Category.ListFromUser(loggedUser.getId_user());

            for (Category c : userCategories) {
                JMenuItem mnuCategory = new JMenuItem(c.getName());
                Color catColor = Color.decode(c.getColor());

                ImageIcon icon = getCategoryIcon(catColor);
                mnuCategory.setIcon(icon);

                mnuCategory.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        Filter(c.getName());
                    }
                });

                popTag.add(mnuCategory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        popTag.add(mnuRemoveTag);
        mnuRemoveTag.setIcon(getCategoryIcon(Color.white));
        popTag.add(separator3);
        popTag.add(mnuManageTags);
    }

    private ImageIcon getCategoryIcon(Color color) {
        int diameter = 9;
        BufferedImage img = new BufferedImage(diameter + 2, diameter + 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gradient = new GradientPaint(0, 0, color.brighter(), diameter, diameter, color.darker());
        g.setPaint(gradient);
        g.fillOval(0, 0, diameter + 1, diameter + 1);

        g.dispose();

        return new ImageIcon(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popNew = new javax.swing.JPopupMenu();
        mnuTitle = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        mnuNewPassword = new javax.swing.JMenuItem();
        mnuNewNote = new javax.swing.JMenuItem();
        mnuNewCreditCard = new javax.swing.JMenuItem();
        popTag = new javax.swing.JPopupMenu();
        mnuTitle2 = new javax.swing.JMenuItem();
        separator2 = new javax.swing.JPopupMenu.Separator();
        mnuRemoveTag = new javax.swing.JMenuItem();
        separator3 = new javax.swing.JPopupMenu.Separator();
        mnuManageTags = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        btnFilter = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        btnSearch = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnSettings = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPasswords = new javax.swing.JPanel();
        pnlPlaceholder = new javax.swing.JPanel();
        lblPlaceholderTitle = new javax.swing.JLabel();
        lblPlaceholderDescription = new javax.swing.JLabel();
        btnPlaceholderNew = new javax.swing.JButton();

        mnuTitle.setText("Create new");
        mnuTitle.setEnabled(false);
        popNew.add(mnuTitle);
        popNew.add(separator);

        mnuNewPassword.setText("Password");
        mnuNewPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        popNew.add(mnuNewPassword);

        mnuNewNote.setText("Text note");
        mnuNewNote.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuNewNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewNoteActionPerformed(evt);
            }
        });
        popNew.add(mnuNewNote);

        mnuNewCreditCard.setText("Credit card");
        mnuNewCreditCard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        popNew.add(mnuNewCreditCard);

        mnuTitle2.setText("Tags");
        mnuTitle2.setEnabled(false);
        popTag.add(mnuTitle2);
        popTag.add(separator2);

        mnuRemoveTag.setText("Everything");
        mnuRemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRemoveTagActionPerformed(evt);
            }
        });
        popTag.add(mnuRemoveTag);
        popTag.add(separator3);

        mnuManageTags.setText("Manage tags");
        mnuManageTags.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuManageTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuManageTagsActionPerformed(evt);
            }
        });
        popTag.add(mnuManageTags);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Passport");
        setMinimumSize(new java.awt.Dimension(364, 250));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnAdd.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnAdd.setForeground(java.awt.Color.white);
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
        jToolBar1.add(filler4);

        btnFilter.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnFilter.setForeground(java.awt.Color.white);
        btnFilter.setMnemonic('f');
        btnFilter.setText("");
        btnFilter.setToolTipText("Tags (Ctrl+T)");
        btnFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFilter.setFocusable(false);
        btnFilter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFilter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFilterMousePressed(evt);
            }
        });
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFilter);
        jToolBar1.add(filler5);

        btnSearch.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnSearch.setForeground(java.awt.Color.white);
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
        btnSettings.setForeground(java.awt.Color.white);
        btnSettings.setMnemonic('p');
        btnSettings.setText("");
        btnSettings.setToolTipText("Settings (F1)");
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSettings.setFocusable(false);
        btnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSettings);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlPasswords.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlPasswords.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pnlPasswordsAncestorResized(evt);
            }
        });
        pnlPasswords.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 7, 7));

        pnlPlaceholder.setBackground(new java.awt.Color(43, 43, 43));
        pnlPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));
        pnlPlaceholder.setPreferredSize(new java.awt.Dimension(286, 123));

        lblPlaceholderTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPlaceholderTitle.setForeground(java.awt.Color.white);
        lblPlaceholderTitle.setText("No secrets here");

        lblPlaceholderDescription.setText("how about adding the first one?");

        btnPlaceholderNew.setBackground(new java.awt.Color(70, 206, 252));
        btnPlaceholderNew.setForeground(java.awt.Color.black);
        btnPlaceholderNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/passportSimbolic.png"))); // NOI18N
        btnPlaceholderNew.setText("Start now");
        btnPlaceholderNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPlaceholderNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceholderNewActionPerformed(evt);
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

        pnlPasswords.add(pnlPlaceholder);

        jScrollPane1.setViewportView(pnlPasswords);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dlgPasswordEditor dlg = new dlgPasswordEditor(this);
        dlg.Create();
        loadPasswords();
        loadCategories();
    }//GEN-LAST:event_btnAddActionPerformed

    private void pnlPasswordsAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_pnlPasswordsAncestorResized
        updateScrollBar();
    }//GEN-LAST:event_pnlPasswordsAncestorResized

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        dlgTextInput dlg = new dlgTextInput(this);
        String searchTerm = dlg.Show("Search", "Enter what are you looking for bellow:", "\ue11a", "Search");

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            setTitle("Passport");
            for (Component c : pnlPasswords.getComponents()) {
                c.setVisible(true);
            }
            return;
        }

        setTitle("Search results for \"" + searchTerm + "\" - Passport");

        for (Component c : pnlPasswords.getComponents()) {
            if (c instanceof pnlPassword) {
                pnlPassword passwordPanel = (pnlPassword) c;
                Password p = passwordPanel.getPassword();

                if (p.getService_name().toLowerCase().startsWith(searchTerm.toLowerCase())
                        || p.getUser_name().toLowerCase().startsWith(searchTerm.toLowerCase())) {
                    c.setVisible(true);
                } else {
                    c.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void Filter(String category) {
        if (category == null || category.trim().isEmpty()) {
            setTitle("Passport");
            for (Component c : pnlPasswords.getComponents()) {
                c.setVisible(true);
            }
            return;
        }

        setTitle("Filter results for \"" + category + "\" - Passport");

        for (Component c : pnlPasswords.getComponents()) {
            if (c instanceof pnlPassword) {
                pnlPassword passwordPanel = (pnlPassword) c;
                Password p = passwordPanel.getPassword();
                Category cat = Category.Read(p.getId_category());

                if (cat.getName().toLowerCase().startsWith(category.toLowerCase())) {
                    c.setVisible(true);
                } else {
                    c.setVisible(false);
                }
            }
        }
    }

    private void btnAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMousePressed
        popNew.show(btnAdd, jToolBar1.getLocation().x + jToolBar1.getWidth(), btnAdd.getLocation().y);
    }//GEN-LAST:event_btnAddMousePressed

    private void mnuManageTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuManageTagsActionPerformed
        dlgCategories ce = new dlgCategories(this);
        ce.setVisible(true);
        loadCategories();
    }//GEN-LAST:event_mnuManageTagsActionPerformed

    private void btnAddActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed1
        popNew.show(btnAdd, jToolBar1.getLocation().x + jToolBar1.getWidth(), btnAdd.getLocation().y);
    }//GEN-LAST:event_btnAddActionPerformed1

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        frmSettings s = new frmSettings();
        s.setLocation(this.getLocation());
        s.setSize(this.getSize());
        s.setVisible(true);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnPlaceholderNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceholderNewActionPerformed
        popNew.show(pnlPasswords, btnPlaceholderNew.getLocation().x, btnPlaceholderNew.getLocation().y);
    }//GEN-LAST:event_btnPlaceholderNewActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        popTag.show(jToolBar1, jToolBar1.getLocation().x + jToolBar1.getWidth(), btnFilter.getLocation().y);
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnFilterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMousePressed
        popTag.show(jToolBar1, jToolBar1.getLocation().x + jToolBar1.getWidth(), btnFilter.getLocation().y);
    }//GEN-LAST:event_btnFilterMousePressed

    private void mnuRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRemoveTagActionPerformed
        Filter(null);
    }//GEN-LAST:event_mnuRemoveTagActionPerformed

    private void mnuNewNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewNoteActionPerformed
        dlgNoteEditor ne = new dlgNoteEditor(this);
        ne.Create();
    }//GEN-LAST:event_mnuNewNoteActionPerformed

    private void updateScrollBar() {
        int buttonHeight = 123;
        int buttonWidth = 286;
        int spacing = 5;
        int lineHeight = buttonHeight + spacing;

        int availableWidth = pnlPasswords.getWidth();

        int buttonsPerLine = availableWidth / (buttonWidth + spacing);

        int totalButtons = pnlPasswords.getComponentCount();

        int rows = (int) Math.ceil((double) totalButtons / buttonsPerLine);

        int preferredHeight = rows * lineHeight;

        pnlPasswords.setPreferredSize(new Dimension(pnlPasswords.getPreferredSize().width, preferredHeight));

        pnlPasswords.revalidate();
        pnlPasswords.repaint();
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            Properties properties = new Properties();

            properties.load(new FileInputStream("src/main/resources/laf/passportlaf.properties"));

            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                if (value.contains(",")) {
                    String[] rgb = value.split(",");
                    UIManager.put(key, new Color(
                            Integer.parseInt(rgb[0].trim()),
                            Integer.parseInt(rgb[1].trim()),
                            Integer.parseInt(rgb[2].trim())
                    ));
                } else {
                    UIManager.put(key, Color.decode(value));
                }
            }

        } catch (IOException | NumberFormatException | UnsupportedLookAndFeelException e) {
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
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPlaceholderDescription;
    private javax.swing.JLabel lblPlaceholderTitle;
    private javax.swing.JMenuItem mnuManageTags;
    private javax.swing.JMenuItem mnuNewCreditCard;
    private javax.swing.JMenuItem mnuNewNote;
    private javax.swing.JMenuItem mnuNewPassword;
    private javax.swing.JMenuItem mnuRemoveTag;
    private javax.swing.JMenuItem mnuTitle;
    private javax.swing.JMenuItem mnuTitle2;
    private javax.swing.JPanel pnlPasswords;
    private javax.swing.JPanel pnlPlaceholder;
    private javax.swing.JPopupMenu popNew;
    private javax.swing.JPopupMenu popTag;
    private javax.swing.JPopupMenu.Separator separator;
    private javax.swing.JPopupMenu.Separator separator2;
    private javax.swing.JPopupMenu.Separator separator3;
    // End of variables declaration//GEN-END:variables
}
