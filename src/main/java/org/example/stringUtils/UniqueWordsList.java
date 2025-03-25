package org.example.stringUtils;

import lombok.ToString;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@ToString
public class UniqueWordsList {
    private List<String> uniqueWordsList = new LinkedList<>();

    public UniqueWordsList(List<String> arrayOfWords){
        for(String word : arrayOfWords){
            if(!uniqueWordsList.contains(word))
                uniqueWordsList.add(word);
        }
    }

    public List<String> sortByStringLength(){
        uniqueWordsList.sort(Comparator.comparing(String::length));
        return uniqueWordsList;
    }
 }
