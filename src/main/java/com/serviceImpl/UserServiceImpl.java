package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.UserMapper;
import com.model.MsgBean;
import com.model.User;
import com.service.BaseService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    private BaseDao<User> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.userMapper=(UserMapper)object;
        super.setBaseDao(this.userMapper);
    }
}
