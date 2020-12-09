package com.example.dsz.controller;

import com.example.dsz.config.HPOConfig;
import com.example.dsz.web_magic.DataPipeline;
import com.example.dsz.web_magic.EpidemicUrlDataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/9 18:01
 * @Description:
 */
@RestController
@RequestMapping("/webmagic")
public class WebMagicController {

    @Autowired
    private EpidemicUrlDataProcessor epidemicUrlDataProcessor;

    @Autowired
    private DataPipeline dataPipeline;

    @GetMapping("queryHpos")
    public Object queryHpos(){
        int i = 0;
        long startTime = System.currentTimeMillis();
        List<String> hpos = HPOConfig.hpos;
        for (String hpo : hpos){
            Spider spider = Spider.create(epidemicUrlDataProcessor);
            spider.addUrl(hpo);
            spider.addPipeline(dataPipeline);
            spider.thread(10);
            spider.setExitWhenComplete(true);
            spider.start();
            spider.stop();
        }
        long endTime = System.currentTimeMillis();
        return "消耗时间" + (endTime - startTime)/1000 + "秒";
    }

}
