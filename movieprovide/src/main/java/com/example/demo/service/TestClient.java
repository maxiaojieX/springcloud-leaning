package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaojie.Ma on 2018/4/19.
 */
@FeignClient("test-service")
public interface TestClient {
    @RequestMapping("/test")
    void test();
}
