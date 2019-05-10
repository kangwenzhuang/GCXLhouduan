package com.kang.qiandao.mapper;


import com.kang.qiandao.model.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DictionaryMapper extends tk.mybatis.mapper.common.Mapper<Dictionary> {

    List<?> typeList();
}