package org.example.stringUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
@ToString
public class WordsRepetitionsCounter {
    private Map<String, Integer> numbersOfWordsRepetitions = new HashMap<>();
    @ToString.Exclude
    private final StringToArrayConverter text;

    public Map countWords() {
        for (String word : text.getArrayOfWords()) {
            numbersOfWordsRepetitions.put(word, numbersOfWordsRepetitions.getOrDefault(word, 0) + 1);
        }
        return numbersOfWordsRepetitions;
    }
}
