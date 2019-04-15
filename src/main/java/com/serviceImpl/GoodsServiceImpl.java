package com.serviceImpl;

import com.dao.GoodsMapper;
import com.model.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    public Goods selectGoodsById(String id) {

        return goodsMapper.selectByPrimaryKey(id);
    }

    public boolean instertGoods(Goods goods) {
        return goodsMapper.insertSelective(goods)>0;
    }
}
