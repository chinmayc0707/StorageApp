package com.example.StorageApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void isDirectory() {
        File file = new File("chinmay");

        assertFalse(file.isDirectory());
    }

    @Test
    void isDirectoryForDirectory() {
        File file = new File("documents", true);

        assertTrue(file.isDirectory());
    }

    @Test
    void setDirectory() {
        File file = new File("test.txt", false);

        file.setDirectory(true);

        assertTrue(file.isDirectory());
    }

    @Test
    void getFilename() {
        File file = new File("chinmay.txt");

        assertEquals("chinmay.txt", file.getFilename());
    }

    @Test
    void setFilename() {
        File file = new File("old.txt");

        file.setFilename("new.txt");

        assertEquals("new.txt", file.getFilename());
    }

    @Test
    void changeUuidForDirectory() {
        File file = new File("documents", true);

        file.changeUuid();

        assertNotNull(file.getUuid());
    }

    @Test
    void changeUuidForFile() {
        File file = new File("test.txt", false);

        file.changeUuid();

        assertNull(file.getUuid());
    }

    @Test
    void getUuid() {
        File file = new File("documents", true);

        file.changeUuid();

        assertNotNull(file.getUuid());
    }
}