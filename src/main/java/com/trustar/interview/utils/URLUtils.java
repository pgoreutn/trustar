package com.trustar.interview.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * This class expose statics method to process json files.
 */
public class URLUtils {

    /**
     * In this is method we implement the way we extract from github the json file list to be process.
     * @return
     * @throws IOException
     */
    public static Set<String> jsonFileList() throws IOException {
        Set<String> jsonList = new HashSet<>();

        //At this point we should download all files to be process.
        Document doc = Jsoup.connect("https://github.com/mitre/cti/tree/master/enterprise-attack/intrusion-set").get();
        for (Element file : doc.select("td.content a")) {
            String f = file.attr("href");
            jsonList.add(f.substring(f.lastIndexOf("/") + 1 ));
        }
        return jsonList;
    }

    /**
     * from the url , return the json as string
     * @param aUrl
     * @return
     * @throws IOException
     */
    public static String getJsonAsString(String aUrl) throws IOException
    {
        String urlData = "";
        URL urlObj = new URL(aUrl);
        URLConnection conn = urlObj.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)))
        {
            urlData = reader.lines().collect(Collectors.joining("\n"));
        }
        return urlData;
    }
}