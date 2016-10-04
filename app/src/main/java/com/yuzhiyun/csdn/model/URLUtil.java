package com.yuzhiyun.csdn.model;

/**
 * Created by yuzhiyun on 2016-10-01.
 */
public class URLUtil
{





    /**
     * 根据文章类型，和当前页码生成url
     * @param newsType
     * @param currentPage
     * @return
     */
    public static String generateUrl(int newsType, int currentPage)
    {
        currentPage = currentPage > 0 ? currentPage : 1;
        String urlStr = "";
        switch (newsType)
        {
            case Constant.NEWS_TYPE_YEJIE:
                urlStr = Constant.NEWS_LIST_URL_YEJIE;
                break;
            case Constant.NEWS_TYPE_YANFA:
                urlStr = Constant.NEWS_LIST_URL_YANFA;
                break;
        }


        urlStr += "/" + currentPage;

        return urlStr;


    }


}
