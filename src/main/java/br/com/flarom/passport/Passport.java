package br.com.flarom.passport;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.flywaydb.core.Flyway;

public class Passport {

    /*
     * ######
     * ##   ###                                                                           ##
     * ##   ### ######   ######  ###### ########   #############################  ##### ######
     * #######      ###  ###     ###    ##    ### ##  ###  ###  ###            ## ##      ##
     * ##       ##   ##     ###     ### ##    ### ##  ###  ###  ###            ## ##      ##
     * ##        ###### ######  ######  ########   #############################  ##       ###
     *                                  ##
     *                                  ##
     */
    public static void main(String[] args) {
        // load look and feel
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
        
        
        // load db
        Flyway.configure()
                .dataSource("jdbc:sqlite:passportdata.db", "", "")
                .load()
                .migrate();
        
        // load main screen
        frmMain main = new frmMain();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.show();
    }
}
