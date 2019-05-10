package com.kang.qiandao.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "joincourse")
public class Joincourse {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 课程号
     */
    private String courseid;

    /**
     * 参加者user表id
     */
    private String userid;

    /**
     * 参加课程状态
0：没结束
1：结束
2：没读完退出
3：老师删除课，由于某种原因
4：其他
     */
    private Integer status;

    /**
     * 分数
     */
    private Integer grade;

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
     * @return courseid - 课程号
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * 设置课程号
     *
     * @param courseid 课程号
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * 获取参加者user表id
     *
     * @return userid - 参加者user表id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置参加者user表id
     *
     * @param userid 参加者user表id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取参加课程状态
0：没结束
1：结束
2：没读完退出
3：老师删除课，由于某种原因
4：其他
     *
     * @return status - 参加课程状态
0：没结束
1：结束
2：没读完退出
3：老师删除课，由于某种原因
4：其他
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置参加课程状态
0：没结束
1：结束
2：没读完退出
3：老师删除课，由于某种原因
4：其他
     *
     * @param status 参加课程状态
0：没结束
1：结束
2：没读完退出
3：老师删除课，由于某种原因
4：其他
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取分数
     *
     * @return grade - 分数
     */
    public Integer getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Joincourse{" +
                "id='" + id + '\'' +
                ", courseid='" + courseid + '\'' +
                ", userid='" + userid + '\'' +
                ", status=" + status +
                ", grade=" + grade +
                '}';
    }

    /**
     * 设置分数
     *
     * @param grade 分数
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

}