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
public class NewsComment extends BaseEntity {

    private int commentId;
    private String content;
    private int parentId;
    private Date createdDay;
    private int createdBy;
    private int newsId;

    private News news;

    public NewsComment() {
    }

    public NewsComment(int commentId, String content, int parentId, Date createdDay, int createdBy, int newsId, News news) {
        this.commentId = commentId;
        this.content = content;
        this.parentId = parentId;
        this.createdDay = createdDay;
        this.createdBy = createdBy;
        this.newsId = newsId;
        this.news = news;
    }
//        public NewsComment(int commentId, String content, int parentId, Date createdDay,String name, int newsId, News news) {
//        this.commentId = commentId;
//        this.content = content;
//        this.parentId = parentId;
//        this.createdDay = createdDay;
//        this.name=name;
//        this.newsId = newsId;
//        this.news = news;
//    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "NewsComment{" + "commentId=" + commentId + ", content=" + content + ", parentId=" + parentId + ", createdDay=" + createdDay + ", createdBy=" + createdBy + ", newsId=" + newsId + ", news=" + news + '}';
    }

}
