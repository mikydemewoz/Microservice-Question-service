package com.example.Questionservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponseDTO {
    private String solution;
    private LocalDate answeredTime;
    private Long userId;
    private Long questionId;
    private Long id;
}
