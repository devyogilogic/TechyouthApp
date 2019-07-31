package com.techyouth.developer.techyouth;

public class QuestionModel {
    String Question_id;
    String Question;
    String TimeandDate;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public QuestionModel(String question_id, String question, String timeandDate, String userName)
    {
        Question_id = question_id;
        Question = question;
        this.userName=userName;
        TimeandDate = timeandDate;
    }

    public String getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(String question_id) {
        Question_id = question_id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getTimeandDate() {
        return TimeandDate;
    }

    public void setTimeandDate(String timeandDate) {
        TimeandDate = timeandDate;
    }
}
