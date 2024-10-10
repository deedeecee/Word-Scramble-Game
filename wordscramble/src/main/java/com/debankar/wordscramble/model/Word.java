package com.debankar.wordscramble.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WORD")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalWord;

    @Transient
    private String scrambledWord;

    public Word() {
    }

    public Word(String originalWord, String scrambledWord) {
        this.originalWord = originalWord;
        this.scrambledWord = scrambledWord;
    }
}
