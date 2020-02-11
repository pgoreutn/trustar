package com.trustar.interview.question1;

import com.trustar.interview.exception.QuestionException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Question1Test {

    private Question1 question1 = new Question1();

    @Test
    public void emptyPatterList(){
        assertThrows(QuestionException.class, () -> {
            question1.run(new ArrayList<>(), "The fox jumped over the fence");
        });
    }

    @Test
    public void nullPatterList(){
        assertThrows(QuestionException.class, () -> {
            question1.run(null , "The fox jumped over the fence");
        });

    }

    @Test
    public void extractPatternTest(){
        List<Pattern> immutableList = new ArrayList<>();
        immutableList.add(Pattern.compile("(the)"));
        immutableList.add(Pattern.compile("(fox|f.nce)"));

        assertTrue( question1.run(immutableList, "The fox jumped over the fence").size() == 3);

        assertTrue( question1.run(immutableList, "The fox jumped over the fence").get(0).equals("the") );

        assertTrue( question1.run(immutableList, "The fox jumped over the fence").get(1).equals("fox") );

        assertTrue( question1.run(immutableList, "The fox jumped over the fence").get(2).equals("fence") );
    }
}
