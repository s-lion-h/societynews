package com.slionh.societynews.entity;

import java.util.Date;

public class News {
    private Integer idnews;

    private String title;

    private String content;

    private String journal;

    private Date publishtime;

    private Date createtime;

    private String newssource;

    private String subhead;

    private String url;

    private String other;

    public Integer getIdnews() {
        return idnews;
    }

    public void setIdnews(Integer idnews) {
        this.idnews = idnews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal == null ? null : journal.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNewssource() {
        return newssource;
    }

    public void setNewssource(String newssource) {
        this.newssource = newssource == null ? null : newssource.trim();
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead == null ? null : subhead.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    @Override
    public String toString() {
        return "News{" +
                "idnews=" + idnews +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", journal='" + journal + '\'' +
                ", publishtime=" + publishtime +
                ", createtime=" + createtime +
                ", newssource='" + newssource + '\'' +
                ", subhead='" + subhead + '\'' +
                ", url='" + url + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}