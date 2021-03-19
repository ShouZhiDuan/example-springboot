package com.example.dsz.mapper;

import com.example.dsz.model.DszTest2;
import org.apache.ibatis.annotations.Param;

public interface TestMapper{


  DszTest2 queryDetailsById(@Param("id") int id);

  DszTest2 queryDetailsById2(@Param("id") int id);


}