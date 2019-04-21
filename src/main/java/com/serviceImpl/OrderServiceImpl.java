package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.OrderMapper;
import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl   extends BaseServiceImpl<Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    private BaseDao<Order> baseDao;

    @Override
    public void setBaseDao(Object object) {

        this.orderMapper=(OrderMapper)object;
        super.setBaseDao(this.orderMapper);
    }
}
