/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title WelcomeController.java
* @Package com.elizabeth
* @Description: TODO:
* @author eric
* @date 2018年8月22日下午1:47:44
* @version V1.0
*/
package com.elizabeth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "hello everyone, this is nothing useless inject via application.properties";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}
