package br.com.flarom.passport.Objects;

import br.com.flarom.passport.Dialogs.dlgNoteEditor;
import static br.com.flarom.passport.Helpers.MiscHelper.colorToString;
import static br.com.flarom.passport.Helpers.MiscHelper.decryptPassword;
import static br.com.flarom.passport.Helpers.MiscHelper.stringToColor;
import br.com.flarom.passport.MiscDialogs.dlgColorInput;
import br.com.flarom.passport.MiscDialogs.dlgTableView;
import br.com.flarom.passport.MiscDialogs.dlgDocumentView;
import java.awt.Color;
import java.awt.Container;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class pnlNote extends javax.swing.JPanel {

    private Color color;
    private Note note;

    public pnlNote(Note n) {
        this.note = n;

        initComponents();

        lblTitle.setText(note.getTitle());
        color = stringToColor(note.getColor());

        updateColor();
        updateStatus();
    }

    public Note getNote(){
        return this.note;
    }
    
    public void updateColor() {
        pnlSidebar.setBackground(this.color);
        btnOptions.setBackground(this.color);
        btnRead.setBackground(this.color);

        Color darker = this.color.darker().darker().darker().darker();

        float[] hsbVals = Color.RGBtoHSB(darker.getRed(), darker.getGreen(), darker.getBlue(), null);

        hsbVals[1] *= 0.5f;

        Color desaturated = Color.getHSBColor(hsbVals[0], hsbVals[1], hsbVals[2]);

        this.setBackground(desaturated);
        lblTitle.setBackground(desaturated);

        double luminance = (0.299 * this.color.getRed() + 0.587 * this.color.getGreen() + 0.114 * this.color.getBlue()) / 255;
        Color textColor = luminance > 0.5 ? Color.BLACK : Color.WHITE;

        btnOptions.setForeground(textColor);
        btnRead.setForeground(textColor);
    }

    public void updateStatus() {
        int words = countWords();
        int subjects = countTitles();

        lblSubjects.setText("Subjects: " + subjects);
        lblWords.setText("Total words: " + words);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmnOptions = new javax.swing.JPopupMenu();
        mnuRead = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuColor = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenuItem();
        mnuProperties = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuDelete = new javax.swing.JMenuItem();
        lblTitle = new javax.swing.JTextField();
        pnlSidebar = new javax.swing.JPanel();
        btnOptions = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        lblSubjects = new javax.swing.JLabel();
        lblWords = new javax.swing.JLabel();

        mnuRead.setText("Read");
        mnuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuRead);
        cmnOptions.add(jSeparator2);

        mnuColor.setText("Change color");
        mnuColor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuColorActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuColor);

        mnuEdit.setText("Edit");
        mnuEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuEdit);

        mnuProperties.setText("Properties");
        mnuProperties.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPropertiesActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuProperties);
        cmnOptions.add(jSeparator1);

        mnuDelete.setForeground(new java.awt.Color(252, 70, 70));
        mnuDelete.setText("Delete");
        mnuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        cmnOptions.add(mnuDelete);

        setBackground(new java.awt.Color(43, 43, 43));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        lblTitle.setEditable(false);
        lblTitle.setBackground(new java.awt.Color(43, 43, 43));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setForeground(java.awt.Color.white);
        lblTitle.setText("Title");
        lblTitle.setBorder(null);

        pnlSidebar.setBackground(new java.awt.Color(0, 0, 0));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(0, 30));

        btnOptions.setBackground(new java.awt.Color(0, 0, 0));
        btnOptions.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnOptions.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions.setText("");
        btnOptions.setToolTipText("Options");
        btnOptions.setBorder(null);
        btnOptions.setBorderPainted(false);
        btnOptions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOptionsMousePressed(evt);
            }
        });

        btnRead.setBackground(new java.awt.Color(0, 0, 0));
        btnRead.setFont(new java.awt.Font("Segoe Fluent Icons", 0, 16)); // NOI18N
        btnRead.setForeground(new java.awt.Color(255, 255, 255));
        btnRead.setText("");
        btnRead.setToolTipText("Read");
        btnRead.setBorder(null);
        btnRead.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        lblSubjects.setText("jLabel1");

        lblWords.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubjects)
                            .addComponent(lblWords))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWords)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mnuColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuColorActionPerformed
        dlgColorInput ci = new dlgColorInput((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar));
        Color newColor = ci.getColor();

        if (newColor == null) {
            return;
        }

        this.color = newColor;
        updateColor();

        try {
            note.setColor(colorToString(newColor));
            note.Update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mnuColorActionPerformed

    private void mnuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditActionPerformed
        dlgNoteEditor ne = new dlgNoteEditor((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar));
        Note nn = ne.Edit(note);

        if (nn == null) {
            return;
        }

        note = nn;

        lblTitle.setText(note.getTitle());
        updateStatus();
    }//GEN-LAST:event_mnuEditActionPerformed

    private void mnuPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPropertiesActionPerformed
        try {
            dlgTableView tv = new dlgTableView((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar), false);

            String tag = "Null";
            String relatedPassword = "Null";

            if (Category.Read(note.getId_category()) != null) {
                tag = Category.Read(note.getId_category()).getName();
            }
            if (Password.Read(note.getId_password()) != null) {
                relatedPassword = Password.Read(note.getId_password()).getService_name();
            }

            String[][] table = {
                {"Property", "Value"},
                {"Owner", "@" + User.Read(note.getId_user()).getUsername()},
                {"Title", note.getTitle()},
                {"Tag", tag},
                {"Related password", relatedPassword},
                {"Created in", note.getCreate_date().toString()},
                {"Last edited in", note.getEdit_date().toString()},
                {"Last viewed in", note.getView_date().toString()}
            };

            tv.displayMatrix(table, note.getTitle() + " properties");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mnuPropertiesActionPerformed

    private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(btnOptions, "Are you sure you want to delete '" + note.getTitle() + "'?", "Delete note", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        note.Delete();
        Container c = this.getParent();
        c.remove(this);
        c.revalidate();
        c.repaint();
    }//GEN-LAST:event_mnuDeleteActionPerformed

    private void btnOptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionsMousePressed
        if (!cmnOptions.isVisible())
            cmnOptions.show(btnOptions, btnOptions.getWidth(), -1);
    }//GEN-LAST:event_btnOptionsMousePressed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
            dlgDocumentView dv = new dlgDocumentView((JFrame) SwingUtilities.getWindowAncestor(pnlSidebar), false);
            updateViewDate();
            dv.readMarkdown(decryptPassword(note.getDocument()), note.getTitle());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnReadActionPerformed

    private int countWords() {
        try {
            String document = decryptPassword(note.getDocument());
            
            if (document == null || document.isEmpty()) {
                return 0;
            }
            
            // removes markdown objects to not affect the counting
            String plainText = document.replaceAll("(\\*\\*|__|\\*|_|`|~~)", "");
            plainText = plainText.replaceAll("\\[(.*?)\\]\\(.*?\\)", "$1"); // [text](url) links
            
            String[] words = plainText.split("\\s+");
            return words.length;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private int countTitles() {
        try {
            String document = decryptPassword(note.getDocument());
            
            if (document == null || document.isEmpty()) {
                return 0;
            }
            
            String[] lines = document.split("\\r?\\n");
            int titleCount = 0;
            
            for (String line : lines) {
                if (line.trim().startsWith("#")) {
                    titleCount++;
                }
            }
            
            return titleCount;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    private void updateViewDate(){
        try {
            this.note.setView_date(new Timestamp(System.currentTimeMillis()));
            this.note.Update();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnRead;
    private javax.swing.JPopupMenu cmnOptions;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblSubjects;
    private javax.swing.JTextField lblTitle;
    private javax.swing.JLabel lblWords;
    private javax.swing.JMenuItem mnuColor;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuProperties;
    private javax.swing.JMenuItem mnuRead;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}
