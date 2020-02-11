package com.trustar.interview.question2;

import com.trustar.interview.exception.QuestionException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Question2Test {

    private Question2 question2 = new Question2();


    @Test()
    public void emptyPatterList() {
        assertThrows(QuestionException.class, () -> {
            question2.run(new ArrayList<>(), "The fox jumped over the fence");
        });
    }

    @Test
    public void nullPatterList(){
        assertThrows(QuestionException.class, () -> {
            question2.run(null , "The fox jumped over the fence");
        });
    }

    @Test
    public void extractPatternTest() {
        List<Pattern> immutableList = new ArrayList<>();
        immutableList.add(Pattern.compile("(the)"));
        immutableList.add(Pattern.compile("(fox|f.nce)"));

        assertTrue( question2.run(immutableList, "The fox jumped over the fence").size() == 3);

        List<String> places = Arrays.asList("the", "fox", "fence");

        places.stream().forEach(el->{
            assertTrue( question2.run(immutableList, "The fox jumped over the fence").contains(el));
        });
    }
}
