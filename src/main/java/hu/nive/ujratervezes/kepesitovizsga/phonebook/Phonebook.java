package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;

public class Phonebook {
    void exportPhonebook(Map<String, String> contacts, String output) throws IllegalArgumentException {
        if (contacts == null) {
            throw new IllegalArgumentException("Contacts can not be null!");
        }
        if (output == null) {
            throw new IllegalArgumentException("Output can not be null!");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(output))) {
            Iterator<Map.Entry<String, String>> it = contacts.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                writer.write(entry.getKey());
                writer.write(": ");
                writer.write(entry.getValue());
                writer.write("\n");
            }
        }
        catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }
}
