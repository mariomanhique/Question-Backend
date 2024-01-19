package com.mariomanhique.tindzava.questions;

import jakarta.persistence.*;

@Entity
@Table
public class QuestionChoice {
    @Id
    @SequenceGenerator(
            name = "choice_sequence",
            sequenceName = "choice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "choice_sequence"
    )
    private Long id;

    private String choice;

    // Getters and setters


    public QuestionChoice() {
    }

    public QuestionChoice(String choice) {
        this.choice = choice;
    }

    public QuestionChoice(Long id, String choice) {
        this.id = id;
        this.choice = choice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String   toString() {
        return "QuestionChoice{" +
                "id=" + id +
                ", choice='" + choice + '\'' +
                '}';
    }
}
