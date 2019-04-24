package com.controller;

import com.model.Donate;
import com.model.MsgBean;
import com.service.DonateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mobile/donate")
public class DonateController {

    @Autowired
    private DonateService donateService;

    private final static Logger logger= LoggerFactory.getLogger(DonateController.class);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable String id) {
        logger.info("收到一个请求参数为{id:"+id+"}");

        return donateService.selectById(id);
    }

    @RequestMapping(value = "all/{page}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page) {

//        return super.queryAllByPage(page, count, needService,needMapper);
        return donateService.selectAllByPage(page);
    }

    @RequestMapping(value = "/search/{word}/{page}", method = RequestMethod.GET)
    @ResponseBody
    public MsgBean searchByWord(@PathVariable String word,@PathVariable int page) {
        logger.info("收到一个search请求参数为{word:"+word+"}");

        return donateService.selectByWord(word, page);
    }

    @RequestMapping(value = "/{userId}/{page}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryUserDonate(@PathVariable String userId, @PathVariable int page) {
        logger.info("收到一个all请求参数为{userId:"+userId+"}");

        return donateService.selectByUserId(userId,page);
    }

    @RequestMapping(value = "/{userId}/{status}/{page}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryUserDonateByStatus(@PathVariable String userId, @PathVariable String status, @PathVariable int page) {
        logger.info("收到一个status请求参数为{userId:"+userId+"} {status:"+status+"}");

        return donateService.selectByUserId(userId, status, page);
    }


    @RequestMapping(value = "/query/{page}" ,method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryByTerm(@ModelAttribute Donate donate, @PathVariable int page) {
        logger.info("收到一个query请求参数为{donate:"+donate+"}");

        return donateService.selectByTerm(donate,page);
    }



    @RequestMapping(value = "/count" ,method = RequestMethod.GET)
    @ResponseBody
    public MsgBean count(@ModelAttribute Donate donate) {
        logger.info("收到一个count请求参数为{donate:"+donate.toString()+"}");

        return donateService.count(donate);
    }


    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Donate donate) {
        logger.info("收到一个add请求参数为{donate:"+donate.toString()+"}");

        return donateService.insert(donate);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Donate donate) {
        logger.info("收到一个update请求参数为{donate:"+donate.toString()+"}");

        return donateService.update(donate);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable String id) {
        logger.info("收到一个delete请求参数为{id:"+id+"}");

        return donateService.delete(id);
    }
}
