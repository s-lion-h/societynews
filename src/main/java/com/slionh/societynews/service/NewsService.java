package com.slionh.societynews.service;

import com.slionh.societynews.entity.Carousel;
import com.slionh.societynews.entity.News;

/*
 * Create by s lion h on 2020-01-01
 */
public interface NewsService {
    News getNews(Integer id);
    Carousel getCarousel(Integer id);
}
