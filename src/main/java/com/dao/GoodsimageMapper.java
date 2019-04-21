package com.dao;

import com.model.Comment;
import com.model.Goods;
import com.model.Goodsimage;
import com.model.GoodsimageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsimageMapper extends BaseDao<Goodsimage>{
    long countByExample(GoodsimageExample example);

    int deleteByExample(GoodsimageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Goodsimage record);

    int insertSelective(Goodsimage record);

    List<Goodsimage> selectByExample(GoodsimageExample example);

    List<Goodsimage> selectByAllBypage();

    Goodsimage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Goodsimage record, @Param("example") GoodsimageExample example);

    int updateByExample(@Param("record") Goodsimage record, @Param("example") GoodsimageExample example);

    int updateByPrimaryKeySelective(Goodsimage record);

    int updateByPrimaryKey(Goodsimage record);
}