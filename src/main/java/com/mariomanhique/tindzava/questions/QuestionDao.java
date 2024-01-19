package com.mariomanhique.tindzava.questions;

import java.util.List;

interface QuestionDao {

    void saveQuestion(
            Question question
    );

     void updateQuestion(
            Long questionId,
            String question,
            String answer
    );

     List<Question> getQuestions();

     void deleteQuestionById(Long questionId);


}
