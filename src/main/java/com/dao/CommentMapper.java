package com.dao;

import com.model.Collection;
import com.model.Comment;
import com.model.CommentExample;
import java.util.List;

import com.model.Order;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper extends BaseDao<Comment>{
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    List<Comment> selectByAllBypage();

    Comment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}