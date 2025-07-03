package com.tuempresa.gestionjud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path basePath;

    public FileStorageService(@Value("${storage.path:uploads}") String path) {
        this.basePath = Paths.get(path);
        try {
            Files.createDirectories(basePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String store(byte[] content, String prefix) {
        try {
            String filename = prefix + "-" + UUID.randomUUID();
            Path dest = basePath.resolve(filename);
            Files.write(dest, content);
            return dest.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] load(String path) {
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
