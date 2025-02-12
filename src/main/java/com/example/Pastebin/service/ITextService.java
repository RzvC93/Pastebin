package com.example.Pastebin.service;

import com.example.Pastebin.dto.TextDto;
import com.example.Pastebin.model.Text;

import java.util.List;

public interface ITextService {

    // Get Method
    List<TextDto> getAllText();

    // Post Method
    Text saveText(Text text);

    // Put Method
    void updateTextById(Long id, Text text);

    // Delete Method
    void deleteTextById(Long id);
}
