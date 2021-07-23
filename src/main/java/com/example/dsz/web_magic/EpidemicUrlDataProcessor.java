package com.example.dsz.web_magic;

import com.example.dsz.config.HPOConfig;
import com.example.dsz.model.FudanHpos;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        List<FudanHpos> hpos = new ArrayList<>();
        if (StringUtils.isNotBlank(source)) {
            Elements select = Jsoup.parse(source).select("table[class=wikitable]");
            select.forEach(element -> {
                FudanHpos hpo = new FudanHpos();
                String hpoName = element.select("caption").html();
                System.out.println("表型名称：" + hpoName);
                hpo.setHpoName(hpoName);
                Elements trs = element.select("tr");
                trs.forEach(tr -> {
                    String th = tr.select("th").html();
                    String td = tr.select("td").html();
                    if (!th.equals("链接")) {
                        if (th.trim().equals("名称")) {
                            System.out.println("英文译名->" + td);
                            hpo.setNameEn(td);
                        } else if (th.trim().equals("定义")) {
                            System.out.println("英文定义->" + td);
                            hpo.setDefinitionEn(td);
                        } else if (th.trim().equals("中文译名")) {
                            System.out.println("中文译名->" + td);
                            hpo.setNameZh(td);
                        } else if (th.trim().equals("中文定义")) {
                            System.out.println("中文定义->" + td);
                            hpo.setDefinitionZh(td);
                        }
                    }
                });
                hpos.add(hpo);
            });
        }
        page.putField("hpos", hpos);
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        List<String> hpos = HPOConfig.hpos;
        for (String hpo : hpos) {
            Spider spider = Spider.create(new EpidemicUrlDataProcessor());
            spider.addUrl(hpos.get(0));
            spider.addPipeline(new DataPipeline());
            spider.thread(1);
            spider.setExitWhenComplete(true);
            spider.start();
            spider.stop();
        }
    }
}
