package com.debankar.wordscramble.controller;

import com.debankar.wordscramble.model.Word;
import com.debankar.wordscramble.service.WordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/word-scramble")
public class WordScrambleController {
    private final WordService wordService;

    public WordScrambleController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/random")
    public Word getScrambledWord() {
        return wordService.getRandomScrambledWord();
    }

    @PostMapping("/check")
    public boolean checkGuess(@RequestParam String originalWord, @RequestParam String guess) {
        return wordService.isGuessCorrect(originalWord, guess);
    }

    @GetMapping("/hint")
    public String getHint(@RequestParam String originalWord, @RequestParam int attempts) {
        if (attempts >= 3) {
            return originalWord;
        } else {
            return wordService.getHint(originalWord, attempts);
        }
    }
}
