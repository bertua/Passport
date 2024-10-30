package com.mycompany.contatos.classes;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/*
    File Manager
    Used to create and read .ctt contact files
*/

public class FileManager {

    // read a .ctt file and return as a string matrix
    public String[][] ReadCtt(String filePath) {
        // check if file exists
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found.");
            return null;
        }

        // check if file is .ctt
        if (!filePath.endsWith(".ctt")) {
            JOptionPane.showMessageDialog(null, "Formato de arquivo inválido.\nEsperado .ctt", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        // read file content and convert to a matrix
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }

            // separate lines with '\n' and columns with '\t'
            String[] lines = fileContent.toString().split("\n");
            String[][] matrix = new String[lines.length][];
            for (int i = 0; i < lines.length; i++) {
                matrix[i] = lines[i].split("\t");
            }

            return matrix;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // write a matrix as a .ctt file
    public void WriteCtt(String filePath, String[][] content) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String[] row : content) {
                bw.write(String.join("\t", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // open a file via dialog
    public String OpenFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de contato (*.ctt)", "ctt");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    // save a file via dialog
    public String SaveFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Contatos");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Contato (*.ctt)", "ctt"));

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // if the file does not have a .ctt extension, add one
            if (!selectedFile.getName().endsWith(".ctt")) {
                return selectedFile.getAbsolutePath() + ".ctt";
            }

            return selectedFile.getAbsolutePath();
        }
        return null;
    }
}
