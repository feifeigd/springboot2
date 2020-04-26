package com.d7kj.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/// 注解RestController相当于注解Controller和ResponseBody的合体。
@RestController
public class UserReditRestController {

    @RequestMapping(value = "/usercredit/{id}")
    public Integer getCreditLevel(@PathVariable String id){
        return Integer.parseInt(id);
    }
}
