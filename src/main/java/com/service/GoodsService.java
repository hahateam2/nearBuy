package com.service;

import com.model.Goods;

public interface GoodsService {

    public Goods selectGoodsById(String id);
    public boolean instertGoods(Goods goods);
}
