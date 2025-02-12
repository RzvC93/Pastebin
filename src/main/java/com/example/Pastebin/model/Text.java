package com.example.Pastebin.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pastebin")

public class Text {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )

    private Long id;

    @Column(length = 2000)
    private String text;
    private LocalDateTime createdAt;

    public Text() {}

    public Text(Long id, String text, LocalDateTime createdAt) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // prePersist method to automatically set the date at creation time
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}

