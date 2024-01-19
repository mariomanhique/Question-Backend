package com.mariomanhique.tindzava.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService implements QuestionDao {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    @Override
    public void deleteQuestionById(Long questionId) {
       boolean exists = questionRepository.existsById(questionId);

        if (!exists){
            throw new IllegalStateException("Question with id "+" was not found");
        }
        questionRepository.deleteById(questionId);
    }


    @Override
    @Transactional
    public void updateQuestion(
            Long questionId,
            String question,
            String answer
    ){

        Question question1 = questionRepository.findById(questionId)
                .orElseThrow(()-> new IllegalStateException(("")));

        if(question != null &&
                question.length() > 0 &&
                !Objects.equals(question1.getQuestion(), question)){
          question1.setQuestion("First Question");
        }

        if(answer != null &&
                question.length() > 0 &&
                !Objects.equals(question1.getAnswer(), answer)){
            question1.setAnswer("First Answer");
        }

    }

    @Override
    public void saveQuestion(
            Question question
            ){
        Optional<Question> studentOptional = questionRepository.findQuestionByQuestion(question.getQuestion());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("question already registered in database");
        }
            questionRepository.save(question);
    }



}
