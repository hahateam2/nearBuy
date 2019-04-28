package com.serviceImpl;

import com.dao.GoodsvideoMapper;
import com.model.Goodsvideo;
import com.model.GoodsvideoExample;
import com.model.MsgBean;
import com.service.GoodsVideoService;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class GoodsVideoServiceImpl extends BaseServiceImpl<Goodsvideo> implements GoodsVideoService {

    @Autowired
    private GoodsvideoMapper goodsvideoMapper;

    @Override
    public void setBaseDao(Object object) {
        this.goodsvideoMapper=(GoodsvideoMapper)object;
        super.setBaseDao(this.goodsvideoMapper);
    }

    @Override
    public MsgBean instert(Object object) {
        if(object == null ){
            return new MsgBean(false,"数据为空无法创建",false);
        }

        Goodsvideo goodsvideo = (Goodsvideo) object;
        String id = goodsvideo.getGoodsid();

//        保存用户上传的视频文件
        int size = goodsvideo.getVideoFiles().size();
        Goodsvideo goodsvideo2;
        for (int i = 0; i < size; i++) {
            MultipartFile file = goodsvideo.getVideoFiles().get(i);
            String src = MyUtil.fileSave(file, "uploadFiles/video/");

            goodsvideo2 = new Goodsvideo();
            goodsvideo2.setId(MyUtil.getTableId());
            goodsvideo2.setGoodsid(id);
            goodsvideo2.setImage(src);
//             保存到数据库
            goodsvideoMapper.insertSelective(goodsvideo2);
        }

        return new MsgBean(true,"插入数据成功",true);
    }

    @Override
    public MsgBean updateByPrimaryKeySelective(Object object) {
        if(object == null ){
            return new MsgBean(false,"数据为空无法更新",false);
        }
//        要修改的数据对象
        Goodsvideo goodsvideo = (Goodsvideo) object;
        String id = goodsvideo.getGoodsid();

//        数据库中已有的数据对象
        Goodsvideo  goodsvideo2 = goodsvideoMapper.selectByPrimaryKey(id);
        if(goodsvideo2 == null){
            return new MsgBean(false,"数据错误",false);
        }

//        将新上传的视频存入磁盘
        String src = MyUtil.fileSave(goodsvideo.getVideoFiles().get(0),"uploadFiles/video/");
//        修改数据库中存储的视频路径
        goodsvideo.setImage(src);

        if(goodsvideoMapper.updateByPrimaryKeySelective(goodsvideo) <= 0){
//            数据库更新失败，将上传的视频删除
            MyUtil.deleteFile(src);
            return new MsgBean(true,"更新数据失败",false);
        }
//        数据库记录更新成功，删除原有的视频
        MyUtil.deleteFile(goodsvideo2.getImage());

        return new MsgBean(true,"更新数据成功",true);
    }

    @Override
    public MsgBean deleteByPrimaryKey(String id) {
        if(id == null ){
            return new MsgBean(false,"数据为空无法删除",false);
        }
//        数据库中已有的数据对象
        Goodsvideo  goodsvideo = goodsvideoMapper.selectByPrimaryKey(id);
        if(goodsvideo == null){
            return new MsgBean(false,"数据错误",false);
        }

        if(goodsvideoMapper.deleteByPrimaryKey(id) <= 0){
            return new MsgBean(true,"删除数据失败",false);
        }
//        数据库记录删除成功，删除原有的视频
        MyUtil.deleteFile(goodsvideo.getImage());

        return new MsgBean(true,"删除数据成功",true);
    }


    @Override
    public MsgBean queryByGoodsId(String goodsid) {
        GoodsvideoExample example = new GoodsvideoExample();
        GoodsvideoExample.Criteria criteria = example.createCriteria();

        criteria.andGoodsidEqualTo(goodsid);
        example.setOrderByClause("createTime desc");

        List<Goodsvideo> Goodsvideos = goodsvideoMapper.selectByExample(example);

        return new MsgBean(true, "查询数据成功", Goodsvideos);

    }
}
