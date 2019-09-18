package com.test;

import com.pojo.UserPojo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //读取配置文件
        InputStream is = Test.class.getResourceAsStream("/SqlMapConfig.xml");

        //创建session工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开sessin
        SqlSession session = sessionFactory.openSession();

        //查询
//        List<UserPojo> list = session.selectList("com.dao.UserDao.All");
//        for (UserPojo pojo: list) {
//
//            System.out.println(pojo.getId()+"   "+pojo.getUsername());
//
//        }
            UserPojo pojo = new UserPojo();
            pojo.setId(4);
            pojo.setUsername("123456");
            pojo.setPassword("123454");

            int n = session.insert("com.dao.UserDao.insertList",pojo);

            if (n>0){
                System.out.println("上传成功");
            }

        //提交事务
        session.commit();

        //关闭session
        session.close();

    }

}
