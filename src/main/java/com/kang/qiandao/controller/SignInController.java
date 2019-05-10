package com.kang.qiandao.controller;


import com.kang.qiandao.bean.Messsage;
import com.kang.qiandao.bean.ReturnOut;
import com.kang.qiandao.constant.PropertyConstant;
import com.kang.qiandao.mapper.UserMapper;
import com.kang.qiandao.model.*;
import com.kang.qiandao.service.SignInService;
import com.kang.qiandao.utils.Base64Util;
import com.kang.qiandao.utils.FileDownload;
import com.kang.qiandao.utils.IdGeneratorUtil;
import com.kang.qiandao.utils.sendMessage.SendMessageTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@Controller
@RequestMapping("/signin")
public class SignInController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SignInService signInService;
    @Autowired
    PropertyConstant propertyConstant;

    @RequestMapping("/hqkch")
    @ResponseBody
    public ReturnOut hqkch() {
        return signInService.hqkch();
    }

    @RequestMapping("/addCourse")
    @ResponseBody
    public ReturnOut addCourse(@RequestBody Course course) {
        return signInService.addCourse(course);
    }

    @RequestMapping(value = "/courseImageDownload")
    @ResponseBody
    public void fileDownload(HttpServletResponse response, @RequestParam String id) throws Exception {

        FileDownload.fileDownload(response, propertyConstant.courseImagePath + id);
    }

    @RequestMapping(value = "/userImageDownload")
    @ResponseBody
    public void userImageDownload(HttpServletResponse response, @RequestParam String id) throws Exception {

        FileDownload.fileDownload(response, propertyConstant.userImagePath + id);
    }

    @RequestMapping(value = "/getCreateCourse")
    @ResponseBody
    public ReturnOut getCreateCourse(@RequestBody Course course) {
        return signInService.getCreateCourse(course);
    }


    @RequestMapping(value = "/searchByKch")
    @ResponseBody
    public ReturnOut searchByKch(@RequestBody Course course) {
        return signInService.searchByKch(course);
    }

    @RequestMapping(value = "/zhuCed")
    @ResponseBody
    public ReturnOut zhuCed(@RequestBody User user) {
        return signInService.zhuCed(user);
    }

    @PostMapping(value = "/zhuCe")
    @ResponseBody
    public ReturnOut zhuCe(@RequestBody User user) {
        return signInService.zhuCe(user);
    }

    @RequestMapping(value = "/denglu")
    @ResponseBody
    public ReturnOut denglu(@RequestBody User user) {
        return signInService.denglu(user);
    }

    @RequestMapping(value = "/wanshanUser")
    @ResponseBody
    public ReturnOut wanshanUser(@RequestBody User user) {
        return signInService.wanshanUser(user);
    }

    @RequestMapping(value = "/findUser")
    @ResponseBody
    public ReturnOut findUser(@RequestBody User user) {
        return signInService.findUser(user);
    }

    @RequestMapping(value = "/joinCourse")
    @ResponseBody
    public ReturnOut joinCourse(@RequestBody Joincourse joincourse) {
        return signInService.joinCourse(joincourse);
    }

    @RequestMapping(value = "/joinedCourse")
    @ResponseBody
    public ReturnOut joinCourse(@RequestBody User user) {
        return signInService.joinedCourse(user);
    }

    /**
     * 发送短信
     */
    @RequestMapping(value = "sendMessage")
    @ResponseBody
    public ReturnOut sendMessage(@RequestBody Messsage message) {
        ReturnOut returnOut = new ReturnOut();
        SendMessageTest.testSendSms(message.getSid(), message.getToken(), message.getAppid(), message.getTemplateid(), message.getParam(), message.getMobile(), "kangwenzhuang");
        return returnOut;
    }

    @RequestMapping(value = "updateUser")
    @ResponseBody
    public ReturnOut updateUser(@RequestBody User user) {
        return signInService.updateUser(user);
    }

    @RequestMapping(value = "beginQiandao")
    @ResponseBody
    public ReturnOut beginQiandao(@RequestBody Course course) {
        return signInService.beginQiandao(course);
    }

    @RequestMapping(value = "cancelQiandao")
    @ResponseBody
    public ReturnOut cancelQiandao(@RequestBody Course course) {
        return signInService.cancelQiandao(course);
    }

    @RequestMapping(value = "qiandaoStatus")
    @ResponseBody
    public ReturnOut qiandaoStatus(@RequestBody Course course) {
        return signInService.qiandaoStatus(course);
    }

    @RequestMapping(value = "manListOfChooseSomeBanke")
    @ResponseBody
    public ReturnOut manListOfChooseSomeBanke(@RequestBody Joincourse joincourse) {

        return signInService.manListOfChooseSomeBanke(joincourse);
    }

    @RequestMapping(value = "courseDetail")
    @ResponseBody
    public ReturnOut courseDetail(@RequestBody Course course) {

        return signInService.courseDetail(course);
    }

    @RequestMapping(value = "qiandao")
    @ResponseBody
    public ReturnOut qiandao(@RequestBody Course course, @RequestParam String id) {

        return signInService.qiandao(course, id);
    }

    @RequestMapping(value = "qiandaoList")
    @ResponseBody
    public ReturnOut qiandaoList(@RequestBody Qiandao qiandao) {

        return signInService.qiandaoList(qiandao);
    }

    @PostMapping(value = "userImageUpload")
    @ResponseBody
    public ReturnOut fileUpload(@RequestBody User user) throws Exception {

        ReturnOut returnOut = new ReturnOut();
        String id = user.getId();
        User user1 = new User();
        user1.setId(id);
        User user2 = userMapper.selectOne(user1);
        String name = user.getName();
        MultipartFile papa = Base64Util.base64ToMultipart(name);
        //如果文件不为空，写入上传路径
        if (!papa.isEmpty()) {
            //上传文件路径
            String path = propertyConstant.userImagePath;
            //上传文件名
            String filename = IdGeneratorUtil.getId() + ".jpg";
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            papa.transferTo(new File(path + File.separator + filename));
            user2.setImageurl("userImageDownload?id=" + filename);
            userMapper.updateByPrimaryKey(user2);
            Map map = new HashMap();
            map.put("url", "userImageDownload?id=" + filename);
            returnOut.setData(map);
            return returnOut;
        } else {
            returnOut.setResultCode(0);
            returnOut.setResultMessage("上传文件发生异常了");
            return returnOut;
        }
    }

    @PostMapping(value = "courseImageUpload")
    @ResponseBody
    public ReturnOut courseImageUpload(@RequestBody User user) throws Exception {

        ReturnOut returnOut = new ReturnOut();
        String name = user.getName();
        MultipartFile papa = Base64Util.base64ToMultipart(name);
        //如果文件不为空，写入上传路径
        if (!papa.isEmpty()) {
            //上传文件路径
            String path = propertyConstant.courseImagePath;
            //上传文件名
            String filename = IdGeneratorUtil.getId() + ".jpg";
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            papa.transferTo(new File(path + File.separator + filename));
            Map map = new HashMap();
            map.put("url", "courseImageDownload?id=" + filename);
            returnOut.setData(map);
            return returnOut;
        } else {
            returnOut.setResultCode(0);
            returnOut.setResultMessage("上传文件发生异常了");
            return returnOut;
        }
    }

    @RequestMapping(value = "typeList")
    @ResponseBody
    public ReturnOut typeList() {

        return signInService.typeList();
    }
}
