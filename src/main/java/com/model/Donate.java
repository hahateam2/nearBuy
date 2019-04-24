package com.model;

import java.util.Date;

public class Donate {
    private String id;

    private String userid;

    private String name;

    private String depict;

    private Date createtime;

    private String status;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    @Override
    public String toString() {
        return "Donate{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", depict='" + depict + '\'' +
                ", createtime=" + createtime +
                ", status='" + status + '\'' +
                '}';
    }
}