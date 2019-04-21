package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.GoodsMapper;
import com.model.Goods;
import com.model.User;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    private BaseDao<Goods> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.goodsMapper=(GoodsMapper)object;
        super.setBaseDao(this.goodsMapper);
    }
}
