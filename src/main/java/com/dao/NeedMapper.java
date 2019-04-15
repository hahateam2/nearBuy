package com.dao;

import com.model.Need;
import com.model.NeedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NeedMapper {
    long countByExample(NeedExample example);

    int deleteByExample(NeedExample example);

    int deleteByPrimaryKey(String id);

    int insert(Need record);

    int insertSelective(Need record);

    List<Need> selectByExample(NeedExample example);

    Need selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Need record, @Param("example") NeedExample example);

    int updateByExample(@Param("record") Need record, @Param("example") NeedExample example);

    int updateByPrimaryKeySelective(Need record);

    int updateByPrimaryKey(Need record);
}