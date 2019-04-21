package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.GoodsimageMapper;
import com.model.Goodsimage;

import com.service.GoodsimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsimageServiceImpl extends BaseServiceImpl<Goodsimage> implements GoodsimageService {

    @Autowired
    private GoodsimageMapper goodsimageMapper;
    private BaseDao<Goodsimage> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.goodsimageMapper=(GoodsimageMapper) object;
        super.setBaseDao(this.goodsimageMapper);
    }
}
