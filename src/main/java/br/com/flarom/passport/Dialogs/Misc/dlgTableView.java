package br.com.flarom.passport.Dialogs.Misc;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class dlgTableView extends javax.swing.JDialog {

    public dlgTableView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);
    }

    public void displayMatrix(String[][] matrix, String title) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        this.setTitle(title);

        String[] columnNames = matrix[0];
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (int i = 1; i < matrix.length; i++) {
            model.addRow(matrix[i]);
        }

        jTable.setModel(model);
        setVisible(true);
    }

    public void displayArrayListMatrix(ArrayList<ArrayList<String>> matrix, String title) {
        if (matrix == null || matrix.isEmpty()) {
            return;
        }
        
        this.setTitle(title);

        ArrayList<String> firstRow = matrix.get(0);
        String[] columnNames = firstRow.toArray(new String[0]);
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (int i = 1; i < matrix.size(); i++) {
            ArrayList<String> row = matrix.get(i);
            model.addRow(row.toArray(new String[0]));
        }

        jTable.setModel(model);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable.setBackground(java.awt.Color.white);
        jTable.setForeground(java.awt.Color.black);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setEnabled(false);
        jTable.setGridColor(new java.awt.Color(204, 204, 204));
        jTable.setShowGrid(false);
        jTable.setShowHorizontalLines(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgTableView dialog = new dlgTableView(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
