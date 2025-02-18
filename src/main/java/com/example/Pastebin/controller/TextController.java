package com.example.Pastebin.controller;

import com.example.Pastebin.model.Text;
import com.example.Pastebin.service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TextController {

    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    // Main page
    @GetMapping("/texts")
    public String getAllTexts(Model model) {
        model.addAttribute("texts", textService.getAllText());
        return "index";
    }

    // Add text
    @PostMapping("/texts")
    public String saveText(@RequestParam String text) {
        Text newText = new Text();
        newText.setText(text);
        textService.saveText(newText);
        return "redirect:/texts";
    }

    // View full text
    @GetMapping("/texts/{id}")
    public String viewText(@PathVariable Long id, Model model) {
        model.addAttribute("text", textService.getTextById(id));
        return "viewText";
    }

    // Delete text
    @DeleteMapping("/texts/delete/{id}")
    public String deleteText(@PathVariable Long id) {
        textService.deleteTextById(id);
        return "redirect:/texts";
    }

    // Edit text
    @GetMapping("/texts/edit/{id}")
    public String editTextForm(@PathVariable Long id, Model model) {
        model.addAttribute("text", textService.getTextById(id));
        return "editText";
    }

    // Update text
    @PostMapping("/texts/update/{id}")
    public String updateText(@PathVariable Long id, @RequestParam String text) {
        Text updatedText = textService.getTextById(id);
        updatedText.setText(text);
        textService.updateTextById(id, updatedText);
        return "redirect:/texts";
    }
}
