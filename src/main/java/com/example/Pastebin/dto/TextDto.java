package com.example.Pastebin.dto;

public class TextDto {
    private Long id;
    private String textSummary;

    public TextDto(Long id, String textSummary) {
        this.id = id;
        this.textSummary = textSummary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextSummary() {
        return textSummary;
    }

    public void setTextSummary(String textSummary) {
        this.textSummary = textSummary;
    }
}
