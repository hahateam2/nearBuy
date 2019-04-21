package com.controller;

import com.dao.UserMapper;
import com.model.User;
import com.service.UserService;
import com.serviceImpl.UserServiceImpl;
import com.util.UUIDgenarater;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class testUserContrller extends BaseJunit4Test {

    @Autowired
    private UserMapper userMapper;
    private UserServiceImpl userService=new UserServiceImpl();
    @Test
    public void testUUID(){
        UUIDgenarater uuiDgenarater=new UUIDgenarater();
        System.out.println(uuiDgenarater.getUUID());
    }
    @Test
    public void UserInster(){

        userService.setBaseDao(userMapper);
        User tempUser=(User)userService.selectById("504183849").getData();
        System.out.println(tempUser);
    }

}
