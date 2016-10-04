package com.yuzhiyun.csdn.model;

import com.yuzhiyun.csdn.model.entity.NewsItem;
import com.yuzhiyun.csdn.model.exception.CommonException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-01.
 */
public class NewsItemBiz {
    /**
     * 业界、移动、云计算
     */
    public List<NewsItem> getNewsItems(int newsType, int currentPage) throws CommonException {
        /**
         * 获取链接
         * http://news.csdn.net/news/1
         * */
        String urlStr = URLUtil.generateUrl(newsType, currentPage);
        /**
         * 获取访问链接后返回的数据
         * */
        String htmlStr = DataUtil.doGet(urlStr);
        List<NewsItem> newsItems = new ArrayList<NewsItem>();
        NewsItem newsItem = null;

        Document doc = Jsoup.parse(htmlStr);
        Elements units = doc.getElementsByClass("unit");
        for (int i = 0; i < units.size(); i++) {
            newsItem = new NewsItem();
            newsItem.setNewsType(newsType);

            Element unit_ele = units.get(i);

//            获取tag为h1的第一个element
            Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
//            获取第一个子元素，child   element,根据网页代码查看，就是element<a  >
            Element h1_a_ele = h1_ele.child(0);
            String title = h1_a_ele.text();
//            根据key获取value
            String href = h1_a_ele.attr("href");

            newsItem.setLink(href);
            newsItem.setTitle(title);

            Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
            Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
            String date = ago_ele.text();

            newsItem.setDate(date);

            Element dl_ele = unit_ele.getElementsByTag("dl").get(0);// dl
            Element dt_ele = dl_ele.child(0);// dt

            try {// 可能没有图片
                Element img_ele = dt_ele.child(0);
                String imgLink = img_ele.child(0).attr("src");
                newsItem.setImgLink(imgLink);
            } catch (IndexOutOfBoundsException e) {

            }
            Element content_ele = dl_ele.child(1);// dd
            String content = content_ele.text();
            newsItem.setContent(content);
            newsItems.add(newsItem);
        }

        return newsItems;

    }

}
