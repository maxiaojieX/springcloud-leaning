package com.example2.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiaojie.Ma on 2018/2/24.
 */
@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fall",threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "30")
    })
    public String getMovie2(Integer id) {
        String url = "http://MOVIEPROVIDE/moviename?id="+id;
        return restTemplate.getForObject(url,String.class);
    }

    public String fall(Integer id) {
        return "容错回退测试";
    }

//    public String getPost() {
//        String url = "http://MOVIEPROVIDE/post";
//        return restTemplate.getForObject(url,String.class);
//    }

}
