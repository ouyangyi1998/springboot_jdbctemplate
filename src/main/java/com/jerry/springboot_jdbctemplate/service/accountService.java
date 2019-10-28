package com.jerry.springboot_jdbctemplate.service;

import com.jerry.springboot_jdbctemplate.entity.Account;

import java.util.List;

public interface accountService {
    public int add(Account account);
    public int update(Account account);
    public int delete(int id);
    public Account findAccountById(int id);
    public List<Account> findAccountList();
}
