package org.example.stringUtils;

import lombok.Getter;

@Getter
public class StringToArrayConverter {
    private String[] arrayOfWords;

    public StringToArrayConverter(String text){
        this.arrayOfWords = text
                .replace("\n", " ")
                .replaceAll("[,()]","")
                .toLowerCase()
                .split(" ");
    }
}
