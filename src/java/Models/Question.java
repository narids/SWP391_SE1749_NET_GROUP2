/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author khanhlinh
 */
public class Question {

    private int questionId;
    private List<Answer> answers;
    private String questionContent;
    private Date createdDay;
    private String imageUrl;
    private String explain;
    private int subjectId;
    private Subject subject;

    // Default constructor
    public Question() {
    }

    // Parameterized constructor
    public Question(int questionId, List<Answer> answers, String questionContent, Date createdDay, String imageUrl, String explain, int subjectId, Subject subject) {
        this.questionId = questionId;
        this.answers = answers;
        this.questionContent = questionContent;
        this.createdDay = createdDay;
        this.imageUrl = imageUrl;
        this.explain = explain;
        this.subjectId = subjectId;
        this.subject = subject;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
