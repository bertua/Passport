package br.com.flarom.passport.Dialogs;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import static br.com.flarom.passport.Helpers.MiscHelper.decryptPassword;
import static br.com.flarom.passport.Helpers.MiscHelper.encryptPassword;
import static br.com.flarom.passport.Helpers.MiscHelper.openWebsite;
import br.com.flarom.passport.Objects.Category;
import br.com.flarom.passport.Objects.Note;
import br.com.flarom.passport.Objects.Password;
import br.com.flarom.passport.Objects.User;
import com.github.rjeschke.txtmark.Processor;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;

public class dlgNoteEditor extends javax.swing.JDialog {

    private java.awt.Frame parent;

    public dlgNoteEditor(java.awt.Frame parent) {
        super(parent, true);
        this.parent = parent;
        
        initComponents();

        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);

        refreshCategories();
        refreshPasswords();

        txtDocument.getDocument().addDocumentListener(new DocumentListener() {
            private void renderHTML() {
                String md = txtDocument.getText();
                String html = Processor.process(md);

                txtPreview.setText(html);
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                renderHTML();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                renderHTML();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();
        cbxPassword = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDocument = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPreview = new javax.swing.JEditorPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Text note - Passport");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Note Details");

        jPanel2.setBackground(new java.awt.Color(43, 43, 43));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jLabel2.setText("Title:");

        jLabel3.setText("Related password:");

        jLabel8.setText("Tag:");

        btnAddCategory.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnAddCategory.setText("");
        btnAddCategory.setToolTipText("Show password");
        btnAddCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddCategory.setPreferredSize(new java.awt.Dimension(22, 22));
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxPassword, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTitle)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxCategory, 0, 356, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCategory))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Note");

        btnOk.setBackground(new java.awt.Color(70, 206, 252));
        btnOk.setForeground(java.awt.Color.black);
        btnOk.setText("OK");
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jScrollPane2.setToolTipText("");
        jScrollPane2.setName(""); // NOI18N

        txtDocument.setBackground(new java.awt.Color(43, 43, 43));
        txtDocument.setColumns(20);
        txtDocument.setRows(5);
        jScrollPane2.setViewportView(txtDocument);

        jTabbedPane1.addTab("Edit", jScrollPane2);

        txtPreview.setEditable(false);
        txtPreview.setBackground(java.awt.Color.white);
        txtPreview.setContentType("text/html"); // NOI18N
        txtPreview.setForeground(java.awt.Color.black);
        jScrollPane1.setViewportView(txtPreview);

        jTabbedPane1.addTab("Preview", jScrollPane1);

        jLabel5.setText("Markdown is supported.");

        jLabel6.setForeground(new java.awt.Color(70, 206, 252));
        jLabel6.setText("Learn more");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk))
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private boolean confirmed = false;

    public void Create() {
        this.setVisible(true);

        if (confirmed) {
            try {
                int id_user = User.getLoggedUser().getId_user();
                int id_category = userCategories.get(cbxCategory.getSelectedIndex()).getId_category();
                String title = txtTitle.getText();
                String document = encryptPassword(txtDocument.getText());
                Timestamp create_date = new Timestamp(System.currentTimeMillis());
                String color = userCategories.get(cbxCategory.getSelectedIndex()).getColor();

                Note n = new Note();

                n.setId_user(id_user);
                n.setId_category(id_category);
                n.setTitle(title);
                n.setDocument(document);
                n.setCreate_date(create_date);
                n.setEdit_date(create_date);
                n.setView_date(create_date);
                n.setColor(color);

                if (cbxPassword.getSelectedIndex() != 0) {
                    int id_password = userPasswords.get(cbxPassword.getSelectedIndex() - 1).getId_password();
                    n.setId_password(id_password);
                }

                n.Create();
            } catch (Exception ex) {
                Logger.getLogger(dlgNoteEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Note Edit(Note n) {
        try {
            txtTitle.setText(n.getTitle());
            if (Password.Read(n.getId_password()) != null) {
                cbxCategory.setSelectedItem(Password.Read(n.getId_password()).getService_name());
            }
            if (Category.Read(n.getId_category()) != null) {
                cbxCategory.setSelectedItem(Category.Read(n.getId_category()).getName());
            }
            txtDocument.setText(decryptPassword(n.getDocument()));

            this.setVisible(true);

            if (confirmed) {
                int id_category = userCategories.get(cbxCategory.getSelectedIndex()).getId_category();
                String title = txtTitle.getText();
                String document = encryptPassword(txtDocument.getText());
                Timestamp edit_date = new Timestamp(System.currentTimeMillis());

                n.setId_category(id_category);
                n.setTitle(title);
                n.setDocument(document);
                n.setEdit_date(edit_date);

                if (cbxPassword.getSelectedIndex() != 0) {
                    int id_password = userPasswords.get(cbxPassword.getSelectedIndex() - 1).getId_password();
                    n.setId_password(id_password);
                }

                n.Update();
                return n;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        dlgCategories ct = new dlgCategories(this.parent);
        ct.setVisible(true);
        refreshCategories();
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (txtTitle.getText().isBlank()) {
            JOptionPane.showMessageDialog(parent, "Title cannot be empty");
            return;
        }
        if (cbxCategory.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Category cannot be empty");
            return;
        }
        if (txtDocument.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Write something... don't be shy!");
            return;
        }

        confirmed = true;
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmed = false;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        openWebsite(rootPane, "https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax");
    }//GEN-LAST:event_jLabel6MouseClicked

    private ArrayList<Password> userPasswords = new ArrayList<Password>();

    private void refreshPasswords() {
        userPasswords.clear();
        cbxPassword.removeAllItems();

        cbxPassword.addItem("(None)");
        try {
            ArrayList<Password> passwords = Password.ListFromUser(User.getLoggedUser().getId_user());
            for (Password pss : passwords) {
                userPasswords.add(pss);
                cbxPassword.addItem(pss.getService_name());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private ArrayList<Category> userCategories = new ArrayList<Category>();

    private void refreshCategories() {
        userCategories.clear();
        cbxCategory.removeAllItems();

        ArrayList<Category> categories = Category.ListFromUser(User.getLoggedUser().getId_user());
        for (Category cat : categories) {
            userCategories.add(cat);
            cbxCategory.addItem(cat.getName());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgNoteEditor dialog = new dlgNoteEditor(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JComboBox<String> cbxPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txtDocument;
    private javax.swing.JEditorPane txtPreview;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
