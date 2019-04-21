package com.dao;

import com.model.Address;
import com.model.Collection;
import com.model.CollectionExample;
import java.util.List;

import com.model.Comment;
import org.apache.ibatis.annotations.Param;

public interface CollectionMapper extends BaseDao<Collection>{
    long countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(String id);

    List<Collection> selectByAllBypage();

    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}