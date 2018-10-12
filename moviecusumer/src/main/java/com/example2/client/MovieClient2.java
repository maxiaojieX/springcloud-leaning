package com.example2.client;

import com.example2.client.fallback.MovieClient2Fallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiaojie.Ma on 2018/3/1.
 */
@FeignClient(name = "MOVIEPROVIDE",fallback = MovieClient2Fallback.class,configuration=FeignAuthConfig.class)
public interface MovieClient2 {

    @GetMapping("/test/{id}")
    String test(@PathVariable(name = "id") Integer id);

    @PostMapping("/post")
    String testPost(@RequestParam(name = "abc")String test);
}
