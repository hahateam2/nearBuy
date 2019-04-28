package com.controller;

import com.dao.GoodsvideoMapper;
import com.model.Goodsvideo;
import com.model.MsgBean;
import com.service.GoodsVideoService;
import com.util.UUIDgenarater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mobile/GoodsVideo")
public class GoodsVideoController extends BaseController<Goodsvideo>{

    @Autowired
    private GoodsVideoService goodsVideoService;
    @Autowired
    private GoodsvideoMapper goodsvideoMapper;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, goodsVideoService,goodsvideoMapper);
    }

    @RequestMapping(value = "goods/video/{goodsid}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryByGoodsId(@PathVariable("goodsid")String goodsid) {
        return goodsVideoService.queryByGoodsId(goodsid);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, goodsVideoService,goodsvideoMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Goodsvideo goodsvideo) {
        goodsvideo.setId(new UUIDgenarater().getUUID());
        return super.instertById(goodsvideo, goodsVideoService,goodsvideoMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Goodsvideo user) {
        return super.updateByKey(user, goodsVideoService,goodsvideoMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, goodsVideoService,goodsvideoMapper);
    }


    }
