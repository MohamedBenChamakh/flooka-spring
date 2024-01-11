package com.project.content.dto;

public class FileDTO {
    private String fileName;

    public FileDTO(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
