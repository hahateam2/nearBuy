package com.serviceImpl;

import com.dao.DonateMapper;
import com.model.Donate;
import com.model.DonateExample;
import com.model.MsgBean;
import com.pojo.Page;
import com.service.DonateService;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DonateServiceImpl implements DonateService {

    @Autowired
    private DonateMapper donateMapper;

    private MsgBean pageExecute(DonateExample example,int page){
        example.setOrderByClause("createTime desc");
        Page page1 = new Page(page);
        if(page>0){
            example.setPage(page1);
        }
        page1.setTotalRows((int)donateMapper.countByExample(example));

        List<Donate> donates = donateMapper.selectByExample(example);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page1);
        map.put("donates",donates);

        return new MsgBean(true,"查询数据成功",map);
    }

    @Override
    public MsgBean selectById(String id) {
        if(id == null ){
            return new MsgBean(false,"数据为空无法查询",false);
        }
        Donate need = donateMapper.selectByPrimaryKey(id);

        return new MsgBean(true,"查询数据成功",need);
    }

    @Override
    public MsgBean selectAllByPage(int page) {
        DonateExample example = new DonateExample();

        return pageExecute(example,page);
    }

    @Override
    public MsgBean selectByWord(String word, int page) {
        DonateExample example = new DonateExample();
        example.or().andNameLike("%%"+word+"%%");
        example.or().andDepictLike("%%"+word+"%%");

        return pageExecute(example,page);
    }

    @Override
    public MsgBean selectByUserId(String id,int page) {
        DonateExample example = new DonateExample();
        example.createCriteria().andUseridEqualTo(id);

        return pageExecute(example,page);
    }

    @Override
    public MsgBean selectByUserId(String id, String status, int page) {
        DonateExample example = new DonateExample();
        example.createCriteria().andUseridEqualTo(id).andStatusEqualTo(status);

        return pageExecute(example,page);
    }

    @Override
    public MsgBean selectByTerm(Donate donate, int page) {
        DonateExample example =new DonateExample();
        DonateExample.Criteria criteria = example.createCriteria();

        if(donate.getName() != null && !"".equals(donate.getName())) {
            criteria.andNameLikeOrDepictLike(donate.getName());
        }
        if(donate.getUserid() != null && !"".equals(donate.getUserid())) {
            criteria.andUseridEqualTo(donate.getUserid());
        }
        if(donate.getStatus() != null && !"".equals(donate.getStatus())) {
            criteria.andStatusEqualTo(donate.getStatus());
        }

        return pageExecute(example,page);
    }

    @Override
    public MsgBean count(Donate donate) {
        DonateExample example = new DonateExample();
        DonateExample.Criteria criteria = example.createCriteria();

        if(donate.getName() != null && !"".equals(donate.getName())) {
            criteria.andNameLikeOrDepictLike(donate.getName());
        }
        if(donate.getUserid() != null && !"".equals(donate.getUserid())) {
            criteria.andUseridEqualTo(donate.getUserid());
        }
        if(donate.getStatus() != null && !"".equals(donate.getStatus())) {
            criteria.andStatusEqualTo(donate.getStatus());
        }

        long count = donateMapper.countByExample(example);

        return new MsgBean(true,"查询数据成功",count);
    }

    @Override
    public MsgBean insert(Donate donate) {
        if(donate == null ){
            return new MsgBean(false,"数据为空无法创建",false);
        }

        String id = MyUtil.getTableId();
        donate.setId(id);
        donate.setCreatetime(MyUtil.nowTime());
        donate.setStatus("捐赠");

        if(donateMapper.insertSelective(donate)>0){
            return new MsgBean(true,"插入数据成功",true);
        }else {
            return new MsgBean(true,"插入数据失败",false);
        }
    }

    @Override
    public MsgBean update(Donate donate) {
        if(donate == null || donate.getId() == null){
            return new MsgBean(false,"数据为空无法更新",false);
        }

        if(donateMapper.updateByPrimaryKeySelective(donate)>0){
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
        if(donateMapper.deleteByPrimaryKey(id)>0){
            return new MsgBean(true,"删除数据成功",true);
        }else {
            return new MsgBean(true,"删除数据失败",false);
        }
    }
}
