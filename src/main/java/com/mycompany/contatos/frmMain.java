package com.mycompany.contatos;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.contatos.classes.FileManager;
import com.mycompany.contatos.classes.Contact;
import com.mycompany.contatos.classes.SearchQuerry;
import com.mycompany.contatos.dialogs.*;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
    Main frame
    Contains all functions of the application and UI to control them
 */
public class frmMain extends javax.swing.JFrame {

    private boolean isModified = false; // used to check if the current file is modified.

    public frmMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnuCopy2 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnuEdit2 = new javax.swing.JMenuItem();
        mnuDelete2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContacts = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnSearch = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuNew = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuOpen = new javax.swing.JMenuItem();
        mnuSave = new javax.swing.JMenuItem();
        mnuSaveAs = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnuReload = new javax.swing.JMenuItem();
        mnuSeeFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAdd = new javax.swing.JMenuItem();
        mnuDelete = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuSearch = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuCopy = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuAbout = new javax.swing.JMenuItem();

        mnuCopy2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copy.png"))); // NOI18N
        mnuCopy2.setText("Copiar célula");
        mnuCopy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCopy2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuCopy2);
        jPopupMenu1.add(jSeparator7);

        mnuEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        mnuEdit2.setText("Editar");
        mnuEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEdit2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuEdit2);

        mnuDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove.png"))); // NOI18N
        mnuDelete2.setText("Remover");
        mnuDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDelete2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuDelete2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Meus Contatos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/icone.png"))).getImage());
        setMinimumSize(new java.awt.Dimension(200, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "E-Mail", "Endereço", "Categoria"
            }
        ));
        tblContacts.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblContacts);

        jToolBar1.setRollover(true);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSave.setToolTipText("<html> <font size=\"4\">Salvar (Ctrl+S)</font><br> Salvar a lista de contatos ativa</html>");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N
        btnOpen.setToolTipText("<html>\n<font size=\"4\">Abrir (Ctrl+O)</font><br>\nAbrir uma lista de contatos existente\n</html>");
        btnOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpen.setFocusable(false);
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOpen);
        jToolBar1.add(jSeparator4);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAdd.setToolTipText("<html>\n<font size=\"4\">Adicionar (Ctrl+B)</font><br>\nAdicionar um novo contato à lista de contatos\n</html>");
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

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove.png"))); // NOI18N
        btnDelete.setToolTipText("<html>\n<font size=\"4\">Remover (Delete)</font><br>\nRemover a seleção da lista de contatos\n</html>");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        btnEdit.setToolTipText("<html>\n<font size=\"4\">Editar (Ctrl+E)</font><br>\nEditar os valores da seleção da lista de contatos\n</html>");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator6);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        btnSearch.setToolTipText("<html>\n<font size=\"4\">Pesquisar (Ctrl+F)</font><br>\nIniciar uma busca por determinados valores\n</html>");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSearch);

        jMenu1.setText("Arquivo");

        mnuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new.png"))); // NOI18N
        mnuNew.setText("Novo");
        mnuNew.setToolTipText("Criar uma nova lista de contatos");
        mnuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewActionPerformed(evt);
            }
        });
        jMenu1.add(mnuNew);
        jMenu1.add(jSeparator2);

        mnuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N
        mnuOpen.setText("Abrir");
        mnuOpen.setToolTipText("Abrir uma lista de contatos existente");
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(mnuOpen);

        mnuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        mnuSave.setText("Salvar");
        mnuSave.setToolTipText("Salvar a lista de contatos ativa");
        mnuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSave);

        mnuSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/saveas.png"))); // NOI18N
        mnuSaveAs.setText("Salvar como");
        mnuSaveAs.setToolTipText("Salvar a lista de contatos com um novo nome ou formato");
        mnuSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSaveAs);
        jMenu1.add(jSeparator8);

        mnuReload.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        mnuReload.setText("Recarregar");
        mnuReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReloadActionPerformed(evt);
            }
        });
        jMenu1.add(mnuReload);

        mnuSeeFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folderopen.png"))); // NOI18N
        mnuSeeFile.setText("Ver arquivo");
        mnuSeeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSeeFileActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSeeFile);
        jMenu1.add(jSeparator1);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        mnuExit.setText("Sair");
        mnuExit.setToolTipText("Sair dos meus contatos");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        mnuAdd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        mnuAdd.setText("Adicionar");
        mnuAdd.setToolTipText("Adicionar um novo contato à lista de contatos");
        mnuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAdd);

        mnuDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        mnuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove.png"))); // NOI18N
        mnuDelete.setText("Remover");
        mnuDelete.setToolTipText("Remover a seleção da lista de contatos");
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuDelete);

        mnuEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        mnuEdit.setText("Editar");
        mnuEdit.setToolTipText("Editar os valores da seleção da lista de contatos");
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        jMenu2.add(mnuEdit);
        jMenu2.add(jSeparator3);

        mnuSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        mnuSearch.setText("Pesquisar");
        mnuSearch.setToolTipText("Iniciar uma busca por determinados valores");
        mnuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSearchActionPerformed(evt);
            }
        });
        jMenu2.add(mnuSearch);
        jMenu2.add(jSeparator5);

        mnuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copy.png"))); // NOI18N
        mnuCopy.setText("Copiar célula");
        mnuCopy.setToolTipText("Copiar os valores da seleção para a Area de Transferência");
        mnuCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCopyActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCopy);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        mnuAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about.png"))); // NOI18N
        mnuAbout.setText("Sobre");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });
        jMenu3.add(mnuAbout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //
    // Contact management
    //
    private void AddItem() {
        restoreOriginalData();
        Set<String> uniqueCategories = new HashSet<>();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblContacts.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String category = model.getValueAt(i, 4).toString();
            uniqueCategories.add(category);
        }

        String[] categoriesArray = uniqueCategories.toArray(new String[0]);

        dlgContactEditor editor = new dlgContactEditor(this, true);
        Contact con = editor.CreateContact(categoriesArray);

        if (con != null) {
            model.addRow(new Object[]{
                con.getName(),
                con.getTelephone(),
                con.getEmail(),
                con.getAddress(),
                con.getCategory()
            });

            if (originalData == null) {
                originalData = new String[model.getRowCount()][model.getColumnCount()];
            } else {
                String[][] newData = new String[model.getRowCount()][model.getColumnCount()];
                System.arraycopy(originalData, 0, newData, 0, originalData.length);
                originalData = newData;
            }

            int lastRow = model.getRowCount() - 1;
            originalData[lastRow] = new String[]{
                con.getName(),
                con.getTelephone(),
                con.getEmail(),
                con.getAddress(),
                con.getCategory()
            };

            isModified = true;
        }
    }

    private void EditItem() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblContacts.getModel();
        int selectedRow = tblContacts.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um contato para editar.", "Nada para editar", JOptionPane.WARNING_MESSAGE);
            return;
        }

        restoreOriginalData();

        Set<String> uniqueCategories = new HashSet<>();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String category = model.getValueAt(i, 4).toString();
            uniqueCategories.add(category);
        }

        String[] categoriesArray = uniqueCategories.toArray(new String[0]);

        dlgContactEditor editor = new dlgContactEditor(this, true);
        Contact con = new Contact();
        con.setName(model.getValueAt(selectedRow, 0).toString());
        con.setTelephone(model.getValueAt(selectedRow, 1).toString());
        con.setEmail(model.getValueAt(selectedRow, 2).toString());
        con.setAddress(model.getValueAt(selectedRow, 3).toString());
        con.setCategory(model.getValueAt(selectedRow, 4).toString());

        con = editor.EditContact(con, categoriesArray);

        if (con != null) {
            model.setValueAt(con.getName(), selectedRow, 0);
            model.setValueAt(con.getTelephone(), selectedRow, 1);
            model.setValueAt(con.getEmail(), selectedRow, 2);
            model.setValueAt(con.getAddress(), selectedRow, 3);
            model.setValueAt(con.getCategory(), selectedRow, 4);

            originalData[selectedRow] = new String[]{
                con.getName(),
                con.getTelephone(),
                con.getEmail(),
                con.getAddress(),
                con.getCategory()
            };

            isModified = true;
        }
    }

    private void DeleteItem() {
        int[] selectedRows = tblContacts.getSelectedRows();

        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um contato para remover.", "Nada para remover", JOptionPane.WARNING_MESSAGE);
            return;
        }

        restoreOriginalData();

        if (selectedRows.length > 1) {
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Você selecionou " + selectedRows.length + " itens. Deseja realmente deletá-los?",
                    "Confirmar deleção grande",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmation != JOptionPane.YES_OPTION) {
                return;
            }
        }

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblContacts.getModel();

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            int rowToRemove = selectedRows[i];
            String[][] newData = new String[originalData.length - 1][originalData[0].length];

            System.arraycopy(originalData, 0, newData, 0, rowToRemove);
            System.arraycopy(originalData, rowToRemove + 1, newData, rowToRemove, originalData.length - rowToRemove - 1);
            originalData = newData;

            model.removeRow(rowToRemove);

            isModified = true;
        }
    }

    private String[][] originalData;

    private void Filter() {
        restoreOriginalData();
        dlgSearch dlg = new dlgSearch(this);
        SearchQuerry querry = dlg.Search();

        if (querry == null) {
            if (originalData != null) {
                restoreOriginalData();
            }
            return;
        }

        String column = querry.getColumn();
        String cell = querry.getCell();

        int columnIndex = -1;
        javax.swing.table.TableModel model = tblContacts.getModel();

        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equalsIgnoreCase(column)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex == -1) {
            JOptionPane.showMessageDialog(null, "Coluna não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.util.List<String[]> filteredData = new java.util.ArrayList<>();

        if (originalData == null) {
            originalData = new String[model.getRowCount()][model.getColumnCount()];
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    originalData[i][j] = model.getValueAt(i, j).toString();
                }
            }
        }

        for (int i = 0; i < originalData.length; i++) {
            if (originalData[i][columnIndex].toLowerCase().contains(cell.toLowerCase())) {
                filteredData.add(originalData[i]);
            }
        }

        updateTable(filteredData);
    }

    private void restoreOriginalData() {
        if (originalData == null) {
            return;
        }

        updateTable(java.util.Arrays.asList(originalData));
    }

    private void updateTable(java.util.List<String[]> data) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblContacts.getModel();

        model.setRowCount(0);

        for (String[] row : data) {
            model.addRow(row);
        }
    }

    private void copy() {
        // copy the selected cell to the clipboard

        // get focused line and column
        int row = tblContacts.getSelectedRow();
        int col = tblContacts.getSelectedColumn();

        // check if there is a selected item
        if (row != -1 && col != -1) {
            Object cellValue = tblContacts.getValueAt(row, col);

            String cellText = cellValue.toString();

            // copy cell text to the clipboard
            StringSelection selection = new StringSelection(cellText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }

    //
    // File management
    //
    private String filepath;

    private void OpenFile() {
        // Open a .ctt file on tblContacts

        if (isModified) {
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza de que deseja abrir o arquivo?\nAlterações não salvas, no arquivo atual, serão perdidas.",
                    "Abrir arquivo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmation != JOptionPane.YES_OPTION) {
                return;
            }
        }

        FileManager fileManager = new FileManager();
        String filePath = fileManager.OpenFileDialog();

        if (filePath != null) {
            String[][] content = fileManager.ReadCtt(filePath);

            filepath = filePath;

            if (content != null) {
                String[] columnNames = {"Nome", "Telefone", "Email", "Endereço", "Categoria"};

                javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(content, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                tblContacts.setModel(model);

                originalData = new String[content.length][content[0].length];
                System.arraycopy(content, 0, originalData, 0, content.length);

                File file = new File(filePath);
                String fileName = file.getName();
                ChangeTitle(fileName);

                isModified = false;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void SaveFile() {
        restoreOriginalData();

        if (filepath == null) {
            SaveFileAs();
            return;
        }

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblContacts.getModel();
        String[][] content = new String[model.getRowCount()][model.getColumnCount()];

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                content[i][j] = model.getValueAt(i, j).toString();
            }
        }

        FileManager fileManager = new FileManager();
        fileManager.WriteCtt(filepath, content);

        isModified = false;
    }

    private void SaveFileAs() {
        restoreOriginalData();

        FileManager fileManager = new FileManager();
        String filePath = fileManager.SaveFileDialog();

        if (filePath != null) {
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblContacts.getModel();
            String[][] content = new String[model.getRowCount()][model.getColumnCount()];

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    content[i][j] = model.getValueAt(i, j).toString();
                }
            }

            fileManager.WriteCtt(filePath, content);

            filepath = filePath;
            ChangeTitle(new File(filepath).getName());
        }

        isModified = false;
    }

    private void Reload() {
        int confirmation = JOptionPane.showConfirmDialog(null,
                "Você tem certeza de que deseja recarregar o arquivo?\nAlterações não salvas, no estado atual, serão perdidas.",
                "Recarregar arquivo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmation != JOptionPane.YES_OPTION) {
            return;
        }

        FileManager fileManager = new FileManager();

        if (filepath != null) {
            String[][] content = fileManager.ReadCtt(filepath);

            if (content != null) {
                String[] columnNames = {"Nome", "Telefone", "Email", "Endereço", "Categoria"};

                javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(content, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                tblContacts.setModel(model);

                File file = new File(filepath);
                String fileName = file.getName();
                ChangeTitle(fileName);

                isModified = false;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void SeeFile() {
        if (filepath == null) return;

        File file = new File(filepath);
        if (file.exists()) {
            File parentDir = file.getParentFile();
            if (parentDir != null) {
                try {
                    Desktop.getDesktop().open(parentDir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "O arquivo '" + filepath + "' existe na memoria, mas não em seu computador.\nSalve o arquivo antes.", "Arquivo não existe", JOptionPane.WARNING_MESSAGE);
        }
    }
    //
    // UI interaction
    //

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddItem();
    }//GEN-LAST:event_btnAddActionPerformed

    private void mnuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddActionPerformed
        AddItem();
    }//GEN-LAST:event_mnuAddActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        OpenFile();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
        OpenFile();
    }//GEN-LAST:event_mnuOpenActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteItem();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
        DeleteItem();
    }//GEN-LAST:event_mnuDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Filter();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void mnuSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSearchActionPerformed
        Filter();
    }//GEN-LAST:event_mnuSearchActionPerformed

    private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
        dlgAbout dlg = new dlgAbout(this, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_mnuAboutActionPerformed

    private void mnuDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDelete2ActionPerformed
        DeleteItem();
    }//GEN-LAST:event_mnuDelete2ActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        safeExit();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditActionPerformed
        EditItem();
    }//GEN-LAST:event_mnuEditActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        EditItem();
    }//GEN-LAST:event_btnEditActionPerformed

    private void mnuEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEdit2ActionPerformed
        EditItem();
    }//GEN-LAST:event_mnuEdit2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        SaveFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed
        SaveFile();
    }//GEN-LAST:event_mnuSaveActionPerformed

    private void mnuSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveAsActionPerformed
        SaveFileAs();
    }//GEN-LAST:event_mnuSaveAsActionPerformed

    private void mnuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewActionPerformed
        newWindow();
    }//GEN-LAST:event_mnuNewActionPerformed

    private void mnuCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCopyActionPerformed
        copy();
    }//GEN-LAST:event_mnuCopyActionPerformed

    private void mnuCopy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCopy2ActionPerformed
        copy();
    }//GEN-LAST:event_mnuCopy2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        safeExit();
    }//GEN-LAST:event_formWindowClosing

    private void mnuReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReloadActionPerformed
        Reload();
    }//GEN-LAST:event_mnuReloadActionPerformed

    private void mnuSeeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSeeFileActionPerformed
        SeeFile();
    }//GEN-LAST:event_mnuSeeFileActionPerformed

    //
    // Other funcions
    //
    public static void main(String[] args) {
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
    }

    private void ChangeTitle(String title) {
        // update window title
        this.setTitle("Meus Contatos - " + title);

        if (title == null) {
            this.setTitle("Meus Contatos");
        }
    }

    private void newWindow() {
        if (isModified) {
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza de que deseja criar um novo arquivo?\nAlterações não salvas serão perdidas.",
                    "Criar novo arquivo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (confirmation != JOptionPane.YES_OPTION) {
                return;
            }
        }

        this.dispose();

        frmMain newFrame = new frmMain();
        newFrame.setVisible(true);
    }

    private void safeExit() {
        if (isModified) {
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza de que deseja sair?\nAlterações não salvas serão perdidas.",
                    "Sair",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmation != JOptionPane.YES_OPTION) {
                return;
            }
        }

        System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuAdd;
    private javax.swing.JMenuItem mnuCopy;
    private javax.swing.JMenuItem mnuCopy2;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuDelete2;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuEdit2;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuNew;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JMenuItem mnuReload;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JMenuItem mnuSaveAs;
    private javax.swing.JMenuItem mnuSearch;
    private javax.swing.JMenuItem mnuSeeFile;
    private javax.swing.JTable tblContacts;
    // End of variables declaration//GEN-END:variables
}
