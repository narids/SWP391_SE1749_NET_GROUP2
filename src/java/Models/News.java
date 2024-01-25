/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author admin
 */
public class News {

    private int newsId;
    private String title;
    private String content;
    private Date createdDay;
    private String thumbnail;
    private String summary;
    private int numberCommment;
    private int createdBy;
    private int viewsCount;

    public News() {
    }

    public News(int newsId, String title, String content, Date createdDay, String thumbnail, String summary, int numberCommment, int createdBy, int viewsCount) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.createdDay = createdDay;
        this.thumbnail = thumbnail;
        this.summary = summary;
        this.numberCommment = numberCommment;
        this.createdBy = createdBy;
        this.viewsCount = viewsCount;
    }

    public int getNewsID() {
        return newsId;
    }

    public void setNewsID(int newsId) {
        this.newsId = newsId;
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

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumberCommment() {
        return numberCommment;
    }

    public void setNumberCommment(int numberCommment) {
        this.numberCommment = numberCommment;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    @Override
    public String toString() {
        return "News{" + "newsId=" + newsId + ", title=" + title + ", content=" + content + ", createdDay=" + createdDay + ", thumbnail=" + thumbnail + ", summary=" + summary + ", numberCommment=" + numberCommment + ", createdBy=" + createdBy + ", viewsCount=" + viewsCount + '}';
    }

}
