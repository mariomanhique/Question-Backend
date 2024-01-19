package com.mariomanhique.tindzava.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("select s from Question s where s.id = ?1")
    Optional<Question> findQuestionById(Long id);

    @Query("select s from Question s where s.question = ?1")
    Optional<Question> findQuestionByQuestion(String question);

}
