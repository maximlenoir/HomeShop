package com.mlenoir.homeshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter implements Writer {
    private String fileName;
    private Path filePath;
    private String content;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void start() {
        this.filePath = Paths.get(this.fileName);

        this.content = "";
    }

    @Override
    public void writeLine(String line) {
        this.content += line + "%n";
    }

    @Override
    public void stop() {
        try {
            Files.write(this.filePath, String.format(this.content).getBytes());
        } catch (IOException e) {
            System.err.println("Impossible d'écrire la facture.");
        }
    }
}
