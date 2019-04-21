package com.controller;

import com.dao.AddressMapper;
import com.model.Address;
import com.model.MsgBean;
import com.service.AddressService;
import com.util.UUIDgenarater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mobile/Address")
public class AddressController extends BaseController<Address>  {

    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressMapper addressMapper;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryById(@PathVariable("id")String id) {
        return super.queryById(id, addressService,addressMapper);
    }

    @RequestMapping(value = "/{page}/{count}",method = RequestMethod.GET)
    @ResponseBody
    public MsgBean queryAllByPage(@PathVariable("page") int page, @PathVariable("count") int count) {
        return super.queryAllByPage(page, count, addressService,addressMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public MsgBean instertById(@ModelAttribute Address address) {

        return super.instertById(address, addressService,addressMapper);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public MsgBean updateByKey(@ModelAttribute Address address) {
        return super.updateByKey(address, addressService,addressMapper);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public MsgBean deleteById(@PathVariable("id") String id) {
        return super.deleteById(id, addressService,addressMapper);
    }

}
