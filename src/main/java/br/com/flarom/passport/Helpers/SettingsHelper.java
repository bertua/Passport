package br.com.flarom.passport.Helpers;

import java.io.*;
import java.nio.file.*;

public class SettingsHelper {
    private static final String CONFIG_FOLDER = ".config";
    private static final String SETTINGS_DIR = "passport";
    private static final String SETTINGS_FILE = "settings.conf";
   
    /**
     * creates the ".config" folder in the system user folder, if it does not already exist
     */
    public static void createSettingsRoot() {
        Path configPath = Paths.get(System.getProperty("user.home"), CONFIG_FOLDER);
        if (!Files.exists(configPath)) {
            try {
                Files.createDirectory(configPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * creates the "passport" folder inside ".config", if it does not already exist
     */
    public static void createSettingsDir() {
        createSettingsRoot();
        Path settingsPath = Paths.get(System.getProperty("user.home"), CONFIG_FOLDER, SETTINGS_DIR);
        if (!Files.exists(settingsPath)) {
            try {
                Files.createDirectory(settingsPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * creates the "settings.conf" file inside the "passport" folder, if it does not already exist
     */
    public static void createSettingsFile() {
        createSettingsDir();
        Path settingsFilePath = Paths.get(System.getProperty("user.home"), CONFIG_FOLDER, SETTINGS_DIR, SETTINGS_FILE);
        if (!Files.exists(settingsFilePath)) {
            try {
                Files.createFile(settingsFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * (over)write a setting
     * @param key setting name
     * @param value setting value
     */
    public static void Write(String key, String value) {
        createSettingsFile();
        Path settingsFilePath = Paths.get(System.getProperty("user.home"), CONFIG_FOLDER, SETTINGS_DIR, SETTINGS_FILE);

        try {
            StringBuilder fileContent = new StringBuilder();
            boolean keyFound = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(settingsFilePath.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(key + "\t")) {
                        fileContent.append(key).append("\t").append(value).append("\n");
                        keyFound = true;
                    } else {
                        fileContent.append(line).append("\n");
                    }
                }
            }

            if (!keyFound) {
                fileContent.append(key).append("\t").append(value).append("\n");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFilePath.toFile()))) {
                writer.write(fileContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * get the value of a setting
     * @param key setting name
     * @return value
     */
    public static String Read(String key) {
        createSettingsFile();
        Path settingsFilePath = Paths.get(System.getProperty("user.home"), CONFIG_FOLDER, SETTINGS_DIR, SETTINGS_FILE);

        try (BufferedReader reader = new BufferedReader(new FileReader(settingsFilePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(key + "\t")) {
                    return line.split("\t", 2)[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
