package com.slionh.societynews.controller;

import com.slionh.societynews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Create by s lion h on 2020-01-01
 */
@Controller
public class DemoController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("demo")
    @ResponseBody
    public String demo(){
        Integer newsId = 555555;
        Integer carouselId = 1;


        return newsService.getCarousel(carouselId).toString()+newsService.getNewsDetail(newsId).toString();
//        return newsService.getNews(newsId).toString();
    }
}
