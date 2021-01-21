package org.example.entity;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer viewCount;
    private Integer userId;
    private Date createTime;

    public Article() {
    }

    public Article(Integer id, String title, String content, Integer viewCount, Integer userId, Date createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.userId = userId;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
