package com.example.Questionservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerResponseDTO {
    private QuestionResponseDTO question;
    private List<AnswerResponseDTO> answer;
}
