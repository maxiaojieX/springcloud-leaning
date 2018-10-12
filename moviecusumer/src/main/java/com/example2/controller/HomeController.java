package com.example2.controller;

import com.example2.client.MovieClient2;
import com.example2.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaojie.Ma on 2018/2/12.
 */
@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private MovieClient2 movieClient;

    @Autowired
    private MovieService movieService;

    @GetMapping("/feign")
    @ResponseBody
    public String hello(int a) {
        logger.info("INFO TEST>>>>>>");
        logger.warn("warn TEST>>>>>");
        logger.debug("debug TEST>>>>>>");
        logger.error("error TEST>>>>>>>");
        return movieClient.test(a);
    }

    @PostMapping("/post1")
    @ResponseBody
    public String test3(String abc) {
        System.out.println(abc+"*****************");
        return movieClient.testPost(abc);
    }
}
