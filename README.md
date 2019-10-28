# springboot_jdbctemplate
利用jdbctemplate实现crud，一个小测试
- 代码来自github的入门代码，jdbcTemplate平时很少使用，但是也很好上手
- entity采用springdata jpa自动建表
- 写出dao层实现类之后对于jdbcTemplate注入后，进行操作，jdbcTemplate crud格式很简单，sql加上注入各个属性
- 在findById时需要注意
```
List<Account> list=jdbcTemplate.query("select * from account where id=?",new Object[]{id},new BeanPropertyRowMapper(Account.class));
        if(list!=null&&list.size()>0)
        {
            Account account=list.get(0);
            return account;
        }else
        {
            return null;
        }
```
- 通过new Object进行注入id 再从BeanPropertyRowMapper，通过反射把结果构造为java实体类，再从中获取第一个符合id的account类
