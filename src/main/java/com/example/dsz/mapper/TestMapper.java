package com.example.dsz.mapper;

import com.example.dsz.model.DszTest2;
import com.example.dsz.model.School2;
import org.apache.ibatis.annotations.Param;

public interface TestMapper{


  DszTest2 queryDetailsById(@Param("id") int id);

  DszTest2 queryDetailsById2(@Param("id") int id);

  School2 queryOneById(@Param("id") int id, @Param("id2") int id2);

  School2 queryOneByObject(@Param("param") School2 school2);




}