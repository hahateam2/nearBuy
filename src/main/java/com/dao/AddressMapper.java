package com.dao;

import com.model.Address;
import com.model.AddressExample;
import java.util.List;

import com.model.Collection;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper extends BaseDao<Address>{
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    List<Address> selectByAllBypage();

    Address selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}