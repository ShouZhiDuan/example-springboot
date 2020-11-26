package com.example.dsz.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/26 15:51
 * @Description:
 */
public interface MyTkMapper<T> extends BaseMapper<T>, InsertListMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

}
