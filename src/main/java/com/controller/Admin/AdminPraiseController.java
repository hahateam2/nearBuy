package com.controller.Admin;

import com.controller.BaseController;
import com.dao.PraiseMapper;
import com.model.MsgBean;
import com.model.Praise;
import com.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Admin/Praise")
public class AdminPraiseController extends BaseController<Praise>  {

    @Autowired
    private PraiseService praiseService;
    @Autowired
    private PraiseMapper praiseMapper;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, praiseService,praiseMapper);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, praiseService,praiseMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Praise praise) {

        return super.instertById(praise, praiseService,praiseMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Praise praise) {
        return super.updateByKey(praise, praiseService,praiseMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, praiseService,praiseMapper);
    }
}
