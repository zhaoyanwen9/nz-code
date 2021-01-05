package com.nz.test.controller;

import com.nz.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestControllerAdvice
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer")
    public String test() {
        try {
            // andy给lucy转账50元
            accountService.transfer(1, 2, 50);
            return "转账成功";
        } catch (Exception e) {
            return "转账失败" + e.getMessage();
        }
    }
}
