package com.xiaoyue26.www.controller;

import com.xiaoyue26.www.entity.Check;
import com.xiaoyue26.www.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by xiaoyue26 on 10/6/16.
 */
@Controller
@RequestMapping("/wechat")
public class TokenController {
    @Autowired
    private TokenService tokenService;


    @RequestMapping(value = "/check/{wxToken}", method = RequestMethod.GET, produces = "text/plain")
    public
    @ResponseBody
    String validate(@PathVariable("wxToken") String wxToken, Check tokenModel) throws ParseException, IOException {
        return tokenService.validate(wxToken, tokenModel);
    }
}
