package com.mariomanhique.tindzava.questions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionsLoader {

    @Bean
    CommandLineRunner commandLineRunner (
            QuestionRepository questionRepository
    ){
        return args -> {
           Question question= new Question(
                    "Guyzelh Ramos",
                    List.of(
                            new QuestionChoice("Guyzelh Ramos"),
                            new QuestionChoice("Dygo Boy"),
                            new QuestionChoice("Zico Da Silva"),
                            new QuestionChoice("Valdemiro Jose")
                    ),
                    "Qual destas celebridades já foi preza em solo nacional e internacional?"
            );

            questionRepository.save(question);
        };
    }
}
