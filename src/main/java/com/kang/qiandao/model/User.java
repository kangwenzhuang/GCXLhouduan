package com.kang.qiandao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {
    /**
     * ����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    /**
     * ѧ��
     */
    private String xuehao;

    /**
     * ����
     */
    private String name;

    /**
     * �绰����
     */
    private String phone;

    /**
     * ����
     */
    private String mail;

    /**
     * ����
     */
    private String password;

    /**
     * 0����ʦ
     * 1��ѧ��
     */
    private Integer shenfen;

    /**
     * 0��ͣ��
     * 1������
     * 3������
     */
    private Integer status;


    /**
     * ͷ��
     */
    private String imageurl;

    /**
     * �Ա�
     */
    private String sex;


    private Integer logined;


    private String motto;

    /**
     * ��ȡ����
     *
     * @return id - ����
     */
    public String getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡѧ��
     *
     * @return xuehao - ѧ��
     */
    public String getXuehao() {
        return xuehao;
    }

    /**
     * ����ѧ��
     *
     * @param xuehao ѧ��
     */
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    /**
     * ��ȡ����
     *
     * @return name - ����
     */
    public String getName() {
        return name;
    }

    /**
     * ��������
     *
     * @param name ����
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ�绰����
     *
     * @return phone - �绰����
     */
    public String getPhone() {
        return phone;
    }

    /**
     * ���õ绰����
     *
     * @param phone �绰����
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * ��ȡ����
     *
     * @return mail - ����
     */
    public String getMail() {
        return mail;
    }

    /**
     * ��������
     *
     * @param mail ����
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * ��ȡ����
     *
     * @return password - ����
     */
    public String getPassword() {
        return password;
    }

    /**
     * ��������
     *
     * @param password ����
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ0����ʦ
     * 1��ѧ��
     *
     * @return shenfen - 0����ʦ
     * 1��ѧ��
     */
    public Integer getShenfen() {
        return shenfen;
    }

    /**
     * ����0����ʦ
     * 1��ѧ��
     *
     * @param shenfen 0����ʦ
     *                1��ѧ��
     */
    public void setShenfen(Integer shenfen) {
        this.shenfen = shenfen;
    }

    /**
     * ��ȡ0��ͣ��
     * 1������
     * 3������
     *
     * @return status - 0��ͣ��
     * 1������
     * 3������
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * ����0��ͣ��
     * 1������
     * 3������
     *
     * @param status 0��ͣ��
     *               1������
     *               3������
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * ��ȡͷ��
     *
     * @return imageurl - ͷ��
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * ����ͷ��
     *
     * @param imageurl ͷ��
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * ��ȡ�Ա�
     *
     * @return sex - �Ա�
     */
    public String getSex() {
        return sex;
    }

    /**
     * �����Ա�
     *
     * @param sex �Ա�
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