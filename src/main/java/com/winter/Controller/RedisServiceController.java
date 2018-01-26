package com.winter.Controller;

import com.winter.service.project.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisServiceController {
    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping(value = "/setredis")
    public String setredis(String keyredis){
        redisService.setStr(keyredis,"2018年1月26日");
        return "保存成功,请访问getredis查询redis";
    }

    @RequestMapping(value = "/getredis")
    public String getredis(String keyredis){
        String getredis = (String) redisService.getKey(keyredis);
        return "redis的key是===>"+getredis;
    }


    @RequestMapping(value = "/delredis")
    public String delredis(String keyredis){
        redisService.delKey(keyredis);
        return "删除成功，请通过getredis进行查询";
    }
}
