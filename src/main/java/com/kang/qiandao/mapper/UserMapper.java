package com.kang.qiandao.mapper;

import com.kang.qiandao.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
}