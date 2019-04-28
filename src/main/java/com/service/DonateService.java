package com.service;

import com.model.Donate;
import com.model.MsgBean;
import com.pojo.Page;


public interface DonateService {
    MsgBean selectById(String id);

    MsgBean selectAllByPage(int page,int count);
    MsgBean selectByWord(String word,int page,int count);
    MsgBean selectByUserId(String id,int page,int count);
    MsgBean selectByUserId(String id, String status, int page,int count);
    MsgBean selectByTerm(Donate donate, Page page);

    MsgBean count(Donate donate);
    MsgBean insert(Donate donate);
    MsgBean update(Donate donate);
    MsgBean delete(String id);

}
