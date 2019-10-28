package com.jerry.springboot_jdbctemplate.dao.impl;

import com.jerry.springboot_jdbctemplate.dao.accountDao;
import com.jerry.springboot_jdbctemplate.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class accountDaoImpl implements accountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from table demo.account where id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> list=jdbcTemplate.query("select * from account where id=?",new Object[]{id},new BeanPropertyRowMapper(Account.class));
        if(list!=null&&list.size()>0)
        {
            Account account=list.get(0);
            return account;
        }else
        {
            return null;
        }
    }

    @Override
     public  List<Account> findAccountList() {
        List<Account> list=jdbcTemplate.query("select * from account",new Object[]{},new BeanPropertyRowMapper(Account.class));
        if(list!=null&&list.size()>0)
        {
            return list;
        }else
        {
            return null;
        }
    }
}
