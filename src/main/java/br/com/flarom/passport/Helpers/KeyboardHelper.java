package br.com.flarom.passport.Helpers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class KeyboardHelper {
    private JRootPane rootPane;

    public KeyboardHelper(JRootPane rootPane) {
        this.rootPane = rootPane;
    }

    public void setConfirmButton(JButton button) {
        addKeyBinding(button, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
    }

    public void setCancelButton(JButton button) {
        addKeyBinding(button, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
    }

    public void setShortcutButton(JButton button, KeyStroke shortcut) {
        addKeyBinding(button, shortcut);
    }

    private void addKeyBinding(JButton button, KeyStroke keyStroke) {
        String actionKey = "action_" + keyStroke.toString();
        
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, actionKey);
        rootPane.getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });
    }
}
