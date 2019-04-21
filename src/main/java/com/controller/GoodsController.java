package com.controller;
import com.dao.GoodsMapper;
import com.model.Goods;
import com.model.MsgBean;
import com.model.User;
import com.service.GoodsService;


import com.util.UUIDgenarater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mobile/Goods")
public class GoodsController extends BaseController<Goods> {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsMapper  goodsMapper;
    private final static Logger logger= LoggerFactory.getLogger(GoodsController.class);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, goodsService,goodsMapper);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, goodsService,goodsMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Goods goods) {
        goods.setId(new UUIDgenarater().getUUID());
        return super.instertById(goods, goodsService,goodsMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Goods goods) {
        return super.updateByKey(goods, goodsService,goodsMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, goodsService,goodsMapper);
    }




}
