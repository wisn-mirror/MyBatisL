package com.wisn.mybatis.mapper;

import com.wisn.mybatis.beans.UserBean;

import java.util.List;

public interface UserMapper {

    public int insertUser(UserBean user) throws Exception;

    public int updateUser(UserBean user) throws Exception;

    public  int deleteUser(int id) throws Exception;

    public  UserBean selectUserById(int id) throws Exception;

    public List<UserBean> selectAllUser() throws Exception;

}
