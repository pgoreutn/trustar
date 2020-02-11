package com.trustar.interview.question3;

import com.trustar.interview.exception.QuestionException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Question3Test {

    private Question3 question3 = new Question3();

    private List<Pattern> patterns;

    public void setUp(){
        patterns = new ArrayList<>();
        patterns.add(Pattern.compile("(?:(?:(?:ftp|http|https|www)[s]*:\\/\\/|www\\.)[^\\.]+\\.[^ \\n]+)"));
    }
    @Test
    public void emptyPatterListTest(){
        assertThrows(QuestionException.class, () -> {
            question3.run(null, "The fox jumped over the fence http://gooogle.com www.symantec.com" , Pattern.compile("symantec.com|cybereason.com"));
        });
    }

    @Test
    public void emptyBlackListPatterTest(){

        assertThrows(QuestionException.class, () -> {
            question3.run( patterns , "The fox jumped over the fence http://gooogle.com www.symantec.com" , Pattern.compile("symantec.com|cybereason.com"));
        });
    }

    @Test
    public void extractPatternTest(){
        List<Pattern> immutableList = new ArrayList<>();
        immutableList.add(Pattern.compile("(the)"));
        immutableList.add(Pattern.compile("(fox|f.nce)"));

        Pattern urlPatter = Pattern.compile(
                "(?:(?:(?:ftp|http|https|www)[s]*:\\/\\/|www\\.)[^\\.]+\\.[^ \\n]+)"
        );

        List<Pattern> patterns = new ArrayList<>();

        patterns.add(urlPatter);

        Set<String> result = new Question3().run(patterns, str, Pattern.compile("(symantec.com|cybereason.com)"));

        assertTrue( result.size() == 5);

        List<String> places = Arrays.asList("symantec.com", "cybereason.com");

        places.stream().forEach(el->{
            assertFalse( result.contains(el));
        });
    }

    private  String str = "{\n" +
            "    \"type\": \"bundle\",\n" +
            "    \"id\": \"bundle--32027171-b02f-4cd8-aa4a-1519fe5f0eac\",\n" +
            "    \"spec_version\": \"2.0\",\n" +
            "    \"objects\": [\n" +
            "        {\n" +
            "            \"aliases\": [\n" +
            "                \"Dragonfly\",\n" +
            "                \"Energetic Bear\"\n" +
            "            ],\n" +
            "            \"type\": \"intrusion-set\",\n" +
            "            \"name\": \"Dragonfly\",\n" +
            "            \"description\": \"[Dragonfly](https://attack.mitre.org/groups/G0035) is a cyber espionage group that has been active since at least 2011. They initially targeted defense and aviation companies but shifted to focus on the energy sector in early 2013. They have also targeted companies related to industrial control systems. (Citation: Symantec Dragonfly)\\n\\nA similar group emerged in 2015 and was identified by Symantec as [Dragonfly 2.0](https://attack.mitre.org/groups/G0074). There is debate over the extent of the overlap between [Dragonfly](https://attack.mitre.org/groups/G0035) and [Dragonfly 2.0](https://attack.mitre.org/groups/G0074), but there is sufficient evidence to lead to these being tracked as two separate groups. (Citation: Symantec Dragonfly Sept 2017) (Citation: Fortune Dragonfly 2.0 Sept 2017)\",\n" +
            "            \"external_references\": [\n" +
            "                {\n" +
            "                    \"external_id\": \"G0035\",\n" +
            "                    \"source_name\": \"mitre-attack\",\n" +
            "                    \"url\": \"https://attack.mitre.org/groups/G0035\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"(Citation: Symantec Dragonfly)\",\n" +
            "                    \"source_name\": \"Dragonfly\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"(Citation: Symantec Dragonfly)\",\n" +
            "                    \"source_name\": \"Energetic Bear\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"source_name\": \"Symantec Dragonfly\",\n" +
            "                    \"description\": \"Symantec Security Response. (2014, July 7). Dragonfly: Cyberespionage Attacks Against Energy Suppliers. Retrieved April 8, 2016.\",\n" +
            "                    \"url\": \"http://www.symantec.com/content/en/us/enterprise/media/security_response/whitepapers/Dragonfly_Threat_Against_Western_Energy_Suppliers.pdf\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"Symantec Security Response. (2017, September 6). Dragonfly: Western energy sector targeted by sophisticated attack group. Retrieved September 9, 2017.\",\n" +
            "                    \"source_name\": \"Symantec Dragonfly Sept 2017\",\n" +
            "                    \"url\": \"https://www.symantec.com/connect/blogs/dragonfly-western-energy-sector-targeted-sophisticated-attack-group\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"Hackett, R. (2017, September 6). Hackers Have Penetrated Energy Grid, Symantec Warns. Retrieved June 6, 2018.\",\n" +
            "                    \"source_name\": \"Fortune Dragonfly 2.0 Sept 2017\",\n" +
            "                    \"url\": \"http://fortune.com/2017/09/06/hack-energy-grid-symantec/\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"created_by_ref\": \"identity--c78cb6e5-0c4b-4611-8297-d1b8b55e40b5\",\n" +
            "            \"created\": \"2017-05-31T21:32:05.217Z\",\n" +
            "            \"id\": \"intrusion-set--1c63d4ec-0a75-4daa-b1df-0d11af3d3cc1\",\n" +
            "            \"modified\": \"2019-03-22T20:11:04.628Z\",\n" +
            "            \"object_marking_refs\": [\n" +
            "                \"marking-definition--fa42a846-8d90-4e51-bc29-71d5b4802168\"\n" +
            "            ],\n" +
            "            \"x_mitre_version\": \"1.0\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

}
