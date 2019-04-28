package com.service;

import com.model.MsgBean;
import com.model.Need;
import com.pojo.Page;


public interface NeedService {
    MsgBean selectById(String id);

    MsgBean selectAllByPage(int page,int count);
    MsgBean selectByWord(String word,int page,int count);
    MsgBean selectByUserId(String userId,int page,int count);
    MsgBean selectByUserId(String userId, String status,int page,int count);
    MsgBean selectByTerm(Need need, Page page);

    MsgBean count(Need need);
    MsgBean insert(Need need);
    MsgBean update(Need need);
    MsgBean delete(String id);

}
