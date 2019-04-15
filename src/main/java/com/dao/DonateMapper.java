package com.dao;

import com.model.Donate;
import com.model.DonateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DonateMapper {
    long countByExample(DonateExample example);

    int deleteByExample(DonateExample example);

    int deleteByPrimaryKey(String id);

    int insert(Donate record);

    int insertSelective(Donate record);

    List<Donate> selectByExample(DonateExample example);

    Donate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Donate record, @Param("example") DonateExample example);

    int updateByExample(@Param("record") Donate record, @Param("example") DonateExample example);

    int updateByPrimaryKeySelective(Donate record);

    int updateByPrimaryKey(Donate record);
}