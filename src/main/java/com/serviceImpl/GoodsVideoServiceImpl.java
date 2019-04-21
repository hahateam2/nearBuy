package com.serviceImpl;

import com.dao.GoodsvideoMapper;
import com.model.Goodsvideo;
import com.service.GoodsVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsVideoServiceImpl extends BaseServiceImpl<Goodsvideo> implements GoodsVideoService {

    @Autowired
    private GoodsvideoMapper goodsvideoMapper;

    @Override
    public void setBaseDao(Object object) {
        this.goodsvideoMapper=(GoodsvideoMapper)object;
        super.setBaseDao(this.goodsvideoMapper);
    }
}
