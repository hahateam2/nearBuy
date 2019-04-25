package com.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Goodsvideo {
    private String id;

    private String goodsid;

    private String image;


    private List<MultipartFile> videoFiles;


    public List<MultipartFile> getVideoFiles() {
        return videoFiles;
    }

    public void setVideoFiles(List<MultipartFile> videoFiles) {
        this.videoFiles = videoFiles;
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
}