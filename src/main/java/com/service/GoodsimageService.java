package com.service;

import com.model.MsgBean;

public interface GoodsimageService extends BaseService{

    MsgBean queryByGoodsId(String goodsid, String type);
}
