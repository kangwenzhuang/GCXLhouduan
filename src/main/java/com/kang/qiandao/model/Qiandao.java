package com.kang.qiandao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Table(name = "qiandao")
public class Qiandao {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    public String getQiandaoid() {
        return qiandaoid;
    }

    public void setQiandaoid(String qiandaoid) {
        this.qiandaoid = qiandaoid;
    }

    private String qiandaoid;
    /**
     * 签到的课id
     */
    private String courseid;

    /**
     * 签到者id
     */
    private String userid;

    /**
     * 0：缺勤
1：正常
2：迟到
3：请假
4：其他
     */
    private Integer status;

    /**
     * 签到开始时间
     */
    private Date begintime;

    /**
     * 签到结束时间
     */
    private Date overtime;

    public Date getQiandaotime() {
        return qiandaotime;
    }

    public void setQiandaotime(Date qiandaotime) {
        this.qiandaotime = qiandaotime;
    }

    private Date qiandaotime;

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
     * 获取签到的课id
     *
     * @return courseid - 签到的课id
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * 设置签到的课id
     *
     * @param courseid 签到的课id
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * 获取签到者id
     *
     * @return userid - 签到者id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置签到者id
     *
     * @param userid 签到者id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取0：缺勤
1：正常
2：迟到
3：请假
4：其他
     *
     * @return status - 0：缺勤
1：正常
2：迟到
3：请假
4：其他
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：缺勤
1：正常
2：迟到
3：请假
4：其他
     *
     * @param status 0：缺勤
1：正常
2：迟到
3：请假
4：其他
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取签到开始时间
     *
     * @return begintime - 签到开始时间
     */
    public Date getBegintime() {
        return begintime;
    }

    /**
     * 设置签到开始时间
     *
     * @param begintime 签到开始时间
     */
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    /**
     * 获取签到结束时间
     *
     * @return overtime - 签到结束时间
     */
    public Date getOvertime() {
        return overtime;
    }

    /**
     * 设置签到结束时间
     *
     * @param overtime 签到结束时间
     */
    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qiandao qiandao = (Qiandao) o;
        return Objects.equals(id, qiandao.id) &&
                Objects.equals(qiandaoid, qiandao.qiandaoid) &&
                Objects.equals(courseid, qiandao.courseid) &&
                Objects.equals(userid, qiandao.userid) &&
                Objects.equals(status, qiandao.status) &&
                Objects.equals(begintime, qiandao.begintime) &&
                Objects.equals(overtime, qiandao.overtime) &&
                Objects.equals(qiandaotime, qiandao.qiandaotime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qiandaoid, courseid, userid, status, begintime, overtime, qiandaotime);
    }

    @Override
    public String toString() {
        return "Qiandao{" +
                "id='" + id + '\'' +
                ", qiandaoid='" + qiandaoid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", userid='" + userid + '\'' +
                ", status=" + status +
                ", begintime=" + begintime +
                ", overtime=" + overtime +
                ", qiandaotime=" + qiandaotime +
                '}';
    }
}