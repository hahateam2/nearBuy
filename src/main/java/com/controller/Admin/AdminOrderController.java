package com.controller.Admin;

import com.controller.BaseController;
import com.dao.OrderMapper;
import com.model.MsgBean;
import com.model.Order;
import com.service.OrderService;
import com.util.UUIDgenarater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Admin/Order")
public class AdminOrderController extends BaseController<Order> {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, orderService,orderMapper);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, orderService,orderMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Order order) {
        order.setId(new UUIDgenarater().getUUID());
        return super.instertById(order, orderService,orderMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Order order) {
        return super.updateByKey(order, orderService,orderMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, orderService,orderMapper);
    }

}
