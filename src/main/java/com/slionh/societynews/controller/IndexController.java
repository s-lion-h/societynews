package com.slionh.societynews.controller;

import com.slionh.societynews.entity.News;
import com.slionh.societynews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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
        modelAndView.addObject("latestNewsList",newsService.listLatestNews(12));
        modelAndView.addObject("classificationNewsIndex1Name1","财经");
        modelAndView.addObject("classificationNewsIndex1Name2","国际");
        modelAndView.addObject("classificationNewsIndex1Name3","时事");
        modelAndView.addObject("classificationNewsIndex1Name4","体育");
        modelAndView.addObject("classificationNewsIndex1",newsService.listLatestClassificationNews("国际",5));
        modelAndView.addObject("classificationNewsIndex2",newsService.listLatestClassificationNews("财经",5));
        modelAndView.addObject("classificationNewsIndex3",newsService.listLatestClassificationNews("时事",5));
        modelAndView.addObject("classificationNewsIndex4",newsService.listLatestClassificationNews("体育",5));

        return  modelAndView;
    }

    @RequestMapping("/classificationNews")
    public ModelAndView classificationNews(ModelAndView modelAndView, HttpServletRequest request,String classification){
        if (classification==null||classification.equals(""))
            classification="汽车";
        modelAndView.setViewName("classificationNews");
        modelAndView.addObject("newsList",newsService.listLatestClassificationNews(classification,15));
        modelAndView.addObject("classificationName",classification);
        modelAndView.addObject("latestNewsList",newsService.listLatestNews(8));


        return  modelAndView;
    }

    @RequestMapping("newsDetail")
    public ModelAndView newsDetail(ModelAndView modelAndView,HttpServletRequest request,Integer newsId){
        if (newsId==null||newsId.equals(""))
            newsId=555555;
        modelAndView.addObject("news",newsService.getNewsDetail(newsId));
        modelAndView.addObject("latestNewsList",newsService.listLatestNews(8));

        modelAndView.setViewName("newsDetail");
        return modelAndView;
    }

    @RequestMapping("titleKey")
    public ModelAndView generalScoreDaysAvg(ModelAndView modelAndView,String key){
        modelAndView.setViewName("NewsList");
        if (key!=null&&!key.equals(""))
            modelAndView.addObject("newsList",newsService.selectByLikeTitleKey(key));
        else
            modelAndView.addObject("newsList",new ArrayList<News>());
        return modelAndView;
    }
}
