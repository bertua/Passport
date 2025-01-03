package br.com.flarom.passport.Dialogs.Misc;

import br.com.flarom.passport.Helpers.KeyboardHelper;
import static br.com.flarom.passport.Helpers.MiscHelper.openWebsite;
import com.github.rjeschke.txtmark.Processor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.event.HyperlinkEvent;

public class dlgDocumentView extends javax.swing.JDialog {

    private String htmlHead = """
                              <head>
                                <style>
                                    h1, h2, h3, h4, h5, h6{
                                        font-weight: 1;
                                    }
                                    h1, h2, h3 {
                                        border-bottom: 1px solid gray;
                                    }
                                    table {
                                        width: 100%;
                                        border-collapse: collapse;
                                        margin-bottom: 1em;
                                    }
                                    th, td {
                                        
                                        padding: 8px;
                                        text-align: left;
                                    }
                                    tr {
                                        border: 1px solid #ddd;
                                    }
                                </style>
                              </head>
                              """;
    private String htmlBody = """
                              <body>
                                %s
                              </body>
                              """;
    
    public dlgDocumentView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        KeyboardHelper kh = new KeyboardHelper(rootPane);
        kh.setCloseOnEscape(this);

        textArea.addHyperlinkListener(e -> {
            if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())) {
                String url = e.getDescription();
                openWebsite(rootPane, url);
            }
        });
    }

    /**
     * show a markdown document in a window
     * @param md document content
     * @param title window title
     */
    public void readMarkdown(String md, String title) {
        if (md.isBlank()) {
            return;
        }

        String html = htmlHead + String.format(htmlBody, Processor.process(md));

        this.setTitle(title);
        textArea.setText(html);

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popDocument = new javax.swing.JPopupMenu();
        mnuCopy = new javax.swing.JMenuItem();
        mnuSelectAll = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuFontIncrease = new javax.swing.JMenuItem();
        mnuFontDecrease = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JEditorPane();

        mnuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuCopy.setText("Copy");
        mnuCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCopyActionPerformed(evt);
            }
        });
        popDocument.add(mnuCopy);

        mnuSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSelectAll.setText("Select all");
        mnuSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSelectAllActionPerformed(evt);
            }
        });
        popDocument.add(mnuSelectAll);
        popDocument.add(jSeparator1);

        mnuFontIncrease.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuFontIncrease.setText("Increase font size");
        mnuFontIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFontIncreaseActionPerformed(evt);
            }
        });
        popDocument.add(mnuFontIncrease);

        mnuFontDecrease.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuFontDecrease.setText("Decrease font size");
        mnuFontDecrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFontDecreaseActionPerformed(evt);
            }
        });
        popDocument.add(mnuFontDecrease);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setBackground(java.awt.Color.white);

        textArea.setEditable(false);
        textArea.setBackground(java.awt.Color.white);
        textArea.setContentType("text/html"); // NOI18N
        textArea.setForeground(java.awt.Color.black);
        textArea.setComponentPopupMenu(popDocument);
        textArea.setSelectedTextColor(java.awt.Color.black);
        textArea.setSelectionColor(new java.awt.Color(70, 206, 252));
        jScrollPane2.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCopyActionPerformed
        String selected = textArea.getSelectedText();
        StringSelection stringSelection = new StringSelection(selected);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }//GEN-LAST:event_mnuCopyActionPerformed

    private void mnuSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSelectAllActionPerformed
        textArea.requestFocus();
        textArea.selectAll();
    }//GEN-LAST:event_mnuSelectAllActionPerformed

    private void mnuFontIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFontIncreaseActionPerformed
        changeFontSize(+5);
    }//GEN-LAST:event_mnuFontIncreaseActionPerformed

    private void mnuFontDecreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFontDecreaseActionPerformed
        changeFontSize(-5);
    }//GEN-LAST:event_mnuFontDecreaseActionPerformed

    /**
     * changes font size based on an modifier
     * @param sizeMod font size modifier, +1 to increase and -1 to decrease
     */
    private void changeFontSize(int sizeMod) {
        Font f = textArea.getFont();
        int newSize = f.getSize() + sizeMod;
        if (newSize > 0) {
            textArea.setFont(new Font(f.getName(), f.getStyle(), newSize));
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgDocumentView dialog = new dlgDocumentView(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuCopy;
    private javax.swing.JMenuItem mnuFontDecrease;
    private javax.swing.JMenuItem mnuFontIncrease;
    private javax.swing.JMenuItem mnuSelectAll;
    private javax.swing.JPopupMenu popDocument;
    private javax.swing.JEditorPane textArea;
    // End of variables declaration//GEN-END:variables
}
