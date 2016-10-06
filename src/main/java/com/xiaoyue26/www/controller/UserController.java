package com.xiaoyue26.www.controller;

import com.xiaoyue26.www.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoyue26 on 10/5/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        return user;
    }
}
