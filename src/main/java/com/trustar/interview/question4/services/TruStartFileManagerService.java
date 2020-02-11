package com.trustar.interview.question4.services;

import com.trustar.interview.question3.Question3;
import com.trustar.interview.utils.URLUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Service
@Qualifier("TruStartFileService")
public class TruStartFileManagerService {

    public Set<String> listFiles() throws Exception {
        return URLUtils.jsonFileList();
    }

    /**
     * This is the service where we find all url that do not match the patter in the black list
     * @return
     * @throws Exception
     */
    public Set<String> excludeBlackListFiles() throws Exception {

        Set<String> result = new HashSet<>();

        URLUtils.jsonFileList().stream().forEach(file->{
            try {

                String str = URLUtils.getJsonAsString("https://raw.githubusercontent.com/mitre/cti/master/enterprise-attack/intrusion-set/" + file);

                Pattern urlPatter = Pattern.compile(
                        "(?:(?:(?:ftp|http|https|www)[s]*:\\/\\/|www\\.)[^\\.]+\\.[^ \\n]+)"
                );

                List<Pattern> patterns = new ArrayList<>();

                patterns.add(urlPatter);

                result.addAll(new Question3().run(patterns, str, Pattern.compile("(symantec.com|cybereason.com)")));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return result;
    }
}