package com.example.myapplication;

/* loaded from: classes2.dex */
public class Quiz {
    private String[] answers;
    private int correctAnswer;
    private String question;

    Quiz(String str, String[] strArr, int i) {
        this.question = str;
        this.answers = strArr;
        this.correctAnswer = i;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswer() {
        return this.answers;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }
}
