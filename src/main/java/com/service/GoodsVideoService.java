package com.service;

import com.model.MsgBean;

public interface GoodsVideoService extends BaseService {
    MsgBean queryByGoodsId(String goodsid);

}
