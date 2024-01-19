package com.mariomanhique.tindzava.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionControlller {

    private final QuestionService questionService;

    @Autowired
    public QuestionControlller(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getQuestion(){
        return questionService.getQuestions();
    }

    @PostMapping("add_question")
    public void saveQuestion(@RequestBody QuestionDTO questionDTO){
        Question question = new Question();
        question.setAnswer(questionDTO.answer());
        question.setQuestion(questionDTO.question());
        question.setChoices(questionDTO.choices());

        questionService.saveQuestion(question);

    }

    @DeleteMapping("delete_question/{questionId}")
    public void deleteQuestionById( @PathVariable("questionId")  Long questionId){
        questionService.deleteQuestionById(questionId);
    }

    @PutMapping(path = "update/{questionId}")
    public void updateQuestion(
            @PathVariable("questionId") Long questionId,
            @RequestParam(required = false) String question,
            @RequestParam(required = false) String answer,
            @RequestParam(required = false) List<String> questions
    ){
        questionService.updateQuestion(
                questionId,
                question,
                answer
        );
    }

}
