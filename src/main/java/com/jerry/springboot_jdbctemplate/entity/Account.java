package com.jerry.springboot_jdbctemplate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account",schema = "demo")
@Setter
@Getter
public class Account {
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    @Id
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    @Column
    private double money;

}
