package com.service;

import com.model.MsgBean;
import com.model.Need;


public interface NeedService {
    MsgBean selectById(String id);

    MsgBean selectAllByPage(int page);
    MsgBean selectByWord(String word,int page);
    MsgBean selectByUserId(String userId,int page);
    MsgBean selectByUserId(String userId, String status,int page);
    MsgBean selectByTerm(Need need, int page);

    MsgBean count(Need need);
    MsgBean insert(Need need);
    MsgBean update(Need need);
    MsgBean delete(String id);

}
