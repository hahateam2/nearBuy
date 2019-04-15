package com.controller;

import com.dao.GoodsMapper;
import com.model.Goods;
import com.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;


@Controller
public class GoodsCotroller {

    @Autowired
    private GoodsService goodsService;

    private final static Logger logger= LoggerFactory.getLogger(GoodsCotroller.class);
    @RequestMapping("/Goods/{id}")
    @ResponseBody
    public Goods queryGoodsById(@PathVariable("id")Integer id){
//        goodsMapper.selectByPrimaryKey();

        logger.info("收到一个请求参数为{id:"+id+"}");
        return goodsService.selectGoodsById("b452ecff9fb94499a508fcfc3f8269f3");
    }

}
