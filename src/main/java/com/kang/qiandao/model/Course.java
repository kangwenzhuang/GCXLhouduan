package com.kang.qiandao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "course")
public class Course {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    /**
     * 创建班级
     */
    private String banji;
    /**
     * 课程号
     */
    private String kch;

    private String kcm;

    /**
     * 创建者user表id
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
     * 创建人
     */
    private String username;
    /**
     * 课程照片url
     */
    private String imageurl;

    /**
     * 开始时间
     */
    private Date createtime;

    /**
     * 结束时间
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
     * 课程状态
0：借宿
1：开始
2：某种原因删除
3：其他
     */
    private String status;

    /**
     * 是否开启签到
0：没开
1：开启
     */
    private Integer beginqiandao;

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
     * 获取课程号
     *
     * @return kch - 课程号
     */
    public String getKch() {
        return kch;
    }

    /**
     * 设置课程号
     *
     * @param kch 课程号
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
     * 获取创建者user表id
     *
     * @return userid - 创建者user表id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置创建者user表id
     *
     * @param userid 创建者user表id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取课程照片url
     *
     * @return imageurl - 课程照片url
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * 设置课程照片url
     *
     * @param imageurl 课程照片url
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * 获取开始时间
     *
     * @return createtime - 开始时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置开始时间
     *
     * @param createtime 开始时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取结束时间
     *
     * @return overtime - 结束时间
     */
    public Date getOvertime() {
        return overtime;
    }

    /**
     * 设置结束时间
     *
     * @param overtime 结束时间
     */
    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    /**
     * 获取课程状态
0：借宿
1：开始
2：某种原因删除
3：其他
     *
     * @return status - 课程状态
0：借宿
1：开始
2：某种原因删除
3：其他
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置课程状态
0：借宿
1：开始
2：某种原因删除
3：其他
     *
     * @param status 课程状态
0：借宿
1：开始
2：某种原因删除
3：其他
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取是否开启签到
0：没开
1：开启
     *
     * @return beginqiandao - 是否开启签到
0：没开
1：开启
     */
    public Integer getBeginqiandao() {
        return beginqiandao;
    }

    /**
     * 设置是否开启签到
0：没开
1：开启
     *
     * @param beginqiandao 是否开启签到
0：没开
1：开启
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