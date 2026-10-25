// creating a separate controller like this helps separate 
//application startup and checksum 
package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashController {

    @GetMapping("/hash")
    public String generateHash() throws NoSuchAlgorithmException {

        // Unique data string containing student information
        String data = "Vincent Esposito - Artemis Financial - CS305 Project Two";

        // Create a SHA-256 hash of our data
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = digest.digest(
            data.getBytes(StandardCharsets.UTF_8)
        );

        // Convert the hash into a readable hexadecimal string
        StringBuilder hexString = new StringBuilder();

        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b & 0xff));
        }

        // Return the original data and its checksum
        return "Original Data: " + data
                + "\nSHA-256 Checksum: " + hexString.toString();
    }
}
