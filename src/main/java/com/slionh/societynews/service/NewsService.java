package com.slionh.societynews.service;

import com.slionh.societynews.entity.Carousel;
import com.slionh.societynews.entity.News;

import java.util.List;

/*
 * Create by s lion h on 2020-01-01
 */
public interface NewsService {
    //获取新闻的详细内容，用于新闻内容展示
    News getNewsDetail(Integer id);

    //list最新的N条新闻，用于首页展示最新新闻，不包含content以加速检索
    List<News> listLatestNews(Integer count);

    //list某一类型新闻的最新新闻，默认使用一级行业分类
    List<News> listLatestClassificationNews(String classification ,Integer count);


    Carousel getCarousel(Integer id);
}
