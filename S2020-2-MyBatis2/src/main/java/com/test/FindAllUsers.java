package com.test;

import com.pojo.UserPojo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class FindAllUsers {
    public static void main(String[] args) {
        //1.读取总的配置文件
        InputStream is = FindAllUsers.class.getResourceAsStream("/SqlMapConfig.xml");
        System.out.println(is);
        //2.创建session工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.打开session
        SqlSession session = sessionFactory.openSession();
        //4.查询
        List<UserPojo> list = session.selectList("com.pojo.UsersDAO.findAll");
        for (UserPojo u : list) {
            System.out.println(u.getSid()+"\t"+u.getUsername());
        }
        //5.提交事务(查询可以不要)
        session.commit();

        //6.关闭session
        session.close();
    }
}
