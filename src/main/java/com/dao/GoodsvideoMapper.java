package com.dao;

import com.model.Goodsvideo;
import com.model.GoodsvideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsvideoMapper {
    long countByExample(GoodsvideoExample example);

    int deleteByExample(GoodsvideoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsvideo record);

    int insertSelective(Goodsvideo record);

    List<Goodsvideo> selectByExample(GoodsvideoExample example);

    Goodsvideo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsvideo record, @Param("example") GoodsvideoExample example);

    int updateByExample(@Param("record") Goodsvideo record, @Param("example") GoodsvideoExample example);

    int updateByPrimaryKeySelective(Goodsvideo record);

    int updateByPrimaryKey(Goodsvideo record);
}