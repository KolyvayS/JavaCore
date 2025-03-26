package org.example.regexUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearcher {
    private Pattern pattern;
    private Matcher matcher;

    public void setPattern(String regexPattern) {
        this.pattern = Pattern.compile(regexPattern);
    }

    public void setMatcher(String text){
        this.matcher = pattern.matcher(text);
    }

    public boolean findMatches(){
        return matcher.find();
    }

    public String returnGroup(){
        return matcher.group();
    }

    public String returnGroup(int group){
        return matcher.group(group);
    }

}
