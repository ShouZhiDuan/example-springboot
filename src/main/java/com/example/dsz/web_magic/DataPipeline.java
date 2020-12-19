package com.example.dsz.web_magic;

import com.alibaba.fastjson.JSON;
import com.example.dsz.mapper.FudanHposMapper;
import com.example.dsz.model.FudanHpos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.awt.print.PrinterAbortException;
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

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 数据处理
     */
    @Override
    @Transactional
    public void process(ResultItems resultItems, Task task) {
//         String[] hpos = resultItems.get("hpos");
//         if(hpos != null && hpos.length > 0){
//             for (String hpo : hpos){
//                 if (hpo.contains("HP:")){
//                     FudanHpos fudanHpos = new FudanHpos();
//                     fudanHpos.setHpoName(hpo);
//                     try {
//                         hposMapper.insert(fudanHpos);
//                     } catch (Exception e) {
//                         log.info("库中已存在：" + hpo);
//                     }
//                 }
//             }
//         }
        List<FudanHpos> hpos = resultItems.get("hpos");
        System.out.println("爬取的数据数量=" + hpos.size());
        if(hpos != null && hpos.size() > 0){
             for (FudanHpos hpo : hpos){
                 try {
                     hposMapper.insert(hpo);
                 } catch (Exception e) {
                     redisTemplate.opsForValue().increment("count");
                     log.info("库中已存在：" + JSON.toJSONString(hpo));
                 }
             }
        }
    }

}
