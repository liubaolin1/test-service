package com.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;



/**
 * @Description: 测试接口
 * @Author: Po Lam
 * @Date: 2019/3/7 16:10
 */
@RestController
@Api(value = "TestController",description = "测试类")
public class TestController {

    private static Logger logger = Logger.getLogger("TestController");


    /**
     * 测试接口
     * @param param
     * @return
     */
    @ApiOperation(notes = "测试方法1111",value = "111")
    @RequestMapping(value = "/method1",method = RequestMethod.GET)
    public Object method1111(Integer param){
        logger.info("测试打印日志");
        return "测试方法1";
    }


}
