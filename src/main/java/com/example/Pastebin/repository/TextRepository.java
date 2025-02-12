package com.example.Pastebin.repository;

import com.example.Pastebin.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {
}
