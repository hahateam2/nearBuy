package com.serviceImpl;

import com.dao.NeedMapper;
import com.model.MsgBean;
import com.model.Need;
import com.model.NeedExample;
import com.pojo.Page;
import com.service.NeedService;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NeedServiceImpl implements NeedService{

    @Autowired
    private NeedMapper needMapper;


    private MsgBean pageExecute(NeedExample needExample,int page,int count){
        needExample.setOrderByClause("createTime desc");
        Page page1 = new Page(page,count);
        if(page>0){
            needExample.setPage(page1);
        }
        page1.setTotalRows((int)needMapper.countByExample(needExample));

        List<Need> needs = needMapper.selectByExample(needExample);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page1);
        map.put("needs",needs);

        return new MsgBean(true,"查询数据成功",map);
    }

    @Override
    public MsgBean selectById(String id) {
        if(id == null ){
            return new MsgBean(false,"数据为空无法查询",false);
        }
        Need need = needMapper.selectByPrimaryKey(id);

        return new MsgBean(true,"查询数据成功",need);
    }

    @Override
    public MsgBean selectAllByPage(int page,int count) {
        NeedExample example = new NeedExample();

        return pageExecute(example,page, count);
    }

    @Override
    public MsgBean selectByWord(String word, int page,int count) {
        NeedExample example = new NeedExample();
        example.or().andNameLike("%%"+word+"%%");
        example.or().andDepictLike("%%"+word+"%%");

        return pageExecute(example,page, count);
    }

    @Override
    public MsgBean selectByUserId(String userId, int page,int count) {
        NeedExample example = new NeedExample();
        example.createCriteria().andUseridEqualTo(userId);

        return pageExecute(example,page, count);
    }

    @Override
    public MsgBean selectByUserId(String userId, String status, int page,int count) {
        NeedExample example = new NeedExample();
        example.createCriteria().andUseridEqualTo(userId).andStatusEqualTo(status);

        return pageExecute(example,page , count);
    }

    @Override
    public MsgBean selectByTerm(Need need, Page page) {
        NeedExample example = new NeedExample();
        NeedExample.Criteria criteria = example.createCriteria();

        if(need.getName() != null && !"".equals(need.getName())){
            criteria.andNameLikeOrDepictLike(need.getName());
        }
        if(need.getUserid() != null && !"".equals(need.getUserid())){
            criteria.andUseridEqualTo(need.getUserid());
        }
        if(need.getStatus() != null && !"".equals(need.getStatus())) {
            criteria.andStatusEqualTo(need.getStatus());
        }

        return pageExecute(example,page.getpage(),page.getPageRows());
    }

    @Override
    public MsgBean count(Need need) {
        NeedExample example = new NeedExample();
        NeedExample.Criteria criteria = example.createCriteria();

        if(need.getName() != null && !"".equals(need.getName()))
            criteria.andNameLikeOrDepictLike(need.getName());
        if(need.getUserid() != null && !"".equals(need.getUserid()))
            criteria.andUseridEqualTo(need.getUserid());
        if(need.getStatus() != null && !"".equals(need.getStatus()))
            criteria.andStatusEqualTo(need.getStatus());

        long count = needMapper.countByExample(example);

        return new MsgBean(true,"查询数据成功",count);
    }


    @Override
    public MsgBean insert(Need need) {
        if(need == null ){

            return new MsgBean(false,"数据为空无法创建",false);
        }

        String id = MyUtil.getTableId();
        need.setId(id);
        need.setCreatetime(MyUtil.nowTime());
        need.setStatus("需求");

        if(needMapper.insertSelective(need)>0){
            return new MsgBean(true,"插入数据成功",id);
        }else {
            return new MsgBean(true,"插入数据失败",false);
        }
    }

    @Override
    public MsgBean update(Need need) {
        if(need == null || need.getId() == null){
            return new MsgBean(false,"数据为空无法更新",false);
        }

        if(needMapper.updateByPrimaryKeySelective(need)>0){
            return new MsgBean(true,"更新数据成功",true);
        }else {
            return new MsgBean(true,"更新数据失败",false);
        }
    }

    @Override
    public MsgBean delete(String id) {
        if(id == null || "".equals(id)){

            return new MsgBean(false,"数据为空无法删除",false);
        }

        if(needMapper.deleteByPrimaryKey(id)>0){
            return new MsgBean(true,"删除数据成功",true);
        }else {
            return new MsgBean(true,"删除数据失败",false);
        }
    }
}
