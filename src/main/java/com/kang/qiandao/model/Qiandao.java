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
     * ����
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
     * ǩ���Ŀ�id
     */
    private String courseid;

    /**
     * ǩ����id
     */
    private String userid;

    /**
     * 0��ȱ��
1������
2���ٵ�
3�����
4������
     */
    private Integer status;

    /**
     * ǩ����ʼʱ��
     */
    private Date begintime;

    /**
     * ǩ������ʱ��
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
     * ��ȡǩ���Ŀ�id
     *
     * @return courseid - ǩ���Ŀ�id
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * ����ǩ���Ŀ�id
     *
     * @param courseid ǩ���Ŀ�id
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * ��ȡǩ����id
     *
     * @return userid - ǩ����id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * ����ǩ����id
     *
     * @param userid ǩ����id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡ0��ȱ��
1������
2���ٵ�
3�����
4������
     *
     * @return status - 0��ȱ��
1������
2���ٵ�
3�����
4������
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * ����0��ȱ��
1������
2���ٵ�
3�����
4������
     *
     * @param status 0��ȱ��
1������
2���ٵ�
3�����
4������
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * ��ȡǩ����ʼʱ��
     *
     * @return begintime - ǩ����ʼʱ��
     */
    public Date getBegintime() {
        return begintime;
    }

    /**
     * ����ǩ����ʼʱ��
     *
     * @param begintime ǩ����ʼʱ��
     */
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    /**
     * ��ȡǩ������ʱ��
     *
     * @return overtime - ǩ������ʱ��
     */
    public Date getOvertime() {
        return overtime;
    }

    /**
     * ����ǩ������ʱ��
     *
     * @param overtime ǩ������ʱ��
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