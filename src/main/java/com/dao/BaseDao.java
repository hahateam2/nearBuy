package com.dao;

import com.model.User;
import com.model.UserExample;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    public abstract T selectByPrimaryKey(String id);
    public abstract int insertSelective(T t);
    public abstract int deleteByPrimaryKey(String id);
    public abstract int updateByPrimaryKeySelective(T t);
    List<T> selectByExample(UserExample example);

    List<T> selectByAllBypage();
}
