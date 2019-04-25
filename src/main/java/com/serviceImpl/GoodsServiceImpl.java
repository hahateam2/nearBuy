package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.GoodsMapper;
import com.dao.GoodsimageMapper;
import com.dao.GoodsvideoMapper;
import com.model.*;
import com.service.GoodsService;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @Override
    public MsgBean instert(Object object) {
        if(object == null ){

            return new MsgBean(false,"数据为空无法创建",false);
        }
        Goods goods = (Goods) object;
        String id = MyUtil.getTableId();
        goods.setId(id);
        goods.setCreatetime(MyUtil.nowTime());
        if(goods.getStatus()==null) {
            goods.setStatus("售卖");
        }

        if(goodsMapper.insertSelective(goods)>0){
            return new MsgBean(true,"插入数据成功",id);
        }else {
            return new MsgBean(true,"插入数据失败",false);
        }
    }

}
