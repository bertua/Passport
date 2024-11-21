package br.com.flarom.passport.Dialogs.Editors;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import br.com.flarom.passport.Objects.Category;
import br.com.flarom.passport.Objects.User;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class dlgCategories extends javax.swing.JDialog {

    private User loggedUser;
    private ArrayList<Category> userCategories = new ArrayList<Category>();
    private DefaultListModel lstCategoriesModel;
    private java.awt.Frame parent;
    
    public dlgCategories(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        
        this.parent = parent;
        loggedUser = User.getLoggedUser();
        
        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);
        
        refresh();
    }
    
    private void refresh(){
        lstCategoriesModel = new DefaultListModel();
        
        userCategories.clear();
        lstCategoriesModel.clear();
        
        ArrayList<Category> categories = Category.ListFromUser(loggedUser.getId_user());
        
        for(Category cat : categories){
            userCategories.add(cat);
            lstCategoriesModel.add(lstCategoriesModel.size(), cat.getName());
        }
        
        lstCategories.setModel(lstCategoriesModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategories = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tags - Passport");
        setMinimumSize(new java.awt.Dimension(400, 306));

        jLabel1.setFont(new java.awt.Font("SegoeUI", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Tags");

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        lstCategories.setBackground(new java.awt.Color(43, 43, 43));
        lstCategories.setBorder(null);
        lstCategories.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lstCategories.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstCategories);

        btnAdd.setBackground(new java.awt.Color(70, 206, 252));
        btnAdd.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnAdd.setForeground(java.awt.Color.black);
        btnAdd.setText("");
        btnAdd.setToolTipText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnEdit.setText("");
        btnEdit.setToolTipText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 18)); // NOI18N
        btnDelete.setText("");
        btnDelete.setToolTipText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dlgCategoryEditor ce = new dlgCategoryEditor(this.parent);
        Category cat = ce.Create();
        
        if(cat == null) return;
        
        cat.Create();
        
        refresh();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(lstCategories.isSelectionEmpty()) return;
        
        dlgCategoryEditor ce = new dlgCategoryEditor(this.parent);
        Category cat = userCategories.get(lstCategories.getSelectedIndex());
        
        cat = ce.Update(cat);
        
        if (cat == null) return;
        
        cat.Update();
        
        refresh();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(lstCategories.isSelectionEmpty()) return;
        
        Category cat = userCategories.get(lstCategories.getSelectedIndex());
        
        int count = Category.Count(cat.getId_category());
        
        int confirmed = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + cat.getName() +"?\nYou have " + count + " items using this tag", "Deleting", JOptionPane.YES_NO_OPTION);
        if(confirmed != JOptionPane.YES_OPTION) return;
        
        cat.Delete();
        refresh();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgCategories dialog = new dlgCategories(new javax.swing.JFrame());
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstCategories;
    // End of variables declaration//GEN-END:variables
}
