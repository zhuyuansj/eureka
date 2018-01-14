package com.winter.Controller;

import com.winter.model.User;
import com.winter.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        List<User> allUser = userService.findAllUser(pageNum, pageSize);
        return allUser;
    }


    /**
     * 事务
     * @param user
     * @return
     */
    @Transactional
    @RequestMapping(value = "/transtration")
    public String transtration(User user){
        int insert = userService.insert(user);
        int i = 1/0;
        return "success";
    }
}
