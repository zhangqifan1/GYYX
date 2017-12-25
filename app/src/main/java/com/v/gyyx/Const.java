package com.v.gyyx;

import com.v.gyyx.application.App;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Const {
    public static final String BaseURL="http://m2.itmayi.net.cn";
    public static final String Device_ID= App.getDEVICE_ID();
    public static final String YouKe= "/api/surfers";
    public static final String Care2= "/api/focus";
    public static final String Care3= "?user=user&flag=list&fromUid=1&page=1&limit=3";
    public static final String CareURL= BaseURL+Care2+Care3;


    public static final String YouKe_POST=BaseURL+YouKe;

    public static final String Huati="/api/articles";
    public static final String Huati4="/api/topics";
    public static final String Huati_item7=BaseURL+Huati+"?user=surfer&flag=index2&fromUid=1&page=1";
    public static final String Huati_item4=BaseURL+Huati4+"?user=surfer&flag=list&fromUid=1&page=1&limit=4#/home";
    //http://m2.itmayi.net.cn/api/articles?user=surfer&flag=index2&fromUid=1&page=1   ?user=user|surfer&flag=index&fromUid=1&page=1&limit=4



    //http://m2.itmayi.net.cn/api/topics?user=surfer&flag=list&fromUid=1&page=1&limit=4#/home
    //第一张图片
    public static final String img1="https://ss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=3252315444,1227221520&fm=202&mola=new&crop=v1";
}
