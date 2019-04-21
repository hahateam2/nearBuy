package com.controller.Admin;

import com.controller.BaseController;
import com.dao.CommentMapper;
import com.model.Comment;
import com.model.MsgBean;
import com.service.CommentService;
import com.util.UUIDgenarater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Admin/Comment")
public class AdminCommentController extends BaseController<Comment>{
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, commentService,commentMapper);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, commentService,commentMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Comment comment) {
        comment.setId(new UUIDgenarater().getUUID());
        return super.instertById(comment, commentService,commentMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Comment comment) {
        return super.updateByKey(comment, commentService,commentMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, commentService,commentMapper);
    }

}
