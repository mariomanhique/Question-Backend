package com.mariomanhique.tindzava.questions;

import java.util.List;

record QuestionDTO(
        String answer,
        List<QuestionChoice> choices,
        String question
) {

}
