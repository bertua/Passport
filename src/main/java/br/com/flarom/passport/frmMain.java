package br.com.flarom.passport;

import br.com.flarom.passport.Dialogs.Editors.dlgCategories;
import br.com.flarom.passport.Dialogs.Editors.dlgCreditCardEditor;
import br.com.flarom.passport.Dialogs.Editors.dlgNoteEditor;
import br.com.flarom.passport.Dialogs.Editors.dlgPasswordEditor;
import br.com.flarom.passport.Dialogs.Logon.dlgLock;
import br.com.flarom.passport.Dialogs.Misc.dlgTextInput;
import br.com.flarom.passport.Dialogs.Logon.dlgLogin;
import br.com.flarom.passport.Helpers.KeyboardHelper;
import br.com.flarom.passport.Helpers.SettingsHelper;
import br.com.flarom.passport.Objects.pnlPassword;
import br.com.flarom.passport.Objects.Category;
import br.com.flarom.passport.Objects.CreditCard;
import br.com.flarom.passport.Objects.Note;
import br.com.flarom.passport.Objects.Password;
import br.com.flarom.passport.Objects.User;
import br.com.flarom.passport.Objects.pnlCreditCard;
import br.com.flarom.passport.Objects.pnlNote;
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
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.flywaydb.core.Flyway;

public class frmMain extends javax.swing.JFrame {

    private User loggedUser;
    private SettingsHelper config = new SettingsHelper();
    private Timer logoutTimer;

    public frmMain() {
        initComponents();

        login();

        loadData();
        loadCategories();
        loadConfigs();

        updateScrollBar();

        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setShortcutButton(btnAdd, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnSearch, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnFilter, KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK));
        kh.setShortcutButton(btnSettings, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
    }

    // starts a login operation, if the user is null (login failed) closes the program
    private void login() {
        dlgLogin dl = new dlgLogin(this);

        User u = dl.LogIn();

        if (u == null) {
            System.exit(0);
        }

        loggedUser = User.getLoggedUser();
    }

    private void loadConfigs() {
        boolean useLockButton = Boolean.parseBoolean(config.Read("useLockButton"));

        jSeparator1.setVisible(useLockButton);
        btnLock.setVisible(useLockButton);
    }

