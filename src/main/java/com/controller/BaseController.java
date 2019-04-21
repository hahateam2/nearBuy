package com.controller;

import com.dao.BaseDao;
import com.model.Goods;
import com.model.MsgBean;
import com.service.BaseService;
import com.serviceImpl.BaseServiceImpl;
import com.util.UUIDgenarater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public abstract class BaseController<T> {


    private T t;
    private final static Logger logger= LoggerFactory.getLogger(GoodsController.class);


    public MsgBean queryById(String id, BaseService baseService, Object object){


        logger.info("收到一个请求参数为{id:"+id+"}");
        baseService.setBaseDao(object);
//        Object object=;
//        if(object !=null){
//            return new MsgBean(true,"queryGoodsById 操作成功!",object);
//        }
        return baseService.selectById(id);
    }

    public MsgBean queryAllByPage(int page, int count ,BaseService baseService, Object object){

        baseService.setBaseDao(object);
        return baseService.selectAllByPage(page,count);
    }

    public  MsgBean instertById( T t,BaseService baseService , Object object){
        baseService.setBaseDao(object);
        return baseService.instert(t);
    }


    public  MsgBean updateByKey( T t,BaseService baseService , Object object){
        baseService.setBaseDao(object);
        return baseService.updateByPrimaryKeySelective(t);
    }


    public MsgBean deleteById(String id,BaseService baseService , Object object) {
        baseService.setBaseDao(object);
        return baseService.deleteByPrimaryKey(id);
    }

}
