package com.jerry.springboot_jdbctemplate.dao;

import com.jerry.springboot_jdbctemplate.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface accountDao {
    int add(Account account);
    int update(Account account);
    int delete(int id);
    Account findAccountById(int id);
    List<Account> findAccountList();
}
