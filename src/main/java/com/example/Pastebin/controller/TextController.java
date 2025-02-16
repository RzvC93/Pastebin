package com.example.Pastebin.controller;

import com.example.Pastebin.dto.TextDto;
import com.example.Pastebin.model.Text;
import com.example.Pastebin.service.TextService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/texts")

public class TextController {

    private final TextService textService;

    //dependency injection
    public TextController(TextService textService) {
        this.textService = textService;
    }

    // for Postman
    @GetMapping
    public List<TextDto> getText() {
        return textService.getAllText();
    }

    @PostMapping("/text")
    public Text saveText(@RequestBody Text textData) {
        // RequestBody -> transform HTTP request to Java object
        return textService.saveText(textData);
    }

    @PutMapping(path = "{id}")
    public void updateTextById(@PathVariable Long id, @RequestBody Text texData) {
        // @PathVariable -> get URL values
        textService.updateTextById(id, texData);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTextById(@PathVariable Long id) {
        textService.deleteTextById(id);
    }

    @GetMapping("/text/{id}")
    public Text getTextById(@PathVariable Long id) {
        return textService.getTextById(id);
    }
}
