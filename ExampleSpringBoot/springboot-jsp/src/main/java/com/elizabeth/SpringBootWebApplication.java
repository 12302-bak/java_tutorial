/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title SpringBootWebApplication.java
* @Package com.elizabeth
* @Description: TODO:
* @author eric
* @date 2018年8月22日下午1:46:51
* @version V1.0
*/
package com.elizabeth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
