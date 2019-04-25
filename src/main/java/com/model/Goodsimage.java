package com.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

public class Goodsimage {
    private String id;

    private String goodsid;

    private String image;

    private String type;

    private List<MultipartFile> imageFiles;

    /**
     * 每张图片的类型描述,如主图，物品图，详情图等
     */
    private List<String> imageType = new LinkedList<>();


    public List<MultipartFile> getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(List<MultipartFile> imageFiles) {
        this.imageFiles = imageFiles;
    }

    public List<String> getImageType() {
        return imageType;
    }

    public void setImageType(List<String> imageType) {
        this.imageType = imageType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}