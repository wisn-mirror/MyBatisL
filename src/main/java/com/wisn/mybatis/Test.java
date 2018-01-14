package com.wisn.mybatis;

import com.wisn.mybatis.beans.UserBean;
import com.wisn.mybatis.mapper.UserMapper;
import com.wisn.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        insertUser();
    }

    private static void insertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            UserBean wisn1 = new UserBean("wisn", "3333", 3333.1d);
            int wisn = mapper.insertUser(wisn1);
            System.out.println(wisn1 + "  id" + wisn);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
