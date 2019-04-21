package com.controller.Admin;

import com.controller.BaseController;
import com.dao.CollectionMapper;
import com.model.Collection;
import com.model.MsgBean;
import com.service.CollectionService;
import com.util.UUIDgenarater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Admin/Collection")
public class AdminCollectionController extends BaseController<Collection>  {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private CollectionMapper collectionMapper;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, collectionService,collectionMapper);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, collectionService,collectionMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Collection collection) {
        collection.setId(new UUIDgenarater().getUUID());
        return super.instertById(collection, collectionService,collectionMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Collection collection) {
        return super.updateByKey(collection, collectionService,collectionMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, collectionService,collectionMapper);
    }


}
