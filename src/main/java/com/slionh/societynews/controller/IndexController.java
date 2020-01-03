package com.slionh.societynews.controller;

import com.slionh.societynews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
 * Create by s lion h on 2020-01-02
 */
@Controller
public class IndexController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/")
    public ModelAndView toIndex(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("index");
        modelAndView.addObject("latestNewsList",newsService.listLatestNews(10));


        return  modelAndView;
    }
}
