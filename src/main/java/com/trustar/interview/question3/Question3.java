package com.trustar.interview.question3;

import com.trustar.interview.AbstractQuestion;
import com.trustar.interview.exception.QuestionException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Write a java function that, given a list of ​java.util.regex.Pattern​ and a string, it extracts and returns all
 * the matches for the patterns found in the string.
 */
public class Question3 extends AbstractQuestion {


    /**
     * This is the entry point to execute a validate that match the reg. exp.
     * @param patternList
     * @param str
     * @param blackList
     * @return
     */
    public Set<String> run(List<Pattern> patternList, final String str, Pattern blackList) {
        if(patternList == null || patternList.size() ==0 )
            throw new QuestionException("Patter list is empty or null");

        if(blackList==null )
            throw new QuestionException("Patter list for the blacklist is null");

        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        String words = Arrays.stream(str.split(" "))
                .filter(s -> !blackList.matcher(s).find())
                .collect( Collectors.joining( " " ) );

        return patternList.stream().map(p -> processAsSet(p, words))
                .flatMap(Set::stream).collect(Collectors.toSet());
    }
}