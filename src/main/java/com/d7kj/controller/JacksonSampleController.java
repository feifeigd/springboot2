package com.d7kj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jackson")
public class JacksonSampleController {
    @GetMapping("/now.json")
    public @ResponseBody
    Map<String, Date> now(){
        Map<String, Date> map = new HashMap<String, Date>();
        map.put("date", new Date());
        return map;
    }
}
