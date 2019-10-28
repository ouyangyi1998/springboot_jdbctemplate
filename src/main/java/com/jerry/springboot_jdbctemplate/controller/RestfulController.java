package com.jerry.springboot_jdbctemplate.controller;

import com.jerry.springboot_jdbctemplate.entity.Account;
import com.jerry.springboot_jdbctemplate.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RestfulController {
    @Autowired
    accountService accountService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccount()
    {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id")int id)
    {
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id")int id, @RequestParam(value = "name",required = true)String name,@RequestParam(value = "money",required = true)double money)
    {
        Account account=new Account();
        account.setId(id);
        account.setMoney(money);
        account.setName(name);
        int t=accountService.update(account);
        if (t==1)
        {
            return account.toString();
        }else
        {
            return "fail";
        }
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name")String name,@RequestParam(value = "money")double money)
    {
        Account account=new Account();
        account.setName(name);
        account.setMoney(money);
        int t=accountService.add(account);
        if(t==1)
        {
            return account.toString();
        }else
        {
            return "fail";
        }
    }
}
