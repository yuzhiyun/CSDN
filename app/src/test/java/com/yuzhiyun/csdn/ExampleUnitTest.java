package com.yuzhiyun.csdn;

import com.yuzhiyun.csdn.model.Constaint;
import com.yuzhiyun.csdn.model.NewsItemBiz;
import com.yuzhiyun.csdn.model.entity.NewsItem;
import com.yuzhiyun.csdn.model.exception.CommonException;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getData() {
        NewsItemBiz biz = new NewsItemBiz();
/**
 * 业界
 */
        List<NewsItem> newsItems = null;
        try {
            newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YEJIE, 1);
            for (NewsItem item : newsItems) {
                System.out.println(item);
            }

        } catch (CommonException e) {


        }

        System.out.println("----------------------");

    }
}