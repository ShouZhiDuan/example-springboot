package com.example.dsz.web_magic;

import com.example.dsz.mapper.FudanHposMapper;
import com.example.dsz.model.FudanHpos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/5/22 16:10
 * @Description:处理数据管道
 */

@Slf4j
@Service("dataPipeline")
public class DataPipeline implements Pipeline {

    @Autowired
    private FudanHposMapper hposMapper;

    /**
     * 数据处理
     */
    @Override
    @Transactional
    public void process(ResultItems resultItems, Task task) {
         List<FudanHpos> list = new ArrayList<>();
         String[] hpos = resultItems.get("hpos");
         for (String hpo : hpos){
             if (hpo.contains("HP:")){
                 FudanHpos fudanHpos = new FudanHpos();
                 fudanHpos.setHpoName(hpo);
                 list.add(fudanHpos);
             }
         }
         hposMapper.insertList(list);
    }

}
