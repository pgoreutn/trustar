package com.trustar.interview;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This abstract class collect common behavior to share in different Questions class
 */
public abstract class AbstractQuestion {

    /**
     * Apply reg. expression patter into the String an return the list.
     * @param p
     * @param s
     * @return
     */
    protected List<String> processAsList(Pattern p, String s) {
        Matcher v = p.matcher(s);
        List<String> values = new ArrayList<>();
        while (v.find()) {
            values.add(v.group());
        }
        return values;
    }

    /**
     * Apply reg. expression patter into the String an return a Set with no repeated matches.
     * @param p
     * @param s
     * @return
     */
    protected Set<String> processAsSet(Pattern p, String s) {
        Matcher v = p.matcher(s);
        Set<String> values = new HashSet<>();
        while (v.find()) {
            values.add(v.group());
        }
        return values;
    }


    /**
     * Apply reg. expression patter into the String and exclude the black list form the response.
     * @param p
     * @param s
     * @return
     */
    protected Set<String> processWithBlackList(Pattern p, String s) {
        Matcher v = p.matcher(s);
        Set<String> values = new HashSet<>();
        while (v.find()) {
            values.add(v.group());
        }
        return values;
    }
}
