package com.slionh.societynews.controller;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.slionh.societynews.entity.News;
import com.slionh.societynews.service.NewsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/*
 * Create by s lion h on 2019-08-21
 * 新闻播报接口
 * 使用百度语音合成技术
 */
@Controller
public class AudioController {
    //@Autowired
    //private BaiduSdk baiduSdk;
    @Autowired
    private NewsService newsService;

    public static final String APP_ID = "17036958";
    public static final String API_KEY = "k9LGXqHdxq9dEKmwDKGOMSiV";
    public static final String SECRET_KEY = "qoe9MpPR1koNid37aGtGIqGArNdmnTZ0";

    //根据id获取news实体，然后请求百度云生成音频MP3
    @RequestMapping("/getAudioById")
    public @ResponseBody void getAudioById(HttpServletResponse response,Integer newsId) throws IOException {
        if (newsId==null){
            newsId=555555;
        }

        News news = newsService.getNewsDetail(newsId);
        String title = news.getTitle();
        String content= news.getContent();
        String text= title+" "+content;


        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");//语速
        options.put("pit", "4");//音调
        options.put("per", "0");//人
        //TtsResponse res = client.synthesis(title, "zh", 1, options);
        TtsResponse res = client.synthesis(text.length()<2048?text: text.substring(0,2047), "zh", 1, options);
        System.out.println(res.toString());
        JSONObject result = res.getResult();    //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        byte[] data = res.getData();            //生成的音频数据

        ServletOutputStream out = response.getOutputStream();

        out.write(data);
        out.flush();
        out.close();

    }



}