    // loads data (passwords, notes, credit cards) from the logged user, and displays it on the screen
    private void loadData() {
        pnlSecrets.removeAll();

        try {
            ArrayList<Password> userPasswords = Password.ListFromUser(loggedUser.getId_user());
            ArrayList<Note> userNotes = Note.ListFromUser(loggedUser.getId_user());
            ArrayList<CreditCard> userCreditCards = CreditCard.ListFromUser(loggedUser.getId_user());

            for (Password p : userPasswords) {
                pnlPassword pass = new pnlPassword(p);

                pnlSecrets.add(pass);
            }

            for (Note n : userNotes) {
                pnlNote note = new pnlNote(n);

                pnlSecrets.add(note);
            }

            for (CreditCard c : userCreditCards) {
                pnlCreditCard cred = new pnlCreditCard(c);

                pnlSecrets.add(cred);
            }

            if (pnlSecrets.getComponentCount() == 0) {
                pnlSecrets.add(pnlPlaceholder);
            }

            updateScrollBar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // loads data (categories) from the logged user and displays it on the tag menu
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

    // creates a decorative icon to the tag
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
        popContext = new javax.swing.JPopupMenu();
        mnuNew = new javax.swing.JMenu();
        mnuPassword = new javax.swing.JMenuItem();
        mnuNote = new javax.swing.JMenuItem();
        mnuCreditCard = new javax.swing.JMenuItem();
        mnuSearch = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        btnAdd = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        btnFilter = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        btnSearch = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        jSeparator1 = new javax.swing.JToolBar.Separator();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 7), new java.awt.Dimension(0, 7), new java.awt.Dimension(32767, 7));
        btnLock = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnSettings = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlSecrets = new javax.swing.JPanel();
        pnlPlaceholder = new javax.swing.JPanel();
        lblPlaceholderTitle = new javax.swing.JLabel();
        btnPlaceholderNew = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPlaceholderDescription = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();

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
        mnuNewCreditCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewCreditCardActionPerformed(evt);
            }
        });
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

        mnuNew.setText("New");

        mnuPassword.setText("Password");
        mnuPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        mnuNew.add(mnuPassword);

        mnuNote.setText("Text note");
        mnuNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewNoteActionPerformed(evt);
            }
        });
        mnuNew.add(mnuNote);

        mnuCreditCard.setText("Credit card");
        mnuNew.add(mnuCreditCard);

        popContext.add(mnuNew);

        mnuSearch.setText("Search");
        mnuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        popContext.add(mnuSearch);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Passport");
        setMinimumSize(new java.awt.Dimension(364, 250));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSecretsMousePressed(evt);
            }
        });
        jToolBar1.add(filler2);

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
        jToolBar1.add(filler6);
        jToolBar1.add(jSeparator1);
        jToolBar1.add(filler7);

        btnLock.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnLock.setForeground(java.awt.Color.white);
        btnLock.setMnemonic('l');
        btnLock.setText("");
        btnLock.setToolTipText("Lock");
        btnLock.setFocusable(false);
        btnLock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLockActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLock);
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
        jScrollPane1.setVerticalScrollBar(jScrollBar1);

        pnlSecrets.setComponentPopupMenu(popContext);
        pnlSecrets.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlSecrets.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlSecretsMousePressed(evt);
            }
        });
        pnlSecrets.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                pnlSecretsAncestorResized(evt);
            }
        });
        pnlSecrets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSecretsMousePressed(evt);
            }
        });
        pnlSecrets.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 7, 7));

        pnlPlaceholder.setBackground(new java.awt.Color(38, 54, 60));
        pnlPlaceholder.setPreferredSize(new java.awt.Dimension(286, 123));

        lblPlaceholderTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPlaceholderTitle.setForeground(java.awt.Color.white);
        lblPlaceholderTitle.setText("No secrets here");

        btnPlaceholderNew.setBackground(new java.awt.Color(70, 206, 252));
        btnPlaceholderNew.setForeground(java.awt.Color.black);
        btnPlaceholderNew.setText("Start now");
        btnPlaceholderNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPlaceholderNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceholderNewActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(70, 206, 252));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        lblPlaceholderDescription.setText("how about adding the first one?");

        javax.swing.GroupLayout pnlPlaceholderLayout = new javax.swing.GroupLayout(pnlPlaceholder);
        pnlPlaceholder.setLayout(pnlPlaceholderLayout);
        pnlPlaceholderLayout.setHorizontalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlaceholderNew)
                        .addContainerGap())
                    .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlaceholderDescription)
                            .addComponent(lblPlaceholderTitle))
                        .addContainerGap(90, Short.MAX_VALUE))))
        );
        pnlPlaceholderLayout.setVerticalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlaceholderTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlaceholderDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPlaceholderNew)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlSecrets.add(pnlPlaceholder);

        jScrollPane1.setViewportView(pnlSecrets);

        jScrollBar1.setBackground(new java.awt.Color(32, 32, 32));
        jScrollBar1.setBlockIncrement(25);
        jScrollBar1.setUnitIncrement(25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dlgPasswordEditor dlg = new dlgPasswordEditor(this);
        dlg.Create();
        loadData();
        loadCategories();
    }//GEN-LAST:event_btnAddActionPerformed

    private void pnlSecretsAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_pnlSecretsAncestorResized
        updateScrollBar();
    }//GEN-LAST:event_pnlSecretsAncestorResized

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        dlgTextInput dlg = new dlgTextInput(this);
        String searchTerm = dlg.Show("Search", "Enter what are you looking for bellow:", "\ue11a", "Search");

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            setTitle("Passport");
            for (Component c : pnlSecrets.getComponents()) {
                c.setVisible(true);
            }
            return;
        }

        setTitle("Search results for \"" + searchTerm + "\" - Passport");

        for (Component c : pnlSecrets.getComponents()) {
            if (c instanceof pnlPassword) {
                pnlPassword passwordPanel = (pnlPassword) c;
                Password p = passwordPanel.getPassword();

                if (p.getService_name().toLowerCase().startsWith(searchTerm.toLowerCase())
                        || p.getUser_name().toLowerCase().startsWith(searchTerm.toLowerCase())) {
                    c.setVisible(true);
                } else {
                    c.setVisible(false);
                }
            } else if (c instanceof pnlNote) {
                pnlNote notePanel = (pnlNote) c;
                Note n = notePanel.getNote();

                try {
                    if (n.getTitle().toLowerCase().startsWith(searchTerm.toLowerCase())
                            || Password.Read(n.getId_password()).getService_name().toLowerCase().startsWith(searchTerm)) {
                        c.setVisible(true);
                    } else {
                        c.setVisible(false);
                    }
                } catch (Exception ex) {
                    c.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    // filters content based on a category search query
    private void Filter(String category) {
        if (category == null || category.trim().isEmpty()) {
            setTitle("Passport");
            for (Component c : pnlSecrets.getComponents()) {
                c.setVisible(true);
            }
            return;
        }

        setTitle("Filter results for \"" + category + "\" - Passport");

        for (Component c : pnlSecrets.getComponents()) {
            if (c instanceof pnlPassword) {
                pnlPassword passwordPanel = (pnlPassword) c;
                Password p = passwordPanel.getPassword();
                Category cat = Category.Read(p.getId_category());

                if (cat.getName().toLowerCase().startsWith(category.toLowerCase())) {
                    c.setVisible(true);
                } else {
                    c.setVisible(false);
                }
            } else if (c instanceof pnlNote) {
                pnlNote notePanel = (pnlNote) c;
                Note n = notePanel.getNote();
                Category cat = Category.Read(n.getId_category());

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
        dlgSettings s = new dlgSettings(this);
        s.setLocation(this.getLocation());
        s.setSize(this.getSize());
        s.setVisible(true);

        loadConfigs();
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnPlaceholderNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceholderNewActionPerformed
        popNew.show(pnlSecrets, btnPlaceholderNew.getLocation().x, btnPlaceholderNew.getLocation().y);
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
        loadData();
        loadCategories();
    }//GEN-LAST:event_mnuNewNoteActionPerformed

    private void mnuNewCreditCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewCreditCardActionPerformed
        dlgCreditCardEditor ce = new dlgCreditCardEditor(this);
        ce.Create();
        loadData();
    }//GEN-LAST:event_mnuNewCreditCardActionPerformed

    private void pnlSecretsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSecretsMousePressed

    }//GEN-LAST:event_pnlSecretsMousePressed

    private void btnLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLockActionPerformed
        dlgLock lock = new dlgLock(this);
        lock.Lock();
    }//GEN-LAST:event_btnLockActionPerformed

    // updates the scroll bar size, based on window size and objects size
    private void updateScrollBar() {
        int objectHeight = 123;
        int objectWidth = 286;
        int spacing = 7;
        int lineHeight = objectHeight + spacing;

        int availableWidth = pnlSecrets.getWidth();

        int objectsPerLine = availableWidth / (objectWidth + spacing);

        int totalObjects = pnlSecrets.getComponentCount();

        int rows = (int) Math.ceil((double) totalObjects / objectsPerLine);

        int preferredHeight = rows * lineHeight;

        pnlSecrets.setPreferredSize(new Dimension(pnlSecrets.getPreferredSize().width, preferredHeight));

        pnlSecrets.revalidate();
        pnlSecrets.repaint();
    }

    public static void main(String args[]) {
        // show window
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLock;
    private javax.swing.JButton btnPlaceholderNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSettings;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPlaceholderDescription;
    private javax.swing.JLabel lblPlaceholderTitle;
    private javax.swing.JMenuItem mnuCreditCard;
    private javax.swing.JMenuItem mnuManageTags;
    private javax.swing.JMenu mnuNew;
    private javax.swing.JMenuItem mnuNewCreditCard;
    private javax.swing.JMenuItem mnuNewNote;
    private javax.swing.JMenuItem mnuNewPassword;
    private javax.swing.JMenuItem mnuNote;
    private javax.swing.JMenuItem mnuPassword;
    private javax.swing.JMenuItem mnuRemoveTag;
    private javax.swing.JMenuItem mnuSearch;
    private javax.swing.JMenuItem mnuTitle;
    private javax.swing.JMenuItem mnuTitle2;
    private javax.swing.JPanel pnlPlaceholder;
    private javax.swing.JPanel pnlSecrets;
    private javax.swing.JPopupMenu popContext;
    private javax.swing.JPopupMenu popNew;
    private javax.swing.JPopupMenu popTag;
    private javax.swing.JPopupMenu.Separator separator;
    private javax.swing.JPopupMenu.Separator separator2;
    private javax.swing.JPopupMenu.Separator separator3;
    // End of variables declaration//GEN-END:variables
}
