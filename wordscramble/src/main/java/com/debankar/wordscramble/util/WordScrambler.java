package com.debankar.wordscramble.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordScrambler {
    public static String scrambleWord(String word) {
        List<String> letters = new ArrayList<>(List.of(word.split("")));
        Collections.shuffle(letters);
        return String.join("", letters);
    }
}
