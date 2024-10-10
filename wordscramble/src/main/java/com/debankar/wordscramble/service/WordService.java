package com.debankar.wordscramble.service;

import com.debankar.wordscramble.model.Word;
import com.debankar.wordscramble.repository.WordRepository;
import com.debankar.wordscramble.util.WordScrambler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordService {
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word getRandomScrambledWord() {
        long count = wordRepository.count();

        if (count == 0) {
            throw new RuntimeException("No words found in the database!");
        }

        long randomId = (long) (Math.random() * count) + 1;
        Optional<Word> optionalWord = wordRepository.findById(randomId);

        if (optionalWord.isPresent()) {
            Word word = optionalWord.get();
            word.setScrambledWord(WordScrambler.scrambleWord(word.getOriginalWord()));

            return word;
        } else {
            throw new RuntimeException("Word not found!");
        }
    }

    public boolean isGuessCorrect(String originalWord, String guess) {
        return originalWord.equalsIgnoreCase(guess);
    }

    public String getHint(String originalWord, int attempts) {
        int hintLength;

        // Logic to progressively show more of the word as a hint
        if (attempts == 1) {
            hintLength = 2; // First two characters
        } else if (attempts == 2) {
            hintLength = 4; // First four characters
        } else if (attempts >= 3) {
            return originalWord; // After 3 attempts, return the full word
        } else {
            return ""; // Default case, no hint
        }

        // Return a partial hint (first few characters) followed by dots
        return originalWord.substring(0, Math.min(hintLength, originalWord.length())) + "...";
    }
}
