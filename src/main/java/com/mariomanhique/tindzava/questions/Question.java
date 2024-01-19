package com.mariomanhique.tindzava.questions;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Question {

    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private Long id;
    private String answer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<QuestionChoice> choices = new ArrayList<>();
    private String question;

    public Question() {

    }

    public Question(String answer, List<QuestionChoice> choices, String question) {
        this.answer = answer;
        this.choices = choices;
        this.question = question;
    }

    public Question(Long id, String answer, List<QuestionChoice> choices, String question) {
        this.id = id;
        this.answer = answer;
        this.choices = choices;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<QuestionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<QuestionChoice> choices) {
        this.choices = choices;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", choices=" + choices +
                ", question='" + question + '\'' +
                '}';
    }
}
