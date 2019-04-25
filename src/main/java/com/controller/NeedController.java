package com.controller;

import com.model.MsgBean;
import com.model.Need;
import com.service.NeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mobile/need")
public class NeedController{

    @Autowired
    private NeedService needService;

    private final static Logger logger= LoggerFactory.getLogger(NeedController.class);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable String id) {
        logger.info("收到一个/请求参数为{id:"+id+"}");

//        return super.queryById(id,needService,needMapper);
        return needService.selectById(id);
    }


    @RequestMapping(value = "all/{page}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page) {
        logger.info("收到一个all请求参数为{page:"+page+"}");

//        return super.queryAllByPage(page, count, needService,needMapper);
        return needService.selectAllByPage(page);
    }

    @RequestMapping(value = "/search/{word}/{page}", method = RequestMethod.GET)
    @ResponseBody
    public MsgBean searchByWord(@PathVariable String word,@PathVariable int page) {
        logger.info("收到一个search请求参数为{word:"+word+"}");

        return needService.selectByWord(word, page);
    }

    @RequestMapping(value = "/{userId}/{page}" ,method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryUserNeed(@PathVariable String userId , @PathVariable int page) {
        logger.info("收到一个/请求参数为{userId:"+userId+"}");

        return needService.selectByUserId(userId,page);
    }

    @RequestMapping(value = "/{userId}/{status}/{page}" ,method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryUserNeedByStatus(@PathVariable String userId, @PathVariable String status, @PathVariable int page) {
        logger.info("收到一个/请求参数为{userId:"+userId+"}{status:"+status+"}");

        return needService.selectByUserId(userId, status,page);
    }

    @RequestMapping(value = "/search/{page}" ,method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryByTerm(@ModelAttribute Need need, @PathVariable int page) {
        logger.info("收到一个search请求参数为{need:"+need+"}");

        return needService.selectByTerm(need,page);
    }



    @RequestMapping(value = "/count" ,method = RequestMethod.GET)
    @ResponseBody
    public MsgBean count(@ModelAttribute Need need) {
        logger.info("收到一个count请求参数为{need:"+need+"}");

        return needService.count(need);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Need need) {
        logger.info("收到一个instert请求参数为{need:"+need+"}");

//        return super.instertById(need,needService,needMapper);
        return needService.insert(need);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Need need) {
        logger.info("收到一个update请求参数为{need:"+need+"}");

        return needService.update(need);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable String id) {
        logger.info("收到一个delete请求参数为{id:"+id+"}");

        return needService.delete(id);
    }
}
