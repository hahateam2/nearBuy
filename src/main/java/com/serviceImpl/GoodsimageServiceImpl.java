package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.GoodsimageMapper;
import com.model.Goods;
import com.model.Goodsimage;

import com.model.Goodsvideo;
import com.model.MsgBean;
import com.service.GoodsimageService;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class GoodsimageServiceImpl extends BaseServiceImpl<Goodsimage> implements GoodsimageService {

    @Autowired
    private GoodsimageMapper goodsimageMapper;
    private BaseDao<Goodsimage> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.goodsimageMapper=(GoodsimageMapper) object;
        super.setBaseDao(this.goodsimageMapper);
    }

    @Override
    public MsgBean instert(Object object) {
        if(object == null ){
            return new MsgBean(false,"数据为空无法创建",false);
        }

        Goodsimage goodsimage = (Goodsimage) object;
        String id = goodsimage.getGoodsid();

//        保存用户上传的图片文件
        int size = goodsimage.getImageFiles().size();
        Goodsimage goodsimage2;
        for (int i = 0; i < size; i++) {
            MultipartFile file = goodsimage.getImageFiles().get(i);
            String src = MyUtil.fileSave(file, "uploadFiles/image/");

            String type = goodsimage.getImageType().get(i) != null ? goodsimage.getImageType().get(i) : "物品";
            goodsimage2 = new Goodsimage();
            goodsimage2.setId(MyUtil.getTableId());
            goodsimage2.setGoodsid(id);
            goodsimage2.setImage(src);
            goodsimage2.setType(type);
//             保存到数据库
            goodsimageMapper.insertSelective(goodsimage2);
        }

        return new MsgBean(true,"插入数据成功",true);
    }



    @Override
    public MsgBean updateByPrimaryKeySelective(Object object) {
        if(object == null ){
            return new MsgBean(false,"数据为空无法更新",false);
        }
//        要修改的数据对象
        Goodsimage goodsimage = (Goodsimage) object;
        String id = goodsimage.getGoodsid();

//        数据库中已有的数据对象
        Goodsimage  goodsimage2 = goodsimageMapper.selectByPrimaryKey(id);
        if(goodsimage2 == null){
            return new MsgBean(false,"数据错误",false);
        }

//        将新上传的图片存入磁盘
        String src = MyUtil.fileSave(goodsimage.getImageFiles().get(0),"uploadFiles/image/");
//        修改数据库中存储的图片路径
        goodsimage.setImage(src);

        if(goodsimageMapper.updateByPrimaryKeySelective(goodsimage) <= 0){
//            数据库更新失败，将上传的图片删除
            MyUtil.deleteFile(src);
            return new MsgBean(true,"更新数据失败",false);
        }
//        数据库记录更新成功，删除原有的图片
        MyUtil.deleteFile(goodsimage2.getImage());

        return new MsgBean(true,"更新数据成功",true);
    }

    @Override
    public MsgBean deleteByPrimaryKey(String id) {
        if(id == null ){
            return new MsgBean(false,"数据为空无法删除",false);
        }
//        数据库中已有的数据对象
        Goodsimage  goodsimage2 = goodsimageMapper.selectByPrimaryKey(id);
        if(goodsimage2 == null){
            return new MsgBean(false,"数据错误",false);
        }

        if(goodsimageMapper.deleteByPrimaryKey(id) <= 0){
            return new MsgBean(true,"删除数据失败",false);
        }
//        数据库记录删除成功，删除原有的图片
        MyUtil.deleteFile(goodsimage2.getImage());

        return new MsgBean(true,"删除数据成功",true);
    }
}
