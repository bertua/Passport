package br.com.flarom.passport.Helpers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
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

    public void setCloseOnEscape(JFrame frame) {
        addEscapeKeyBinding(frame);
    }

    public void setCloseOnEscape(JDialog dialog) {
        addEscapeKeyBinding(dialog);
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

    private void addEscapeKeyBinding(JFrame frame) {
        KeyStroke escapeKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        String actionKey = "action_escape_" + escapeKey.toString();

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKey, actionKey);
        rootPane.getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    private void addEscapeKeyBinding(JDialog dialog) {
        KeyStroke escapeKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        String actionKey = "action_escape_" + escapeKey.toString();

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKey, actionKey);
        rootPane.getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }
}
