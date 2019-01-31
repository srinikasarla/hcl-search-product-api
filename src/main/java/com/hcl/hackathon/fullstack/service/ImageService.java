package com.hcl.hackathon.fullstack.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    public String populateImageBytes(String pathname) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(pathname).getFile());
            byte[] encoded = Base64.encodeBase64(Files.readAllBytes(file.toPath()));
            return new String(encoded, StandardCharsets.US_ASCII);
        } catch (Exception e) {
            return null;
        }
    }
}
