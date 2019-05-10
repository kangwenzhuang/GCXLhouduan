package com.kang.qiandao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    /**
     * 学号
     */
    private String xuehao;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 密码
     */
    private String password;

    /**
     * 0：老师
     * 1：学生
     */
    private Integer shenfen;

    /**
     * 0：停用
     * 1：正常
     * 3：其他
     */
    private Integer status;


    /**
     * 头像
     */
    private String imageurl;

    /**
     * 性别
     */
    private String sex;


    private Integer logined;


    private String motto;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取学号
     *
     * @return xuehao - 学号
     */
    public String getXuehao() {
        return xuehao;
    }

    /**
     * 设置学号
     *
     * @param xuehao 学号
     */
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取0：老师
     * 1：学生
     *
     * @return shenfen - 0：老师
     * 1：学生
     */
    public Integer getShenfen() {
        return shenfen;
    }

    /**
     * 设置0：老师
     * 1：学生
     *
     * @param shenfen 0：老师
     *                1：学生
     */
    public void setShenfen(Integer shenfen) {
        this.shenfen = shenfen;
    }

    /**
     * 获取0：停用
     * 1：正常
     * 3：其他
     *
     * @return status - 0：停用
     * 1：正常
     * 3：其他
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：停用
     * 1：正常
     * 3：其他
     *
     * @param status 0：停用
     *               1：正常
     *               3：其他
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取头像
     *
     * @return imageurl - 头像
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * 设置头像
     *
     * @param imageurl 头像
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLogined() {
        return logined;
    }

    public void setLogined(Integer logined) {
        this.logined = logined;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", xuehao='" + xuehao + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", shenfen=" + shenfen +
                ", status=" + status +
                ", imageurl='" + imageurl + '\'' +
                ", sex='" + sex + '\'' +
                ", logined=" + logined +
                ", motto='" + motto + '\'' +
                '}';
    }


}