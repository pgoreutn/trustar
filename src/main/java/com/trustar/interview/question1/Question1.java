package com.trustar.interview.question1;

import com.trustar.interview.AbstractQuestion;
import com.trustar.interview.exception.QuestionException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Write a java function that, given a list of ​java.util.regex.Pattern​ and a string, it extracts and returns all
 * the matches for the patterns found in the string.
 */
public class Question1 extends AbstractQuestion {


    /**
     * Run method is the entry point to process and execute the regular expresion into the String
     *
     * @param patternList
     * @param str
     * @return
     */
    public List<String> run(List<Pattern> patternList, String str) {
        if(patternList == null || patternList.size() ==0 )
            throw new QuestionException("Patter list is empty or null");

        return patternList.stream().map(p -> processAsList(p, str))
                .flatMap(List::stream).collect(Collectors.toList());
    }
}