package com.kang.qiandao.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConstant {
    @Value("${user.image.path}")
    public   String userImagePath;
    @Value("${course.image.path}")
    public   String courseImagePath;
    @Value("${server.ip}")
    public   String serverIp;
}
