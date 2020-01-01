package com.slionh.societynews.service.impl;

import com.slionh.societynews.entity.Carousel;
import com.slionh.societynews.entity.News;
import com.slionh.societynews.mapper.DbTencent.NewsMapper;
import com.slionh.societynews.mapper.dbAli.CarouselMapper;
import com.slionh.societynews.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * Create by s lion h on 2020-01-01
 */

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;
    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public News getNews(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Carousel getCarousel(Integer id) {
        return carouselMapper.selectByPrimaryKey(id);
    }
}
