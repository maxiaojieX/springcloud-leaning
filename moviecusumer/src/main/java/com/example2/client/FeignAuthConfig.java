package com.example2.client;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/8.
 */
@Configuration
public class FeignAuthConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("maxiaojie","123123");
    }

}
