package com.example2.client.fallback;

import com.example2.client.MovieClient2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by xiaojie.Ma on 2018/3/2.
 */
@Component
public class MovieClient2Fallback implements MovieClient2 {



    @Override
    public String test(Integer id) {
        return "0";
    }

    @Override
    public String testPost(String test) {
        return null;
    }
}
