package com.wisn.mybatis;

import com.wisn.mybatis.beans.UserBean;
import com.wisn.mybatis.mapper.UserMapper;
import com.wisn.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        insertUser();
        updateUser();
//        selectAllUser();
//        deleteUser();
//        selectAllUser();
//        selectUserById();
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

    private static void updateUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            UserBean wisn1 = new UserBean(3,"evey", "33343243", 3333.1d);
            int wisn = mapper.updateUser(wisn1);
            System.out.println(wisn1 + "  id" + wisn);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    private static void deleteUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            int wisn = mapper.deleteUser( 2);
            System.out.println("  id" + wisn);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    private static void selectAllUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<UserBean> userBeans = mapper.selectAllUser();
            session.commit();
            Iterator<UserBean> iterator = userBeans.iterator();
            while (iterator.hasNext()){
                UserBean next = iterator.next();
                System.out.println("  id" + next);
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    private static void selectUserById() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            UserBean userBeans = mapper.selectUserById(5);
            session.commit();
                System.out.println("  id" + userBeans);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
