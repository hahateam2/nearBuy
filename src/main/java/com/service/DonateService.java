package com.service;

import com.model.Donate;
import com.model.MsgBean;


public interface DonateService {
    MsgBean selectById(String id);

    MsgBean selectAllByPage(int page);
    MsgBean selectByWord(String word,int page);
    MsgBean selectByUserId(String id,int page);
    MsgBean selectByUserId(String id, String status, int page);
    MsgBean selectByTerm(Donate donate, int page);

    MsgBean count(Donate donate);
    MsgBean insert(Donate donate);
    MsgBean update(Donate donate);
    MsgBean delete(String id);

}
