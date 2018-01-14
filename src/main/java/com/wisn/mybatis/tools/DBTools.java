package com.wisn.mybatis.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBTools {
    public static SqlSessionFactory sessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }
}
