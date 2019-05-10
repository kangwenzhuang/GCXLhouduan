package com.kang.qiandao.mapper;

import com.kang.qiandao.model.Qiandao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QiandaoMapper extends tk.mybatis.mapper.common.Mapper<Qiandao> {
    List<Qiandao> qiandaoList(Qiandao qiandao);
}