package com.kang.qiandao.service;

import com.kang.qiandao.bean.ReturnOut;
import com.kang.qiandao.constant.PropertyConstant;
import com.kang.qiandao.mapper.*;
import com.kang.qiandao.model.Course;
import com.kang.qiandao.model.Dictionary;
import com.kang.qiandao.model.Joincourse;
import com.kang.qiandao.model.Qiandao;
import com.kang.qiandao.model.User;
import com.kang.qiandao.utils.IdGeneratorUtil;
import com.kang.qiandao.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class SignInService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    JoincourseMapper joincourseMapper;

    @Autowired
    QiandaoMapper qiandaoMapper;

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Autowired
    DictionarydataMapper dictionarydataMapper;

    @Autowired
    PropertyConstant propertyConstant;

    public ReturnOut hqkch() {
        ReturnOut returnOut = new ReturnOut();
        Course course = new Course();
        course.setKch(RandomNumber.getRandom());
        while (courseMapper.selectOne(course) != null) {
            course.setKch(RandomNumber.getRandom());
        }
        Map<String, String> map = new HashMap();
        map.put("kch", course.getKch());
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut addCourse(Course course) {
        ReturnOut returnOut = new ReturnOut();
        Date date = new Date();
        Course course1 = new Course();
        course1.setBanji(course.getBanji());
        course1.setKch(course.getKch());
        course1.setKcm(course.getKcm());
        course1.setUserid(course.getUserid());
        course1.setUsername(course.getUsername());
        course1.setImageurl(course.getImageurl());
        course1.setId(IdGeneratorUtil.getId());
        course1.setStatus("1");
        course1.setBeginqiandao(0);
        course1.setCreatetime(date);
        courseMapper.insert(course1);
        Map<String, Course> map = new HashMap();
        map.put("添加的课", course1);
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut getCreateCourse(Course course) {
        ReturnOut returnOut = new ReturnOut();
        Course course1 = new Course();
        course1.setUserid(course.getUserid());
        List<Course> list = new ArrayList();
        list = courseMapper.select(course1);
        for (Course c : list) {
            c.setImageurl(propertyConstant.serverIp + c.getImageurl());
        }
        Map<String, List<Course>> map = new HashMap();
        map.put("getCreateCourse", list);
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut searchByKch(Course course) {
        ReturnOut returnOut = new ReturnOut();
        Course course1 = new Course();
        Map<String, Course> map = new HashMap();
        course1.setKch(course.getKch());
        if (courseMapper.selectOne(course1) == null) {
            returnOut.setResultCode(2);
            returnOut.setResultMessage("没有该课程！！！");
        } else if ((courseMapper.selectOne(course1).getUserid()).equals(course.getUserid())) {
            course1 = courseMapper.selectOne(course1);
            returnOut.setResultCode(3);
            returnOut.setResultMessage("自己创建的课程！！！");
            course1.setImageurl(propertyConstant.serverIp + course1.getImageurl());
            map.put("searchByKch", course1);
            returnOut.setData(map);
        } else {
            course1 = courseMapper.selectOne(course1);
            course1.setImageurl(propertyConstant.serverIp + course1.getImageurl());
            map.put("searchByKch", course1);
            returnOut.setData(map);
        }
        return returnOut;
    }

    public ReturnOut zhuCed(User user) {
        ReturnOut returnOut = new ReturnOut();
        User user1 = new User();
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());
        if (userMapper.selectOne(user1) != null) {
            returnOut.setResultCode(2);
            returnOut.setResultMessage("你已经注册过了");
        } else {
            returnOut.setResultMessage("尚未注册");
        }
        return returnOut;
    }

    public ReturnOut zhuCe(User user) {
        ReturnOut returnOut = new ReturnOut();
        User user3 = new User();
        user3.setPhone(user.getPhone());
        if (userMapper.selectOne(user3) == null) {
            User user1 = new User();
            user1.setId(IdGeneratorUtil.getId());
            user1.setPhone(user.getPhone());
            user1.setPassword(user.getPassword());
            user1.setLogined(0);
            userMapper.insert(user1);
            returnOut.setResultMessage("注册成功");
        }
        return returnOut;
    }

    public ReturnOut denglu(User user) {
        ReturnOut returnOut = new ReturnOut();
        User user1 = new User();
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());
        User user2 = userMapper.selectOne(user1);
        if (userMapper.selectOne(user1) == null) {
            returnOut.setResultCode(2);
            returnOut.setResultMessage("账号密码错误");
        } else if (userMapper.selectOne(user1).getLogined() == 0) {
            returnOut.setResultCode(3);
            returnOut.setResultMessage("尚未登陆过,需要完善信息");
        } else {
            returnOut.setResultMessage("登陆成功");
        }
        return returnOut;
    }

    public ReturnOut wanshanUser(User user) {
        ReturnOut returnOut = new ReturnOut();
        User user2 = new User();
        user2.setPhone(user.getPhone());
        User user1 = userMapper.selectOne(user2);
        user1.setXuehao(user.getXuehao());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setLogined(1);
        userMapper.delete(user2);
        userMapper.insert(user1);
        returnOut.setResultMessage("完善成功");
        return returnOut;
    }

    public ReturnOut findUser(User user) {
        ReturnOut returnOut = new ReturnOut();
        User user1 = new User();
        user1.setPhone(user.getPhone());
        Map<String, User> map = new HashMap<>();
        map.put("findUser", userMapper.selectOne(user1));
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut joinCourse(Joincourse joincourse) {
        ReturnOut returnOut = new ReturnOut();
        if (joincourseMapper.selectOne(joincourse) != null) {
            returnOut.setResultCode(2);
            returnOut.setResultMessage("插入失败,你已经添加过！！！");
        } else {
            Joincourse joincourse1 = new Joincourse();
            joincourse1.setId(IdGeneratorUtil.getId());
            joincourse1.setCourseid(joincourse.getCourseid());
            joincourse1.setUserid(joincourse.getUserid());
            joincourse1.setStatus(0);
            joincourseMapper.insert(joincourse1);
            returnOut.setData(joincourse1);
            returnOut.setResultMessage("插入成功");
        }
        return returnOut;
    }

    public ReturnOut joinedCourse(User user) {
        ReturnOut returnOut = new ReturnOut();
        Joincourse joincourse = new Joincourse();
        Course course = new Course();
        List<Course> courseList = new ArrayList<>();
        Map<String, List<Course>> map = new HashMap<>();
        joincourse.setUserid(user.getId());
        List<Joincourse> list = joincourseMapper.select(joincourse);
        for (Joincourse jj : list) {
            course.setId(jj.getCourseid());
            courseList.add(courseMapper.selectOne(course));
        }
        for (Course c : courseList) {
            c.setImageurl(propertyConstant.serverIp + c.getImageurl());
        }
        map.put("joinedCourse", courseList);
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut updateUser(User user) {
        ReturnOut returnOut = new ReturnOut();
        User user1 = new User();
        User user2 = new User();
        user2.setId(user.getId());
        User user3 = userMapper.selectOne(user2);
        user1.setId(user.getId());
        userMapper.delete(user1);
        userMapper.insert(user);
        if (user3.getName().equals(user.getName())) {
        } else {
            Course course = new Course();
            course.setUsername(user3.getName());
            List<Course> list = courseMapper.select(course);
            for (Course cc : list) {
                courseMapper.delete(cc);
                cc.setUsername(user.getName());
                courseMapper.insert(cc);
            }
        }
        return returnOut;
    }

    public ReturnOut qiandaoStatus(Course course) {
        ReturnOut returnOut = new ReturnOut();
        Course course1 = courseMapper.selectOne(course);
        boolean qiandao;
        if (course1.getBeginqiandao() == 0) {
            qiandao = false;
        } else {
            qiandao = true;
        }
        returnOut.setData(qiandao);
        return returnOut;
    }

    public ReturnOut beginQiandao(Course course) {
        ReturnOut returnOut = new ReturnOut();
        Date date = new Date();
        Course course1 = courseMapper.selectOne(course);
        course1.setBeginqiandao(1);
        course1.setQiandaoid(IdGeneratorUtil.getId());
        course1.setQiandaobegintime(date);
        courseMapper.updateByPrimaryKey(course1);
        return returnOut;
    }

    public ReturnOut cancelQiandao(Course course) {
        ReturnOut returnOut = new ReturnOut();
        //1.课先取消签到，置为0
        Course course1 = courseMapper.selectOne(course);
        course1.setBeginqiandao(0);
        Date date = new Date();
        courseMapper.updateByPrimaryKey(course1);
        //2.查找选择这个课的JoincourseList
        Joincourse joincourse = new Joincourse();
        joincourse.setCourseid(course.getId());
        List<Joincourse> list = joincourseMapper.select(joincourse);
        List<Qiandao> allqiandao = new ArrayList<>();
        for (Joincourse jo : list) {
            Qiandao qiandao = new Qiandao();
            qiandao.setCourseid(jo.getCourseid());
            qiandao.setUserid(jo.getUserid());
            qiandao.setQiandaoid(course1.getQiandaoid());
            allqiandao.add(qiandao);
        }
//        for(Qiandao q:allqiandao){
//            System.out.println("11111+1"+q);
//        }
        List<Qiandao> qiandaoList = new ArrayList<>();//正常签到，只有3列
        List<Qiandao> qiandaoList1 = new ArrayList<>();
        Qiandao qiandao1 = new Qiandao();
        qiandao1.setQiandaoid(course1.getQiandaoid());
        qiandaoList1 = qiandaoMapper.select(qiandao1);//正常签到
        for (Qiandao qd : qiandaoList1) {
            Qiandao qiandao2 = new Qiandao();
            qiandao2.setCourseid(qd.getCourseid());
            qiandao2.setUserid(qd.getUserid());
            qiandao2.setQiandaoid(qd.getQiandaoid());
            qiandaoList.add(qiandao2);
        }
//        for(Qiandao q:qiandaoList){
//            System.out.println("11111+2"+q);
//        }
        allqiandao.removeAll(qiandaoList);//没签到列表，只有3列
//        for(Qiandao q:allqiandao){
//            System.out.println("11111+3"+q);
//        }
        List<Qiandao> noqiandaoList = new ArrayList<>();//没签到列表
        for (Qiandao qq : allqiandao) {
            qq.setId(IdGeneratorUtil.getId());
            qq.setStatus(0);
            qq.setBegintime(course1.getQiandaobegintime());
            noqiandaoList.add(qq);
            qiandaoMapper.insert(qq);
        }
        List<Qiandao> llall = new ArrayList<>();//全部签到情况
        for (Qiandao qi : qiandaoList1) {
            qi.setOvertime(date);
            qiandaoMapper.updateByPrimaryKey(qi);
            llall.add(qi);
        }
        for (Qiandao qi : noqiandaoList) {
            qi.setOvertime(date);
            qi.setQiandaotime(course1.getQiandaobegintime());
            qiandaoMapper.updateByPrimaryKey(qi);
            llall.add(qi);
        }
        returnOut.setData(llall);
        return returnOut;
    }

    public ReturnOut manListOfChooseSomeBanke(Joincourse joincourse) {
        ReturnOut returnOut = new ReturnOut();
        User user = new User();
        List<Joincourse> list1 = joincourseMapper.select(joincourse);
        returnOut.setResultCode(list1.size());
        List<User> list2 = new ArrayList();
        for (Joincourse j : list1) {
            user.setId(j.getUserid());
            list2.add(userMapper.selectOne(user));
        }
        Map map = new HashMap<String, List<User>>();
        map.put("manListOfChooseSomeBanke", list2);
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut courseDetail(Course course) {
        ReturnOut returnOut = new ReturnOut();
        Course course1 = courseMapper.selectOne(course);
        Map map = new HashMap<String, Course>();
        map.put("course", course1);
        System.out.println("+++++++" + course1);
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut qiandao(Course course, String id) {
        ReturnOut returnOut = new ReturnOut();
        Qiandao qiandao = new Qiandao();
        Course course1 = courseMapper.selectOne(course);
        Qiandao qiandao1 = new Qiandao();
        qiandao1.setQiandaoid(course1.getQiandaoid());
        qiandao1.setUserid(id);
        if (course1.getBeginqiandao() == 0) {
            returnOut.setResultCode(0);
            returnOut.setResultMessage(course1.getUsername() + " 老师还没有开始签到或签到已结束");
        } else if (!(qiandaoMapper.select(qiandao1).isEmpty())) {
            returnOut.setResultCode(2);
            returnOut.setResultMessage("请勿重复签到");
        } else {
            Date date = new Date();
            qiandao.setId(IdGeneratorUtil.getId());
            qiandao.setQiandaoid(course1.getQiandaoid());
            qiandao.setCourseid(course1.getId());
            qiandao.setUserid(id);
            qiandao.setStatus(1);
            qiandao.setBegintime(course1.getQiandaobegintime());
            qiandao.setQiandaotime(date);
            qiandaoMapper.insert(qiandao);
            returnOut.setData(qiandao);
        }
        return returnOut;
    }

    public ReturnOut qiandaoList(Qiandao qiandao) {
        ReturnOut returnOut = new ReturnOut();
//        List<Qiandao> list = qiandaoMapper.select(qiandao);
        List<Qiandao> list = qiandaoMapper.qiandaoList(qiandao);
        Map<String, List<Qiandao>> map = new HashMap<>();
        map.put("qiandaoList", list);
        returnOut.setData(map);
        return returnOut;
    }

    public ReturnOut typeList() {
        ReturnOut returnOut = new ReturnOut();
//        List<Dictionary> typeList = new ArrayList<>();
        List<Dictionary> typeList = dictionaryMapper.selectAll();
        Map<String, List<Dictionary>> map = new HashMap<>();
        map.put("typeList", typeList);
        returnOut.setData(map);
        return returnOut;
    }
}
