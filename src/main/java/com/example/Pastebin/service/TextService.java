package com.example.Pastebin.service;

import com.example.Pastebin.dto.TextDto;
import com.example.Pastebin.model.Text;
import com.example.Pastebin.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TextService implements ITextService{

    // Repository for database interactions.
    public TextRepository textRepository;

    // repository constructor injection
    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    // methods
    @Override
    public List<TextDto> getAllText() {
        return textRepository.findAll().stream()
                .map(text -> {
                    String textSummary;
                    if (text.getText()  != null && text.getText().length() > 50) {
                        textSummary = text.getText().substring(0, 50) + "...";
                    } else {
                        textSummary = text.getText();
                    }
                    return new TextDto(text.getId(), textSummary);
                })
                .collect(Collectors.toList());
    }
    // stream => like a conveyor belt on which all the texts come one by one, and you can apply different operations on them.

    @Override
    public Text saveText(Text text) {
        if (text == null || text.getText().isEmpty()) {
            throw new IllegalArgumentException("Text can't be null or empty");
        }
        return textRepository.save(text);
    }

    @Override
    public void updateTextById(Long id, Text text) {

        // check if the text with the specific ID exists
        Text existingText = textRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The text with ID: " + id + " was not found."));
        // update the text
        existingText.setText(text.getText());
        // save the updated text
        textRepository.save(existingText);
    }

    @Override
    public void deleteTextById(Long id) {
        // same check as updating a text
        Text existingText = textRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The text with ID: \" + id + \" was not found."));
        textRepository.delete(existingText);
    }

    // for full text
    @Override
    public Text getTextById(Long id) {
        return textRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The text with id " + id + " was not found!"));
    }
}
