package com.kang.qiandao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "course")
public class Course {
    /**
     * ����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * �����༶
     */
    private String banji;
    /**
     * �γ̺�
     */
    private String kch;

    private String kcm;

    /**
     * ������user��id
     */
    private String userid;

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ������
     */
    private String username;
    /**
     * �γ���Ƭurl
     */
    private String imageurl;

    /**
     * ��ʼʱ��
     */
    private Date createtime;

    /**
     * ����ʱ��
     */
    private Date overtime;
    private String qiandaoid;

    public String getQiandaoid() {
        return qiandaoid;
    }

    public void setQiandaoid(String qiandaoid) {
        this.qiandaoid = qiandaoid;
    }

    public Date getQiandaobegintime() {
        return qiandaobegintime;
    }

    public void setQiandaobegintime(Date qiandaobegintime) {
        this.qiandaobegintime = qiandaobegintime;
    }

    private Date qiandaobegintime;

    /**
     * �γ�״̬
0������
1����ʼ
2��ĳ��ԭ��ɾ��
3������
     */
    private String status;

    /**
     * �Ƿ���ǩ��
0��û��
1������
     */
    private Integer beginqiandao;

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
     * ��ȡ�γ̺�
     *
     * @return kch - �γ̺�
     */
    public String getKch() {
        return kch;
    }

    /**
     * ���ÿγ̺�
     *
     * @param kch �γ̺�
     */
    public void setKch(String kch) {
        this.kch = kch;
    }

    /**
     * @return kcm
     */
    public String getKcm() {
        return kcm;
    }

    /**
     * @param kcm
     */
    public void setKcm(String kcm) {
        this.kcm = kcm;
    }

    /**
     * ��ȡ������user��id
     *
     * @return userid - ������user��id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * ���ô�����user��id
     *
     * @param userid ������user��id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡ�γ���Ƭurl
     *
     * @return imageurl - �γ���Ƭurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * ���ÿγ���Ƭurl
     *
     * @param imageurl �γ���Ƭurl
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * ��ȡ��ʼʱ��
     *
     * @return createtime - ��ʼʱ��
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * ���ÿ�ʼʱ��
     *
     * @param createtime ��ʼʱ��
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return overtime - ����ʱ��
     */
    public Date getOvertime() {
        return overtime;
    }

    /**
     * ���ý���ʱ��
     *
     * @param overtime ����ʱ��
     */
    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    /**
     * ��ȡ�γ�״̬
0������
1����ʼ
2��ĳ��ԭ��ɾ��
3������
     *
     * @return status - �γ�״̬
0������
1����ʼ
2��ĳ��ԭ��ɾ��
3������
     */
    public String getStatus() {
        return status;
    }

    /**
     * ���ÿγ�״̬
0������
1����ʼ
2��ĳ��ԭ��ɾ��
3������
     *
     * @param status �γ�״̬
0������
1����ʼ
2��ĳ��ԭ��ɾ��
3������
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * ��ȡ�Ƿ���ǩ��
0��û��
1������
     *
     * @return beginqiandao - �Ƿ���ǩ��
0��û��
1������
     */
    public Integer getBeginqiandao() {
        return beginqiandao;
    }

    /**
     * �����Ƿ���ǩ��
0��û��
1������
     *
     * @param beginqiandao �Ƿ���ǩ��
0��û��
1������
     */
    public void setBeginqiandao(Integer beginqiandao) {
        this.beginqiandao = beginqiandao;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", banji='" + banji + '\'' +
                ", kch='" + kch + '\'' +
                ", kcm='" + kcm + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", createtime=" + createtime +
                ", overtime=" + overtime +
                ", status='" + status + '\'' +
                ", beginqiandao=" + beginqiandao +
                '}';
    }
}