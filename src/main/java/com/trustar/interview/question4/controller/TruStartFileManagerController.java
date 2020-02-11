package com.trustar.interview.question4.controller;

import com.trustar.interview.question4.services.TruStartFileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * This is the controller where the magic happened .
 */

@RestController
public class TruStartFileManagerController {

    @Autowired
    @Qualifier("TruStartFileService")
    private TruStartFileManagerService service;


    @RequestMapping(value = "/listFiles", method = RequestMethod.GET)
    public Set<String> list() throws Exception {
        return service.listFiles();
    }

    @RequestMapping(value = "/excludeblacklist", method = RequestMethod.GET)
    public Set<String> listFiles() throws Exception {
        return service.excludeBlackListFiles();
    }
}
