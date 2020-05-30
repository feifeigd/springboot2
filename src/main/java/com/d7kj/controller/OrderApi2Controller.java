package com.d7kj.controller;

import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/v2")
@RestController
public class OrderApi2Controller {
    @Autowired
    WebSimulate webSimulate;

    @RequestMapping("/**")
    public void simulateJson(HttpServletRequest request, HttpServletResponse response){
        webSimulate.execute(request, response);
    }
}
