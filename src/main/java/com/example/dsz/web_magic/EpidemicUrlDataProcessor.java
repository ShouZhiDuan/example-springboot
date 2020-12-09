package com.example.dsz.web_magic;

import com.example.dsz.config.HPOConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/9 15:50
 * @Description:医学HPO数据表型爬取
 */

@Slf4j
@Component
public class EpidemicUrlDataProcessor implements PageProcessor {

    private Site site = Site.me()
            .setDomain("http://www.chinahpo.org")
            .setSleepTime(1000)   //间隔时间
            .setRetryTimes(30)    //重试时间
            .setCharset("utf-8")  //编码
            .setTimeOut(30000)    //超时时间
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        String source = page.getRawText();
        if(StringUtils.isNotBlank(source)){
            String[] html = Jsoup.parse(source).select("span[class=toctext]").html().split("\n");
            page.putField("hpos",html);
        }
    }

    /**
     * 测试
     */
//    public static void main(String[] args) {
//        List<String> hpos = HPOConfig.hpos;
//        for (String hpo : hpos){
//            Spider spider = Spider.create(new EpidemicUrlDataProcessor());
//            spider.addUrl(hpo);
//            spider.addPipeline(new DataPipeline());
//            spider.thread(1);
//            spider.setExitWhenComplete(true);
//            spider.start();
//            spider.stop();
//        }
//    }
}
