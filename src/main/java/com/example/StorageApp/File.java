package com.example.StorageApp;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class File {
    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String filename;
    private boolean isDirectory;

    public void changeUuid() {
        if(isDirectory){
        this.uuid = String.valueOf(UUID.randomUUID());
        }
        else{

            this.uuid =null;
        }
    }

    private String uuid;

    File(String filename,boolean isDirectory){
        this.filename=filename;
        this.isDirectory=isDirectory;


    }
    File(String filename)
    {
        this.filename=filename;
        this.isDirectory=false;

    }

    public String getUuid() {
        return uuid;
    }
}
