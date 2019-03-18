package com.demo.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 默认
 * @Author: Po Lam
 * @Date: 2019/3/7 16:10
 */
@RestController
public class IndexController {
    @RequestMapping(value = {"/","/info"}, method = RequestMethod.GET)
    public String toLoginPage(HttpServletRequest request){
        return "welcome!";
    }
}

