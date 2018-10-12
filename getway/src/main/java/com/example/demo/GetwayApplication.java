package com.example.demo;

import com.example.demo.filter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GetwayApplication {


	/**
	 * 配置自定义的Zuul过滤器
	 * @return
	 */
	@Bean
	public MyFilter myZuulFilter() {
		return new MyFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(GetwayApplication.class, args);
	}
}
