package com.tangyu.model;

import java.util.Date;

public class Code {
    private Long id;

    private String name;

    private String codes;

    private String orgCode;

    private Integer width;

    private Integer height;

    private Integer disturbNum;

    private Integer isLowerCase;

    private Integer expirtTime;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDisturbNum() {
        return disturbNum;
    }

    public void setDisturbNum(Integer disturbNum) {
        this.disturbNum = disturbNum;
    }

    public Integer getIsLowerCase() {
        return isLowerCase;
    }

    public void setIsLowerCase(Integer isLowerCase) {
        this.isLowerCase = isLowerCase;
    }

    public Integer getExpirtTime() {
        return expirtTime;
    }

    public void setExpirtTime(Integer expirtTime) {
        this.expirtTime = expirtTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}