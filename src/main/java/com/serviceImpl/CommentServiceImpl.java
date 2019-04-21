package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.CommentMapper;
import com.model.Comment;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    private BaseDao<Comment> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.commentMapper=(CommentMapper)object;
        super.setBaseDao(this.commentMapper);
    }

}
